package controllers

import play.api.mvc.{Action, Controller}
import play.api.Play
import play.api.Routes
import play.core.Router.JavascriptReverseRoute
import play.api.cache.Cached

object Application extends Controller {

  import Play.current

  def index = Action {
    Redirect(routes.Projects.showProjects)
  }

  def jsRoutes = Cached("jsRoutes"){
    Action { implicit req =>
      val cls = classOf[routes.javascript]
      val jsRoutes = cls.getFields.toList
        .map (_.get(cls))
        .flatMap (o => o.getClass.getMethods.toList map (o ->))
        .filter {case (o, m) => classOf[JavascriptReverseRoute].isAssignableFrom(m.getReturnType)}
        .map {case (o, m) => m.invoke(o).asInstanceOf[JavascriptReverseRoute]}
        .toList

      Ok(Routes.javascriptRouter("routes")(jsRoutes: _*)).as(JAVASCRIPT)
    }
  }
}

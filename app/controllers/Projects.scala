package controllers

import scaldi.{Injectable, Injector}
import play.api.mvc.{Action, Controller}
import play.api.libs.json.Json
import play.api.Play
import scala.io.Source

class Projects(implicit inj: Injector) extends Controller with Injectable {
  def showProjects = Action { implicit req =>
    Ok(views.html.projects())
  }

  def addStuff = TODO

  def dependencies = Action {
    val jsonFile = Play.current getFile "conf/flare.json"
    val jsonString = (Source fromFile jsonFile).getLines mkString "\n"

    Ok(Json parse jsonString)
  }
}

import controllers.Projects
import play.api.GlobalSettings
import scaldi.Module
import scaldi.play.ScaldiSupport

object Global extends GlobalSettings with ScaldiSupport {
  def applicationModule = new Module {
    binding to new Projects
  }
}

package models

import play.api.mvc.Call
import controllers.routes

case class Button(name: String, call: Call, icon: Option[String] = None)

object Button {
  val addStuff = Button("Add Mo Stuff", routes.Projects.addStuff(), Some("plus"))
}

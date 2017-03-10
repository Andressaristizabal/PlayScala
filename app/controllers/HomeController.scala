package controllers

import javax.inject._

import play.api._
import play.api.libs.json._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {
  implicit val c = Codec.javaSupported("UTF-8") // implicit code charset UTF-8
  def index = Action(parse.json) {implicit request =>
    implicit val r = Json.format[AppRequest]
    //val x: Reads[String] = (JsPath \ "name").read[String]

    request.body.validate[AppRequest] match {
      case JsSuccess(approute,s) => Ok(s"$approute ss $s" )
      case JsError(e) => BadRequest
    }
    //Ok(s"Hi $r") //? Redirect browser in some domain
    //Ok(s"name is $name") //? Response string
  }

  def todo = TODO
  def expression(id:Long) = Action{
    Ok(s"$id")
  }

  def clients(name: String)= Action{
    Ok(s"Nombre $name")
  }
}

case class AppRequest(name:String)

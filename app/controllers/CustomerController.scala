package controllers

import play.api._
import play.api.data._
import play.api.data.Forms._
import play.api.mvc._

import models.Customer

object CustomerController extends Controller {

  val customerForm = Form(
    tuple(
      "name" -> nonEmptyText,
      "address" -> text
    )
  )

  def index = Action {
    Ok(views.html.customers(Customer.all(), customerForm))
  }

  def create = Action { implicit request =>
    customerForm.bindFromRequest.fold(
      errors =>
        BadRequest(views.html.customers(Customer.all(), errors)),
      values => {
        Customer.create(values._1, values._2)
        Redirect(routes.CustomerController.index)
      }
    )
  }

}

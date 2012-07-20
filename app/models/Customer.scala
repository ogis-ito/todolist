package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

object Customer {

  val customer = {
    get[Long]("id") ~
    get[String]("name") ~
    get[String]("address") map {
      case id ~ name ~ address => Customer(id, name, address)
    }
  }

  def all(): List[Customer] = DB.withConnection { implicit c =>
    SQL("select * from CUSTOMER").as(customer *)
  }

  def create(name: String, address: String) {
    DB.withConnection { implicit c =>
      SQL("insert into CUSTOMER (NAME, ADDRESS) values ({name}, {address})").on(
        'name -> name,
        'address -> address
      ).executeUpdate()
    }
  }

}

case class Customer(id: Long, name: String, address: String)

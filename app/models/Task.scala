package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

object Task {

  val task = {
    get[Long]("id") ~
    get[String]("label") map {
      case id ~ label => Task(id, label)
    }
  }

  def all(): List[Task] = DB.withConnection { implicit c =>
    SQL("select * from TASK").as(task *)
  }

  def create(label: String) {
    DB.withConnection { implicit c =>
      SQL("insert into TASK (LABEL) values ({label})").on(
        'label -> label
      ).executeUpdate()
    }
  }

  def delete(id: Long) {
    DB.withConnection { implicit c =>
      SQL("delete from TASK where id = {id}").on(
        'id -> id
      ).executeUpdate()
    }
  }

}

case class Task(id: Long, label: String)

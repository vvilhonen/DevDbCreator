package devdb

import com.typesafe.config.ConfigFactory
import scala.slick.session.Database
import scala.slick.session.Database.threadLocalSession
import scala.slick.jdbc.StaticQuery.interpolation

object Main extends App {
  val config = ConfigFactory.load()
  val db = Database.forURL(
    config.getString("db.connString"),
    user = config.getString("db.user"),
    password = config.getString("db.password"),
    driver = config.getString("db.driver"))
  db withSession {
    sql"show databases".as[String] foreach { row =>
      println(row)
    }
  }
}

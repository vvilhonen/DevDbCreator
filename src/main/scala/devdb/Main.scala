package devdb

import com.typesafe.config.ConfigFactory
import scala.slick.session.Database
import scala.slick.session.Database.threadLocalSession
import scala.slick.jdbc.StaticQuery.interpolation
import org.slf4j.LoggerFactory
import java.sql.Date

object Main extends App {
  val config = ConfigFactory.load()
  val log = LoggerFactory.getLogger(getClass)
  val db = Database.forURL(
    config.getString("db.connString"),
    user = config.getString("db.user"),
    password = config.getString("db.password"),
    driver = config.getString("db.driver"))

  db withSession {
    sql"show databases".as[String] foreach { dbName =>
      log.info(s"Db named $dbName last accessed ${lastAccess(dbName)}")
    }
  }

  def lastAccess(schema: String) = {
    sql"SELECT UPDATE_TIME FROM information_schema.TABLES WHERE TABLE_SCHEMA = $schema ORDER BY UPDATE_TIME DESC".as[Date].first()
  }
}

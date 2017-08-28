import scala.concurrent.{Await, Future}
import shapeless._
import slickless._
import scala.concurrent.ExecutionContext.Implicits.global
import db.Tables.profile.api._
import scala.concurrent.duration._

case class User(
	id: Int,
	c2: Option[String],
	c3: Option[String],
	c4: Option[String],
	c5: Option[String],
	c6: Option[String],
	c7: Option[String],
	c8: Option[String],
	c9: Option[String],
	c10: Option[String],
	c11: Option[String],
	c12: Option[String],
	c13: Option[String],
	c14: Option[String],
	c15: Option[String],
	c16: Option[String],
	c17: Option[String],
	c18: Option[String],
	c19: Option[String],
	c20: Option[String],
	c21: Option[String],
	c22: Option[String],
	c23: Option[String],
	c24: Option[String],
	c25: Option[String]
)

object App extends App {
	
	val database = slick.jdbc.JdbcBackend.Database.forURL(
		"jdbc:h2:mem:test1;DB_CLOSE_DELAY=-1;INIT=runscript from 'src/main/resources/create.sql'",
		driver="org.h2.Driver"
	)

	def columns = { user: db.Tables.User =>
		user.id ::
		user.c2 ::
		user.c3 ::
		user.c4 ::
		user.c5 ::
		user.c6 ::
		user.c7 ::
		user.c8 ::
		user.c9 ::
		user.c10 ::
		user.c11 ::
		user.c12 ::
		user.c13 ::
		user.c14 ::
		user.c15 ::
		user.c16 ::
		user.c17 ::
		user.c18 ::
		user.c19 ::
		user.c20 ::
		user.c21 ::
		user.c22 ::
		user.c23 ::
		user.c24 ::
		user.c25 ::
		HNil
	}

	val values =
		1 ::
		Some("two") ::
		Some("three") ::
		Some("four") ::
		Some("five") ::
		Some("six") ::
		Some("seven") ::
		Some("eight") ::
		Some("nine") ::
		Some("ten") ::
		Some("eleven") ::
		Some("twelve") ::
		Some("thirteen") ::
		Some("fourteen") ::
		Some("fifteen") ::
		Some("sixteen") ::
		Some("seventeen") ::
		Some("eighteen") ::
		Some("nineteen") ::
		Some("twenty") ::
		Some("twenty one") ::
		Some("twenty two") ::
		Some("twenty three") ::
		Some("twenty four") ::
		Some("twenty five") ::
		HNil

	def getUser(id: Int): Future[Option[User]] = {
		database.run(db.Tables.User.filter(_.id === id).map(columns).result).map(_.headOption.map(row => Generic[User].from(row)))
	}

	def insertUser(user: User): Future[Int] = {
		database.run(db.Tables.User.map(columns).returning(db.Tables.User.map(_.id)) += Generic[User].to(user))
	}

	def updateUser(user: User): Future[Int] = {
		database.run(db.Tables.User.filter(_.id === user.id).map(columns).update(Generic[User].to(user)))
	}

	val userID = insertUser(Generic[User].from(values))
	val selectedUser = userID.flatMap(id => getUser(id))

	val updatedUserID = selectedUser.flatMap {
		case Some(u) =>
			val newValues = u.id :: Some("two plus two") :: values.tail.tail
			updateUser(Generic[User].from(newValues))
		case None => Future(0)
	}
	val updatedUser = updatedUserID.flatMap(id => getUser(id))

	val result = (for {
		sUser <- selectedUser
		uUser <- updatedUser
	} yield (sUser, uUser)).map {
		case (Some(u1), Some(u2)) =>
			println(u1)
			println(u2)
		case _ => println("not found")
	}

	Await.ready(result, Duration.Inf)
	
}
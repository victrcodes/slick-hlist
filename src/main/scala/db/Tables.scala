package db
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.H2Profile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  import slick.collection.heterogeneous._
  import slick.collection.heterogeneous.syntax._
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Test.schema ++ User.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Test
   *  @param id Database column ID SqlType(INTEGER), AutoInc, PrimaryKey
   *  @param name Database column NAME SqlType(VARCHAR) */
  case class TestRow(id: Int, name: String)
  /** GetResult implicit for fetching TestRow objects using plain SQL queries */
  implicit def GetResultTestRow(implicit e0: GR[Int], e1: GR[String]): GR[TestRow] = GR{
    prs => import prs._
    TestRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table TEST. Objects of this class serve as prototypes for rows in queries. */
  class Test(_tableTag: Tag) extends profile.api.Table[TestRow](_tableTag, "TEST") {
    def * = (id, name) <> (TestRow.tupled, TestRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name)).shaped.<>({r=>import r._; _1.map(_=> TestRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(INTEGER), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column NAME SqlType(VARCHAR) */
    val name: Rep[String] = column[String]("NAME")
  }
  /** Collection-like TableQuery object for table Test */
  lazy val Test = new TableQuery(tag => new Test(tag))

  /** Row type of table User */
  type UserRow = HCons[Int,HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HNil]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for UserRow providing default values if available in the database schema. */
  def UserRow(id: Int, c2: Option[String], c3: Option[String], c4: Option[String], c5: Option[String], c6: Option[String], c7: Option[String], c8: Option[String], c9: Option[String], c10: Option[String], c11: Option[String], c12: Option[String], c13: Option[String], c14: Option[String], c15: Option[String], c16: Option[String], c17: Option[String], c18: Option[String], c19: Option[String], c20: Option[String], c21: Option[String], c22: Option[String], c23: Option[String], c24: Option[String], c25: Option[String]): UserRow = {
    id :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: HNil
  }
  /** GetResult implicit for fetching UserRow objects using plain SQL queries */
  implicit def GetResultUserRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[UserRow] = GR{
    prs => import prs._
    <<[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: HNil
  }
  /** Table description of table USER. Objects of this class serve as prototypes for rows in queries. */
  class User(_tableTag: Tag) extends profile.api.Table[UserRow](_tableTag, "USER") {
    def * = id :: c2 :: c3 :: c4 :: c5 :: c6 :: c7 :: c8 :: c9 :: c10 :: c11 :: c12 :: c13 :: c14 :: c15 :: c16 :: c17 :: c18 :: c19 :: c20 :: c21 :: c22 :: c23 :: c24 :: c25 :: HNil

    /** Database column ID SqlType(INTEGER), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column C2 SqlType(VARCHAR) */
    val c2: Rep[Option[String]] = column[Option[String]]("C2")
    /** Database column C3 SqlType(VARCHAR) */
    val c3: Rep[Option[String]] = column[Option[String]]("C3")
    /** Database column C4 SqlType(VARCHAR) */
    val c4: Rep[Option[String]] = column[Option[String]]("C4")
    /** Database column C5 SqlType(VARCHAR) */
    val c5: Rep[Option[String]] = column[Option[String]]("C5")
    /** Database column C6 SqlType(VARCHAR) */
    val c6: Rep[Option[String]] = column[Option[String]]("C6")
    /** Database column C7 SqlType(VARCHAR) */
    val c7: Rep[Option[String]] = column[Option[String]]("C7")
    /** Database column C8 SqlType(VARCHAR) */
    val c8: Rep[Option[String]] = column[Option[String]]("C8")
    /** Database column C9 SqlType(VARCHAR) */
    val c9: Rep[Option[String]] = column[Option[String]]("C9")
    /** Database column C10 SqlType(VARCHAR) */
    val c10: Rep[Option[String]] = column[Option[String]]("C10")
    /** Database column C11 SqlType(VARCHAR) */
    val c11: Rep[Option[String]] = column[Option[String]]("C11")
    /** Database column C12 SqlType(VARCHAR) */
    val c12: Rep[Option[String]] = column[Option[String]]("C12")
    /** Database column C13 SqlType(VARCHAR) */
    val c13: Rep[Option[String]] = column[Option[String]]("C13")
    /** Database column C14 SqlType(VARCHAR) */
    val c14: Rep[Option[String]] = column[Option[String]]("C14")
    /** Database column C15 SqlType(VARCHAR) */
    val c15: Rep[Option[String]] = column[Option[String]]("C15")
    /** Database column C16 SqlType(VARCHAR) */
    val c16: Rep[Option[String]] = column[Option[String]]("C16")
    /** Database column C17 SqlType(VARCHAR) */
    val c17: Rep[Option[String]] = column[Option[String]]("C17")
    /** Database column C18 SqlType(VARCHAR) */
    val c18: Rep[Option[String]] = column[Option[String]]("C18")
    /** Database column C19 SqlType(VARCHAR) */
    val c19: Rep[Option[String]] = column[Option[String]]("C19")
    /** Database column C20 SqlType(VARCHAR) */
    val c20: Rep[Option[String]] = column[Option[String]]("C20")
    /** Database column C21 SqlType(VARCHAR) */
    val c21: Rep[Option[String]] = column[Option[String]]("C21")
    /** Database column C22 SqlType(VARCHAR) */
    val c22: Rep[Option[String]] = column[Option[String]]("C22")
    /** Database column C23 SqlType(VARCHAR) */
    val c23: Rep[Option[String]] = column[Option[String]]("C23")
    /** Database column C24 SqlType(VARCHAR) */
    val c24: Rep[Option[String]] = column[Option[String]]("C24")
    /** Database column C25 SqlType(VARCHAR) */
    val c25: Rep[Option[String]] = column[Option[String]]("C25")
  }
  /** Collection-like TableQuery object for table User */
  lazy val User = new TableQuery(tag => new User(tag))
}

package rillit


case class Electronic(email: String, web: String)
case class Contact(electronic: Electronic)
case class Name(first: String, last: String)
case class Person(name: Name, age: Int, contact: Contact)

object Main {
  val aki = Person(
    name = Name("Aki", "Saarinen"),
    age  = 27,
    contact = Contact(
      electronic = Electronic(
        email = "aki@akisaarinen.fi",
        web   = "http://akisaarinen.fi"
      )
    )
  )

  val email      = new Lenser[Electronic].email
  val electronic = new Lenser[Contact].electronic
  val contact    = new Lenser[Person].contact

  def main(args: Array[String]) {
    val lens = contact andThen electronic andThen email

    val aki2 = lens.set(aki, "aki2@akisaarinen.fi")

    println("Original: %s".format(lens.get(aki)))
    println("Updated:  %s".format(lens.get(aki2)))
  }
}


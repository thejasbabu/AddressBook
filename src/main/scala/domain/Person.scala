package domain

case class Person(firstName: String, lastName: String, phoneNumber: String) {
  override def equals(obj: scala.Any): Boolean = {
    val person = obj.asInstanceOf[Person]
    this.lastName.equalsIgnoreCase(person.lastName) && this.firstName.equalsIgnoreCase(person.firstName)
  }
}

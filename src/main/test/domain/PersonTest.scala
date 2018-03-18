package domain

import org.scalatest.{FlatSpec, Matchers}

class PersonTest extends FlatSpec with Matchers {

  "Person" should "equal to another person if they have the same first and last name" in {
    Person("mark", "newton", "9987778").equals(Person("mark", "newton", "99222")) shouldBe true
    Person("mark", "newton", "9987778").equals(Person("mark", "sam", "99222")) shouldBe false
    Person("marky", "sam", "9987778").equals(Person("mark", "sam", "99222")) shouldBe false
  }
}

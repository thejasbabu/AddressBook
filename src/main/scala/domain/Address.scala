package domain

case class Address(city: String, state: String, zipCode: String, address: String)

object ZipCodeComparator extends Ordering[Address] {
  override def compare(x: Address, y: Address): Int = {
    x.zipCode.compareTo(y.zipCode)
  }
}

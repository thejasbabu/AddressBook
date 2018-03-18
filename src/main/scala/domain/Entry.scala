package domain

case class Entry(person: Person, address: Address) {
  def editAddress(address: Address): Entry = {
    Entry(this.person, address)
  }
}

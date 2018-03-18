package domain

case class Entry(person: Person, address: Address) {
  def editAddress(address: Address): Entry = {
    Entry(this.person, address)
  }
}

object LastNameEntryOrdering extends Ordering[Entry] {
  override def compare(x: Entry, y: Entry): Int = {
    LastNameComparator.compare(x.person, y.person)
  }
}

object ZipCodeEntryOrdering extends Ordering[Entry] {
  override def compare(x: Entry, y: Entry): Int = {
    ZipCodeComparator.compare(x.address, y.address)
  }
}
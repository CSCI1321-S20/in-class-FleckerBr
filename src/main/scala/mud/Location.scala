package mud

class Location(val name: String, val desc: String, private var items: List[Item], private val exits: Array[Int]) {

    def description(): String = {
        "\n===========================================================================\n" +
        name + "\n\"" + desc + "\n \n" +listExits() + "\n\n" + listItems() + 
        "\n===========================================================================\n"
    }
    
    def getExit(dir: Int): Option[Location] = ???

    def getItem(itemName: String): Option[Item] = {
        items.find(_.name.toLowerCase == itemName.toLowerCase) match {
        case Some(item) =>
            items = items.filter(_ != item)
            Some(item)
        case None => None
        }
    }

    def dropItem(item: Item): Unit = items ::= item

    def listExits(): String = {
        var x = "Exits:\n "
		if (exits(0) != -1) {
            x += "[North] "
        }
		if (exits(1) != -1) {
            x += "[South] "
        }
		if (exits(2) != -1) {
            x += "[East] "
        }
		if (exits(3) != -1) {
            x += "[West] "
        }
		if (exits(4) != -1) {
            x += "[Up] "
        }
		if (exits(5) != -1) {
            x += "[Down] "
        }
		x
	}
	def listItems(): String = {
		var y = "Items:\n "
		for (item <- items) {
			y += "[" + item.name + "] "
        }
        if (y == "Items:\n "){
            y += "[None]"
        }
		y
	}
}

object Location {
  val locations = readLocations()

  def readLocations(): Array[Location] = {
    val source = scala.io.Source.fromFile("world.txt")
    val lines = source.getLines()
    val r = Array.fill(lines.next.toInt)(readLocation(lines))
    source.close()
    r
  }

  def readLocation(lines: Iterator[String]): Location = {
      val name = lines.next()
      val desc = lines.next()
      val items = List.fill(lines.next.toInt)(Item(lines.next(),lines.next()))
      val exits = lines.next().split(",").map(_.toInt)
      new Location(name, desc, items, exits)
  }
}
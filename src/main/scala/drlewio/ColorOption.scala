package drlewio

object ColorOption extends Enumeration {
    val Red, Yellow, Blue = Value

    def randomColor: ColorOption.Value = util.Random.nextInt(3) match {
        case 0 => Red
        case 1 => Yellow
        case 2 => Blue
    }
}
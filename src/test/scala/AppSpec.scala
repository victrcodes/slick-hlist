import org.scalatest._

class AppSpec extends FlatSpec with Matchers {
	
	"Hello" should "have tests" in {
		true should === (true)
	}
	
}

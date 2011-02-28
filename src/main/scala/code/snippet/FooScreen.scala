package code.snippet

import code.model.Foo
import net.liftweb.http.{S, LiftScreen}

class FooScreen extends LiftScreen {

  object foo extends ScreenVar[Foo](Foo.createRecord)

  addFields(() => foo.ok)
  addFields(() => foo.fail)

  protected def finish() = {
    S.redirectTo("/")
  }
}
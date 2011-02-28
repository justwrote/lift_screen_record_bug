package code.model

import net.liftweb.mongodb.record._
import net.liftweb.record.field._
import net.liftweb.http.S
import net.liftweb.http.S._
import net.liftweb.common._
import xml.NodeSeq
import net.liftweb.util.Helpers._

class Foo extends MongoRecord[Foo] with MongoId[Foo] {
  def meta = Foo

  object ok extends StringField(this, 50) {
    override def validations = valMinLen(5, "OK must be at least 5 characters long") _ :: super.validations

    private def elem = S.fmapFunc(SFuncHolder(this.setFromAny(_))) {
      funcName =>
      <input type="text" maxlength={maxLength.toString}
        name={funcName}
        value={valueBox openOr ""}
        tabindex={tabIndex toString}/>
    }

    override def toForm: Box[NodeSeq] =
      uniqueFieldId match {
        case Full(id) => Full(elem % ("id" -> (id)))
        case _ => Full(elem)
      }
  }

  object fail extends StringField(this, 50) {
    override def validations = valMinLen(5, "FAIL must be at least 5 characters long") _ :: super.validations
  }
}

object Foo extends Foo with MongoMetaRecord[Foo]
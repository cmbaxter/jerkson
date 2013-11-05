package com.codahale.jerkson.ser

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.{SerializerProvider, JsonSerializer}

class MapSerializer extends JsonSerializer[collection.Map[_ ,_]] {
  def serialize(map: collection.Map[_,_], json: JsonGenerator, provider: SerializerProvider) {
    json.writeStartObject()
    map.foreach{ tup:(Any,Any) =>
      provider.defaultSerializeField(tup._1.toString, tup._2, json)
    }
    json.writeEndObject()
  }
}

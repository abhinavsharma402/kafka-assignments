import java.util
import java.util.Properties

import org.apache.kafka.clients.consumer.KafkaConsumer

import scala.collection.JavaConverters._

/**
 * Consumer class used to consume message from .
 */
object Consumer {

  def main(args: Array[String]): Unit = {

    consumeMessage("json-demo")

  }

  /**
   * consumeMessage used to consume message from kafka.
   *
   * @param topic name of topic.
   */

  def consumeMessage(topic: String): Unit = {

    val props = new Properties()

    props.put("bootstrap.servers", "localhost:9092")

    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")

    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")

    props.put("auto.offset.reset", "latest")

    props.put("group.id", "consumer-group")

    val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](props)
    println(consumer)
    println(consumer.subscribe(util.Arrays.asList(topic)))
    val time = 3000
    val record = consumer.poll(time).asScala



    //    implicit val formats = DefaultFormats
    //    record.foreach(data=> {
    //
    //    println(write(data))
    //
    //    })


    //    for (data <- record.iterator)
    //      println(data.key())
    //
    //
    for (data <- record.iterator)
      println(data.value())

    consumer.close

  }

}

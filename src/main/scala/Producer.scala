import java.io.{BufferedWriter, File, FileWriter}
import java.util.Properties

import com.knoldus.controller.{JsonStringCreate, ParseJson}
import com.knoldus.model.Employee
import org.apache.jute.Record
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

/**
 * this class is used to produce message on kafka.
 */
object Producer {

  def main(args: Array[String]): Unit = {
    val jsonStringCreateObj=new JsonStringCreate
    val parseJsonObj=new ParseJson
    val jsonStr=jsonStringCreateObj.getCreatedJsonString
    val parsedJson= parseJsonObj.parseJsonString(jsonStr)
    produceMessage("json-demo",jsonStr,parsedJson)

    /**
     *produceMessage used to produce message on kafka
     * @param topic name of the topic.
     * @param jsonString.string of json.
     * @param employee. case class of employee.
     */

    def produceMessage(topic: String,jsonString:String,employee: Employee): Unit = {

      val props = new Properties()

      props.put("bootstrap.servers", "localhost:9092")

      props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")

      props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

      val producer = new KafkaProducer[String,String](props)

      val record = new ProducerRecord[String,String](topic,"1",jsonStr)
      val writer = new BufferedWriter(new FileWriter(new File("./src/main/resources/sample1.txt"),true))
      writer.write(employee.toString)
      writer.close()
      producer.send(record)
      producer.close()

    }

  }
}

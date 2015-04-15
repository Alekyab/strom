package StromExamples;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;
import java.util.Map;

public class BoltExample extends BaseRichBolt {
	private int count = 0;

	public void execute(Tuple tuple) {
		String test = tuple.getStringByField("count");
		if (test == "Nike") {
			count++;
			System.out.println(" Nike - Current Count  "
					+ Integer.toString(count));
		}
	}

	public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
	}

	public void prepare(Map stormConf, TopologyContext context,
			OutputCollector collector) {
		// TODO Auto-generated method stub

	}
}
package StromExamples;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import java.util.Map;
import java.util.Random;

public class SpoutExample extends BaseRichSpout {
	private SpoutOutputCollector collector;
	private int random;

	public SpoutExample() {
		Random rand = new Random();
		random = rand.nextInt(2);
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("count"));
	}

	public void open(Map conf, TopologyContext topologyContext,
			SpoutOutputCollector collector) {
		this.collector = collector;
	}

	public void nextTuple() {
		final Random rand = new Random();
		int instanceRandom = rand.nextInt(2);
		if (instanceRandom == random) {
			collector.emit(new Values("Nike"));
		} else {
			collector.emit(new Values("Rebok"));
		}
	}
}
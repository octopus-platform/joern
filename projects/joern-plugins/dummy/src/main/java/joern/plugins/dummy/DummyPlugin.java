package joern.plugins.dummy;

import org.json.JSONObject;

import com.tinkerpop.blueprints.impls.orient.OrientGraphNoTx;

import joern.pluginlib.plugintypes.JoernPlugin;

public class DummyPlugin extends JoernPlugin
{

	private String myParameter = "";
	private OrientGraphNoTx graph;

	@Override
	public void configure(JSONObject settings)
	{
		super.configure(settings);
		myParameter = settings.getString("myParameter");
	}

	 @Override
     public void execute() throws Exception
	 {
		 graph = getOrientConnector().getNoTxGraphInstance();

		 System.out.println(myParameter);

		 graph.shutdown();
	 }

}

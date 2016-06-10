package inputModules.csv.KeyedCSV;

import java.util.Objects;

public class CSVKey
{
	private String name;
	private String type;
	public static final String DEFAULT_TYPE = "string";

	public CSVKey(String name) {
		this(name, DEFAULT_TYPE);
	}

	public CSVKey(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public String getName()
	{
		return name;
	}

	public String getType()
	{
		return type;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setType(String type)
	{
		this.type = type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof CSVKey))
			return false;
		return this.name.equals(((CSVKey)obj).name) && this.type.equals(((CSVKey)obj).type);
	}
	
	/**
	 * Needed for HashMap<CSVKey,T>
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.name, this.type);
	}
	
	@Override
	public String toString() {
		return this.name + ":" + this.type;
	}
}

package pkg;
public class TestFile2
{
  int sampleValue;
  public TestFile2 (int sampleValue)
  {
    if (sampleValue > 0)
    {
      this.sampleValue = sampleValue;
    }
    else
    {
      this.sampleValue = -1;
    }
  }
}
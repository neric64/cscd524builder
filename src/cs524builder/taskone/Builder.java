package cs524builder.taskone;

//=============================================================================================================================================================
/**
 * Creates a builder that reads and executes a component-definition file.
 * 
 * @author Dan Tappan [06.02.13]
 */
public class Builder
{
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Executes the builder.
    * 
    * @param arguments - the fully qualified filename of the definition file
    */
   public static void main(final String[] arguments)
   {
      if (arguments.length != 2)
      {
         throw new RuntimeException("usage: input_filename output_filename ");
      }

      try
      {
         BuilderParser parser = new BuilderParser(arguments[0], arguments[1]);

         parser.parse();
      }
      catch (Exception exception)
      {
         exception.printStackTrace();
      }
   }
}

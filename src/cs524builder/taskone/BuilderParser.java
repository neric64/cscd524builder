/* Generated By:JavaCC: Do not edit this line. BuilderParser.java */
package cs524builder.taskone;

import java.util.*;
import java.io.*;

public class BuilderParser implements BuilderParserConstants {
   /** the fully qualified output filename of the Gnuplot file */
   private String _outputFilenameFull;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a parser.  Call <tt>parse()</tt> to execute it.
    *
    * @param inputFilenameFull - the fully qualified input filename of the tank source file
    * @param outputFilenameFull - the fully qualified output filename of the Gnuplot file
    *
    * @throws IOException if there is any file error
    */
   public BuilderParser(final String inputFilenameFull, final String outputFilenameFull) throws IOException
   {
      this(new BufferedReader(new FileReader(inputFilenameFull)));

      assert (outputFilenameFull != null);

      _outputFilenameFull = outputFilenameFull;
   }

  final public void parse() throws ParseException {
   List<String> arguments;
    label_1:
    while (true) {
      arguments = Command();
        System.out.println("arguments: "+ arguments);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DEFINE:
      case EXPORT_TO_GNUPLOT:
      case PRINT_XML:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
    }
    jj_consume_token(0);
  }

  final private List<String> Command() throws ParseException {
        List<String> arguments = new ArrayList<String>();
        String argument;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DEFINE:
      arguments = Define();
      break;
    case EXPORT_TO_GNUPLOT:
      arguments = ExportToGnuplot();
      break;
    case PRINT_XML:
      arguments = PrintXML();
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(SEMICOLON);
                {if (true) return arguments;}
    throw new Error("Missing return statement in function");
  }

  final private List<String> Define() throws ParseException {
        List<String> args = new ArrayList<String>();
        String argument;
    jj_consume_token(DEFINE);
    argument = Variable();
                Builder.setId(argument);
    jj_consume_token(ASSIGN);
    args = ComponentDefinition();
                args.add(0, argument);
                {if (true) return args;}
    throw new Error("Missing return statement in function");
  }

  final private List<String> ComponentDefinition() throws ParseException {
        List<String> compArgs = new ArrayList<String>();
        List<String> temp = new ArrayList<String>();
        String argument;
    jj_consume_token(LPAREN);
    argument = Identifier();
    compArgs = Volume();
                Builder.setComponent(argument);

                compArgs.add(0, argument);
    temp = Socket();
                compArgs.addAll(temp);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CONNECTS_TO:
      //I can read three of the blocks, but not four.  When I try to read four gun is skipped and sensor is not.
                      temp = Connections();
                        compArgs.addAll(temp);
      break;
    default:
      jj_la1[2] = jj_gen;
      ;
    }
    jj_consume_token(RPAREN);
                {if (true) return compArgs;}
    throw new Error("Missing return statement in function");
  }

  final private List<String> Connections() throws ParseException {
        List<String> arguments = new ArrayList<String>();
        List<String> temp = new ArrayList<String>();
        String argument;
    jj_consume_token(CONNECTS_TO);
    jj_consume_token(LPAREN);
    label_2:
    while (true) {
      temp = ComponentDefinition();
      jj_consume_token(AT);
      arguments = Triple();
                        arguments.addAll(0, temp);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LPAREN:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
    }
    jj_consume_token(RPAREN);
                {if (true) return arguments;}
    throw new Error("Missing return statement in function");
  }

  final private List<String> ExportToGnuplot() throws ParseException {
        List<String> arguments = new ArrayList<String>();
        String argument;
    jj_consume_token(EXPORT_TO_GNUPLOT);
    jj_consume_token(LPAREN);
    argument = Variable();
    jj_consume_token(COMMA);
    arguments = Triple();
                Builder.printGnu(argument, arguments);
                arguments.add(0, argument);
    jj_consume_token(RPAREN);
                {if (true) return arguments;}
    throw new Error("Missing return statement in function");
  }

  final private List<String> PrintXML() throws ParseException {
        List<String> print = new ArrayList<String>();
        String id;
    jj_consume_token(PRINT_XML);
    jj_consume_token(LPAREN);
    id = Variable();
                Builder.PrintXML(id);

                print.add(id);
    jj_consume_token(RPAREN);
                {if (true) return print;}
    throw new Error("Missing return statement in function");
  }

  final private List<String> Socket() throws ParseException {
        List<String> sNums = new ArrayList<String>();
    jj_consume_token(SOCKET);
    jj_consume_token(ASSIGN);
    sNums = Triple();
                Builder.setSocket(sNums);
                {if (true) return sNums;}
    throw new Error("Missing return statement in function");
  }

  final private List<String> Volume() throws ParseException {
        List<String> vNums = new ArrayList<String>();
    jj_consume_token(VOLUME);
    jj_consume_token(ASSIGN);
    vNums = Triple();
                Builder.setVolume(vNums);
                {if (true) return vNums;}
    throw new Error("Missing return statement in function");
  }

  final private List<String> Triple() throws ParseException {
        List<String> nums = new ArrayList<String>();
        String num;
    jj_consume_token(LBRACKET);
    jj_consume_token(LITERAL_NUMBER);
                num = token.image;
                nums.add(num);
    jj_consume_token(COMMA);
    jj_consume_token(LITERAL_NUMBER);
                num = token.image;
                nums.add(num);
    jj_consume_token(COMMA);
    jj_consume_token(LITERAL_NUMBER);
                num = token.image;
                nums.add(num);
    jj_consume_token(RBRACKET);
                {if (true) return nums;}
    throw new Error("Missing return statement in function");
  }

  final private String Variable() throws ParseException {
   String variable;
    jj_consume_token(IDENTIFIER);
            variable = token.image;

                {if (true) return variable;}
    throw new Error("Missing return statement in function");
  }

  final private String Identifier() throws ParseException {
        String name;
    jj_consume_token(ID);
    jj_consume_token(ASSIGN);
    jj_consume_token(LITERAL_STRING);
                name = token.image;

                {if (true) return name;}
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public BuilderParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[4];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x26000,0x26000,0x1000,0x10000000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public BuilderParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public BuilderParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new BuilderParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public BuilderParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new BuilderParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public BuilderParser(BuilderParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(BuilderParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[41];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 4; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 41; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}

/* Generated By:JavaCC: Do not edit this line. BuilderParserDemo.java */
package cs524builder.parserdemo;

import java.util.*;
import java.io.*;

//=============================================================================================================================================================
/**
 * Defines a demo parser that reads simple function calls from a source file.  The grammar allows calls like these:
 *
 * <code>
 * function();
 * function(a);
 * function(a,b);
 * function(a,b,c);
 * </code>
 *
 * with the output:
 *
 * <code>
 * arguments: []
 * arguments: [a]
 * arguments: [a, b]
 * arguments: [a, b, c]
 * </code>
 *
 * It does not write anything to the output file.
 *
 * @author Dan Tappan [06.02.13]
 */
public class BuilderParserDemo implements BuilderParserDemoConstants {
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
   public BuilderParserDemo(final String inputFilenameFull, final String outputFilenameFull) throws IOException
   {
      this(new BufferedReader(new FileReader(inputFilenameFull)));

      assert (outputFilenameFull != null);

      _outputFilenameFull = outputFilenameFull;
   }

  final public void parse() throws ParseException {
   List<String> arguments;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      arguments = Function();
      jj_consume_token(SEMICOLON);
        System.out.println("arguments: "+ arguments);
    }
    jj_consume_token(0);
  }

  final private List<String> Function() throws ParseException {
   List<String> arguments = new ArrayList<String>();

   String argument;
    jj_consume_token(IDENTIFIER);
    jj_consume_token(LPAREN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      argument = Variable();
         arguments.add(argument);
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[1] = jj_gen;
          break label_2;
        }
        jj_consume_token(COMMA);
        argument = Variable();
            arguments.add(argument);
      }
      break;
    default:
      jj_la1[2] = jj_gen;
      ;
    }
    jj_consume_token(RPAREN);
      {if (true) return arguments;}
    throw new Error("Missing return statement in function");
  }

  final private String Variable() throws ParseException {
   String variable;
    jj_consume_token(IDENTIFIER);
      variable = token.image;

      {if (true) return variable;}
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public BuilderParserDemoTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[3];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x40000000,0x8000,0x40000000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public BuilderParserDemo(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public BuilderParserDemo(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new BuilderParserDemoTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public BuilderParserDemo(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new BuilderParserDemoTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public BuilderParserDemo(BuilderParserDemoTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(BuilderParserDemoTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
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
    boolean[] la1tokens = new boolean[33];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 3; i++) {
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
    for (int i = 0; i < 33; i++) {
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

// Generated from ./FunctionGrammar.g4 by ANTLR 4.0

	package antlr;


  import java.util.Stack;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FunctionGrammarParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__57=1, T__56=2, T__55=3, T__54=4, T__53=5, T__52=6, T__51=7, T__50=8, 
		T__49=9, T__48=10, T__47=11, T__46=12, T__45=13, T__44=14, T__43=15, T__42=16, 
		T__41=17, T__40=18, T__39=19, T__38=20, T__37=21, T__36=22, T__35=23, 
		T__34=24, T__33=25, T__32=26, T__31=27, T__30=28, T__29=29, T__28=30, 
		T__27=31, T__26=32, T__25=33, T__24=34, T__23=35, T__22=36, T__21=37, 
		T__20=38, T__19=39, T__18=40, T__17=41, T__16=42, T__15=43, T__14=44, 
		T__13=45, T__12=46, T__11=47, T__10=48, T__9=49, T__8=50, T__7=51, T__6=52, 
		T__5=53, T__4=54, T__3=55, T__2=56, T__1=57, T__0=58, IF=59, ELSE=60, 
		FOR=61, WHILE=62, BREAK=63, CASE=64, CONTINUE=65, SWITCH=66, DO=67, GOTO=68, 
		RETURN=69, TYPEDEF=70, VOID=71, UNSIGNED=72, SIGNED=73, LONG=74, CV_QUALIFIER=75, 
		VIRTUAL=76, TRY=77, CATCH=78, THROW=79, USING=80, NAMESPACE=81, AUTO=82, 
		REGISTER=83, OPERATOR=84, TEMPLATE=85, ALPHA_NUMERIC=86, OPENING_CURLY=87, 
		CLOSING_CURLY=88, PRE_IF=89, PRE_ELSE=90, PRE_ENDIF=91, HEX_LITERAL=92, 
		DECIMAL_LITERAL=93, OCTAL_LITERAL=94, FLOATING_POINT_LITERAL=95, CHAR=96, 
		STRING=97, COMMENT=98, WHITESPACE=99, CPPCOMMENT=100, OTHER=101;
	public static final String[] tokenNames = {
		"<INVALID>", "'&'", "'['", "'*'", "'<'", "'--'", "'!='", "'<='", "'<<'", 
		"'%'", "'->'", "'*='", "'union'", "')'", "'explicit'", "'inline'", "'::'", 
		"'='", "'|='", "'new'", "'class'", "'|'", "'!'", "'enum'", "']'", "'<<='", 
		"'-='", "'->*'", "'public'", "','", "'-'", "'('", "':'", "'&='", "'private'", 
		"'?'", "'>>='", "'+='", "'^='", "'friend'", "'struct'", "'static'", "'++'", 
		"'>>'", "'^'", "'delete'", "'.'", "'+'", "'protected'", "';'", "'&&'", 
		"'||'", "'>'", "'%='", "'/='", "'/'", "'=='", "'~'", "'>='", "'if'", "'else'", 
		"'for'", "'while'", "'break'", "'case'", "'continue'", "'switch'", "'do'", 
		"'goto'", "'return'", "'typedef'", "'void'", "'unsigned'", "'signed'", 
		"'long'", "CV_QUALIFIER", "'virtual'", "'try'", "'catch'", "'throw'", 
		"'using'", "'namespace'", "'auto'", "'register'", "'operator'", "'template'", 
		"ALPHA_NUMERIC", "'{'", "'}'", "PRE_IF", "PRE_ELSE", "PRE_ENDIF", "HEX_LITERAL", 
		"DECIMAL_LITERAL", "OCTAL_LITERAL", "FLOATING_POINT_LITERAL", "CHAR", 
		"STRING", "COMMENT", "WHITESPACE", "CPPCOMMENT", "OTHER"
	};
	public static final int
		RULE_statements = 0, RULE_statement = 1, RULE_opening_curly = 2, RULE_closing_curly = 3, 
		RULE_block_starter = 4, RULE_selection_statement = 5, RULE_if_statement = 6, 
		RULE_else_statement = 7, RULE_switch_statement = 8, RULE_iteration_statement = 9, 
		RULE_for_statement = 10, RULE_while_statement = 11, RULE_do_statement = 12, 
		RULE_do_statement1 = 13, RULE_for_init_statement = 14, RULE_jump_statement = 15, 
		RULE_break_or_continue = 16, RULE_return_statement = 17, RULE_goto_statement = 18, 
		RULE_try_block = 19, RULE_catch_block = 20, RULE_label = 21, RULE_expr_statement = 22, 
		RULE_condition = 23, RULE_unary_operator = 24, RULE_relational_operator = 25, 
		RULE_constant = 26, RULE_function_decl_specifiers = 27, RULE_class_key = 28, 
		RULE_ptr_operator = 29, RULE_access_specifier = 30, RULE_operator_function_id = 31, 
		RULE_operator = 32, RULE_assignment_operator = 33, RULE_equality_operator = 34, 
		RULE_template_decl_start = 35, RULE_template_param_list = 36, RULE_no_brackets = 37, 
		RULE_no_brackets_curlies_or_squares = 38, RULE_no_brackets_or_semicolon = 39, 
		RULE_no_angle_brackets_or_brackets = 40, RULE_no_curlies = 41, RULE_no_squares = 42, 
		RULE_no_squares_or_semicolon = 43, RULE_no_comma_or_semicolon = 44, RULE_assign_water = 45, 
		RULE_assign_water_l2 = 46, RULE_water = 47, RULE_expr = 48, RULE_assign_expr = 49, 
		RULE_conditional_expression = 50, RULE_or_expression = 51, RULE_and_expression = 52, 
		RULE_inclusive_or_expression = 53, RULE_exclusive_or_expression = 54, 
		RULE_bit_and_expression = 55, RULE_equality_expression = 56, RULE_relational_expression = 57, 
		RULE_shift_expression = 58, RULE_additive_expression = 59, RULE_multiplicative_expression = 60, 
		RULE_cast_expression = 61, RULE_unary_expression = 62, RULE_postfix_expression = 63, 
		RULE_field = 64, RULE_function_call_tail = 65, RULE_call_template_list = 66, 
		RULE_function_argument_list = 67, RULE_function_argument = 68, RULE_postfix = 69, 
		RULE_primary_expression = 70, RULE_init_declarator = 71, RULE_type_suffix = 72, 
		RULE_simple_decl = 73, RULE_var_decl = 74, RULE_init_declarator_list = 75, 
		RULE_initializer = 76, RULE_initializer_list = 77, RULE_class_def = 78, 
		RULE_class_name = 79, RULE_base_classes = 80, RULE_base_class = 81, RULE_type_name = 82, 
		RULE_base_type = 83, RULE_param_decl_specifiers = 84, RULE_parameter_name = 85, 
		RULE_param_type_list = 86, RULE_param_type = 87, RULE_param_type_id = 88, 
		RULE_identifier = 89, RULE_number = 90, RULE_ptrs = 91;
	public static final String[] ruleNames = {
		"statements", "statement", "opening_curly", "closing_curly", "block_starter", 
		"selection_statement", "if_statement", "else_statement", "switch_statement", 
		"iteration_statement", "for_statement", "while_statement", "do_statement", 
		"do_statement1", "for_init_statement", "jump_statement", "break_or_continue", 
		"return_statement", "goto_statement", "try_block", "catch_block", "label", 
		"expr_statement", "condition", "unary_operator", "relational_operator", 
		"constant", "function_decl_specifiers", "class_key", "ptr_operator", "access_specifier", 
		"operator_function_id", "operator", "assignment_operator", "equality_operator", 
		"template_decl_start", "template_param_list", "no_brackets", "no_brackets_curlies_or_squares", 
		"no_brackets_or_semicolon", "no_angle_brackets_or_brackets", "no_curlies", 
		"no_squares", "no_squares_or_semicolon", "no_comma_or_semicolon", "assign_water", 
		"assign_water_l2", "water", "expr", "assign_expr", "conditional_expression", 
		"or_expression", "and_expression", "inclusive_or_expression", "exclusive_or_expression", 
		"bit_and_expression", "equality_expression", "relational_expression", 
		"shift_expression", "additive_expression", "multiplicative_expression", 
		"cast_expression", "unary_expression", "postfix_expression", "field", 
		"function_call_tail", "call_template_list", "function_argument_list", 
		"function_argument", "postfix", "primary_expression", "init_declarator", 
		"type_suffix", "simple_decl", "var_decl", "init_declarator_list", "initializer", 
		"initializer_list", "class_def", "class_name", "base_classes", "base_class", 
		"type_name", "base_type", "param_decl_specifiers", "parameter_name", "param_type_list", 
		"param_type", "param_type_id", "identifier", "number", "ptrs"
	};

	@Override
	public String getGrammarFileName() { return "FunctionGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


	            public boolean skipToEndOfObject()
	            {
	                Stack<Object> CurlyStack = new Stack<Object>();
	                Object o = new Object();
	                int t = _input.LA(1);

	                while(t != EOF && !(CurlyStack.empty() && t == CLOSING_CURLY)){
	                    
	                    if(t == PRE_ELSE){
	                        Stack<Object> ifdefStack = new Stack<Object>();
	                        consume();
	                        t = _input.LA(1);
	                        
	                        while(t != EOF && !(ifdefStack.empty() && (t == PRE_ENDIF))){
	                            if(t == PRE_IF)
	                                ifdefStack.push(o);
	                            else if(t == PRE_ENDIF)
	                                ifdefStack.pop();
	                            consume();
	                            t = _input.LA(1);
	                        }
	                    }
	                    
	                    if(t == OPENING_CURLY)
	                        CurlyStack.push(o);
	                    else if(t == CLOSING_CURLY)
	                        CurlyStack.pop();
	                    
	                    consume();
	                    t = _input.LA(1);
	                }
	                if(t != EOF)
	                    consume();
	                return true;
	            }

	   // this should go into FunctionGrammar but ANTLR fails
	   // to join the parser::members-section on inclusion
	   
	   public boolean preProcSkipToEnd()
	   {
	                Stack<Object> CurlyStack = new Stack<Object>();
	                Object o = new Object();
	                int t = _input.LA(1);

	                while(t != EOF && !(CurlyStack.empty() && t == PRE_ENDIF)){
	                                        
	                    if(t == PRE_IF)
	                        CurlyStack.push(o);
	                    else if(t == PRE_ENDIF)
	                        CurlyStack.pop();
	                    
	                    consume();
	                    t = _input.LA(1);
	                }
	                if(t != EOF)
	                    consume();
	                return true;
	   }


	public FunctionGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode EOF() { return getToken(FunctionGrammarParser.EOF, 0); }
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)) | (1L << (5 - 64)) | (1L << (12 - 64)) | (1L << (20 - 64)) | (1L << (22 - 64)) | (1L << (23 - 64)) | (1L << (28 - 64)) | (1L << (30 - 64)) | (1L << (31 - 64)) | (1L << (34 - 64)) | (1L << (40 - 64)) | (1L << (42 - 64)) | (1L << (47 - 64)) | (1L << (48 - 64)) | (1L << (57 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)))) != 0)) {
				{
				{
				setState(184); statement();
				}
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(190); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public WaterContext water() {
			return getRuleContext(WaterContext.class,0);
		}
		public Closing_curlyContext closing_curly() {
			return getRuleContext(Closing_curlyContext.class,0);
		}
		public Opening_curlyContext opening_curly() {
			return getRuleContext(Opening_curlyContext.class,0);
		}
		public TerminalNode PRE_ELSE() { return getToken(FunctionGrammarParser.PRE_ELSE, 0); }
		public Expr_statementContext expr_statement() {
			return getRuleContext(Expr_statementContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public Jump_statementContext jump_statement() {
			return getRuleContext(Jump_statementContext.class,0);
		}
		public Simple_declContext simple_decl() {
			return getRuleContext(Simple_declContext.class,0);
		}
		public Block_starterContext block_starter() {
			return getRuleContext(Block_starterContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(202);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(192); match(PRE_ELSE);
				preProcSkipToEnd(); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(194); opening_curly();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(195); closing_curly();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(196); block_starter();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(197); jump_statement();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(198); simple_decl();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(199); label();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(200); expr_statement();
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(201); water();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Opening_curlyContext extends ParserRuleContext {
		public Opening_curlyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opening_curly; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterOpening_curly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitOpening_curly(this);
		}
	}

	public final Opening_curlyContext opening_curly() throws RecognitionException {
		Opening_curlyContext _localctx = new Opening_curlyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_opening_curly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204); match(OPENING_CURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Closing_curlyContext extends ParserRuleContext {
		public Closing_curlyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closing_curly; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterClosing_curly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitClosing_curly(this);
		}
	}

	public final Closing_curlyContext closing_curly() throws RecognitionException {
		Closing_curlyContext _localctx = new Closing_curlyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_closing_curly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206); match(CLOSING_CURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Block_starterContext extends ParserRuleContext {
		public Catch_blockContext catch_block() {
			return getRuleContext(Catch_blockContext.class,0);
		}
		public Selection_statementContext selection_statement() {
			return getRuleContext(Selection_statementContext.class,0);
		}
		public Iteration_statementContext iteration_statement() {
			return getRuleContext(Iteration_statementContext.class,0);
		}
		public Try_blockContext try_block() {
			return getRuleContext(Try_blockContext.class,0);
		}
		public Block_starterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_starter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterBlock_starter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitBlock_starter(this);
		}
	}

	public final Block_starterContext block_starter() throws RecognitionException {
		Block_starterContext _localctx = new Block_starterContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block_starter);
		try {
			setState(212);
			switch (_input.LA(1)) {
			case IF:
			case ELSE:
			case SWITCH:
				enterOuterAlt(_localctx, 1);
				{
				setState(208); selection_statement();
				}
				break;
			case FOR:
			case WHILE:
			case DO:
				enterOuterAlt(_localctx, 2);
				{
				setState(209); iteration_statement();
				}
				break;
			case TRY:
				enterOuterAlt(_localctx, 3);
				{
				setState(210); try_block();
				}
				break;
			case CATCH:
				enterOuterAlt(_localctx, 4);
				{
				setState(211); catch_block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Selection_statementContext extends ParserRuleContext {
		public Else_statementContext else_statement() {
			return getRuleContext(Else_statementContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public Switch_statementContext switch_statement() {
			return getRuleContext(Switch_statementContext.class,0);
		}
		public Selection_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterSelection_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitSelection_statement(this);
		}
	}

	public final Selection_statementContext selection_statement() throws RecognitionException {
		Selection_statementContext _localctx = new Selection_statementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_selection_statement);
		try {
			setState(217);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(214); if_statement();
				}
				break;
			case ELSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(215); else_statement();
				}
				break;
			case SWITCH:
				enterOuterAlt(_localctx, 3);
				{
				setState(216); switch_statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_statementContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode IF() { return getToken(FunctionGrammarParser.IF, 0); }
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitIf_statement(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219); match(IF);
			setState(220); match(31);
			setState(221); condition();
			setState(222); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Else_statementContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(FunctionGrammarParser.ELSE, 0); }
		public Else_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterElse_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitElse_statement(this);
		}
	}

	public final Else_statementContext else_statement() throws RecognitionException {
		Else_statementContext _localctx = new Else_statementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_else_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224); match(ELSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Switch_statementContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode SWITCH() { return getToken(FunctionGrammarParser.SWITCH, 0); }
		public Switch_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterSwitch_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitSwitch_statement(this);
		}
	}

	public final Switch_statementContext switch_statement() throws RecognitionException {
		Switch_statementContext _localctx = new Switch_statementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_switch_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226); match(SWITCH);
			setState(227); match(31);
			setState(228); condition();
			setState(229); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Iteration_statementContext extends ParserRuleContext {
		public While_statementContext while_statement() {
			return getRuleContext(While_statementContext.class,0);
		}
		public For_statementContext for_statement() {
			return getRuleContext(For_statementContext.class,0);
		}
		public Do_statementContext do_statement() {
			return getRuleContext(Do_statementContext.class,0);
		}
		public Iteration_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iteration_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterIteration_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitIteration_statement(this);
		}
	}

	public final Iteration_statementContext iteration_statement() throws RecognitionException {
		Iteration_statementContext _localctx = new Iteration_statementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_iteration_statement);
		try {
			setState(234);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(231); for_statement();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 2);
				{
				setState(232); do_statement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(233); while_statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class For_statementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(FunctionGrammarParser.FOR, 0); }
		public For_init_statementContext for_init_statement() {
			return getRuleContext(For_init_statementContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public For_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterFor_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitFor_statement(this);
		}
	}

	public final For_statementContext for_statement() throws RecognitionException {
		For_statementContext _localctx = new For_statementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_for_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236); match(FOR);
			setState(237); match(31);
			setState(238); for_init_statement();
			setState(239); condition();
			setState(240); match(49);
			setState(242);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 22) | (1L << 30) | (1L << 31) | (1L << 42) | (1L << 47) | (1L << 57))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (ALPHA_NUMERIC - 86)) | (1L << (HEX_LITERAL - 86)) | (1L << (DECIMAL_LITERAL - 86)) | (1L << (OCTAL_LITERAL - 86)) | (1L << (FLOATING_POINT_LITERAL - 86)) | (1L << (CHAR - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				setState(241); expr();
				}
			}

			setState(244); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_statementContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(FunctionGrammarParser.WHILE, 0); }
		public While_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterWhile_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitWhile_statement(this);
		}
	}

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_while_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246); match(WHILE);
			setState(247); match(31);
			setState(248); condition();
			setState(249); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Do_statementContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(FunctionGrammarParser.DO, 0); }
		public Do_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_do_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterDo_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitDo_statement(this);
		}
	}

	public final Do_statementContext do_statement() throws RecognitionException {
		Do_statementContext _localctx = new Do_statementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_do_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251); match(DO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Do_statement1Context extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Do_statement1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_do_statement1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterDo_statement1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitDo_statement1(this);
		}
	}

	public final Do_statement1Context do_statement1() throws RecognitionException {
		Do_statement1Context _localctx = new Do_statement1Context(_ctx, getState());
		enterRule(_localctx, 26, RULE_do_statement1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253); match(DO);
			setState(254); statement();
			setState(255); match(WHILE);
			setState(256); match(31);
			setState(257); expr();
			setState(258); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class For_init_statementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Simple_declContext simple_decl() {
			return getRuleContext(Simple_declContext.class,0);
		}
		public For_init_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_init_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterFor_init_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitFor_init_statement(this);
		}
	}

	public final For_init_statementContext for_init_statement() throws RecognitionException {
		For_init_statementContext _localctx = new For_init_statementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_for_init_statement);
		int _la;
		try {
			setState(265);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(260); simple_decl();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 22) | (1L << 30) | (1L << 31) | (1L << 42) | (1L << 47) | (1L << 57))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (ALPHA_NUMERIC - 86)) | (1L << (HEX_LITERAL - 86)) | (1L << (DECIMAL_LITERAL - 86)) | (1L << (OCTAL_LITERAL - 86)) | (1L << (FLOATING_POINT_LITERAL - 86)) | (1L << (CHAR - 86)) | (1L << (STRING - 86)))) != 0)) {
					{
					setState(261); expr();
					}
				}

				setState(264); match(49);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Jump_statementContext extends ParserRuleContext {
		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class,0);
		}
		public Break_or_continueContext break_or_continue() {
			return getRuleContext(Break_or_continueContext.class,0);
		}
		public Goto_statementContext goto_statement() {
			return getRuleContext(Goto_statementContext.class,0);
		}
		public Jump_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jump_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterJump_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitJump_statement(this);
		}
	}

	public final Jump_statementContext jump_statement() throws RecognitionException {
		Jump_statementContext _localctx = new Jump_statementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_jump_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			switch (_input.LA(1)) {
			case BREAK:
			case CONTINUE:
				{
				setState(267); break_or_continue();
				}
				break;
			case RETURN:
				{
				setState(268); return_statement();
				}
				break;
			case GOTO:
				{
				setState(269); goto_statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(272); match(49);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Break_or_continueContext extends ParserRuleContext {
		public Break_or_continueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_break_or_continue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterBreak_or_continue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitBreak_or_continue(this);
		}
	}

	public final Break_or_continueContext break_or_continue() throws RecognitionException {
		Break_or_continueContext _localctx = new Break_or_continueContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_break_or_continue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			_la = _input.LA(1);
			if ( !(_la==BREAK || _la==CONTINUE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_statementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterReturn_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitReturn_statement(this);
		}
	}

	public final Return_statementContext return_statement() throws RecognitionException {
		Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_return_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276); match(RETURN);
			setState(278);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 22) | (1L << 30) | (1L << 31) | (1L << 42) | (1L << 47) | (1L << 57))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (ALPHA_NUMERIC - 86)) | (1L << (HEX_LITERAL - 86)) | (1L << (DECIMAL_LITERAL - 86)) | (1L << (OCTAL_LITERAL - 86)) | (1L << (FLOATING_POINT_LITERAL - 86)) | (1L << (CHAR - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				setState(277); expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Goto_statementContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Goto_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goto_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterGoto_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitGoto_statement(this);
		}
	}

	public final Goto_statementContext goto_statement() throws RecognitionException {
		Goto_statementContext _localctx = new Goto_statementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_goto_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280); match(GOTO);
			setState(281); identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Try_blockContext extends ParserRuleContext {
		public TerminalNode TRY() { return getToken(FunctionGrammarParser.TRY, 0); }
		public Try_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_try_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterTry_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitTry_block(this);
		}
	}

	public final Try_blockContext try_block() throws RecognitionException {
		Try_blockContext _localctx = new Try_blockContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_try_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283); match(TRY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Catch_blockContext extends ParserRuleContext {
		public Param_typeContext param_type() {
			return getRuleContext(Param_typeContext.class,0);
		}
		public TerminalNode CATCH() { return getToken(FunctionGrammarParser.CATCH, 0); }
		public Catch_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catch_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterCatch_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitCatch_block(this);
		}
	}

	public final Catch_blockContext catch_block() throws RecognitionException {
		Catch_blockContext _localctx = new Catch_blockContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_catch_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285); match(CATCH);
			setState(286); match(31);
			setState(287); param_type();
			setState(288); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public Access_specifierContext access_specifier() {
			return getRuleContext(Access_specifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitLabel(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			switch (_input.LA(1)) {
			case CASE:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
				{
				{
				setState(291);
				_la = _input.LA(1);
				if (_la==CASE) {
					{
					setState(290); match(CASE);
					}
				}

				setState(295);
				switch (_input.LA(1)) {
				case ALPHA_NUMERIC:
					{
					setState(293); identifier();
					}
					break;
				case HEX_LITERAL:
				case DECIMAL_LITERAL:
				case OCTAL_LITERAL:
					{
					setState(294); number();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				break;
			case 28:
			case 34:
			case 48:
				{
				setState(297); access_specifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(300); match(32);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_statementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterExpr_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitExpr_statement(this);
		}
	}

	public final Expr_statementContext expr_statement() throws RecognitionException {
		Expr_statementContext _localctx = new Expr_statementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expr_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302); expr();
			setState(303); match(49);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305); expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_operatorContext extends ParserRuleContext {
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitUnary_operator(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 22) | (1L << 30) | (1L << 47) | (1L << 57))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Relational_operatorContext extends ParserRuleContext {
		public Relational_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterRelational_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitRelational_operator(this);
		}
	}

	public final Relational_operatorContext relational_operator() throws RecognitionException {
		Relational_operatorContext _localctx = new Relational_operatorContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_relational_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 52) | (1L << 58))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode CHAR() { return getToken(FunctionGrammarParser.CHAR, 0); }
		public TerminalNode OCTAL_LITERAL() { return getToken(FunctionGrammarParser.OCTAL_LITERAL, 0); }
		public TerminalNode HEX_LITERAL() { return getToken(FunctionGrammarParser.HEX_LITERAL, 0); }
		public TerminalNode FLOATING_POINT_LITERAL() { return getToken(FunctionGrammarParser.FLOATING_POINT_LITERAL, 0); }
		public TerminalNode DECIMAL_LITERAL() { return getToken(FunctionGrammarParser.DECIMAL_LITERAL, 0); }
		public TerminalNode STRING() { return getToken(FunctionGrammarParser.STRING, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			_la = _input.LA(1);
			if ( !(((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (HEX_LITERAL - 92)) | (1L << (DECIMAL_LITERAL - 92)) | (1L << (OCTAL_LITERAL - 92)) | (1L << (FLOATING_POINT_LITERAL - 92)) | (1L << (CHAR - 92)) | (1L << (STRING - 92)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_decl_specifiersContext extends ParserRuleContext {
		public Function_decl_specifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_decl_specifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterFunction_decl_specifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitFunction_decl_specifiers(this);
		}
	}

	public final Function_decl_specifiersContext function_decl_specifiers() throws RecognitionException {
		Function_decl_specifiersContext _localctx = new Function_decl_specifiersContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_function_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			_la = _input.LA(1);
			if ( !(((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & ((1L << (14 - 14)) | (1L << (15 - 14)) | (1L << (39 - 14)) | (1L << (41 - 14)) | (1L << (VIRTUAL - 14)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_keyContext extends ParserRuleContext {
		public Class_keyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterClass_key(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitClass_key(this);
		}
	}

	public final Class_keyContext class_key() throws RecognitionException {
		Class_keyContext _localctx = new Class_keyContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_class_key);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 20) | (1L << 23) | (1L << 40))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ptr_operatorContext extends ParserRuleContext {
		public Ptr_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ptr_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterPtr_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitPtr_operator(this);
		}
	}

	public final Ptr_operatorContext ptr_operator() throws RecognitionException {
		Ptr_operatorContext _localctx = new Ptr_operatorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_ptr_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			_la = _input.LA(1);
			if ( !(_la==1 || _la==3) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Access_specifierContext extends ParserRuleContext {
		public Access_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_access_specifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterAccess_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitAccess_specifier(this);
		}
	}

	public final Access_specifierContext access_specifier() throws RecognitionException {
		Access_specifierContext _localctx = new Access_specifierContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_access_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 28) | (1L << 34) | (1L << 48))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operator_function_idContext extends ParserRuleContext {
		public TerminalNode OPERATOR() { return getToken(FunctionGrammarParser.OPERATOR, 0); }
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public Operator_function_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_function_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterOperator_function_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitOperator_function_id(this);
		}
	}

	public final Operator_function_idContext operator_function_id() throws RecognitionException {
		Operator_function_idContext _localctx = new Operator_function_idContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_operator_function_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321); match(OPERATOR);
			setState(322); operator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorContext extends ParserRuleContext {
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitOperator(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_operator);
		int _la;
		try {
			setState(369);
			switch (_input.LA(1)) {
			case 19:
			case 45:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(324);
				_la = _input.LA(1);
				if ( !(_la==19 || _la==45) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(327);
				_la = _input.LA(1);
				if (_la==2) {
					{
					setState(325); match(2);
					setState(326); match(24);
					}
				}

				}
				}
				break;
			case 47:
				enterOuterAlt(_localctx, 2);
				{
				setState(329); match(47);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 3);
				{
				setState(330); match(30);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 4);
				{
				setState(331); match(3);
				}
				break;
			case 55:
				enterOuterAlt(_localctx, 5);
				{
				setState(332); match(55);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 6);
				{
				setState(333); match(9);
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 7);
				{
				setState(334); match(44);
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 8);
				{
				setState(335); match(1);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 9);
				{
				setState(336); match(21);
				}
				break;
			case 57:
				enterOuterAlt(_localctx, 10);
				{
				setState(337); match(57);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 11);
				{
				setState(338); match(22);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 12);
				{
				setState(339); match(17);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 13);
				{
				setState(340); match(4);
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 14);
				{
				setState(341); match(52);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 15);
				{
				setState(342); match(37);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 16);
				{
				setState(343); match(26);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 17);
				{
				setState(344); match(11);
				}
				break;
			case 54:
				enterOuterAlt(_localctx, 18);
				{
				setState(345); match(54);
				}
				break;
			case 53:
				enterOuterAlt(_localctx, 19);
				{
				setState(346); match(53);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 20);
				{
				setState(347); match(38);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 21);
				{
				setState(348); match(33);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 22);
				{
				setState(349); match(18);
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 23);
				{
				setState(350); match(43);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 24);
				{
				setState(351); match(8);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 25);
				{
				setState(352); match(36);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 26);
				{
				setState(353); match(25);
				}
				break;
			case 56:
				enterOuterAlt(_localctx, 27);
				{
				setState(354); match(56);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 28);
				{
				setState(355); match(6);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 29);
				{
				setState(356); match(7);
				}
				break;
			case 58:
				enterOuterAlt(_localctx, 30);
				{
				setState(357); match(58);
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 31);
				{
				setState(358); match(50);
				}
				break;
			case 51:
				enterOuterAlt(_localctx, 32);
				{
				setState(359); match(51);
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 33);
				{
				setState(360); match(42);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 34);
				{
				setState(361); match(5);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 35);
				{
				setState(362); match(29);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 36);
				{
				setState(363); match(27);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 37);
				{
				setState(364); match(10);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 38);
				{
				setState(365); match(31);
				setState(366); match(13);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 39);
				{
				setState(367); match(2);
				setState(368); match(24);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assignment_operatorContext extends ParserRuleContext {
		public Assignment_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterAssignment_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitAssignment_operator(this);
		}
	}

	public final Assignment_operatorContext assignment_operator() throws RecognitionException {
		Assignment_operatorContext _localctx = new Assignment_operatorContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_assignment_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 17) | (1L << 18) | (1L << 25) | (1L << 26) | (1L << 33) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 53) | (1L << 54))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Equality_operatorContext extends ParserRuleContext {
		public Equality_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterEquality_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitEquality_operator(this);
		}
	}

	public final Equality_operatorContext equality_operator() throws RecognitionException {
		Equality_operatorContext _localctx = new Equality_operatorContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_equality_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			_la = _input.LA(1);
			if ( !(_la==6 || _la==56) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Template_decl_startContext extends ParserRuleContext {
		public Template_param_listContext template_param_list() {
			return getRuleContext(Template_param_listContext.class,0);
		}
		public TerminalNode TEMPLATE() { return getToken(FunctionGrammarParser.TEMPLATE, 0); }
		public Template_decl_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_decl_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterTemplate_decl_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitTemplate_decl_start(this);
		}
	}

	public final Template_decl_startContext template_decl_start() throws RecognitionException {
		Template_decl_startContext _localctx = new Template_decl_startContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_template_decl_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375); match(TEMPLATE);
			setState(376); match(4);
			setState(377); template_param_list();
			setState(378); match(52);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Template_param_listContext extends ParserRuleContext {
		public Template_param_listContext template_param_list(int i) {
			return getRuleContext(Template_param_listContext.class,i);
		}
		public No_angle_brackets_or_bracketsContext no_angle_brackets_or_brackets(int i) {
			return getRuleContext(No_angle_brackets_or_bracketsContext.class,i);
		}
		public List<No_angle_brackets_or_bracketsContext> no_angle_brackets_or_brackets() {
			return getRuleContexts(No_angle_brackets_or_bracketsContext.class);
		}
		public List<Template_param_listContext> template_param_list() {
			return getRuleContexts(Template_param_listContext.class);
		}
		public Template_param_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_param_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterTemplate_param_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitTemplate_param_list(this);
		}
	}

	public final Template_param_listContext template_param_list() throws RecognitionException {
		Template_param_listContext _localctx = new Template_param_listContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_template_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				setState(389);
				switch (_input.LA(1)) {
				case 4:
					{
					{
					setState(380); match(4);
					setState(381); template_param_list();
					setState(382); match(52);
					}
					}
					break;
				case 31:
					{
					{
					setState(384); match(31);
					setState(385); template_param_list();
					setState(386); match(13);
					}
					}
					break;
				case 1:
				case 2:
				case 3:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
				case 11:
				case 12:
				case 14:
				case 15:
				case 16:
				case 17:
				case 18:
				case 19:
				case 20:
				case 21:
				case 22:
				case 23:
				case 24:
				case 25:
				case 26:
				case 27:
				case 28:
				case 29:
				case 30:
				case 32:
				case 33:
				case 34:
				case 35:
				case 36:
				case 37:
				case 38:
				case 39:
				case 40:
				case 41:
				case 42:
				case 43:
				case 44:
				case 45:
				case 46:
				case 47:
				case 48:
				case 49:
				case 50:
				case 51:
				case 53:
				case 54:
				case 55:
				case 56:
				case 57:
				case 58:
				case IF:
				case ELSE:
				case FOR:
				case WHILE:
				case BREAK:
				case CASE:
				case CONTINUE:
				case SWITCH:
				case DO:
				case GOTO:
				case RETURN:
				case TYPEDEF:
				case VOID:
				case UNSIGNED:
				case SIGNED:
				case LONG:
				case CV_QUALIFIER:
				case VIRTUAL:
				case TRY:
				case CATCH:
				case THROW:
				case USING:
				case NAMESPACE:
				case AUTO:
				case REGISTER:
				case OPERATOR:
				case TEMPLATE:
				case ALPHA_NUMERIC:
				case OPENING_CURLY:
				case CLOSING_CURLY:
				case PRE_IF:
				case PRE_ELSE:
				case PRE_ENDIF:
				case HEX_LITERAL:
				case DECIMAL_LITERAL:
				case OCTAL_LITERAL:
				case FLOATING_POINT_LITERAL:
				case CHAR:
				case STRING:
				case COMMENT:
				case WHITESPACE:
				case CPPCOMMENT:
				case OTHER:
					{
					setState(388); no_angle_brackets_or_brackets();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(393);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class No_bracketsContext extends ParserRuleContext {
		public No_bracketsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_brackets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterNo_brackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitNo_brackets(this);
		}
	}

	public final No_bracketsContext no_brackets() throws RecognitionException {
		No_bracketsContext _localctx = new No_bracketsContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_no_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==13 || _la==31) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class No_brackets_curlies_or_squaresContext extends ParserRuleContext {
		public No_brackets_curlies_or_squaresContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_brackets_curlies_or_squares; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterNo_brackets_curlies_or_squares(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitNo_brackets_curlies_or_squares(this);
		}
	}

	public final No_brackets_curlies_or_squaresContext no_brackets_curlies_or_squares() throws RecognitionException {
		No_brackets_curlies_or_squaresContext _localctx = new No_brackets_curlies_or_squaresContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_no_brackets_curlies_or_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 13) | (1L << 24) | (1L << 31))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class No_brackets_or_semicolonContext extends ParserRuleContext {
		public No_brackets_or_semicolonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_brackets_or_semicolon; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterNo_brackets_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitNo_brackets_or_semicolon(this);
		}
	}

	public final No_brackets_or_semicolonContext no_brackets_or_semicolon() throws RecognitionException {
		No_brackets_or_semicolonContext _localctx = new No_brackets_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_no_brackets_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 31) | (1L << 49))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class No_angle_brackets_or_bracketsContext extends ParserRuleContext {
		public No_angle_brackets_or_bracketsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_angle_brackets_or_brackets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterNo_angle_brackets_or_brackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitNo_angle_brackets_or_brackets(this);
		}
	}

	public final No_angle_brackets_or_bracketsContext no_angle_brackets_or_brackets() throws RecognitionException {
		No_angle_brackets_or_bracketsContext _localctx = new No_angle_brackets_or_bracketsContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_no_angle_brackets_or_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 13) | (1L << 31) | (1L << 52))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class No_curliesContext extends ParserRuleContext {
		public No_curliesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_curlies; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterNo_curlies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitNo_curlies(this);
		}
	}

	public final No_curliesContext no_curlies() throws RecognitionException {
		No_curliesContext _localctx = new No_curliesContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_no_curlies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class No_squaresContext extends ParserRuleContext {
		public No_squaresContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_squares; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterNo_squares(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitNo_squares(this);
		}
	}

	public final No_squaresContext no_squares() throws RecognitionException {
		No_squaresContext _localctx = new No_squaresContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_no_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==2 || _la==24) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class No_squares_or_semicolonContext extends ParserRuleContext {
		public No_squares_or_semicolonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_squares_or_semicolon; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterNo_squares_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitNo_squares_or_semicolon(this);
		}
	}

	public final No_squares_or_semicolonContext no_squares_or_semicolon() throws RecognitionException {
		No_squares_or_semicolonContext _localctx = new No_squares_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_no_squares_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 24) | (1L << 49))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class No_comma_or_semicolonContext extends ParserRuleContext {
		public No_comma_or_semicolonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_comma_or_semicolon; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterNo_comma_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitNo_comma_or_semicolon(this);
		}
	}

	public final No_comma_or_semicolonContext no_comma_or_semicolon() throws RecognitionException {
		No_comma_or_semicolonContext _localctx = new No_comma_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_no_comma_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==29 || _la==49) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_waterContext extends ParserRuleContext {
		public Assign_waterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_water; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterAssign_water(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitAssign_water(this);
		}
	}

	public final Assign_waterContext assign_water() throws RecognitionException {
		Assign_waterContext _localctx = new Assign_waterContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_assign_water);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 13) | (1L << 24) | (1L << 29) | (1L << 31) | (1L << 49))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_water_l2Context extends ParserRuleContext {
		public Assign_water_l2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_water_l2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterAssign_water_l2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitAssign_water_l2(this);
		}
	}

	public final Assign_water_l2Context assign_water_l2() throws RecognitionException {
		Assign_water_l2Context _localctx = new Assign_water_l2Context(_ctx, getState());
		enterRule(_localctx, 92, RULE_assign_water_l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 13) | (1L << 24) | (1L << 31))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WaterContext extends ParserRuleContext {
		public WaterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_water; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterWater(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitWater(this);
		}
	}

	public final WaterContext water() throws RecognitionException {
		WaterContext _localctx = new WaterContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_water);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			matchWildcard();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Assign_exprContext assign_expr(int i) {
			return getRuleContext(Assign_exprContext.class,i);
		}
		public List<Assign_exprContext> assign_expr() {
			return getRuleContexts(Assign_exprContext.class);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416); assign_expr();
			setState(419);
			_la = _input.LA(1);
			if (_la==29) {
				{
				setState(417); match(29);
				setState(418); assign_expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_exprContext extends ParserRuleContext {
		public Assignment_operatorContext assignment_operator() {
			return getRuleContext(Assignment_operatorContext.class,0);
		}
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public Assign_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterAssign_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitAssign_expr(this);
		}
	}

	public final Assign_exprContext assign_expr() throws RecognitionException {
		Assign_exprContext _localctx = new Assign_exprContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_assign_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421); conditional_expression();
			setState(425);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 17) | (1L << 18) | (1L << 25) | (1L << 26) | (1L << 33) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 53) | (1L << 54))) != 0)) {
				{
				setState(422); assignment_operator();
				setState(423); assign_expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Conditional_expressionContext extends ParserRuleContext {
		public Or_expressionContext or_expression() {
			return getRuleContext(Or_expressionContext.class,0);
		}
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Conditional_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterConditional_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitConditional_expression(this);
		}
	}

	public final Conditional_expressionContext conditional_expression() throws RecognitionException {
		Conditional_expressionContext _localctx = new Conditional_expressionContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_conditional_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427); or_expression();
			setState(433);
			_la = _input.LA(1);
			if (_la==35) {
				{
				setState(428); match(35);
				setState(429); expr();
				setState(430); match(32);
				setState(431); conditional_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Or_expressionContext extends ParserRuleContext {
		public Or_expressionContext or_expression() {
			return getRuleContext(Or_expressionContext.class,0);
		}
		public And_expressionContext and_expression() {
			return getRuleContext(And_expressionContext.class,0);
		}
		public Or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterOr_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitOr_expression(this);
		}
	}

	public final Or_expressionContext or_expression() throws RecognitionException {
		Or_expressionContext _localctx = new Or_expressionContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435); and_expression();
			setState(438);
			_la = _input.LA(1);
			if (_la==51) {
				{
				setState(436); match(51);
				setState(437); or_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class And_expressionContext extends ParserRuleContext {
		public Inclusive_or_expressionContext inclusive_or_expression() {
			return getRuleContext(Inclusive_or_expressionContext.class,0);
		}
		public And_expressionContext and_expression() {
			return getRuleContext(And_expressionContext.class,0);
		}
		public And_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterAnd_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitAnd_expression(this);
		}
	}

	public final And_expressionContext and_expression() throws RecognitionException {
		And_expressionContext _localctx = new And_expressionContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440); inclusive_or_expression();
			setState(443);
			_la = _input.LA(1);
			if (_la==50) {
				{
				setState(441); match(50);
				setState(442); and_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Inclusive_or_expressionContext extends ParserRuleContext {
		public Inclusive_or_expressionContext inclusive_or_expression() {
			return getRuleContext(Inclusive_or_expressionContext.class,0);
		}
		public Exclusive_or_expressionContext exclusive_or_expression() {
			return getRuleContext(Exclusive_or_expressionContext.class,0);
		}
		public Inclusive_or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inclusive_or_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterInclusive_or_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitInclusive_or_expression(this);
		}
	}

	public final Inclusive_or_expressionContext inclusive_or_expression() throws RecognitionException {
		Inclusive_or_expressionContext _localctx = new Inclusive_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_inclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445); exclusive_or_expression();
			setState(448);
			_la = _input.LA(1);
			if (_la==21) {
				{
				setState(446); match(21);
				setState(447); inclusive_or_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exclusive_or_expressionContext extends ParserRuleContext {
		public Exclusive_or_expressionContext exclusive_or_expression() {
			return getRuleContext(Exclusive_or_expressionContext.class,0);
		}
		public Bit_and_expressionContext bit_and_expression() {
			return getRuleContext(Bit_and_expressionContext.class,0);
		}
		public Exclusive_or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusive_or_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterExclusive_or_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitExclusive_or_expression(this);
		}
	}

	public final Exclusive_or_expressionContext exclusive_or_expression() throws RecognitionException {
		Exclusive_or_expressionContext _localctx = new Exclusive_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_exclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450); bit_and_expression();
			setState(453);
			_la = _input.LA(1);
			if (_la==44) {
				{
				setState(451); match(44);
				setState(452); exclusive_or_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bit_and_expressionContext extends ParserRuleContext {
		public Equality_expressionContext equality_expression() {
			return getRuleContext(Equality_expressionContext.class,0);
		}
		public Bit_and_expressionContext bit_and_expression() {
			return getRuleContext(Bit_and_expressionContext.class,0);
		}
		public Bit_and_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bit_and_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterBit_and_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitBit_and_expression(this);
		}
	}

	public final Bit_and_expressionContext bit_and_expression() throws RecognitionException {
		Bit_and_expressionContext _localctx = new Bit_and_expressionContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_bit_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455); equality_expression();
			setState(458);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(456); match(1);
				setState(457); bit_and_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Equality_expressionContext extends ParserRuleContext {
		public Equality_expressionContext equality_expression() {
			return getRuleContext(Equality_expressionContext.class,0);
		}
		public Equality_operatorContext equality_operator() {
			return getRuleContext(Equality_operatorContext.class,0);
		}
		public Relational_expressionContext relational_expression() {
			return getRuleContext(Relational_expressionContext.class,0);
		}
		public Equality_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterEquality_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitEquality_expression(this);
		}
	}

	public final Equality_expressionContext equality_expression() throws RecognitionException {
		Equality_expressionContext _localctx = new Equality_expressionContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_equality_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460); relational_expression();
			setState(464);
			_la = _input.LA(1);
			if (_la==6 || _la==56) {
				{
				setState(461); equality_operator();
				setState(462); equality_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Relational_expressionContext extends ParserRuleContext {
		public Shift_expressionContext shift_expression() {
			return getRuleContext(Shift_expressionContext.class,0);
		}
		public Relational_operatorContext relational_operator() {
			return getRuleContext(Relational_operatorContext.class,0);
		}
		public Relational_expressionContext relational_expression() {
			return getRuleContext(Relational_expressionContext.class,0);
		}
		public Relational_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterRelational_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitRelational_expression(this);
		}
	}

	public final Relational_expressionContext relational_expression() throws RecognitionException {
		Relational_expressionContext _localctx = new Relational_expressionContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_relational_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466); shift_expression();
			setState(470);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 52) | (1L << 58))) != 0)) {
				{
				setState(467); relational_operator();
				setState(468); relational_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Shift_expressionContext extends ParserRuleContext {
		public Additive_expressionContext additive_expression() {
			return getRuleContext(Additive_expressionContext.class,0);
		}
		public Shift_expressionContext shift_expression() {
			return getRuleContext(Shift_expressionContext.class,0);
		}
		public Shift_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterShift_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitShift_expression(this);
		}
	}

	public final Shift_expressionContext shift_expression() throws RecognitionException {
		Shift_expressionContext _localctx = new Shift_expressionContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_shift_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472); additive_expression();
			setState(475);
			_la = _input.LA(1);
			if (_la==8 || _la==43) {
				{
				setState(473);
				_la = _input.LA(1);
				if ( !(_la==8 || _la==43) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(474); shift_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Additive_expressionContext extends ParserRuleContext {
		public Additive_expressionContext additive_expression() {
			return getRuleContext(Additive_expressionContext.class,0);
		}
		public Multiplicative_expressionContext multiplicative_expression() {
			return getRuleContext(Multiplicative_expressionContext.class,0);
		}
		public Additive_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterAdditive_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitAdditive_expression(this);
		}
	}

	public final Additive_expressionContext additive_expression() throws RecognitionException {
		Additive_expressionContext _localctx = new Additive_expressionContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_additive_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477); multiplicative_expression();
			setState(480);
			_la = _input.LA(1);
			if (_la==30 || _la==47) {
				{
				setState(478);
				_la = _input.LA(1);
				if ( !(_la==30 || _la==47) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(479); additive_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Multiplicative_expressionContext extends ParserRuleContext {
		public List<Cast_expressionContext> cast_expression() {
			return getRuleContexts(Cast_expressionContext.class);
		}
		public Cast_expressionContext cast_expression(int i) {
			return getRuleContext(Cast_expressionContext.class,i);
		}
		public Multiplicative_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterMultiplicative_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitMultiplicative_expression(this);
		}
	}

	public final Multiplicative_expressionContext multiplicative_expression() throws RecognitionException {
		Multiplicative_expressionContext _localctx = new Multiplicative_expressionContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_multiplicative_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482); cast_expression();
			setState(485);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 9) | (1L << 55))) != 0)) {
				{
				setState(483);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 9) | (1L << 55))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(484); cast_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cast_expressionContext extends ParserRuleContext {
		public Cast_expressionContext cast_expression() {
			return getRuleContext(Cast_expressionContext.class,0);
		}
		public Ptr_operatorContext ptr_operator(int i) {
			return getRuleContext(Ptr_operatorContext.class,i);
		}
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public List<Ptr_operatorContext> ptr_operator() {
			return getRuleContexts(Ptr_operatorContext.class);
		}
		public Cast_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterCast_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitCast_expression(this);
		}
	}

	public final Cast_expressionContext cast_expression() throws RecognitionException {
		Cast_expressionContext _localctx = new Cast_expressionContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_cast_expression);
		int _la;
		try {
			setState(499);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(487); match(31);
				setState(488); type_name();
				setState(492);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1 || _la==3) {
					{
					{
					setState(489); ptr_operator();
					}
					}
					setState(494);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(495); match(13);
				setState(496); cast_expression();
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(498); unary_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_expressionContext extends ParserRuleContext {
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public List<Unary_operatorContext> unary_operator() {
			return getRuleContexts(Unary_operatorContext.class);
		}
		public Unary_operatorContext unary_operator(int i) {
			return getRuleContext(Unary_operatorContext.class,i);
		}
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterUnary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitUnary_expression(this);
		}
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_unary_expression);
		int _la;
		try {
			setState(512);
			switch (_input.LA(1)) {
			case 5:
				enterOuterAlt(_localctx, 1);
				{
				setState(501); match(5);
				setState(502); unary_expression();
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 2);
				{
				setState(503); match(42);
				setState(504); unary_expression();
				}
				break;
			case 1:
			case 3:
			case 22:
			case 30:
			case 31:
			case 47:
			case 57:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case CHAR:
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(508);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 22) | (1L << 30) | (1L << 47) | (1L << 57))) != 0)) {
					{
					{
					setState(505); unary_operator();
					}
					}
					setState(510);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(511); postfix_expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Postfix_expressionContext extends ParserRuleContext {
		public Postfix_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix_expression; }
	 
		public Postfix_expressionContext() { }
		public void copyFrom(Postfix_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FieldOnlyContext extends Postfix_expressionContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public FieldOnlyContext(Postfix_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterFieldOnly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitFieldOnly(this);
		}
	}
	public static class FuncCallContext extends Postfix_expressionContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public Function_call_tailContext function_call_tail() {
			return getRuleContext(Function_call_tailContext.class,0);
		}
		public FuncCallContext(Postfix_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitFuncCall(this);
		}
	}

	public final Postfix_expressionContext postfix_expression() throws RecognitionException {
		Postfix_expressionContext _localctx = new Postfix_expressionContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_postfix_expression);
		try {
			setState(518);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(514); field();
				setState(515); function_call_tail();
				}
				break;

			case 2:
				_localctx = new FieldOnlyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(517); field();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public PostfixContext postfix(int i) {
			return getRuleContext(PostfixContext.class,i);
		}
		public List<PostfixContext> postfix() {
			return getRuleContexts(PostfixContext.class);
		}
		public Primary_expressionContext primary_expression() {
			return getRuleContext(Primary_expressionContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520); primary_expression();
			setState(524);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 5) | (1L << 10) | (1L << 42) | (1L << 46))) != 0)) {
				{
				{
				setState(521); postfix();
				}
				}
				setState(526);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_call_tailContext extends ParserRuleContext {
		public Call_template_listContext call_template_list() {
			return getRuleContext(Call_template_listContext.class,0);
		}
		public Function_argument_listContext function_argument_list() {
			return getRuleContext(Function_argument_listContext.class,0);
		}
		public Function_call_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterFunction_call_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitFunction_call_tail(this);
		}
	}

	public final Function_call_tailContext function_call_tail() throws RecognitionException {
		Function_call_tailContext _localctx = new Function_call_tailContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_function_call_tail);
		try {
			setState(531);
			switch (_input.LA(1)) {
			case 4:
				enterOuterAlt(_localctx, 1);
				{
				setState(527); call_template_list();
				setState(528); function_argument_list();
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 2);
				{
				setState(530); function_argument_list();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Call_template_listContext extends ParserRuleContext {
		public Template_param_listContext template_param_list() {
			return getRuleContext(Template_param_listContext.class,0);
		}
		public Call_template_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_template_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterCall_template_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitCall_template_list(this);
		}
	}

	public final Call_template_listContext call_template_list() throws RecognitionException {
		Call_template_listContext _localctx = new Call_template_listContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_call_template_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(533); match(4);
			setState(534); template_param_list();
			setState(535); match(52);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_argument_listContext extends ParserRuleContext {
		public Function_argumentContext function_argument(int i) {
			return getRuleContext(Function_argumentContext.class,i);
		}
		public List<Function_argumentContext> function_argument() {
			return getRuleContexts(Function_argumentContext.class);
		}
		public Function_argument_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_argument_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterFunction_argument_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitFunction_argument_list(this);
		}
	}

	public final Function_argument_listContext function_argument_list() throws RecognitionException {
		Function_argument_listContext _localctx = new Function_argument_listContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_function_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537); match(31);
			setState(546);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 22) | (1L << 30) | (1L << 31) | (1L << 42) | (1L << 47) | (1L << 57))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (ALPHA_NUMERIC - 86)) | (1L << (HEX_LITERAL - 86)) | (1L << (DECIMAL_LITERAL - 86)) | (1L << (OCTAL_LITERAL - 86)) | (1L << (FLOATING_POINT_LITERAL - 86)) | (1L << (CHAR - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				setState(538); function_argument();
				setState(543);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==29) {
					{
					{
					setState(539); match(29);
					setState(540); function_argument();
					}
					}
					setState(545);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(548); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_argumentContext extends ParserRuleContext {
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public Function_argumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterFunction_argument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitFunction_argument(this);
		}
	}

	public final Function_argumentContext function_argument() throws RecognitionException {
		Function_argumentContext _localctx = new Function_argumentContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_function_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550); assign_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterPostfix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitPostfix(this);
		}
	}

	public final PostfixContext postfix() throws RecognitionException {
		PostfixContext _localctx = new PostfixContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_postfix);
		try {
			setState(564);
			switch (_input.LA(1)) {
			case 2:
			case 10:
			case 46:
				enterOuterAlt(_localctx, 1);
				{
				setState(560);
				switch (_input.LA(1)) {
				case 46:
					{
					setState(552); match(46);
					setState(553); identifier();
					}
					break;
				case 10:
					{
					setState(554); match(10);
					setState(555); identifier();
					}
					break;
				case 2:
					{
					setState(556); match(2);
					setState(557); expr();
					setState(558); match(24);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 2);
				{
				setState(562); match(42);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 3);
				{
				setState(563); match(5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Primary_expressionContext extends ParserRuleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Primary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterPrimary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitPrimary_expression(this);
		}
	}

	public final Primary_expressionContext primary_expression() throws RecognitionException {
		Primary_expressionContext _localctx = new Primary_expressionContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_primary_expression);
		try {
			setState(572);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(566); identifier();
				}
				break;
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case CHAR:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(567); constant();
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 3);
				{
				setState(568); match(31);
				setState(569); expr();
				setState(570); match(13);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Init_declaratorContext extends ParserRuleContext {
		public Type_suffixContext type_suffix() {
			return getRuleContext(Type_suffixContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PtrsContext ptrs() {
			return getRuleContext(PtrsContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public Init_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterInit_declarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitInit_declarator(this);
		}
	}

	public final Init_declaratorContext init_declarator() throws RecognitionException {
		Init_declaratorContext _localctx = new Init_declaratorContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_init_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(575);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(574); ptrs();
				}
			}

			setState(577); identifier();
			setState(579);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(578); type_suffix();
				}
				break;
			}
			}
			setState(588);
			switch (_input.LA(1)) {
			case 31:
				{
				{
				setState(581); match(31);
				setState(583);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 22) | (1L << 30) | (1L << 31) | (1L << 42) | (1L << 47) | (1L << 57))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (ALPHA_NUMERIC - 86)) | (1L << (HEX_LITERAL - 86)) | (1L << (DECIMAL_LITERAL - 86)) | (1L << (OCTAL_LITERAL - 86)) | (1L << (FLOATING_POINT_LITERAL - 86)) | (1L << (CHAR - 86)) | (1L << (STRING - 86)))) != 0)) {
					{
					setState(582); expr();
					}
				}

				setState(585); match(13);
				}
				}
				break;
			case 17:
				{
				{
				setState(586); match(17);
				setState(587); initializer();
				}
				}
				break;
			case 29:
			case 49:
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_suffixContext extends ParserRuleContext {
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public Param_type_listContext param_type_list() {
			return getRuleContext(Param_type_listContext.class,0);
		}
		public Type_suffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_suffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterType_suffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitType_suffix(this);
		}
	}

	public final Type_suffixContext type_suffix() throws RecognitionException {
		Type_suffixContext _localctx = new Type_suffixContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_type_suffix);
		int _la;
		try {
			setState(596);
			switch (_input.LA(1)) {
			case 2:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(590); match(2);
				setState(592);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 22) | (1L << 30) | (1L << 31) | (1L << 42) | (1L << 47) | (1L << 57))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (ALPHA_NUMERIC - 86)) | (1L << (HEX_LITERAL - 86)) | (1L << (DECIMAL_LITERAL - 86)) | (1L << (OCTAL_LITERAL - 86)) | (1L << (FLOATING_POINT_LITERAL - 86)) | (1L << (CHAR - 86)) | (1L << (STRING - 86)))) != 0)) {
					{
					setState(591); conditional_expression();
					}
				}

				setState(594); match(24);
				}
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 2);
				{
				setState(595); param_type_list();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_declContext extends ParserRuleContext {
		public Template_decl_startContext template_decl_start() {
			return getRuleContext(Template_decl_startContext.class,0);
		}
		public TerminalNode TYPEDEF() { return getToken(FunctionGrammarParser.TYPEDEF, 0); }
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Simple_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterSimple_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitSimple_decl(this);
		}
	}

	public final Simple_declContext simple_decl() throws RecognitionException {
		Simple_declContext _localctx = new Simple_declContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_simple_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			_la = _input.LA(1);
			if (_la==TYPEDEF) {
				{
				setState(598); match(TYPEDEF);
				}
			}

			setState(602);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(601); template_decl_start();
				}
			}

			setState(604); var_decl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
	 
		public Var_declContext() { }
		public void copyFrom(Var_declContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclByClassContext extends Var_declContext {
		public Class_defContext class_def() {
			return getRuleContext(Class_defContext.class,0);
		}
		public Init_declarator_listContext init_declarator_list() {
			return getRuleContext(Init_declarator_listContext.class,0);
		}
		public DeclByClassContext(Var_declContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterDeclByClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitDeclByClass(this);
		}
	}
	public static class DeclByTypeContext extends Var_declContext {
		public Init_declarator_listContext init_declarator_list() {
			return getRuleContext(Init_declarator_listContext.class,0);
		}
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public DeclByTypeContext(Var_declContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterDeclByType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitDeclByType(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_var_decl);
		try {
			setState(613);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				_localctx = new DeclByTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(606); type_name();
				setState(607); init_declarator_list();
				}
				break;

			case 2:
				_localctx = new DeclByClassContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(609); class_def();
				setState(611);
				switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
				case 1:
					{
					setState(610); init_declarator_list();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Init_declarator_listContext extends ParserRuleContext {
		public List<Init_declaratorContext> init_declarator() {
			return getRuleContexts(Init_declaratorContext.class);
		}
		public Init_declaratorContext init_declarator(int i) {
			return getRuleContext(Init_declaratorContext.class,i);
		}
		public Init_declarator_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_declarator_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterInit_declarator_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitInit_declarator_list(this);
		}
	}

	public final Init_declarator_listContext init_declarator_list() throws RecognitionException {
		Init_declarator_listContext _localctx = new Init_declarator_listContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(615); init_declarator();
			setState(620);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==29) {
				{
				{
				setState(616); match(29);
				setState(617); init_declarator();
				}
				}
				setState(622);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(623); match(49);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerContext extends ParserRuleContext {
		public Initializer_listContext initializer_list() {
			return getRuleContext(Initializer_listContext.class,0);
		}
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitInitializer(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_initializer);
		try {
			setState(630);
			switch (_input.LA(1)) {
			case 1:
			case 3:
			case 5:
			case 22:
			case 30:
			case 31:
			case 42:
			case 47:
			case 57:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case CHAR:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(625); assign_expr();
				}
				break;
			case OPENING_CURLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(626); match(OPENING_CURLY);
				setState(627); initializer_list();
				setState(628); match(CLOSING_CURLY);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Initializer_listContext extends ParserRuleContext {
		public InitializerContext initializer(int i) {
			return getRuleContext(InitializerContext.class,i);
		}
		public List<InitializerContext> initializer() {
			return getRuleContexts(InitializerContext.class);
		}
		public Initializer_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterInitializer_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitInitializer_list(this);
		}
	}

	public final Initializer_listContext initializer_list() throws RecognitionException {
		Initializer_listContext _localctx = new Initializer_listContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_initializer_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(632); initializer();
			setState(637);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==29) {
				{
				{
				setState(633); match(29);
				setState(634); initializer();
				}
				}
				setState(639);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_defContext extends ParserRuleContext {
		public Base_classesContext base_classes() {
			return getRuleContext(Base_classesContext.class,0);
		}
		public Class_keyContext class_key() {
			return getRuleContext(Class_keyContext.class,0);
		}
		public Class_nameContext class_name() {
			return getRuleContext(Class_nameContext.class,0);
		}
		public TerminalNode OPENING_CURLY() { return getToken(FunctionGrammarParser.OPENING_CURLY, 0); }
		public Class_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterClass_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitClass_def(this);
		}
	}

	public final Class_defContext class_def() throws RecognitionException {
		Class_defContext _localctx = new Class_defContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(640); class_key();
			setState(642);
			_la = _input.LA(1);
			if (_la==ALPHA_NUMERIC) {
				{
				setState(641); class_name();
				}
			}

			setState(645);
			_la = _input.LA(1);
			if (_la==32) {
				{
				setState(644); base_classes();
				}
			}

			setState(647); match(OPENING_CURLY);
			skipToEndOfObject(); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_nameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Class_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterClass_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitClass_name(this);
		}
	}

	public final Class_nameContext class_name() throws RecognitionException {
		Class_nameContext _localctx = new Class_nameContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_class_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(650); identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Base_classesContext extends ParserRuleContext {
		public Base_classContext base_class(int i) {
			return getRuleContext(Base_classContext.class,i);
		}
		public List<Base_classContext> base_class() {
			return getRuleContexts(Base_classContext.class);
		}
		public Base_classesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_classes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterBase_classes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitBase_classes(this);
		}
	}

	public final Base_classesContext base_classes() throws RecognitionException {
		Base_classesContext _localctx = new Base_classesContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_base_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(652); match(32);
			setState(653); base_class();
			setState(658);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==29) {
				{
				{
				setState(654); match(29);
				setState(655); base_class();
				}
				}
				setState(660);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Base_classContext extends ParserRuleContext {
		public TerminalNode VIRTUAL() { return getToken(FunctionGrammarParser.VIRTUAL, 0); }
		public Access_specifierContext access_specifier() {
			return getRuleContext(Access_specifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Base_classContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_class; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterBase_class(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitBase_class(this);
		}
	}

	public final Base_classContext base_class() throws RecognitionException {
		Base_classContext _localctx = new Base_classContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_base_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(662);
			_la = _input.LA(1);
			if (_la==VIRTUAL) {
				{
				setState(661); match(VIRTUAL);
				}
			}

			setState(665);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 28) | (1L << 34) | (1L << 48))) != 0)) {
				{
				setState(664); access_specifier();
				}
			}

			setState(667); identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_nameContext extends ParserRuleContext {
		public List<TerminalNode> CV_QUALIFIER() { return getTokens(FunctionGrammarParser.CV_QUALIFIER); }
		public Template_param_listContext template_param_list(int i) {
			return getRuleContext(Template_param_listContext.class,i);
		}
		public TerminalNode SIGNED() { return getToken(FunctionGrammarParser.SIGNED, 0); }
		public TerminalNode UNSIGNED() { return getToken(FunctionGrammarParser.UNSIGNED, 0); }
		public List<Template_param_listContext> template_param_list() {
			return getRuleContexts(Template_param_listContext.class);
		}
		public Class_keyContext class_key() {
			return getRuleContext(Class_keyContext.class,0);
		}
		public Base_typeContext base_type(int i) {
			return getRuleContext(Base_typeContext.class,i);
		}
		public List<Base_typeContext> base_type() {
			return getRuleContexts(Base_typeContext.class);
		}
		public TerminalNode CV_QUALIFIER(int i) {
			return getToken(FunctionGrammarParser.CV_QUALIFIER, i);
		}
		public Type_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterType_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitType_name(this);
		}
	}

	public final Type_nameContext type_name() throws RecognitionException {
		Type_nameContext _localctx = new Type_nameContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_type_name);
		int _la;
		try {
			setState(701);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(672);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CV_QUALIFIER) {
					{
					{
					setState(669); match(CV_QUALIFIER);
					}
					}
					setState(674);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(678);
				switch (_input.LA(1)) {
				case 12:
				case 20:
				case 23:
				case 40:
					{
					setState(675); class_key();
					}
					break;
				case UNSIGNED:
					{
					setState(676); match(UNSIGNED);
					}
					break;
				case SIGNED:
					{
					setState(677); match(SIGNED);
					}
					break;
				case VOID:
				case LONG:
				case ALPHA_NUMERIC:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(680); base_type();
				setState(685);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(681); match(4);
					setState(682); template_param_list();
					setState(683); match(52);
					}
				}

				setState(697);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==16) {
					{
					{
					setState(687); match(16);
					setState(688); base_type();
					setState(693);
					_la = _input.LA(1);
					if (_la==4) {
						{
						setState(689); match(4);
						setState(690); template_param_list();
						setState(691); match(52);
						}
					}

					}
					}
					setState(699);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(700);
				_la = _input.LA(1);
				if ( !(_la==UNSIGNED || _la==SIGNED) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Base_typeContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(FunctionGrammarParser.VOID, 0); }
		public TerminalNode ALPHA_NUMERIC() { return getToken(FunctionGrammarParser.ALPHA_NUMERIC, 0); }
		public TerminalNode LONG(int i) {
			return getToken(FunctionGrammarParser.LONG, i);
		}
		public List<TerminalNode> LONG() { return getTokens(FunctionGrammarParser.LONG); }
		public Base_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterBase_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitBase_type(this);
		}
	}

	public final Base_typeContext base_type() throws RecognitionException {
		Base_typeContext _localctx = new Base_typeContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_base_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(708);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				{
				setState(703); match(ALPHA_NUMERIC);
				}
				break;

			case 2:
				{
				setState(704); match(VOID);
				}
				break;

			case 3:
				{
				setState(705); match(LONG);
				}
				break;

			case 4:
				{
				setState(706); match(LONG);
				setState(707); match(LONG);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_decl_specifiersContext extends ParserRuleContext {
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public TerminalNode REGISTER() { return getToken(FunctionGrammarParser.REGISTER, 0); }
		public TerminalNode AUTO() { return getToken(FunctionGrammarParser.AUTO, 0); }
		public Param_decl_specifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl_specifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterParam_decl_specifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitParam_decl_specifiers(this);
		}
	}

	public final Param_decl_specifiersContext param_decl_specifiers() throws RecognitionException {
		Param_decl_specifiersContext _localctx = new Param_decl_specifiersContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_param_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(711);
			_la = _input.LA(1);
			if (_la==AUTO || _la==REGISTER) {
				{
				setState(710);
				_la = _input.LA(1);
				if ( !(_la==AUTO || _la==REGISTER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(713); type_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parameter_nameContext extends ParserRuleContext {
		public Access_specifierContext access_specifier() {
			return getRuleContext(Access_specifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Parameter_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterParameter_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitParameter_name(this);
		}
	}

	public final Parameter_nameContext parameter_name() throws RecognitionException {
		Parameter_nameContext _localctx = new Parameter_nameContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_parameter_name);
		try {
			setState(717);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(715); identifier();
				}
				break;
			case 28:
			case 34:
			case 48:
				enterOuterAlt(_localctx, 2);
				{
				setState(716); access_specifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_type_listContext extends ParserRuleContext {
		public Param_typeContext param_type(int i) {
			return getRuleContext(Param_typeContext.class,i);
		}
		public List<Param_typeContext> param_type() {
			return getRuleContexts(Param_typeContext.class);
		}
		public TerminalNode VOID() { return getToken(FunctionGrammarParser.VOID, 0); }
		public Param_type_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_type_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterParam_type_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitParam_type_list(this);
		}
	}

	public final Param_type_listContext param_type_list() throws RecognitionException {
		Param_type_listContext _localctx = new Param_type_listContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_param_type_list);
		int _la;
		try {
			setState(734);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(719); match(31);
				setState(720); match(VOID);
				setState(721); match(13);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(722); match(31);
				setState(731);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 20) | (1L << 23) | (1L << 40))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (VOID - 71)) | (1L << (UNSIGNED - 71)) | (1L << (SIGNED - 71)) | (1L << (LONG - 71)) | (1L << (CV_QUALIFIER - 71)) | (1L << (AUTO - 71)) | (1L << (REGISTER - 71)) | (1L << (ALPHA_NUMERIC - 71)))) != 0)) {
					{
					setState(723); param_type();
					setState(728);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==29) {
						{
						{
						setState(724); match(29);
						setState(725); param_type();
						}
						}
						setState(730);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(733); match(13);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_typeContext extends ParserRuleContext {
		public Param_type_idContext param_type_id() {
			return getRuleContext(Param_type_idContext.class,0);
		}
		public Param_decl_specifiersContext param_decl_specifiers() {
			return getRuleContext(Param_decl_specifiersContext.class,0);
		}
		public Param_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterParam_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitParam_type(this);
		}
	}

	public final Param_typeContext param_type() throws RecognitionException {
		Param_typeContext _localctx = new Param_typeContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_param_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(736); param_decl_specifiers();
			setState(737); param_type_id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_type_idContext extends ParserRuleContext {
		public Param_type_idContext param_type_id() {
			return getRuleContext(Param_type_idContext.class,0);
		}
		public Type_suffixContext type_suffix() {
			return getRuleContext(Type_suffixContext.class,0);
		}
		public Parameter_nameContext parameter_name() {
			return getRuleContext(Parameter_nameContext.class,0);
		}
		public PtrsContext ptrs() {
			return getRuleContext(PtrsContext.class,0);
		}
		public Param_type_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_type_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterParam_type_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitParam_type_id(this);
		}
	}

	public final Param_type_idContext param_type_id() throws RecognitionException {
		Param_type_idContext _localctx = new Param_type_idContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_param_type_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(740);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(739); ptrs();
				}
			}

			setState(749);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				{
				setState(742); match(31);
				setState(743); param_type_id();
				setState(744); match(13);
				}
				break;

			case 2:
				{
				setState(747);
				_la = _input.LA(1);
				if (((((_la - 28)) & ~0x3f) == 0 && ((1L << (_la - 28)) & ((1L << (28 - 28)) | (1L << (34 - 28)) | (1L << (48 - 28)) | (1L << (ALPHA_NUMERIC - 28)))) != 0)) {
					{
					setState(746); parameter_name();
					}
				}

				}
				break;
			}
			setState(752);
			_la = _input.LA(1);
			if (_la==2 || _la==31) {
				{
				setState(751); type_suffix();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode ALPHA_NUMERIC(int i) {
			return getToken(FunctionGrammarParser.ALPHA_NUMERIC, i);
		}
		public List<TerminalNode> ALPHA_NUMERIC() { return getTokens(FunctionGrammarParser.ALPHA_NUMERIC); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(754); match(ALPHA_NUMERIC);
			setState(759);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==16) {
				{
				{
				setState(755); match(16);
				setState(756); match(ALPHA_NUMERIC);
				}
				}
				setState(761);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode OCTAL_LITERAL() { return getToken(FunctionGrammarParser.OCTAL_LITERAL, 0); }
		public TerminalNode HEX_LITERAL() { return getToken(FunctionGrammarParser.HEX_LITERAL, 0); }
		public TerminalNode DECIMAL_LITERAL() { return getToken(FunctionGrammarParser.DECIMAL_LITERAL, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(762);
			_la = _input.LA(1);
			if ( !(((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (HEX_LITERAL - 92)) | (1L << (DECIMAL_LITERAL - 92)) | (1L << (OCTAL_LITERAL - 92)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PtrsContext extends ParserRuleContext {
		public Ptr_operatorContext ptr_operator(int i) {
			return getRuleContext(Ptr_operatorContext.class,i);
		}
		public List<Ptr_operatorContext> ptr_operator() {
			return getRuleContexts(Ptr_operatorContext.class);
		}
		public PtrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ptrs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterPtrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitPtrs(this);
		}
	}

	public final PtrsContext ptrs() throws RecognitionException {
		PtrsContext _localctx = new PtrsContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_ptrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(765); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(764); ptr_operator();
				}
				}
				setState(767); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==1 || _la==3 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\2\3g\u0304\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\t"+
		"F\4G\tG\4H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4"+
		"R\tR\4S\tS\4T\tT\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]"+
		"\t]\3\2\7\2\u00bc\n\2\f\2\16\2\u00bf\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\5\3\u00cd\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\5\6"+
		"\u00d7\n\6\3\7\3\7\3\7\5\7\u00dc\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\5\13\u00ed\n\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\f\u00f5\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\5\20\u0109\n\20\3\20\5\20\u010c\n\20\3\21"+
		"\3\21\3\21\5\21\u0111\n\21\3\21\3\21\3\22\3\22\3\23\3\23\5\23\u0119\n"+
		"\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\5\27\u0126"+
		"\n\27\3\27\3\27\5\27\u012a\n\27\3\27\5\27\u012d\n\27\3\27\3\27\3\30\3"+
		"\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3"+
		"\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3\"\5\"\u014a\n\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\5\"\u0174\n\"\3#\3#\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\7"+
		"&\u0188\n&\f&\16&\u018b\13&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3"+
		"-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\62\5\62\u01a6\n\62\3\63"+
		"\3\63\3\63\3\63\5\63\u01ac\n\63\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u01b4"+
		"\n\64\3\65\3\65\3\65\5\65\u01b9\n\65\3\66\3\66\3\66\5\66\u01be\n\66\3"+
		"\67\3\67\3\67\5\67\u01c3\n\67\38\38\38\58\u01c8\n8\39\39\39\59\u01cd\n"+
		"9\3:\3:\3:\3:\5:\u01d3\n:\3;\3;\3;\3;\5;\u01d9\n;\3<\3<\3<\5<\u01de\n"+
		"<\3=\3=\3=\5=\u01e3\n=\3>\3>\3>\5>\u01e8\n>\3?\3?\3?\7?\u01ed\n?\f?\16"+
		"?\u01f0\13?\3?\3?\3?\3?\5?\u01f6\n?\3@\3@\3@\3@\3@\7@\u01fd\n@\f@\16@"+
		"\u0200\13@\3@\5@\u0203\n@\3A\3A\3A\3A\5A\u0209\nA\3B\3B\7B\u020d\nB\f"+
		"B\16B\u0210\13B\3C\3C\3C\3C\5C\u0216\nC\3D\3D\3D\3D\3E\3E\3E\3E\7E\u0220"+
		"\nE\fE\16E\u0223\13E\5E\u0225\nE\3E\3E\3F\3F\3G\3G\3G\3G\3G\3G\3G\3G\5"+
		"G\u0233\nG\3G\3G\5G\u0237\nG\3H\3H\3H\3H\3H\3H\5H\u023f\nH\3I\5I\u0242"+
		"\nI\3I\3I\5I\u0246\nI\3I\3I\5I\u024a\nI\3I\3I\3I\5I\u024f\nI\3J\3J\5J"+
		"\u0253\nJ\3J\3J\5J\u0257\nJ\3K\5K\u025a\nK\3K\5K\u025d\nK\3K\3K\3L\3L"+
		"\3L\3L\3L\5L\u0266\nL\5L\u0268\nL\3M\3M\3M\7M\u026d\nM\fM\16M\u0270\13"+
		"M\3M\3M\3N\3N\3N\3N\3N\5N\u0279\nN\3O\3O\3O\7O\u027e\nO\fO\16O\u0281\13"+
		"O\3P\3P\5P\u0285\nP\3P\5P\u0288\nP\3P\3P\3P\3Q\3Q\3R\3R\3R\3R\7R\u0293"+
		"\nR\fR\16R\u0296\13R\3S\5S\u0299\nS\3S\5S\u029c\nS\3S\3S\3T\7T\u02a1\n"+
		"T\fT\16T\u02a4\13T\3T\3T\3T\5T\u02a9\nT\3T\3T\3T\3T\3T\5T\u02b0\nT\3T"+
		"\3T\3T\3T\3T\3T\5T\u02b8\nT\7T\u02ba\nT\fT\16T\u02bd\13T\3T\5T\u02c0\n"+
		"T\3U\3U\3U\3U\3U\5U\u02c7\nU\3V\5V\u02ca\nV\3V\3V\3W\3W\5W\u02d0\nW\3"+
		"X\3X\3X\3X\3X\3X\3X\7X\u02d9\nX\fX\16X\u02dc\13X\5X\u02de\nX\3X\5X\u02e1"+
		"\nX\3Y\3Y\3Y\3Z\5Z\u02e7\nZ\3Z\3Z\3Z\3Z\3Z\5Z\u02ee\nZ\5Z\u02f0\nZ\3Z"+
		"\5Z\u02f3\nZ\3[\3[\3[\7[\u02f8\n[\f[\16[\u02fb\13[\3\\\3\\\3]\6]\u0300"+
		"\n]\r]\16]\u0301\3]\2^\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,"+
		".\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e"+
		"\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6"+
		"\u00b8\2\35\4AACC\b\3\3\5\5\30\30  \61\61;;\6\6\6\t\t\66\66<<\3^c\6\20"+
		"\21))++NN\6\16\16\26\26\31\31**\4\3\3\5\5\5\36\36$$\62\62\4\25\25//\b"+
		"\r\r\23\24\33\34##&(\678\4\b\b::\4\17\17!!\7\4\4\17\17\32\32!!YZ\5\17"+
		"\17!!\63\63\6\6\6\17\17!!\66\66\3YZ\4\4\4\32\32\5\4\4\32\32\63\63\4\37"+
		"\37\63\63\t\4\4\17\17\32\32\37\37!!\63\63YZ\7\4\4\17\17\32\32!!YZ\4\n"+
		"\n--\4  \61\61\5\5\5\13\1399\3JK\3TU\3^`\u0330\2\u00bd\3\2\2\2\4\u00cc"+
		"\3\2\2\2\6\u00ce\3\2\2\2\b\u00d0\3\2\2\2\n\u00d6\3\2\2\2\f\u00db\3\2\2"+
		"\2\16\u00dd\3\2\2\2\20\u00e2\3\2\2\2\22\u00e4\3\2\2\2\24\u00ec\3\2\2\2"+
		"\26\u00ee\3\2\2\2\30\u00f8\3\2\2\2\32\u00fd\3\2\2\2\34\u00ff\3\2\2\2\36"+
		"\u010b\3\2\2\2 \u0110\3\2\2\2\"\u0114\3\2\2\2$\u0116\3\2\2\2&\u011a\3"+
		"\2\2\2(\u011d\3\2\2\2*\u011f\3\2\2\2,\u012c\3\2\2\2.\u0130\3\2\2\2\60"+
		"\u0133\3\2\2\2\62\u0135\3\2\2\2\64\u0137\3\2\2\2\66\u0139\3\2\2\28\u013b"+
		"\3\2\2\2:\u013d\3\2\2\2<\u013f\3\2\2\2>\u0141\3\2\2\2@\u0143\3\2\2\2B"+
		"\u0173\3\2\2\2D\u0175\3\2\2\2F\u0177\3\2\2\2H\u0179\3\2\2\2J\u0189\3\2"+
		"\2\2L\u018c\3\2\2\2N\u018e\3\2\2\2P\u0190\3\2\2\2R\u0192\3\2\2\2T\u0194"+
		"\3\2\2\2V\u0196\3\2\2\2X\u0198\3\2\2\2Z\u019a\3\2\2\2\\\u019c\3\2\2\2"+
		"^\u019e\3\2\2\2`\u01a0\3\2\2\2b\u01a2\3\2\2\2d\u01a7\3\2\2\2f\u01ad\3"+
		"\2\2\2h\u01b5\3\2\2\2j\u01ba\3\2\2\2l\u01bf\3\2\2\2n\u01c4\3\2\2\2p\u01c9"+
		"\3\2\2\2r\u01ce\3\2\2\2t\u01d4\3\2\2\2v\u01da\3\2\2\2x\u01df\3\2\2\2z"+
		"\u01e4\3\2\2\2|\u01f5\3\2\2\2~\u0202\3\2\2\2\u0080\u0208\3\2\2\2\u0082"+
		"\u020a\3\2\2\2\u0084\u0215\3\2\2\2\u0086\u0217\3\2\2\2\u0088\u021b\3\2"+
		"\2\2\u008a\u0228\3\2\2\2\u008c\u0236\3\2\2\2\u008e\u023e\3\2\2\2\u0090"+
		"\u0241\3\2\2\2\u0092\u0256\3\2\2\2\u0094\u0259\3\2\2\2\u0096\u0267\3\2"+
		"\2\2\u0098\u0269\3\2\2\2\u009a\u0278\3\2\2\2\u009c\u027a\3\2\2\2\u009e"+
		"\u0282\3\2\2\2\u00a0\u028c\3\2\2\2\u00a2\u028e\3\2\2\2\u00a4\u0298\3\2"+
		"\2\2\u00a6\u02bf\3\2\2\2\u00a8\u02c6\3\2\2\2\u00aa\u02c9\3\2\2\2\u00ac"+
		"\u02cf\3\2\2\2\u00ae\u02e0\3\2\2\2\u00b0\u02e2\3\2\2\2\u00b2\u02e6\3\2"+
		"\2\2\u00b4\u02f4\3\2\2\2\u00b6\u02fc\3\2\2\2\u00b8\u02ff\3\2\2\2\u00ba"+
		"\u00bc\5\4\3\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2"+
		"\2\2\u00bd\u00be\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0"+
		"\u00c1\7\1\2\2\u00c1\3\3\2\2\2\u00c2\u00c3\7\\\2\2\u00c3\u00cd\b\3\1\2"+
		"\u00c4\u00cd\5\6\4\2\u00c5\u00cd\5\b\5\2\u00c6\u00cd\5\n\6\2\u00c7\u00cd"+
		"\5 \21\2\u00c8\u00cd\5\u0094K\2\u00c9\u00cd\5,\27\2\u00ca\u00cd\5.\30"+
		"\2\u00cb\u00cd\5`\61\2\u00cc\u00c2\3\2\2\2\u00cc\u00c4\3\2\2\2\u00cc\u00c5"+
		"\3\2\2\2\u00cc\u00c6\3\2\2\2\u00cc\u00c7\3\2\2\2\u00cc\u00c8\3\2\2\2\u00cc"+
		"\u00c9\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd\5\3\2\2\2"+
		"\u00ce\u00cf\7Y\2\2\u00cf\7\3\2\2\2\u00d0\u00d1\7Z\2\2\u00d1\t\3\2\2\2"+
		"\u00d2\u00d7\5\f\7\2\u00d3\u00d7\5\24\13\2\u00d4\u00d7\5(\25\2\u00d5\u00d7"+
		"\5*\26\2\u00d6\u00d2\3\2\2\2\u00d6\u00d3\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6"+
		"\u00d5\3\2\2\2\u00d7\13\3\2\2\2\u00d8\u00dc\5\16\b\2\u00d9\u00dc\5\20"+
		"\t\2\u00da\u00dc\5\22\n\2\u00db\u00d8\3\2\2\2\u00db\u00d9\3\2\2\2\u00db"+
		"\u00da\3\2\2\2\u00dc\r\3\2\2\2\u00dd\u00de\7=\2\2\u00de\u00df\7!\2\2\u00df"+
		"\u00e0\5\60\31\2\u00e0\u00e1\7\17\2\2\u00e1\17\3\2\2\2\u00e2\u00e3\7>"+
		"\2\2\u00e3\21\3\2\2\2\u00e4\u00e5\7D\2\2\u00e5\u00e6\7!\2\2\u00e6\u00e7"+
		"\5\60\31\2\u00e7\u00e8\7\17\2\2\u00e8\23\3\2\2\2\u00e9\u00ed\5\26\f\2"+
		"\u00ea\u00ed\5\32\16\2\u00eb\u00ed\5\30\r\2\u00ec\u00e9\3\2\2\2\u00ec"+
		"\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\25\3\2\2\2\u00ee\u00ef\7?\2\2"+
		"\u00ef\u00f0\7!\2\2\u00f0\u00f1\5\36\20\2\u00f1\u00f2\5\60\31\2\u00f2"+
		"\u00f4\7\63\2\2\u00f3\u00f5\5b\62\2\u00f4\u00f3\3\2\2\2\u00f4\u00f5\3"+
		"\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\7\17\2\2\u00f7\27\3\2\2\2\u00f8"+
		"\u00f9\7@\2\2\u00f9\u00fa\7!\2\2\u00fa\u00fb\5\60\31\2\u00fb\u00fc\7\17"+
		"\2\2\u00fc\31\3\2\2\2\u00fd\u00fe\7E\2\2\u00fe\33\3\2\2\2\u00ff\u0100"+
		"\7E\2\2\u0100\u0101\5\4\3\2\u0101\u0102\7@\2\2\u0102\u0103\7!\2\2\u0103"+
		"\u0104\5b\62\2\u0104\u0105\7\17\2\2\u0105\35\3\2\2\2\u0106\u010c\5\u0094"+
		"K\2\u0107\u0109\5b\62\2\u0108\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u010a\3\2\2\2\u010a\u010c\7\63\2\2\u010b\u0106\3\2\2\2\u010b\u0108\3"+
		"\2\2\2\u010c\37\3\2\2\2\u010d\u0111\5\"\22\2\u010e\u0111\5$\23\2\u010f"+
		"\u0111\5&\24\2\u0110\u010d\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u010f\3\2"+
		"\2\2\u0111\u0112\3\2\2\2\u0112\u0113\7\63\2\2\u0113!\3\2\2\2\u0114\u0115"+
		"\t\2\2\2\u0115#\3\2\2\2\u0116\u0118\7G\2\2\u0117\u0119\5b\62\2\u0118\u0117"+
		"\3\2\2\2\u0118\u0119\3\2\2\2\u0119%\3\2\2\2\u011a\u011b\7F\2\2\u011b\u011c"+
		"\5\u00b4[\2\u011c\'\3\2\2\2\u011d\u011e\7O\2\2\u011e)\3\2\2\2\u011f\u0120"+
		"\7P\2\2\u0120\u0121\7!\2\2\u0121\u0122\5\u00b0Y\2\u0122\u0123\7\17\2\2"+
		"\u0123+\3\2\2\2\u0124\u0126\7B\2\2\u0125\u0124\3\2\2\2\u0125\u0126\3\2"+
		"\2\2\u0126\u0129\3\2\2\2\u0127\u012a\5\u00b4[\2\u0128\u012a\5\u00b6\\"+
		"\2\u0129\u0127\3\2\2\2\u0129\u0128\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u012d"+
		"\5> \2\u012c\u0125\3\2\2\2\u012c\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e"+
		"\u012f\7\"\2\2\u012f-\3\2\2\2\u0130\u0131\5b\62\2\u0131\u0132\7\63\2\2"+
		"\u0132/\3\2\2\2\u0133\u0134\5b\62\2\u0134\61\3\2\2\2\u0135\u0136\t\3\2"+
		"\2\u0136\63\3\2\2\2\u0137\u0138\t\4\2\2\u0138\65\3\2\2\2\u0139\u013a\t"+
		"\5\2\2\u013a\67\3\2\2\2\u013b\u013c\t\6\2\2\u013c9\3\2\2\2\u013d\u013e"+
		"\t\7\2\2\u013e;\3\2\2\2\u013f\u0140\t\b\2\2\u0140=\3\2\2\2\u0141\u0142"+
		"\t\t\2\2\u0142?\3\2\2\2\u0143\u0144\7V\2\2\u0144\u0145\5B\"\2\u0145A\3"+
		"\2\2\2\u0146\u0149\t\n\2\2\u0147\u0148\7\4\2\2\u0148\u014a\7\32\2\2\u0149"+
		"\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u0174\3\2\2\2\u014b\u0174\7\61"+
		"\2\2\u014c\u0174\7 \2\2\u014d\u0174\7\5\2\2\u014e\u0174\79\2\2\u014f\u0174"+
		"\7\13\2\2\u0150\u0174\7.\2\2\u0151\u0174\7\3\2\2\u0152\u0174\7\27\2\2"+
		"\u0153\u0174\7;\2\2\u0154\u0174\7\30\2\2\u0155\u0174\7\23\2\2\u0156\u0174"+
		"\7\6\2\2\u0157\u0174\7\66\2\2\u0158\u0174\7\'\2\2\u0159\u0174\7\34\2\2"+
		"\u015a\u0174\7\r\2\2\u015b\u0174\78\2\2\u015c\u0174\7\67\2\2\u015d\u0174"+
		"\7(\2\2\u015e\u0174\7#\2\2\u015f\u0174\7\24\2\2\u0160\u0174\7-\2\2\u0161"+
		"\u0174\7\n\2\2\u0162\u0174\7&\2\2\u0163\u0174\7\33\2\2\u0164\u0174\7:"+
		"\2\2\u0165\u0174\7\b\2\2\u0166\u0174\7\t\2\2\u0167\u0174\7<\2\2\u0168"+
		"\u0174\7\64\2\2\u0169\u0174\7\65\2\2\u016a\u0174\7,\2\2\u016b\u0174\7"+
		"\7\2\2\u016c\u0174\7\37\2\2\u016d\u0174\7\35\2\2\u016e\u0174\7\f\2\2\u016f"+
		"\u0170\7!\2\2\u0170\u0174\7\17\2\2\u0171\u0172\7\4\2\2\u0172\u0174\7\32"+
		"\2\2\u0173\u0146\3\2\2\2\u0173\u014b\3\2\2\2\u0173\u014c\3\2\2\2\u0173"+
		"\u014d\3\2\2\2\u0173\u014e\3\2\2\2\u0173\u014f\3\2\2\2\u0173\u0150\3\2"+
		"\2\2\u0173\u0151\3\2\2\2\u0173\u0152\3\2\2\2\u0173\u0153\3\2\2\2\u0173"+
		"\u0154\3\2\2\2\u0173\u0155\3\2\2\2\u0173\u0156\3\2\2\2\u0173\u0157\3\2"+
		"\2\2\u0173\u0158\3\2\2\2\u0173\u0159\3\2\2\2\u0173\u015a\3\2\2\2\u0173"+
		"\u015b\3\2\2\2\u0173\u015c\3\2\2\2\u0173\u015d\3\2\2\2\u0173\u015e\3\2"+
		"\2\2\u0173\u015f\3\2\2\2\u0173\u0160\3\2\2\2\u0173\u0161\3\2\2\2\u0173"+
		"\u0162\3\2\2\2\u0173\u0163\3\2\2\2\u0173\u0164\3\2\2\2\u0173\u0165\3\2"+
		"\2\2\u0173\u0166\3\2\2\2\u0173\u0167\3\2\2\2\u0173\u0168\3\2\2\2\u0173"+
		"\u0169\3\2\2\2\u0173\u016a\3\2\2\2\u0173\u016b\3\2\2\2\u0173\u016c\3\2"+
		"\2\2\u0173\u016d\3\2\2\2\u0173\u016e\3\2\2\2\u0173\u016f\3\2\2\2\u0173"+
		"\u0171\3\2\2\2\u0174C\3\2\2\2\u0175\u0176\t\13\2\2\u0176E\3\2\2\2\u0177"+
		"\u0178\t\f\2\2\u0178G\3\2\2\2\u0179\u017a\7W\2\2\u017a\u017b\7\6\2\2\u017b"+
		"\u017c\5J&\2\u017c\u017d\7\66\2\2\u017dI\3\2\2\2\u017e\u017f\7\6\2\2\u017f"+
		"\u0180\5J&\2\u0180\u0181\7\66\2\2\u0181\u0188\3\2\2\2\u0182\u0183\7!\2"+
		"\2\u0183\u0184\5J&\2\u0184\u0185\7\17\2\2\u0185\u0188\3\2\2\2\u0186\u0188"+
		"\5R*\2\u0187\u017e\3\2\2\2\u0187\u0182\3\2\2\2\u0187\u0186\3\2\2\2\u0188"+
		"\u018b\3\2\2\2\u0189\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018aK\3\2\2\2"+
		"\u018b\u0189\3\2\2\2\u018c\u018d\n\r\2\2\u018dM\3\2\2\2\u018e\u018f\n"+
		"\16\2\2\u018fO\3\2\2\2\u0190\u0191\n\17\2\2\u0191Q\3\2\2\2\u0192\u0193"+
		"\n\20\2\2\u0193S\3\2\2\2\u0194\u0195\n\21\2\2\u0195U\3\2\2\2\u0196\u0197"+
		"\n\22\2\2\u0197W\3\2\2\2\u0198\u0199\n\23\2\2\u0199Y\3\2\2\2\u019a\u019b"+
		"\n\24\2\2\u019b[\3\2\2\2\u019c\u019d\n\25\2\2\u019d]\3\2\2\2\u019e\u019f"+
		"\n\26\2\2\u019f_\3\2\2\2\u01a0\u01a1\13\2\2\2\u01a1a\3\2\2\2\u01a2\u01a5"+
		"\5d\63\2\u01a3\u01a4\7\37\2\2\u01a4\u01a6\5d\63\2\u01a5\u01a3\3\2\2\2"+
		"\u01a5\u01a6\3\2\2\2\u01a6c\3\2\2\2\u01a7\u01ab\5f\64\2\u01a8\u01a9\5"+
		"D#\2\u01a9\u01aa\5d\63\2\u01aa\u01ac\3\2\2\2\u01ab\u01a8\3\2\2\2\u01ab"+
		"\u01ac\3\2\2\2\u01ace\3\2\2\2\u01ad\u01b3\5h\65\2\u01ae\u01af\7%\2\2\u01af"+
		"\u01b0\5b\62\2\u01b0\u01b1\7\"\2\2\u01b1\u01b2\5f\64\2\u01b2\u01b4\3\2"+
		"\2\2\u01b3\u01ae\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4g\3\2\2\2\u01b5\u01b8"+
		"\5j\66\2\u01b6\u01b7\7\65\2\2\u01b7\u01b9\5h\65\2\u01b8\u01b6\3\2\2\2"+
		"\u01b8\u01b9\3\2\2\2\u01b9i\3\2\2\2\u01ba\u01bd\5l\67\2\u01bb\u01bc\7"+
		"\64\2\2\u01bc\u01be\5j\66\2\u01bd\u01bb\3\2\2\2\u01bd\u01be\3\2\2\2\u01be"+
		"k\3\2\2\2\u01bf\u01c2\5n8\2\u01c0\u01c1\7\27\2\2\u01c1\u01c3\5l\67\2\u01c2"+
		"\u01c0\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3m\3\2\2\2\u01c4\u01c7\5p9\2\u01c5"+
		"\u01c6\7.\2\2\u01c6\u01c8\5n8\2\u01c7\u01c5\3\2\2\2\u01c7\u01c8\3\2\2"+
		"\2\u01c8o\3\2\2\2\u01c9\u01cc\5r:\2\u01ca\u01cb\7\3\2\2\u01cb\u01cd\5"+
		"p9\2\u01cc\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cdq\3\2\2\2\u01ce\u01d2"+
		"\5t;\2\u01cf\u01d0\5F$\2\u01d0\u01d1\5r:\2\u01d1\u01d3\3\2\2\2\u01d2\u01cf"+
		"\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3s\3\2\2\2\u01d4\u01d8\5v<\2\u01d5\u01d6"+
		"\5\64\33\2\u01d6\u01d7\5t;\2\u01d7\u01d9\3\2\2\2\u01d8\u01d5\3\2\2\2\u01d8"+
		"\u01d9\3\2\2\2\u01d9u\3\2\2\2\u01da\u01dd\5x=\2\u01db\u01dc\t\27\2\2\u01dc"+
		"\u01de\5v<\2\u01dd\u01db\3\2\2\2\u01dd\u01de\3\2\2\2\u01dew\3\2\2\2\u01df"+
		"\u01e2\5z>\2\u01e0\u01e1\t\30\2\2\u01e1\u01e3\5x=\2\u01e2\u01e0\3\2\2"+
		"\2\u01e2\u01e3\3\2\2\2\u01e3y\3\2\2\2\u01e4\u01e7\5|?\2\u01e5\u01e6\t"+
		"\31\2\2\u01e6\u01e8\5|?\2\u01e7\u01e5\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8"+
		"{\3\2\2\2\u01e9\u01ea\7!\2\2\u01ea\u01ee\5\u00a6T\2\u01eb\u01ed\5<\37"+
		"\2\u01ec\u01eb\3\2\2\2\u01ed\u01f0\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ee\u01ef"+
		"\3\2\2\2\u01ef\u01f1\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f1\u01f2\7\17\2\2"+
		"\u01f2\u01f3\5|?\2\u01f3\u01f6\3\2\2\2\u01f4\u01f6\5~@\2\u01f5\u01e9\3"+
		"\2\2\2\u01f5\u01f4\3\2\2\2\u01f6}\3\2\2\2\u01f7\u01f8\7\7\2\2\u01f8\u0203"+
		"\5~@\2\u01f9\u01fa\7,\2\2\u01fa\u0203\5~@\2\u01fb\u01fd\5\62\32\2\u01fc"+
		"\u01fb\3\2\2\2\u01fd\u0200\3\2\2\2\u01fe\u01fc\3\2\2\2\u01fe\u01ff\3\2"+
		"\2\2\u01ff\u0201\3\2\2\2\u0200\u01fe\3\2\2\2\u0201\u0203\5\u0080A\2\u0202"+
		"\u01f7\3\2\2\2\u0202\u01f9\3\2\2\2\u0202\u01fe\3\2\2\2\u0203\177\3\2\2"+
		"\2\u0204\u0205\5\u0082B\2\u0205\u0206\5\u0084C\2\u0206\u0209\3\2\2\2\u0207"+
		"\u0209\5\u0082B\2\u0208\u0204\3\2\2\2\u0208\u0207\3\2\2\2\u0209\u0081"+
		"\3\2\2\2\u020a\u020e\5\u008eH\2\u020b\u020d\5\u008cG\2\u020c\u020b\3\2"+
		"\2\2\u020d\u0210\3\2\2\2\u020e\u020c\3\2\2\2\u020e\u020f\3\2\2\2\u020f"+
		"\u0083\3\2\2\2\u0210\u020e\3\2\2\2\u0211\u0212\5\u0086D\2\u0212\u0213"+
		"\5\u0088E\2\u0213\u0216\3\2\2\2\u0214\u0216\5\u0088E\2\u0215\u0211\3\2"+
		"\2\2\u0215\u0214\3\2\2\2\u0216\u0085\3\2\2\2\u0217\u0218\7\6\2\2\u0218"+
		"\u0219\5J&\2\u0219\u021a\7\66\2\2\u021a\u0087\3\2\2\2\u021b\u0224\7!\2"+
		"\2\u021c\u0221\5\u008aF\2\u021d\u021e\7\37\2\2\u021e\u0220\5\u008aF\2"+
		"\u021f\u021d\3\2\2\2\u0220\u0223\3\2\2\2\u0221\u021f\3\2\2\2\u0221\u0222"+
		"\3\2\2\2\u0222\u0225\3\2\2\2\u0223\u0221\3\2\2\2\u0224\u021c\3\2\2\2\u0224"+
		"\u0225\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0227\7\17\2\2\u0227\u0089\3"+
		"\2\2\2\u0228\u0229\5d\63\2\u0229\u008b\3\2\2\2\u022a\u022b\7\60\2\2\u022b"+
		"\u0233\5\u00b4[\2\u022c\u022d\7\f\2\2\u022d\u0233\5\u00b4[\2\u022e\u022f"+
		"\7\4\2\2\u022f\u0230\5b\62\2\u0230\u0231\7\32\2\2\u0231\u0233\3\2\2\2"+
		"\u0232\u022a\3\2\2\2\u0232\u022c\3\2\2\2\u0232\u022e\3\2\2\2\u0233\u0237"+
		"\3\2\2\2\u0234\u0237\7,\2\2\u0235\u0237\7\7\2\2\u0236\u0232\3\2\2\2\u0236"+
		"\u0234\3\2\2\2\u0236\u0235\3\2\2\2\u0237\u008d\3\2\2\2\u0238\u023f\5\u00b4"+
		"[\2\u0239\u023f\5\66\34\2\u023a\u023b\7!\2\2\u023b\u023c\5b\62\2\u023c"+
		"\u023d\7\17\2\2\u023d\u023f\3\2\2\2\u023e\u0238\3\2\2\2\u023e\u0239\3"+
		"\2\2\2\u023e\u023a\3\2\2\2\u023f\u008f\3\2\2\2\u0240\u0242\5\u00b8]\2"+
		"\u0241\u0240\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0243\3\2\2\2\u0243\u0245"+
		"\5\u00b4[\2\u0244\u0246\5\u0092J\2\u0245\u0244\3\2\2\2\u0245\u0246\3\2"+
		"\2\2\u0246\u024e\3\2\2\2\u0247\u0249\7!\2\2\u0248\u024a\5b\62\2\u0249"+
		"\u0248\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u024b\3\2\2\2\u024b\u024f\7\17"+
		"\2\2\u024c\u024d\7\23\2\2\u024d\u024f\5\u009aN\2\u024e\u0247\3\2\2\2\u024e"+
		"\u024c\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u0091\3\2\2\2\u0250\u0252\7\4"+
		"\2\2\u0251\u0253\5f\64\2\u0252\u0251\3\2\2\2\u0252\u0253\3\2\2\2\u0253"+
		"\u0254\3\2\2\2\u0254\u0257\7\32\2\2\u0255\u0257\5\u00aeX\2\u0256\u0250"+
		"\3\2\2\2\u0256\u0255\3\2\2\2\u0257\u0093\3\2\2\2\u0258\u025a\7H\2\2\u0259"+
		"\u0258\3\2\2\2\u0259\u025a\3\2\2\2\u025a\u025c\3\2\2\2\u025b\u025d\5H"+
		"%\2\u025c\u025b\3\2\2\2\u025c\u025d\3\2\2\2\u025d\u025e\3\2\2\2\u025e"+
		"\u025f\5\u0096L\2\u025f\u0095\3\2\2\2\u0260\u0261\5\u00a6T\2\u0261\u0262"+
		"\5\u0098M\2\u0262\u0268\3\2\2\2\u0263\u0265\5\u009eP\2\u0264\u0266\5\u0098"+
		"M\2\u0265\u0264\3\2\2\2\u0265\u0266\3\2\2\2\u0266\u0268\3\2\2\2\u0267"+
		"\u0260\3\2\2\2\u0267\u0263\3\2\2\2\u0268\u0097\3\2\2\2\u0269\u026e\5\u0090"+
		"I\2\u026a\u026b\7\37\2\2\u026b\u026d\5\u0090I\2\u026c\u026a\3\2\2\2\u026d"+
		"\u0270\3\2\2\2\u026e\u026c\3\2\2\2\u026e\u026f\3\2\2\2\u026f\u0271\3\2"+
		"\2\2\u0270\u026e\3\2\2\2\u0271\u0272\7\63\2\2\u0272\u0099\3\2\2\2\u0273"+
		"\u0279\5d\63\2\u0274\u0275\7Y\2\2\u0275\u0276\5\u009cO\2\u0276\u0277\7"+
		"Z\2\2\u0277\u0279\3\2\2\2\u0278\u0273\3\2\2\2\u0278\u0274\3\2\2\2\u0279"+
		"\u009b\3\2\2\2\u027a\u027f\5\u009aN\2\u027b\u027c\7\37\2\2\u027c\u027e"+
		"\5\u009aN\2\u027d\u027b\3\2\2\2\u027e\u0281\3\2\2\2\u027f\u027d\3\2\2"+
		"\2\u027f\u0280\3\2\2\2\u0280\u009d\3\2\2\2\u0281\u027f\3\2\2\2\u0282\u0284"+
		"\5:\36\2\u0283\u0285\5\u00a0Q\2\u0284\u0283\3\2\2\2\u0284\u0285\3\2\2"+
		"\2\u0285\u0287\3\2\2\2\u0286\u0288\5\u00a2R\2\u0287\u0286\3\2\2\2\u0287"+
		"\u0288\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u028a\7Y\2\2\u028a\u028b\bP\1"+
		"\2\u028b\u009f\3\2\2\2\u028c\u028d\5\u00b4[\2\u028d\u00a1\3\2\2\2\u028e"+
		"\u028f\7\"\2\2\u028f\u0294\5\u00a4S\2\u0290\u0291\7\37\2\2\u0291\u0293"+
		"\5\u00a4S\2\u0292\u0290\3\2\2\2\u0293\u0296\3\2\2\2\u0294\u0292\3\2\2"+
		"\2\u0294\u0295\3\2\2\2\u0295\u00a3\3\2\2\2\u0296\u0294\3\2\2\2\u0297\u0299"+
		"\7N\2\2\u0298\u0297\3\2\2\2\u0298\u0299\3\2\2\2\u0299\u029b\3\2\2\2\u029a"+
		"\u029c\5> \2\u029b\u029a\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u029d\3\2\2"+
		"\2\u029d\u029e\5\u00b4[\2\u029e\u00a5\3\2\2\2\u029f\u02a1\7M\2\2\u02a0"+
		"\u029f\3\2\2\2\u02a1\u02a4\3\2\2\2\u02a2\u02a0\3\2\2\2\u02a2\u02a3\3\2"+
		"\2\2\u02a3\u02a8\3\2\2\2\u02a4\u02a2\3\2\2\2\u02a5\u02a9\5:\36\2\u02a6"+
		"\u02a9\7J\2\2\u02a7\u02a9\7K\2\2\u02a8\u02a5\3\2\2\2\u02a8\u02a6\3\2\2"+
		"\2\u02a8\u02a7\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9\u02aa\3\2\2\2\u02aa\u02af"+
		"\5\u00a8U\2\u02ab\u02ac\7\6\2\2\u02ac\u02ad\5J&\2\u02ad\u02ae\7\66\2\2"+
		"\u02ae\u02b0\3\2\2\2\u02af\u02ab\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0\u02bb"+
		"\3\2\2\2\u02b1\u02b2\7\22\2\2\u02b2\u02b7\5\u00a8U\2\u02b3\u02b4\7\6\2"+
		"\2\u02b4\u02b5\5J&\2\u02b5\u02b6\7\66\2\2\u02b6\u02b8\3\2\2\2\u02b7\u02b3"+
		"\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8\u02ba\3\2\2\2\u02b9\u02b1\3\2\2\2\u02ba"+
		"\u02bd\3\2\2\2\u02bb\u02b9\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02c0\3\2"+
		"\2\2\u02bd\u02bb\3\2\2\2\u02be\u02c0\t\32\2\2\u02bf\u02a2\3\2\2\2\u02bf"+
		"\u02be\3\2\2\2\u02c0\u00a7\3\2\2\2\u02c1\u02c7\7X\2\2\u02c2\u02c7\7I\2"+
		"\2\u02c3\u02c7\7L\2\2\u02c4\u02c5\7L\2\2\u02c5\u02c7\7L\2\2\u02c6\u02c1"+
		"\3\2\2\2\u02c6\u02c2\3\2\2\2\u02c6\u02c3\3\2\2\2\u02c6\u02c4\3\2\2\2\u02c7"+
		"\u00a9\3\2\2\2\u02c8\u02ca\t\33\2\2\u02c9\u02c8\3\2\2\2\u02c9\u02ca\3"+
		"\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\u02cc\5\u00a6T\2\u02cc\u00ab\3\2\2\2"+
		"\u02cd\u02d0\5\u00b4[\2\u02ce\u02d0\5> \2\u02cf\u02cd\3\2\2\2\u02cf\u02ce"+
		"\3\2\2\2\u02d0\u00ad\3\2\2\2\u02d1\u02d2\7!\2\2\u02d2\u02d3\7I\2\2\u02d3"+
		"\u02e1\7\17\2\2\u02d4\u02dd\7!\2\2\u02d5\u02da\5\u00b0Y\2\u02d6\u02d7"+
		"\7\37\2\2\u02d7\u02d9\5\u00b0Y\2\u02d8\u02d6\3\2\2\2\u02d9\u02dc\3\2\2"+
		"\2\u02da\u02d8\3\2\2\2\u02da\u02db\3\2\2\2\u02db\u02de\3\2\2\2\u02dc\u02da"+
		"\3\2\2\2\u02dd\u02d5\3\2\2\2\u02dd\u02de\3\2\2\2\u02de\u02df\3\2\2\2\u02df"+
		"\u02e1\7\17\2\2\u02e0\u02d1\3\2\2\2\u02e0\u02d4\3\2\2\2\u02e1\u00af\3"+
		"\2\2\2\u02e2\u02e3\5\u00aaV\2\u02e3\u02e4\5\u00b2Z\2\u02e4\u00b1\3\2\2"+
		"\2\u02e5\u02e7\5\u00b8]\2\u02e6\u02e5\3\2\2\2\u02e6\u02e7\3\2\2\2\u02e7"+
		"\u02ef\3\2\2\2\u02e8\u02e9\7!\2\2\u02e9\u02ea\5\u00b2Z\2\u02ea\u02eb\7"+
		"\17\2\2\u02eb\u02f0\3\2\2\2\u02ec\u02ee\5\u00acW\2\u02ed\u02ec\3\2\2\2"+
		"\u02ed\u02ee\3\2\2\2\u02ee\u02f0\3\2\2\2\u02ef\u02e8\3\2\2\2\u02ef\u02ed"+
		"\3\2\2\2\u02f0\u02f2\3\2\2\2\u02f1\u02f3\5\u0092J\2\u02f2\u02f1\3\2\2"+
		"\2\u02f2\u02f3\3\2\2\2\u02f3\u00b3\3\2\2\2\u02f4\u02f9\7X\2\2\u02f5\u02f6"+
		"\7\22\2\2\u02f6\u02f8\7X\2\2\u02f7\u02f5\3\2\2\2\u02f8\u02fb\3\2\2\2\u02f9"+
		"\u02f7\3\2\2\2\u02f9\u02fa\3\2\2\2\u02fa\u00b5\3\2\2\2\u02fb\u02f9\3\2"+
		"\2\2\u02fc\u02fd\t\34\2\2\u02fd\u00b7\3\2\2\2\u02fe\u0300\5<\37\2\u02ff"+
		"\u02fe\3\2\2\2\u0300\u0301\3\2\2\2\u0301\u02ff\3\2\2\2\u0301\u0302\3\2"+
		"\2\2\u0302\u00b9\3\2\2\2P\u00bd\u00cc\u00d6\u00db\u00ec\u00f4\u0108\u010b"+
		"\u0110\u0118\u0125\u0129\u012c\u0149\u0173\u0187\u0189\u01a5\u01ab\u01b3"+
		"\u01b8\u01bd\u01c2\u01c7\u01cc\u01d2\u01d8\u01dd\u01e2\u01e7\u01ee\u01f5"+
		"\u01fe\u0202\u0208\u020e\u0215\u0221\u0224\u0232\u0236\u023e\u0241\u0245"+
		"\u0249\u024e\u0252\u0256\u0259\u025c\u0265\u0267\u026e\u0278\u027f\u0284"+
		"\u0287\u0294\u0298\u029b\u02a2\u02a8\u02af\u02b7\u02bb\u02bf\u02c6\u02c9"+
		"\u02cf\u02da\u02dd\u02e0\u02e6\u02ed\u02ef\u02f2\u02f9\u0301";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}
// Generated from ./FineFunctionGrammar.g4 by ANTLR 4.0

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
public class FineFunctionGrammarParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__53=1, T__52=2, T__51=3, T__50=4, T__49=5, T__48=6, T__47=7, T__46=8, 
		T__45=9, T__44=10, T__43=11, T__42=12, T__41=13, T__40=14, T__39=15, T__38=16, 
		T__37=17, T__36=18, T__35=19, T__34=20, T__33=21, T__32=22, T__31=23, 
		T__30=24, T__29=25, T__28=26, T__27=27, T__26=28, T__25=29, T__24=30, 
		T__23=31, T__22=32, T__21=33, T__20=34, T__19=35, T__18=36, T__17=37, 
		T__16=38, T__15=39, T__14=40, T__13=41, T__12=42, T__11=43, T__10=44, 
		T__9=45, T__8=46, T__7=47, T__6=48, T__5=49, T__4=50, T__3=51, T__2=52, 
		T__1=53, T__0=54, IF=55, ELSE=56, FOR=57, WHILE=58, BREAK=59, CASE=60, 
		CONTINUE=61, SWITCH=62, DO=63, GOTO=64, RETURN=65, TYPEDEF=66, VOID=67, 
		UNSIGNED=68, SIGNED=69, LONG=70, CV_QUALIFIER=71, VIRTUAL=72, TRY=73, 
		CATCH=74, THROW=75, USING=76, NAMESPACE=77, AUTO=78, REGISTER=79, OPERATOR=80, 
		TEMPLATE=81, CLASS_KEY=82, ALPHA_NUMERIC=83, OPENING_CURLY=84, CLOSING_CURLY=85, 
		PRE_IF=86, PRE_ELSE=87, PRE_ENDIF=88, HEX_LITERAL=89, DECIMAL_LITERAL=90, 
		OCTAL_LITERAL=91, FLOATING_POINT_LITERAL=92, CHAR=93, STRING=94, COMMENT=95, 
		WHITESPACE=96, CPPCOMMENT=97, OTHER=98;
	public static final String[] tokenNames = {
		"<INVALID>", "'&'", "'['", "'*'", "'<'", "'--'", "'!='", "'<='", "'<<'", 
		"'%'", "'->'", "'*='", "')'", "'inline'", "'explicit'", "'::'", "'='", 
		"'|='", "'new'", "'|'", "'!'", "'<<='", "']'", "'-='", "'->*'", "'public'", 
		"','", "'-'", "':'", "'('", "'&='", "'private'", "'?'", "'>>='", "'+='", 
		"'^='", "'friend'", "'static'", "'++'", "'>>'", "'^'", "'delete'", "'.'", 
		"'+'", "'protected'", "';'", "'&&'", "'||'", "'>'", "'%='", "'/='", "'=='", 
		"'/'", "'~'", "'>='", "'if'", "'else'", "'for'", "'while'", "'break'", 
		"'case'", "'continue'", "'switch'", "'do'", "'goto'", "'return'", "'typedef'", 
		"'void'", "'unsigned'", "'signed'", "'long'", "CV_QUALIFIER", "'virtual'", 
		"'try'", "'catch'", "'throw'", "'using'", "'namespace'", "'auto'", "'register'", 
		"'operator'", "'template'", "CLASS_KEY", "ALPHA_NUMERIC", "'{'", "'}'", 
		"PRE_IF", "PRE_ELSE", "PRE_ENDIF", "HEX_LITERAL", "DECIMAL_LITERAL", "OCTAL_LITERAL", 
		"FLOATING_POINT_LITERAL", "CHAR", "STRING", "COMMENT", "WHITESPACE", "CPPCOMMENT", 
		"OTHER"
	};
	public static final int
		RULE_statements = 0, RULE_statement = 1, RULE_pre_opener = 2, RULE_pre_else = 3, 
		RULE_pre_closer = 4, RULE_opening_curly = 5, RULE_closing_curly = 6, RULE_block_starter = 7, 
		RULE_selection_or_iteration = 8, RULE_do_statement1 = 9, RULE_for_init_statement = 10, 
		RULE_jump_statement = 11, RULE_break_or_continue = 12, RULE_return_statement = 13, 
		RULE_goto_statement = 14, RULE_label = 15, RULE_expr_statement = 16, RULE_condition = 17, 
		RULE_unary_operator = 18, RULE_relational_operator = 19, RULE_constant = 20, 
		RULE_function_decl_specifiers = 21, RULE_ptr_operator = 22, RULE_access_specifier = 23, 
		RULE_operator = 24, RULE_assignment_operator = 25, RULE_equality_operator = 26, 
		RULE_template_decl_start = 27, RULE_template_param_list = 28, RULE_no_brackets = 29, 
		RULE_no_brackets_curlies_or_squares = 30, RULE_no_brackets_or_semicolon = 31, 
		RULE_no_angle_brackets_or_brackets = 32, RULE_no_curlies = 33, RULE_no_squares = 34, 
		RULE_no_squares_or_semicolon = 35, RULE_no_comma_or_semicolon = 36, RULE_assign_water = 37, 
		RULE_assign_water_l2 = 38, RULE_water = 39, RULE_expr = 40, RULE_assign_expr = 41, 
		RULE_conditional_expression = 42, RULE_or_expression = 43, RULE_and_expression = 44, 
		RULE_inclusive_or_expression = 45, RULE_exclusive_or_expression = 46, 
		RULE_bit_and_expression = 47, RULE_equality_expression = 48, RULE_relational_expression = 49, 
		RULE_shift_expression = 50, RULE_additive_expression = 51, RULE_multiplicative_expression = 52, 
		RULE_cast_expression = 53, RULE_cast_target = 54, RULE_unary_expression = 55, 
		RULE_inc_dec = 56, RULE_unary_operators = 57, RULE_field = 58, RULE_function_argument_list = 59, 
		RULE_function_argument = 60, RULE_postfix = 61, RULE_primary_expression = 62, 
		RULE_init_declarator = 63, RULE_type_suffix = 64, RULE_simple_decl = 65, 
		RULE_var_decl = 66, RULE_init_declarator_list = 67, RULE_initializer = 68, 
		RULE_initializer_list = 69, RULE_class_def = 70, RULE_class_name = 71, 
		RULE_base_classes = 72, RULE_base_class = 73, RULE_type_name = 74, RULE_base_type = 75, 
		RULE_param_decl_specifiers = 76, RULE_parameter_name = 77, RULE_param_type_list = 78, 
		RULE_param_type = 79, RULE_param_type_id = 80, RULE_identifier = 81, RULE_number = 82, 
		RULE_ptrs = 83;
	public static final String[] ruleNames = {
		"statements", "statement", "pre_opener", "pre_else", "pre_closer", "opening_curly", 
		"closing_curly", "block_starter", "selection_or_iteration", "do_statement1", 
		"for_init_statement", "jump_statement", "break_or_continue", "return_statement", 
		"goto_statement", "label", "expr_statement", "condition", "unary_operator", 
		"relational_operator", "constant", "function_decl_specifiers", "ptr_operator", 
		"access_specifier", "operator", "assignment_operator", "equality_operator", 
		"template_decl_start", "template_param_list", "no_brackets", "no_brackets_curlies_or_squares", 
		"no_brackets_or_semicolon", "no_angle_brackets_or_brackets", "no_curlies", 
		"no_squares", "no_squares_or_semicolon", "no_comma_or_semicolon", "assign_water", 
		"assign_water_l2", "water", "expr", "assign_expr", "conditional_expression", 
		"or_expression", "and_expression", "inclusive_or_expression", "exclusive_or_expression", 
		"bit_and_expression", "equality_expression", "relational_expression", 
		"shift_expression", "additive_expression", "multiplicative_expression", 
		"cast_expression", "cast_target", "unary_expression", "inc_dec", "unary_operators", 
		"field", "function_argument_list", "function_argument", "postfix", "primary_expression", 
		"init_declarator", "type_suffix", "simple_decl", "var_decl", "init_declarator_list", 
		"initializer", "initializer_list", "class_def", "class_name", "base_classes", 
		"base_class", "type_name", "base_type", "param_decl_specifiers", "parameter_name", 
		"param_type_list", "param_type", "param_type_id", "identifier", "number", 
		"ptrs"
	};

	@Override
	public String getGrammarFileName() { return "FineFunctionGrammar.g4"; }

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


	public FineFunctionGrammarParser(TokenStream input) {
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
		public List<Pre_elseContext> pre_else() {
			return getRuleContexts(Pre_elseContext.class);
		}
		public List<Pre_openerContext> pre_opener() {
			return getRuleContexts(Pre_openerContext.class);
		}
		public List<Pre_closerContext> pre_closer() {
			return getRuleContexts(Pre_closerContext.class);
		}
		public Pre_elseContext pre_else(int i) {
			return getRuleContext(Pre_elseContext.class,i);
		}
		public Pre_openerContext pre_opener(int i) {
			return getRuleContext(Pre_openerContext.class,i);
		}
		public Pre_closerContext pre_closer(int i) {
			return getRuleContext(Pre_closerContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH) | (1L << DO))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)) | (1L << (5 - 64)) | (1L << (20 - 64)) | (1L << (25 - 64)) | (1L << (27 - 64)) | (1L << (29 - 64)) | (1L << (31 - 64)) | (1L << (38 - 64)) | (1L << (43 - 64)) | (1L << (44 - 64)) | (1L << (53 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)))) != 0)) {
				{
				setState(174);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(168); pre_opener();
					}
					break;

				case 2:
					{
					setState(169); pre_closer();
					}
					break;

				case 3:
					{
					setState(170); pre_else();
					preProcSkipToEnd(); 
					}
					break;

				case 4:
					{
					setState(173); statement();
					}
					break;
				}
				}
				setState(178);
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(187);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(179); opening_curly();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(180); closing_curly();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(181); block_starter();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(182); jump_statement();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(183); simple_decl();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(184); label();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(185); expr_statement();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(186); water();
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

	public static class Pre_openerContext extends ParserRuleContext {
		public TerminalNode PRE_IF() { return getToken(FineFunctionGrammarParser.PRE_IF, 0); }
		public Pre_openerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pre_opener; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterPre_opener(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitPre_opener(this);
		}
	}

	public final Pre_openerContext pre_opener() throws RecognitionException {
		Pre_openerContext _localctx = new Pre_openerContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pre_opener);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189); match(PRE_IF);
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

	public static class Pre_elseContext extends ParserRuleContext {
		public TerminalNode PRE_ELSE() { return getToken(FineFunctionGrammarParser.PRE_ELSE, 0); }
		public Pre_elseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pre_else; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterPre_else(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitPre_else(this);
		}
	}

	public final Pre_elseContext pre_else() throws RecognitionException {
		Pre_elseContext _localctx = new Pre_elseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pre_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191); match(PRE_ELSE);
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

	public static class Pre_closerContext extends ParserRuleContext {
		public TerminalNode PRE_ENDIF() { return getToken(FineFunctionGrammarParser.PRE_ENDIF, 0); }
		public Pre_closerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pre_closer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterPre_closer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitPre_closer(this);
		}
	}

	public final Pre_closerContext pre_closer() throws RecognitionException {
		Pre_closerContext _localctx = new Pre_closerContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_pre_closer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193); match(PRE_ENDIF);
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterOpening_curly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitOpening_curly(this);
		}
	}

	public final Opening_curlyContext opening_curly() throws RecognitionException {
		Opening_curlyContext _localctx = new Opening_curlyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_opening_curly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195); match(OPENING_CURLY);
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterClosing_curly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitClosing_curly(this);
		}
	}

	public final Closing_curlyContext closing_curly() throws RecognitionException {
		Closing_curlyContext _localctx = new Closing_curlyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_closing_curly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197); match(CLOSING_CURLY);
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
		public Selection_or_iterationContext selection_or_iteration() {
			return getRuleContext(Selection_or_iterationContext.class,0);
		}
		public Block_starterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_starter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterBlock_starter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitBlock_starter(this);
		}
	}

	public final Block_starterContext block_starter() throws RecognitionException {
		Block_starterContext _localctx = new Block_starterContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_block_starter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199); selection_or_iteration();
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

	public static class Selection_or_iterationContext extends ParserRuleContext {
		public Selection_or_iterationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection_or_iteration; }
	 
		public Selection_or_iterationContext() { }
		public void copyFrom(Selection_or_iterationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Catch_statementContext extends Selection_or_iterationContext {
		public Param_typeContext param_type() {
			return getRuleContext(Param_typeContext.class,0);
		}
		public TerminalNode CATCH() { return getToken(FineFunctionGrammarParser.CATCH, 0); }
		public Catch_statementContext(Selection_or_iterationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterCatch_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitCatch_statement(this);
		}
	}
	public static class Else_statementContext extends Selection_or_iterationContext {
		public TerminalNode ELSE() { return getToken(FineFunctionGrammarParser.ELSE, 0); }
		public Else_statementContext(Selection_or_iterationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterElse_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitElse_statement(this);
		}
	}
	public static class Switch_statementContext extends Selection_or_iterationContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode SWITCH() { return getToken(FineFunctionGrammarParser.SWITCH, 0); }
		public Switch_statementContext(Selection_or_iterationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterSwitch_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitSwitch_statement(this);
		}
	}
	public static class Do_statementContext extends Selection_or_iterationContext {
		public TerminalNode DO() { return getToken(FineFunctionGrammarParser.DO, 0); }
		public Do_statementContext(Selection_or_iterationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterDo_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitDo_statement(this);
		}
	}
	public static class If_statementContext extends Selection_or_iterationContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode IF() { return getToken(FineFunctionGrammarParser.IF, 0); }
		public If_statementContext(Selection_or_iterationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitIf_statement(this);
		}
	}
	public static class While_statementContext extends Selection_or_iterationContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(FineFunctionGrammarParser.WHILE, 0); }
		public While_statementContext(Selection_or_iterationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterWhile_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitWhile_statement(this);
		}
	}
	public static class For_statementContext extends Selection_or_iterationContext {
		public TerminalNode FOR() { return getToken(FineFunctionGrammarParser.FOR, 0); }
		public For_init_statementContext for_init_statement() {
			return getRuleContext(For_init_statementContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public For_statementContext(Selection_or_iterationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterFor_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitFor_statement(this);
		}
	}
	public static class Try_statementContext extends Selection_or_iterationContext {
		public TerminalNode TRY() { return getToken(FineFunctionGrammarParser.TRY, 0); }
		public Try_statementContext(Selection_or_iterationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterTry_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitTry_statement(this);
		}
	}

	public final Selection_or_iterationContext selection_or_iteration() throws RecognitionException {
		Selection_or_iterationContext _localctx = new Selection_or_iterationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_selection_or_iteration);
		int _la;
		try {
			setState(234);
			switch (_input.LA(1)) {
			case TRY:
				_localctx = new Try_statementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(201); match(TRY);
				}
				break;
			case CATCH:
				_localctx = new Catch_statementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(202); match(CATCH);
				setState(203); match(29);
				setState(204); param_type();
				setState(205); match(12);
				}
				break;
			case IF:
				_localctx = new If_statementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(207); match(IF);
				setState(208); match(29);
				setState(209); condition();
				setState(210); match(12);
				}
				break;
			case ELSE:
				_localctx = new Else_statementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(212); match(ELSE);
				}
				break;
			case SWITCH:
				_localctx = new Switch_statementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(213); match(SWITCH);
				setState(214); match(29);
				setState(215); condition();
				setState(216); match(12);
				}
				break;
			case FOR:
				_localctx = new For_statementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(218); match(FOR);
				setState(219); match(29);
				setState(220); for_init_statement();
				setState(221); condition();
				setState(222); match(45);
				setState(224);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 20) | (1L << 27) | (1L << 29) | (1L << 38) | (1L << 43) | (1L << 53))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (ALPHA_NUMERIC - 83)) | (1L << (HEX_LITERAL - 83)) | (1L << (DECIMAL_LITERAL - 83)) | (1L << (OCTAL_LITERAL - 83)) | (1L << (FLOATING_POINT_LITERAL - 83)) | (1L << (CHAR - 83)) | (1L << (STRING - 83)))) != 0)) {
					{
					setState(223); expr();
					}
				}

				setState(226); match(12);
				}
				break;
			case DO:
				_localctx = new Do_statementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(228); match(DO);
				}
				break;
			case WHILE:
				_localctx = new While_statementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(229); match(WHILE);
				setState(230); match(29);
				setState(231); condition();
				setState(232); match(12);
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

	public static class Do_statement1Context extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode DO() { return getToken(FineFunctionGrammarParser.DO, 0); }
		public TerminalNode WHILE() { return getToken(FineFunctionGrammarParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Do_statement1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_do_statement1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterDo_statement1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitDo_statement1(this);
		}
	}

	public final Do_statement1Context do_statement1() throws RecognitionException {
		Do_statement1Context _localctx = new Do_statement1Context(_ctx, getState());
		enterRule(_localctx, 18, RULE_do_statement1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236); match(DO);
			setState(237); statement();
			setState(238); match(WHILE);
			setState(239); match(29);
			setState(240); expr();
			setState(241); match(12);
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterFor_init_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitFor_init_statement(this);
		}
	}

	public final For_init_statementContext for_init_statement() throws RecognitionException {
		For_init_statementContext _localctx = new For_init_statementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_for_init_statement);
		int _la;
		try {
			setState(248);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(243); simple_decl();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 20) | (1L << 27) | (1L << 29) | (1L << 38) | (1L << 43) | (1L << 53))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (ALPHA_NUMERIC - 83)) | (1L << (HEX_LITERAL - 83)) | (1L << (DECIMAL_LITERAL - 83)) | (1L << (OCTAL_LITERAL - 83)) | (1L << (FLOATING_POINT_LITERAL - 83)) | (1L << (CHAR - 83)) | (1L << (STRING - 83)))) != 0)) {
					{
					setState(244); expr();
					}
				}

				setState(247); match(45);
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterJump_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitJump_statement(this);
		}
	}

	public final Jump_statementContext jump_statement() throws RecognitionException {
		Jump_statementContext _localctx = new Jump_statementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_jump_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			switch (_input.LA(1)) {
			case BREAK:
			case CONTINUE:
				{
				setState(250); break_or_continue();
				}
				break;
			case RETURN:
				{
				setState(251); return_statement();
				}
				break;
			case GOTO:
				{
				setState(252); goto_statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(255); match(45);
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
		public TerminalNode CONTINUE() { return getToken(FineFunctionGrammarParser.CONTINUE, 0); }
		public TerminalNode BREAK() { return getToken(FineFunctionGrammarParser.BREAK, 0); }
		public Break_or_continueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_break_or_continue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterBreak_or_continue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitBreak_or_continue(this);
		}
	}

	public final Break_or_continueContext break_or_continue() throws RecognitionException {
		Break_or_continueContext _localctx = new Break_or_continueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_break_or_continue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
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
		public TerminalNode RETURN() { return getToken(FineFunctionGrammarParser.RETURN, 0); }
		public Return_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterReturn_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitReturn_statement(this);
		}
	}

	public final Return_statementContext return_statement() throws RecognitionException {
		Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_return_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259); match(RETURN);
			setState(261);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 20) | (1L << 27) | (1L << 29) | (1L << 38) | (1L << 43) | (1L << 53))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (ALPHA_NUMERIC - 83)) | (1L << (HEX_LITERAL - 83)) | (1L << (DECIMAL_LITERAL - 83)) | (1L << (OCTAL_LITERAL - 83)) | (1L << (FLOATING_POINT_LITERAL - 83)) | (1L << (CHAR - 83)) | (1L << (STRING - 83)))) != 0)) {
				{
				setState(260); expr();
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
		public TerminalNode GOTO() { return getToken(FineFunctionGrammarParser.GOTO, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Goto_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goto_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterGoto_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitGoto_statement(this);
		}
	}

	public final Goto_statementContext goto_statement() throws RecognitionException {
		Goto_statementContext _localctx = new Goto_statementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_goto_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263); match(GOTO);
			setState(264); identifier();
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
		public TerminalNode CASE() { return getToken(FineFunctionGrammarParser.CASE, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitLabel(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			switch (_input.LA(1)) {
			case CASE:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
				{
				{
				setState(267);
				_la = _input.LA(1);
				if (_la==CASE) {
					{
					setState(266); match(CASE);
					}
				}

				setState(271);
				switch (_input.LA(1)) {
				case ALPHA_NUMERIC:
					{
					setState(269); identifier();
					}
					break;
				case HEX_LITERAL:
				case DECIMAL_LITERAL:
				case OCTAL_LITERAL:
					{
					setState(270); number();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				break;
			case 25:
			case 31:
			case 44:
				{
				setState(273); access_specifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(276); match(28);
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterExpr_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitExpr_statement(this);
		}
	}

	public final Expr_statementContext expr_statement() throws RecognitionException {
		Expr_statementContext _localctx = new Expr_statementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expr_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278); expr();
			setState(279); match(45);
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281); expr();
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitUnary_operator(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 20) | (1L << 27) | (1L << 43) | (1L << 53))) != 0)) ) {
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterRelational_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitRelational_operator(this);
		}
	}

	public final Relational_operatorContext relational_operator() throws RecognitionException {
		Relational_operatorContext _localctx = new Relational_operatorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_relational_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 48) | (1L << 54))) != 0)) ) {
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
		public TerminalNode CHAR() { return getToken(FineFunctionGrammarParser.CHAR, 0); }
		public TerminalNode OCTAL_LITERAL() { return getToken(FineFunctionGrammarParser.OCTAL_LITERAL, 0); }
		public TerminalNode HEX_LITERAL() { return getToken(FineFunctionGrammarParser.HEX_LITERAL, 0); }
		public TerminalNode FLOATING_POINT_LITERAL() { return getToken(FineFunctionGrammarParser.FLOATING_POINT_LITERAL, 0); }
		public TerminalNode DECIMAL_LITERAL() { return getToken(FineFunctionGrammarParser.DECIMAL_LITERAL, 0); }
		public TerminalNode STRING() { return getToken(FineFunctionGrammarParser.STRING, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			_la = _input.LA(1);
			if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (HEX_LITERAL - 89)) | (1L << (DECIMAL_LITERAL - 89)) | (1L << (OCTAL_LITERAL - 89)) | (1L << (FLOATING_POINT_LITERAL - 89)) | (1L << (CHAR - 89)) | (1L << (STRING - 89)))) != 0)) ) {
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterFunction_decl_specifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitFunction_decl_specifiers(this);
		}
	}

	public final Function_decl_specifiersContext function_decl_specifiers() throws RecognitionException {
		Function_decl_specifiersContext _localctx = new Function_decl_specifiersContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_function_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			_la = _input.LA(1);
			if ( !(((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & ((1L << (13 - 13)) | (1L << (14 - 13)) | (1L << (36 - 13)) | (1L << (37 - 13)) | (1L << (VIRTUAL - 13)))) != 0)) ) {
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterPtr_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitPtr_operator(this);
		}
	}

	public final Ptr_operatorContext ptr_operator() throws RecognitionException {
		Ptr_operatorContext _localctx = new Ptr_operatorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_ptr_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterAccess_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitAccess_specifier(this);
		}
	}

	public final Access_specifierContext access_specifier() throws RecognitionException {
		Access_specifierContext _localctx = new Access_specifierContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_access_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 25) | (1L << 31) | (1L << 44))) != 0)) ) {
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

	public static class OperatorContext extends ParserRuleContext {
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitOperator(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_operator);
		int _la;
		try {
			setState(340);
			switch (_input.LA(1)) {
			case 18:
			case 41:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(295);
				_la = _input.LA(1);
				if ( !(_la==18 || _la==41) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(298);
				_la = _input.LA(1);
				if (_la==2) {
					{
					setState(296); match(2);
					setState(297); match(22);
					}
				}

				}
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 2);
				{
				setState(300); match(43);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 3);
				{
				setState(301); match(27);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 4);
				{
				setState(302); match(3);
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 5);
				{
				setState(303); match(52);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 6);
				{
				setState(304); match(9);
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 7);
				{
				setState(305); match(40);
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 8);
				{
				setState(306); match(1);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 9);
				{
				setState(307); match(19);
				}
				break;
			case 53:
				enterOuterAlt(_localctx, 10);
				{
				setState(308); match(53);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 11);
				{
				setState(309); match(20);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 12);
				{
				setState(310); match(16);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 13);
				{
				setState(311); match(4);
				}
				break;
			case 48:
				enterOuterAlt(_localctx, 14);
				{
				setState(312); match(48);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 15);
				{
				setState(313); match(34);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 16);
				{
				setState(314); match(23);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 17);
				{
				setState(315); match(11);
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 18);
				{
				setState(316); match(50);
				}
				break;
			case 49:
				enterOuterAlt(_localctx, 19);
				{
				setState(317); match(49);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 20);
				{
				setState(318); match(35);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 21);
				{
				setState(319); match(30);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 22);
				{
				setState(320); match(17);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 23);
				{
				setState(321); match(39);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 24);
				{
				setState(322); match(8);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 25);
				{
				setState(323); match(33);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 26);
				{
				setState(324); match(21);
				}
				break;
			case 51:
				enterOuterAlt(_localctx, 27);
				{
				setState(325); match(51);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 28);
				{
				setState(326); match(6);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 29);
				{
				setState(327); match(7);
				}
				break;
			case 54:
				enterOuterAlt(_localctx, 30);
				{
				setState(328); match(54);
				}
				break;
			case 46:
				enterOuterAlt(_localctx, 31);
				{
				setState(329); match(46);
				}
				break;
			case 47:
				enterOuterAlt(_localctx, 32);
				{
				setState(330); match(47);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 33);
				{
				setState(331); match(38);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 34);
				{
				setState(332); match(5);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 35);
				{
				setState(333); match(26);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 36);
				{
				setState(334); match(24);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 37);
				{
				setState(335); match(10);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 38);
				{
				setState(336); match(29);
				setState(337); match(12);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 39);
				{
				setState(338); match(2);
				setState(339); match(22);
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterAssignment_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitAssignment_operator(this);
		}
	}

	public final Assignment_operatorContext assignment_operator() throws RecognitionException {
		Assignment_operatorContext _localctx = new Assignment_operatorContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_assignment_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 16) | (1L << 17) | (1L << 21) | (1L << 23) | (1L << 30) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 49) | (1L << 50))) != 0)) ) {
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterEquality_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitEquality_operator(this);
		}
	}

	public final Equality_operatorContext equality_operator() throws RecognitionException {
		Equality_operatorContext _localctx = new Equality_operatorContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_equality_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			_la = _input.LA(1);
			if ( !(_la==6 || _la==51) ) {
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
		public TerminalNode TEMPLATE() { return getToken(FineFunctionGrammarParser.TEMPLATE, 0); }
		public Template_decl_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_decl_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterTemplate_decl_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitTemplate_decl_start(this);
		}
	}

	public final Template_decl_startContext template_decl_start() throws RecognitionException {
		Template_decl_startContext _localctx = new Template_decl_startContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_template_decl_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346); match(TEMPLATE);
			setState(347); match(4);
			setState(348); template_param_list();
			setState(349); match(48);
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterTemplate_param_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitTemplate_param_list(this);
		}
	}

	public final Template_param_listContext template_param_list() throws RecognitionException {
		Template_param_listContext _localctx = new Template_param_listContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_template_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(360);
				switch (_input.LA(1)) {
				case 4:
					{
					{
					setState(351); match(4);
					setState(352); template_param_list();
					setState(353); match(48);
					}
					}
					break;
				case 29:
					{
					{
					setState(355); match(29);
					setState(356); template_param_list();
					setState(357); match(12);
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
				case 13:
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
				case 30:
				case 31:
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
				case 49:
				case 50:
				case 51:
				case 52:
				case 53:
				case 54:
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
				case CLASS_KEY:
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
					setState(359); no_angle_brackets_or_brackets();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(362); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH) | (1L << DO))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0) );
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterNo_brackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitNo_brackets(this);
		}
	}

	public final No_bracketsContext no_brackets() throws RecognitionException {
		No_bracketsContext _localctx = new No_bracketsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_no_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==12 || _la==29) ) {
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterNo_brackets_curlies_or_squares(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitNo_brackets_curlies_or_squares(this);
		}
	}

	public final No_brackets_curlies_or_squaresContext no_brackets_curlies_or_squares() throws RecognitionException {
		No_brackets_curlies_or_squaresContext _localctx = new No_brackets_curlies_or_squaresContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_no_brackets_curlies_or_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 12) | (1L << 22) | (1L << 29))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterNo_brackets_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitNo_brackets_or_semicolon(this);
		}
	}

	public final No_brackets_or_semicolonContext no_brackets_or_semicolon() throws RecognitionException {
		No_brackets_or_semicolonContext _localctx = new No_brackets_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_no_brackets_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 29) | (1L << 45))) != 0)) ) {
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterNo_angle_brackets_or_brackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitNo_angle_brackets_or_brackets(this);
		}
	}

	public final No_angle_brackets_or_bracketsContext no_angle_brackets_or_brackets() throws RecognitionException {
		No_angle_brackets_or_bracketsContext _localctx = new No_angle_brackets_or_bracketsContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_no_angle_brackets_or_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 12) | (1L << 29) | (1L << 48))) != 0)) ) {
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterNo_curlies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitNo_curlies(this);
		}
	}

	public final No_curliesContext no_curlies() throws RecognitionException {
		No_curliesContext _localctx = new No_curliesContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_no_curlies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterNo_squares(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitNo_squares(this);
		}
	}

	public final No_squaresContext no_squares() throws RecognitionException {
		No_squaresContext _localctx = new No_squaresContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_no_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==2 || _la==22) ) {
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterNo_squares_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitNo_squares_or_semicolon(this);
		}
	}

	public final No_squares_or_semicolonContext no_squares_or_semicolon() throws RecognitionException {
		No_squares_or_semicolonContext _localctx = new No_squares_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_no_squares_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 22) | (1L << 45))) != 0)) ) {
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterNo_comma_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitNo_comma_or_semicolon(this);
		}
	}

	public final No_comma_or_semicolonContext no_comma_or_semicolon() throws RecognitionException {
		No_comma_or_semicolonContext _localctx = new No_comma_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_no_comma_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==26 || _la==45) ) {
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterAssign_water(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitAssign_water(this);
		}
	}

	public final Assign_waterContext assign_water() throws RecognitionException {
		Assign_waterContext _localctx = new Assign_waterContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_assign_water);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 12) | (1L << 22) | (1L << 26) | (1L << 29) | (1L << 45))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterAssign_water_l2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitAssign_water_l2(this);
		}
	}

	public final Assign_water_l2Context assign_water_l2() throws RecognitionException {
		Assign_water_l2Context _localctx = new Assign_water_l2Context(_ctx, getState());
		enterRule(_localctx, 76, RULE_assign_water_l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 12) | (1L << 22) | (1L << 29))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterWater(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitWater(this);
		}
	}

	public final WaterContext water() throws RecognitionException {
		WaterContext _localctx = new WaterContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_water);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386); assign_expr();
			setState(389);
			_la = _input.LA(1);
			if (_la==26) {
				{
				setState(387); match(26);
				setState(388); expr();
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterAssign_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitAssign_expr(this);
		}
	}

	public final Assign_exprContext assign_expr() throws RecognitionException {
		Assign_exprContext _localctx = new Assign_exprContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_assign_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391); conditional_expression();
			setState(395);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 16) | (1L << 17) | (1L << 21) | (1L << 23) | (1L << 30) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 49) | (1L << 50))) != 0)) {
				{
				setState(392); assignment_operator();
				setState(393); assign_expr();
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterConditional_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitConditional_expression(this);
		}
	}

	public final Conditional_expressionContext conditional_expression() throws RecognitionException {
		Conditional_expressionContext _localctx = new Conditional_expressionContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_conditional_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397); or_expression();
			setState(403);
			_la = _input.LA(1);
			if (_la==32) {
				{
				setState(398); match(32);
				setState(399); expr();
				setState(400); match(28);
				setState(401); conditional_expression();
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterOr_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitOr_expression(this);
		}
	}

	public final Or_expressionContext or_expression() throws RecognitionException {
		Or_expressionContext _localctx = new Or_expressionContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405); and_expression();
			setState(408);
			_la = _input.LA(1);
			if (_la==47) {
				{
				setState(406); match(47);
				setState(407); or_expression();
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterAnd_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitAnd_expression(this);
		}
	}

	public final And_expressionContext and_expression() throws RecognitionException {
		And_expressionContext _localctx = new And_expressionContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410); inclusive_or_expression();
			setState(413);
			_la = _input.LA(1);
			if (_la==46) {
				{
				setState(411); match(46);
				setState(412); and_expression();
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterInclusive_or_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitInclusive_or_expression(this);
		}
	}

	public final Inclusive_or_expressionContext inclusive_or_expression() throws RecognitionException {
		Inclusive_or_expressionContext _localctx = new Inclusive_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_inclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415); exclusive_or_expression();
			setState(418);
			_la = _input.LA(1);
			if (_la==19) {
				{
				setState(416); match(19);
				setState(417); inclusive_or_expression();
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterExclusive_or_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitExclusive_or_expression(this);
		}
	}

	public final Exclusive_or_expressionContext exclusive_or_expression() throws RecognitionException {
		Exclusive_or_expressionContext _localctx = new Exclusive_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_exclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420); bit_and_expression();
			setState(423);
			_la = _input.LA(1);
			if (_la==40) {
				{
				setState(421); match(40);
				setState(422); exclusive_or_expression();
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterBit_and_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitBit_and_expression(this);
		}
	}

	public final Bit_and_expressionContext bit_and_expression() throws RecognitionException {
		Bit_and_expressionContext _localctx = new Bit_and_expressionContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_bit_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425); equality_expression();
			setState(428);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(426); match(1);
				setState(427); bit_and_expression();
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterEquality_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitEquality_expression(this);
		}
	}

	public final Equality_expressionContext equality_expression() throws RecognitionException {
		Equality_expressionContext _localctx = new Equality_expressionContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_equality_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430); relational_expression();
			setState(434);
			_la = _input.LA(1);
			if (_la==6 || _la==51) {
				{
				setState(431); equality_operator();
				setState(432); equality_expression();
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterRelational_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitRelational_expression(this);
		}
	}

	public final Relational_expressionContext relational_expression() throws RecognitionException {
		Relational_expressionContext _localctx = new Relational_expressionContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_relational_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436); shift_expression();
			setState(440);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 48) | (1L << 54))) != 0)) {
				{
				setState(437); relational_operator();
				setState(438); relational_expression();
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterShift_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitShift_expression(this);
		}
	}

	public final Shift_expressionContext shift_expression() throws RecognitionException {
		Shift_expressionContext _localctx = new Shift_expressionContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_shift_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442); additive_expression();
			setState(445);
			_la = _input.LA(1);
			if (_la==8 || _la==39) {
				{
				setState(443);
				_la = _input.LA(1);
				if ( !(_la==8 || _la==39) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(444); shift_expression();
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterAdditive_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitAdditive_expression(this);
		}
	}

	public final Additive_expressionContext additive_expression() throws RecognitionException {
		Additive_expressionContext _localctx = new Additive_expressionContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_additive_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447); multiplicative_expression();
			setState(450);
			_la = _input.LA(1);
			if (_la==27 || _la==43) {
				{
				setState(448);
				_la = _input.LA(1);
				if ( !(_la==27 || _la==43) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(449); additive_expression();
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
		public Cast_expressionContext cast_expression() {
			return getRuleContext(Cast_expressionContext.class,0);
		}
		public Multiplicative_expressionContext multiplicative_expression() {
			return getRuleContext(Multiplicative_expressionContext.class,0);
		}
		public Multiplicative_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterMultiplicative_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitMultiplicative_expression(this);
		}
	}

	public final Multiplicative_expressionContext multiplicative_expression() throws RecognitionException {
		Multiplicative_expressionContext _localctx = new Multiplicative_expressionContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_multiplicative_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452); cast_expression();
			setState(455);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 9) | (1L << 52))) != 0)) {
				{
				setState(453);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 9) | (1L << 52))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(454); multiplicative_expression();
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
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public Cast_targetContext cast_target() {
			return getRuleContext(Cast_targetContext.class,0);
		}
		public Cast_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterCast_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitCast_expression(this);
		}
	}

	public final Cast_expressionContext cast_expression() throws RecognitionException {
		Cast_expressionContext _localctx = new Cast_expressionContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_cast_expression);
		try {
			setState(463);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(457); match(29);
				setState(458); cast_target();
				setState(459); match(12);
				setState(460); cast_expression();
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(462); unary_expression();
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

	public static class Cast_targetContext extends ParserRuleContext {
		public Ptr_operatorContext ptr_operator(int i) {
			return getRuleContext(Ptr_operatorContext.class,i);
		}
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public List<Ptr_operatorContext> ptr_operator() {
			return getRuleContexts(Ptr_operatorContext.class);
		}
		public Cast_targetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast_target; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterCast_target(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitCast_target(this);
		}
	}

	public final Cast_targetContext cast_target() throws RecognitionException {
		Cast_targetContext _localctx = new Cast_targetContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_cast_target);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465); type_name();
			setState(469);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1 || _la==3) {
				{
				{
				setState(466); ptr_operator();
				}
				}
				setState(471);
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

	public static class Unary_expressionContext extends ParserRuleContext {
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
	 
		public Unary_expressionContext() { }
		public void copyFrom(Unary_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FieldOnlyContext extends Unary_expressionContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public Inc_decContext inc_dec() {
			return getRuleContext(Inc_decContext.class,0);
		}
		public Unary_operatorsContext unary_operators() {
			return getRuleContext(Unary_operatorsContext.class,0);
		}
		public FieldOnlyContext(Unary_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterFieldOnly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitFieldOnly(this);
		}
	}
	public static class FuncCallContext extends Unary_expressionContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public Inc_decContext inc_dec() {
			return getRuleContext(Inc_decContext.class,0);
		}
		public Template_param_listContext template_param_list() {
			return getRuleContext(Template_param_listContext.class,0);
		}
		public Unary_operatorsContext unary_operators() {
			return getRuleContext(Unary_operatorsContext.class,0);
		}
		public Function_argument_listContext function_argument_list() {
			return getRuleContext(Function_argument_listContext.class,0);
		}
		public FuncCallContext(Unary_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitFuncCall(this);
		}
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_unary_expression);
		int _la;
		try {
			setState(487);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(472); inc_dec();
				setState(473); unary_operators();
				setState(474); field();
				{
				setState(479);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(475); match(4);
					setState(476); template_param_list();
					setState(477); match(48);
					}
				}

				setState(481); function_argument_list();
				}
				}
				break;

			case 2:
				_localctx = new FieldOnlyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(483); inc_dec();
				setState(484); unary_operators();
				setState(485); field();
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

	public static class Inc_decContext extends ParserRuleContext {
		public Inc_decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inc_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterInc_dec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitInc_dec(this);
		}
	}

	public final Inc_decContext inc_dec() throws RecognitionException {
		Inc_decContext _localctx = new Inc_decContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_inc_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(492);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==5 || _la==38) {
				{
				{
				setState(489);
				_la = _input.LA(1);
				if ( !(_la==5 || _la==38) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(494);
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

	public static class Unary_operatorsContext extends ParserRuleContext {
		public List<Unary_operatorContext> unary_operator() {
			return getRuleContexts(Unary_operatorContext.class);
		}
		public Unary_operatorContext unary_operator(int i) {
			return getRuleContext(Unary_operatorContext.class,i);
		}
		public Unary_operatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterUnary_operators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitUnary_operators(this);
		}
	}

	public final Unary_operatorsContext unary_operators() throws RecognitionException {
		Unary_operatorsContext _localctx = new Unary_operatorsContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_unary_operators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 20) | (1L << 27) | (1L << 43) | (1L << 53))) != 0)) {
				{
				{
				setState(495); unary_operator();
				}
				}
				setState(500);
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501); primary_expression();
			setState(505);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 5) | (1L << 10) | (1L << 38) | (1L << 42))) != 0)) {
				{
				{
				setState(502); postfix();
				}
				}
				setState(507);
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterFunction_argument_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitFunction_argument_list(this);
		}
	}

	public final Function_argument_listContext function_argument_list() throws RecognitionException {
		Function_argument_listContext _localctx = new Function_argument_listContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_function_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508); match(29);
			setState(517);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 20) | (1L << 27) | (1L << 29) | (1L << 38) | (1L << 43) | (1L << 53))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (ALPHA_NUMERIC - 83)) | (1L << (HEX_LITERAL - 83)) | (1L << (DECIMAL_LITERAL - 83)) | (1L << (OCTAL_LITERAL - 83)) | (1L << (FLOATING_POINT_LITERAL - 83)) | (1L << (CHAR - 83)) | (1L << (STRING - 83)))) != 0)) {
				{
				setState(509); function_argument();
				setState(514);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==26) {
					{
					{
					setState(510); match(26);
					setState(511); function_argument();
					}
					}
					setState(516);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(519); match(12);
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterFunction_argument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitFunction_argument(this);
		}
	}

	public final Function_argumentContext function_argument() throws RecognitionException {
		Function_argumentContext _localctx = new Function_argumentContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_function_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521); assign_expr();
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterPostfix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitPostfix(this);
		}
	}

	public final PostfixContext postfix() throws RecognitionException {
		PostfixContext _localctx = new PostfixContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_postfix);
		try {
			setState(535);
			switch (_input.LA(1)) {
			case 2:
			case 10:
			case 42:
				enterOuterAlt(_localctx, 1);
				{
				setState(531);
				switch (_input.LA(1)) {
				case 42:
					{
					setState(523); match(42);
					setState(524); identifier();
					}
					break;
				case 10:
					{
					setState(525); match(10);
					setState(526); identifier();
					}
					break;
				case 2:
					{
					setState(527); match(2);
					setState(528); expr();
					setState(529); match(22);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 2);
				{
				setState(533); match(38);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 3);
				{
				setState(534); match(5);
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterPrimary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitPrimary_expression(this);
		}
	}

	public final Primary_expressionContext primary_expression() throws RecognitionException {
		Primary_expressionContext _localctx = new Primary_expressionContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_primary_expression);
		try {
			setState(543);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(537); identifier();
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
				setState(538); constant();
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 3);
				{
				setState(539); match(29);
				setState(540); expr();
				setState(541); match(12);
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterInit_declarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitInit_declarator(this);
		}
	}

	public final Init_declaratorContext init_declarator() throws RecognitionException {
		Init_declaratorContext _localctx = new Init_declaratorContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_init_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(546);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(545); ptrs();
				}
			}

			setState(548); identifier();
			setState(550);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(549); type_suffix();
				}
				break;
			}
			}
			setState(559);
			switch (_input.LA(1)) {
			case 29:
				{
				{
				setState(552); match(29);
				setState(554);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 20) | (1L << 27) | (1L << 29) | (1L << 38) | (1L << 43) | (1L << 53))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (ALPHA_NUMERIC - 83)) | (1L << (HEX_LITERAL - 83)) | (1L << (DECIMAL_LITERAL - 83)) | (1L << (OCTAL_LITERAL - 83)) | (1L << (FLOATING_POINT_LITERAL - 83)) | (1L << (CHAR - 83)) | (1L << (STRING - 83)))) != 0)) {
					{
					setState(553); expr();
					}
				}

				setState(556); match(12);
				}
				}
				break;
			case 16:
				{
				{
				setState(557); match(16);
				setState(558); initializer();
				}
				}
				break;
			case 26:
			case 45:
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterType_suffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitType_suffix(this);
		}
	}

	public final Type_suffixContext type_suffix() throws RecognitionException {
		Type_suffixContext _localctx = new Type_suffixContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_type_suffix);
		int _la;
		try {
			setState(567);
			switch (_input.LA(1)) {
			case 2:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(561); match(2);
				setState(563);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 20) | (1L << 27) | (1L << 29) | (1L << 38) | (1L << 43) | (1L << 53))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (ALPHA_NUMERIC - 83)) | (1L << (HEX_LITERAL - 83)) | (1L << (DECIMAL_LITERAL - 83)) | (1L << (OCTAL_LITERAL - 83)) | (1L << (FLOATING_POINT_LITERAL - 83)) | (1L << (CHAR - 83)) | (1L << (STRING - 83)))) != 0)) {
					{
					setState(562); conditional_expression();
					}
				}

				setState(565); match(22);
				}
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 2);
				{
				setState(566); param_type_list();
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
		public TerminalNode TYPEDEF() { return getToken(FineFunctionGrammarParser.TYPEDEF, 0); }
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Simple_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterSimple_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitSimple_decl(this);
		}
	}

	public final Simple_declContext simple_decl() throws RecognitionException {
		Simple_declContext _localctx = new Simple_declContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_simple_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(570);
			_la = _input.LA(1);
			if (_la==TYPEDEF) {
				{
				setState(569); match(TYPEDEF);
				}
			}

			setState(573);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(572); template_decl_start();
				}
			}

			}
			setState(575); var_decl();
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterDeclByClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitDeclByClass(this);
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterDeclByType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitDeclByType(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_var_decl);
		try {
			setState(584);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				_localctx = new DeclByClassContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(577); class_def();
				setState(579);
				switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
				case 1:
					{
					setState(578); init_declarator_list();
					}
					break;
				}
				}
				break;

			case 2:
				_localctx = new DeclByTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(581); type_name();
				setState(582); init_declarator_list();
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterInit_declarator_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitInit_declarator_list(this);
		}
	}

	public final Init_declarator_listContext init_declarator_list() throws RecognitionException {
		Init_declarator_listContext _localctx = new Init_declarator_listContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(586); init_declarator();
			setState(591);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==26) {
				{
				{
				setState(587); match(26);
				setState(588); init_declarator();
				}
				}
				setState(593);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(594); match(45);
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitInitializer(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_initializer);
		try {
			setState(601);
			switch (_input.LA(1)) {
			case 1:
			case 3:
			case 5:
			case 20:
			case 27:
			case 29:
			case 38:
			case 43:
			case 53:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case CHAR:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(596); assign_expr();
				}
				break;
			case OPENING_CURLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(597); match(OPENING_CURLY);
				setState(598); initializer_list();
				setState(599); match(CLOSING_CURLY);
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterInitializer_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitInitializer_list(this);
		}
	}

	public final Initializer_listContext initializer_list() throws RecognitionException {
		Initializer_listContext _localctx = new Initializer_listContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_initializer_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603); initializer();
			setState(608);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==26) {
				{
				{
				setState(604); match(26);
				setState(605); initializer();
				}
				}
				setState(610);
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
		public Class_nameContext class_name() {
			return getRuleContext(Class_nameContext.class,0);
		}
		public TerminalNode CLASS_KEY() { return getToken(FineFunctionGrammarParser.CLASS_KEY, 0); }
		public TerminalNode OPENING_CURLY() { return getToken(FineFunctionGrammarParser.OPENING_CURLY, 0); }
		public Class_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterClass_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitClass_def(this);
		}
	}

	public final Class_defContext class_def() throws RecognitionException {
		Class_defContext _localctx = new Class_defContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(611); match(CLASS_KEY);
			setState(613);
			_la = _input.LA(1);
			if (_la==ALPHA_NUMERIC) {
				{
				setState(612); class_name();
				}
			}

			setState(616);
			_la = _input.LA(1);
			if (_la==28) {
				{
				setState(615); base_classes();
				}
			}

			setState(618); match(OPENING_CURLY);
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterClass_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitClass_name(this);
		}
	}

	public final Class_nameContext class_name() throws RecognitionException {
		Class_nameContext _localctx = new Class_nameContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_class_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(621); identifier();
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterBase_classes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitBase_classes(this);
		}
	}

	public final Base_classesContext base_classes() throws RecognitionException {
		Base_classesContext _localctx = new Base_classesContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_base_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623); match(28);
			setState(624); base_class();
			setState(629);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==26) {
				{
				{
				setState(625); match(26);
				setState(626); base_class();
				}
				}
				setState(631);
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
		public TerminalNode VIRTUAL() { return getToken(FineFunctionGrammarParser.VIRTUAL, 0); }
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterBase_class(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitBase_class(this);
		}
	}

	public final Base_classContext base_class() throws RecognitionException {
		Base_classContext _localctx = new Base_classContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_base_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			_la = _input.LA(1);
			if (_la==VIRTUAL) {
				{
				setState(632); match(VIRTUAL);
				}
			}

			setState(636);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 25) | (1L << 31) | (1L << 44))) != 0)) {
				{
				setState(635); access_specifier();
				}
			}

			setState(638); identifier();
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
		public List<TerminalNode> CV_QUALIFIER() { return getTokens(FineFunctionGrammarParser.CV_QUALIFIER); }
		public Template_param_listContext template_param_list(int i) {
			return getRuleContext(Template_param_listContext.class,i);
		}
		public TerminalNode SIGNED() { return getToken(FineFunctionGrammarParser.SIGNED, 0); }
		public TerminalNode UNSIGNED() { return getToken(FineFunctionGrammarParser.UNSIGNED, 0); }
		public List<Template_param_listContext> template_param_list() {
			return getRuleContexts(Template_param_listContext.class);
		}
		public Base_typeContext base_type(int i) {
			return getRuleContext(Base_typeContext.class,i);
		}
		public List<Base_typeContext> base_type() {
			return getRuleContexts(Base_typeContext.class);
		}
		public TerminalNode CV_QUALIFIER(int i) {
			return getToken(FineFunctionGrammarParser.CV_QUALIFIER, i);
		}
		public TerminalNode CLASS_KEY() { return getToken(FineFunctionGrammarParser.CLASS_KEY, 0); }
		public Type_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterType_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitType_name(this);
		}
	}

	public final Type_nameContext type_name() throws RecognitionException {
		Type_nameContext _localctx = new Type_nameContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_type_name);
		int _la;
		try {
			setState(671);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(643);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CV_QUALIFIER) {
					{
					{
					setState(640); match(CV_QUALIFIER);
					}
					}
					setState(645);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(647);
				_la = _input.LA(1);
				if (((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (UNSIGNED - 68)) | (1L << (SIGNED - 68)) | (1L << (CLASS_KEY - 68)))) != 0)) {
					{
					setState(646);
					_la = _input.LA(1);
					if ( !(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (UNSIGNED - 68)) | (1L << (SIGNED - 68)) | (1L << (CLASS_KEY - 68)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(649); base_type();
				setState(654);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(650); match(4);
					setState(651); template_param_list();
					setState(652); match(48);
					}
				}

				setState(666);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==15) {
					{
					{
					setState(656); match(15);
					setState(657); base_type();
					setState(662);
					_la = _input.LA(1);
					if (_la==4) {
						{
						setState(658); match(4);
						setState(659); template_param_list();
						setState(660); match(48);
						}
					}

					}
					}
					setState(668);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(669); match(UNSIGNED);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(670); match(SIGNED);
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
		public TerminalNode VOID() { return getToken(FineFunctionGrammarParser.VOID, 0); }
		public TerminalNode ALPHA_NUMERIC() { return getToken(FineFunctionGrammarParser.ALPHA_NUMERIC, 0); }
		public TerminalNode LONG(int i) {
			return getToken(FineFunctionGrammarParser.LONG, i);
		}
		public List<TerminalNode> LONG() { return getTokens(FineFunctionGrammarParser.LONG); }
		public Base_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterBase_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitBase_type(this);
		}
	}

	public final Base_typeContext base_type() throws RecognitionException {
		Base_typeContext _localctx = new Base_typeContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_base_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(678);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(673); match(ALPHA_NUMERIC);
				}
				break;

			case 2:
				{
				setState(674); match(VOID);
				}
				break;

			case 3:
				{
				setState(675); match(LONG);
				}
				break;

			case 4:
				{
				setState(676); match(LONG);
				setState(677); match(LONG);
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
		public TerminalNode REGISTER() { return getToken(FineFunctionGrammarParser.REGISTER, 0); }
		public TerminalNode AUTO() { return getToken(FineFunctionGrammarParser.AUTO, 0); }
		public Param_decl_specifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl_specifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterParam_decl_specifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitParam_decl_specifiers(this);
		}
	}

	public final Param_decl_specifiersContext param_decl_specifiers() throws RecognitionException {
		Param_decl_specifiersContext _localctx = new Param_decl_specifiersContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_param_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(681);
			_la = _input.LA(1);
			if (_la==AUTO || _la==REGISTER) {
				{
				setState(680);
				_la = _input.LA(1);
				if ( !(_la==AUTO || _la==REGISTER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(683); type_name();
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterParameter_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitParameter_name(this);
		}
	}

	public final Parameter_nameContext parameter_name() throws RecognitionException {
		Parameter_nameContext _localctx = new Parameter_nameContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_parameter_name);
		try {
			setState(687);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(685); identifier();
				}
				break;
			case 25:
			case 31:
			case 44:
				enterOuterAlt(_localctx, 2);
				{
				setState(686); access_specifier();
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
		public TerminalNode VOID() { return getToken(FineFunctionGrammarParser.VOID, 0); }
		public Param_type_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_type_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterParam_type_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitParam_type_list(this);
		}
	}

	public final Param_type_listContext param_type_list() throws RecognitionException {
		Param_type_listContext _localctx = new Param_type_listContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_param_type_list);
		int _la;
		try {
			setState(704);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(689); match(29);
				setState(690); match(VOID);
				setState(691); match(12);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(692); match(29);
				setState(701);
				_la = _input.LA(1);
				if (((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (VOID - 67)) | (1L << (UNSIGNED - 67)) | (1L << (SIGNED - 67)) | (1L << (LONG - 67)) | (1L << (CV_QUALIFIER - 67)) | (1L << (AUTO - 67)) | (1L << (REGISTER - 67)) | (1L << (CLASS_KEY - 67)) | (1L << (ALPHA_NUMERIC - 67)))) != 0)) {
					{
					setState(693); param_type();
					setState(698);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==26) {
						{
						{
						setState(694); match(26);
						setState(695); param_type();
						}
						}
						setState(700);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(703); match(12);
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterParam_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitParam_type(this);
		}
	}

	public final Param_typeContext param_type() throws RecognitionException {
		Param_typeContext _localctx = new Param_typeContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_param_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(706); param_decl_specifiers();
			setState(707); param_type_id();
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterParam_type_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitParam_type_id(this);
		}
	}

	public final Param_type_idContext param_type_id() throws RecognitionException {
		Param_type_idContext _localctx = new Param_type_idContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_param_type_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(710);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(709); ptrs();
				}
			}

			setState(719);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				{
				setState(712); match(29);
				setState(713); param_type_id();
				setState(714); match(12);
				}
				break;

			case 2:
				{
				setState(717);
				_la = _input.LA(1);
				if (((((_la - 25)) & ~0x3f) == 0 && ((1L << (_la - 25)) & ((1L << (25 - 25)) | (1L << (31 - 25)) | (1L << (44 - 25)) | (1L << (ALPHA_NUMERIC - 25)))) != 0)) {
					{
					setState(716); parameter_name();
					}
				}

				}
				break;
			}
			setState(722);
			_la = _input.LA(1);
			if (_la==2 || _la==29) {
				{
				setState(721); type_suffix();
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
			return getToken(FineFunctionGrammarParser.ALPHA_NUMERIC, i);
		}
		public List<TerminalNode> ALPHA_NUMERIC() { return getTokens(FineFunctionGrammarParser.ALPHA_NUMERIC); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(724); match(ALPHA_NUMERIC);
			setState(729);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==15) {
				{
				{
				setState(725); match(15);
				setState(726); match(ALPHA_NUMERIC);
				}
				}
				setState(731);
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
		public TerminalNode OCTAL_LITERAL() { return getToken(FineFunctionGrammarParser.OCTAL_LITERAL, 0); }
		public TerminalNode HEX_LITERAL() { return getToken(FineFunctionGrammarParser.HEX_LITERAL, 0); }
		public TerminalNode DECIMAL_LITERAL() { return getToken(FineFunctionGrammarParser.DECIMAL_LITERAL, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(732);
			_la = _input.LA(1);
			if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (HEX_LITERAL - 89)) | (1L << (DECIMAL_LITERAL - 89)) | (1L << (OCTAL_LITERAL - 89)))) != 0)) ) {
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
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterPtrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitPtrs(this);
		}
	}

	public final PtrsContext ptrs() throws RecognitionException {
		PtrsContext _localctx = new PtrsContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_ptrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(735); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(734); ptr_operator();
				}
				}
				setState(737); 
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
		"\2\3d\u02e6\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\t"+
		"F\4G\tG\4H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4"+
		"R\tR\4S\tS\4T\tT\4U\tU\3\2\3\2\3\2\3\2\3\2\3\2\7\2\u00b1\n\2\f\2\16\2"+
		"\u00b4\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00be\n\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00e3\n"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00ed\n\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\5\f\u00f8\n\f\3\f\5\f\u00fb\n\f\3\r\3\r\3\r\5\r"+
		"\u0100\n\r\3\r\3\r\3\16\3\16\3\17\3\17\5\17\u0108\n\17\3\20\3\20\3\20"+
		"\3\21\5\21\u010e\n\21\3\21\3\21\5\21\u0112\n\21\3\21\5\21\u0115\n\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\5\32\u012d\n\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0157\n\32\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\6\36\u016b\n\36\r\36\16\36\u016c\3\37\3\37\3 \3 \3!\3!\3\""+
		"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\5*\u0188\n*"+
		"\3+\3+\3+\3+\5+\u018e\n+\3,\3,\3,\3,\3,\3,\5,\u0196\n,\3-\3-\3-\5-\u019b"+
		"\n-\3.\3.\3.\5.\u01a0\n.\3/\3/\3/\5/\u01a5\n/\3\60\3\60\3\60\5\60\u01aa"+
		"\n\60\3\61\3\61\3\61\5\61\u01af\n\61\3\62\3\62\3\62\3\62\5\62\u01b5\n"+
		"\62\3\63\3\63\3\63\3\63\5\63\u01bb\n\63\3\64\3\64\3\64\5\64\u01c0\n\64"+
		"\3\65\3\65\3\65\5\65\u01c5\n\65\3\66\3\66\3\66\5\66\u01ca\n\66\3\67\3"+
		"\67\3\67\3\67\3\67\3\67\5\67\u01d2\n\67\38\38\78\u01d6\n8\f8\168\u01d9"+
		"\138\39\39\39\39\39\39\39\59\u01e2\n9\39\39\39\39\39\39\59\u01ea\n9\3"+
		":\7:\u01ed\n:\f:\16:\u01f0\13:\3;\7;\u01f3\n;\f;\16;\u01f6\13;\3<\3<\7"+
		"<\u01fa\n<\f<\16<\u01fd\13<\3=\3=\3=\3=\7=\u0203\n=\f=\16=\u0206\13=\5"+
		"=\u0208\n=\3=\3=\3>\3>\3?\3?\3?\3?\3?\3?\3?\3?\5?\u0216\n?\3?\3?\5?\u021a"+
		"\n?\3@\3@\3@\3@\3@\3@\5@\u0222\n@\3A\5A\u0225\nA\3A\3A\5A\u0229\nA\3A"+
		"\3A\5A\u022d\nA\3A\3A\3A\5A\u0232\nA\3B\3B\5B\u0236\nB\3B\3B\5B\u023a"+
		"\nB\3C\5C\u023d\nC\3C\5C\u0240\nC\3C\3C\3D\3D\5D\u0246\nD\3D\3D\3D\5D"+
		"\u024b\nD\3E\3E\3E\7E\u0250\nE\fE\16E\u0253\13E\3E\3E\3F\3F\3F\3F\3F\5"+
		"F\u025c\nF\3G\3G\3G\7G\u0261\nG\fG\16G\u0264\13G\3H\3H\5H\u0268\nH\3H"+
		"\5H\u026b\nH\3H\3H\3H\3I\3I\3J\3J\3J\3J\7J\u0276\nJ\fJ\16J\u0279\13J\3"+
		"K\5K\u027c\nK\3K\5K\u027f\nK\3K\3K\3L\7L\u0284\nL\fL\16L\u0287\13L\3L"+
		"\5L\u028a\nL\3L\3L\3L\3L\3L\5L\u0291\nL\3L\3L\3L\3L\3L\3L\5L\u0299\nL"+
		"\7L\u029b\nL\fL\16L\u029e\13L\3L\3L\5L\u02a2\nL\3M\3M\3M\3M\3M\5M\u02a9"+
		"\nM\3N\5N\u02ac\nN\3N\3N\3O\3O\5O\u02b2\nO\3P\3P\3P\3P\3P\3P\3P\7P\u02bb"+
		"\nP\fP\16P\u02be\13P\5P\u02c0\nP\3P\5P\u02c3\nP\3Q\3Q\3Q\3R\5R\u02c9\n"+
		"R\3R\3R\3R\3R\3R\5R\u02d0\nR\5R\u02d2\nR\3R\5R\u02d5\nR\3S\3S\3S\7S\u02da"+
		"\nS\fS\16S\u02dd\13S\3T\3T\3U\6U\u02e2\nU\rU\16U\u02e3\3U\2V\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\"+
		"^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090"+
		"\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8"+
		"\2\35\4==??\b\3\3\5\5\26\26\35\35--\67\67\6\6\6\t\t\62\6288\3[`\5\17\20"+
		"&\'JJ\4\3\3\5\5\5\33\33!!..\4\24\24++\t\r\r\22\23\27\27\31\31  #%\63\64"+
		"\4\b\b\65\65\4\16\16\37\37\7\4\4\16\16\30\30\37\37VW\5\16\16\37\37//\6"+
		"\6\6\16\16\37\37\62\62\3VW\4\4\4\30\30\5\4\4\30\30//\4\34\34//\t\4\4\16"+
		"\16\30\30\34\34\37\37//VW\7\4\4\16\16\30\30\37\37VW\4\n\n))\4\35\35--"+
		"\5\5\5\13\13\66\66\4\7\7((\4FGTT\3PQ\3[]\u031a\2\u00b2\3\2\2\2\4\u00bd"+
		"\3\2\2\2\6\u00bf\3\2\2\2\b\u00c1\3\2\2\2\n\u00c3\3\2\2\2\f\u00c5\3\2\2"+
		"\2\16\u00c7\3\2\2\2\20\u00c9\3\2\2\2\22\u00ec\3\2\2\2\24\u00ee\3\2\2\2"+
		"\26\u00fa\3\2\2\2\30\u00ff\3\2\2\2\32\u0103\3\2\2\2\34\u0105\3\2\2\2\36"+
		"\u0109\3\2\2\2 \u0114\3\2\2\2\"\u0118\3\2\2\2$\u011b\3\2\2\2&\u011d\3"+
		"\2\2\2(\u011f\3\2\2\2*\u0121\3\2\2\2,\u0123\3\2\2\2.\u0125\3\2\2\2\60"+
		"\u0127\3\2\2\2\62\u0156\3\2\2\2\64\u0158\3\2\2\2\66\u015a\3\2\2\28\u015c"+
		"\3\2\2\2:\u016a\3\2\2\2<\u016e\3\2\2\2>\u0170\3\2\2\2@\u0172\3\2\2\2B"+
		"\u0174\3\2\2\2D\u0176\3\2\2\2F\u0178\3\2\2\2H\u017a\3\2\2\2J\u017c\3\2"+
		"\2\2L\u017e\3\2\2\2N\u0180\3\2\2\2P\u0182\3\2\2\2R\u0184\3\2\2\2T\u0189"+
		"\3\2\2\2V\u018f\3\2\2\2X\u0197\3\2\2\2Z\u019c\3\2\2\2\\\u01a1\3\2\2\2"+
		"^\u01a6\3\2\2\2`\u01ab\3\2\2\2b\u01b0\3\2\2\2d\u01b6\3\2\2\2f\u01bc\3"+
		"\2\2\2h\u01c1\3\2\2\2j\u01c6\3\2\2\2l\u01d1\3\2\2\2n\u01d3\3\2\2\2p\u01e9"+
		"\3\2\2\2r\u01ee\3\2\2\2t\u01f4\3\2\2\2v\u01f7\3\2\2\2x\u01fe\3\2\2\2z"+
		"\u020b\3\2\2\2|\u0219\3\2\2\2~\u0221\3\2\2\2\u0080\u0224\3\2\2\2\u0082"+
		"\u0239\3\2\2\2\u0084\u023c\3\2\2\2\u0086\u024a\3\2\2\2\u0088\u024c\3\2"+
		"\2\2\u008a\u025b\3\2\2\2\u008c\u025d\3\2\2\2\u008e\u0265\3\2\2\2\u0090"+
		"\u026f\3\2\2\2\u0092\u0271\3\2\2\2\u0094\u027b\3\2\2\2\u0096\u02a1\3\2"+
		"\2\2\u0098\u02a8\3\2\2\2\u009a\u02ab\3\2\2\2\u009c\u02b1\3\2\2\2\u009e"+
		"\u02c2\3\2\2\2\u00a0\u02c4\3\2\2\2\u00a2\u02c8\3\2\2\2\u00a4\u02d6\3\2"+
		"\2\2\u00a6\u02de\3\2\2\2\u00a8\u02e1\3\2\2\2\u00aa\u00b1\5\6\4\2\u00ab"+
		"\u00b1\5\n\6\2\u00ac\u00ad\5\b\5\2\u00ad\u00ae\b\2\1\2\u00ae\u00b1\3\2"+
		"\2\2\u00af\u00b1\5\4\3\2\u00b0\u00aa\3\2\2\2\u00b0\u00ab\3\2\2\2\u00b0"+
		"\u00ac\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b3\3\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00be"+
		"\5\f\7\2\u00b6\u00be\5\16\b\2\u00b7\u00be\5\20\t\2\u00b8\u00be\5\30\r"+
		"\2\u00b9\u00be\5\u0084C\2\u00ba\u00be\5 \21\2\u00bb\u00be\5\"\22\2\u00bc"+
		"\u00be\5P)\2\u00bd\u00b5\3\2\2\2\u00bd\u00b6\3\2\2\2\u00bd\u00b7\3\2\2"+
		"\2\u00bd\u00b8\3\2\2\2\u00bd\u00b9\3\2\2\2\u00bd\u00ba\3\2\2\2\u00bd\u00bb"+
		"\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be\5\3\2\2\2\u00bf\u00c0\7X\2\2\u00c0"+
		"\7\3\2\2\2\u00c1\u00c2\7Y\2\2\u00c2\t\3\2\2\2\u00c3\u00c4\7Z\2\2\u00c4"+
		"\13\3\2\2\2\u00c5\u00c6\7V\2\2\u00c6\r\3\2\2\2\u00c7\u00c8\7W\2\2\u00c8"+
		"\17\3\2\2\2\u00c9\u00ca\5\22\n\2\u00ca\21\3\2\2\2\u00cb\u00ed\7K\2\2\u00cc"+
		"\u00cd\7L\2\2\u00cd\u00ce\7\37\2\2\u00ce\u00cf\5\u00a0Q\2\u00cf\u00d0"+
		"\7\16\2\2\u00d0\u00ed\3\2\2\2\u00d1\u00d2\79\2\2\u00d2\u00d3\7\37\2\2"+
		"\u00d3\u00d4\5$\23\2\u00d4\u00d5\7\16\2\2\u00d5\u00ed\3\2\2\2\u00d6\u00ed"+
		"\7:\2\2\u00d7\u00d8\7@\2\2\u00d8\u00d9\7\37\2\2\u00d9\u00da\5$\23\2\u00da"+
		"\u00db\7\16\2\2\u00db\u00ed\3\2\2\2\u00dc\u00dd\7;\2\2\u00dd\u00de\7\37"+
		"\2\2\u00de\u00df\5\26\f\2\u00df\u00e0\5$\23\2\u00e0\u00e2\7/\2\2\u00e1"+
		"\u00e3\5R*\2\u00e2\u00e1\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2\2"+
		"\2\u00e4\u00e5\7\16\2\2\u00e5\u00ed\3\2\2\2\u00e6\u00ed\7A\2\2\u00e7\u00e8"+
		"\7<\2\2\u00e8\u00e9\7\37\2\2\u00e9\u00ea\5$\23\2\u00ea\u00eb\7\16\2\2"+
		"\u00eb\u00ed\3\2\2\2\u00ec\u00cb\3\2\2\2\u00ec\u00cc\3\2\2\2\u00ec\u00d1"+
		"\3\2\2\2\u00ec\u00d6\3\2\2\2\u00ec\u00d7\3\2\2\2\u00ec\u00dc\3\2\2\2\u00ec"+
		"\u00e6\3\2\2\2\u00ec\u00e7\3\2\2\2\u00ed\23\3\2\2\2\u00ee\u00ef\7A\2\2"+
		"\u00ef\u00f0\5\4\3\2\u00f0\u00f1\7<\2\2\u00f1\u00f2\7\37\2\2\u00f2\u00f3"+
		"\5R*\2\u00f3\u00f4\7\16\2\2\u00f4\25\3\2\2\2\u00f5\u00fb\5\u0084C\2\u00f6"+
		"\u00f8\5R*\2\u00f7\u00f6\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\3\2\2"+
		"\2\u00f9\u00fb\7/\2\2\u00fa\u00f5\3\2\2\2\u00fa\u00f7\3\2\2\2\u00fb\27"+
		"\3\2\2\2\u00fc\u0100\5\32\16\2\u00fd\u0100\5\34\17\2\u00fe\u0100\5\36"+
		"\20\2\u00ff\u00fc\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u00fe\3\2\2\2\u0100"+
		"\u0101\3\2\2\2\u0101\u0102\7/\2\2\u0102\31\3\2\2\2\u0103\u0104\t\2\2\2"+
		"\u0104\33\3\2\2\2\u0105\u0107\7C\2\2\u0106\u0108\5R*\2\u0107\u0106\3\2"+
		"\2\2\u0107\u0108\3\2\2\2\u0108\35\3\2\2\2\u0109\u010a\7B\2\2\u010a\u010b"+
		"\5\u00a4S\2\u010b\37\3\2\2\2\u010c\u010e\7>\2\2\u010d\u010c\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u0112\5\u00a4S\2\u0110\u0112"+
		"\5\u00a6T\2\u0111\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112\u0115\3\2\2"+
		"\2\u0113\u0115\5\60\31\2\u0114\u010d\3\2\2\2\u0114\u0113\3\2\2\2\u0115"+
		"\u0116\3\2\2\2\u0116\u0117\7\36\2\2\u0117!\3\2\2\2\u0118\u0119\5R*\2\u0119"+
		"\u011a\7/\2\2\u011a#\3\2\2\2\u011b\u011c\5R*\2\u011c%\3\2\2\2\u011d\u011e"+
		"\t\3\2\2\u011e\'\3\2\2\2\u011f\u0120\t\4\2\2\u0120)\3\2\2\2\u0121\u0122"+
		"\t\5\2\2\u0122+\3\2\2\2\u0123\u0124\t\6\2\2\u0124-\3\2\2\2\u0125\u0126"+
		"\t\7\2\2\u0126/\3\2\2\2\u0127\u0128\t\b\2\2\u0128\61\3\2\2\2\u0129\u012c"+
		"\t\t\2\2\u012a\u012b\7\4\2\2\u012b\u012d\7\30\2\2\u012c\u012a\3\2\2\2"+
		"\u012c\u012d\3\2\2\2\u012d\u0157\3\2\2\2\u012e\u0157\7-\2\2\u012f\u0157"+
		"\7\35\2\2\u0130\u0157\7\5\2\2\u0131\u0157\7\66\2\2\u0132\u0157\7\13\2"+
		"\2\u0133\u0157\7*\2\2\u0134\u0157\7\3\2\2\u0135\u0157\7\25\2\2\u0136\u0157"+
		"\7\67\2\2\u0137\u0157\7\26\2\2\u0138\u0157\7\22\2\2\u0139\u0157\7\6\2"+
		"\2\u013a\u0157\7\62\2\2\u013b\u0157\7$\2\2\u013c\u0157\7\31\2\2\u013d"+
		"\u0157\7\r\2\2\u013e\u0157\7\64\2\2\u013f\u0157\7\63\2\2\u0140\u0157\7"+
		"%\2\2\u0141\u0157\7 \2\2\u0142\u0157\7\23\2\2\u0143\u0157\7)\2\2\u0144"+
		"\u0157\7\n\2\2\u0145\u0157\7#\2\2\u0146\u0157\7\27\2\2\u0147\u0157\7\65"+
		"\2\2\u0148\u0157\7\b\2\2\u0149\u0157\7\t\2\2\u014a\u0157\78\2\2\u014b"+
		"\u0157\7\60\2\2\u014c\u0157\7\61\2\2\u014d\u0157\7(\2\2\u014e\u0157\7"+
		"\7\2\2\u014f\u0157\7\34\2\2\u0150\u0157\7\32\2\2\u0151\u0157\7\f\2\2\u0152"+
		"\u0153\7\37\2\2\u0153\u0157\7\16\2\2\u0154\u0155\7\4\2\2\u0155\u0157\7"+
		"\30\2\2\u0156\u0129\3\2\2\2\u0156\u012e\3\2\2\2\u0156\u012f\3\2\2\2\u0156"+
		"\u0130\3\2\2\2\u0156\u0131\3\2\2\2\u0156\u0132\3\2\2\2\u0156\u0133\3\2"+
		"\2\2\u0156\u0134\3\2\2\2\u0156\u0135\3\2\2\2\u0156\u0136\3\2\2\2\u0156"+
		"\u0137\3\2\2\2\u0156\u0138\3\2\2\2\u0156\u0139\3\2\2\2\u0156\u013a\3\2"+
		"\2\2\u0156\u013b\3\2\2\2\u0156\u013c\3\2\2\2\u0156\u013d\3\2\2\2\u0156"+
		"\u013e\3\2\2\2\u0156\u013f\3\2\2\2\u0156\u0140\3\2\2\2\u0156\u0141\3\2"+
		"\2\2\u0156\u0142\3\2\2\2\u0156\u0143\3\2\2\2\u0156\u0144\3\2\2\2\u0156"+
		"\u0145\3\2\2\2\u0156\u0146\3\2\2\2\u0156\u0147\3\2\2\2\u0156\u0148\3\2"+
		"\2\2\u0156\u0149\3\2\2\2\u0156\u014a\3\2\2\2\u0156\u014b\3\2\2\2\u0156"+
		"\u014c\3\2\2\2\u0156\u014d\3\2\2\2\u0156\u014e\3\2\2\2\u0156\u014f\3\2"+
		"\2\2\u0156\u0150\3\2\2\2\u0156\u0151\3\2\2\2\u0156\u0152\3\2\2\2\u0156"+
		"\u0154\3\2\2\2\u0157\63\3\2\2\2\u0158\u0159\t\n\2\2\u0159\65\3\2\2\2\u015a"+
		"\u015b\t\13\2\2\u015b\67\3\2\2\2\u015c\u015d\7S\2\2\u015d\u015e\7\6\2"+
		"\2\u015e\u015f\5:\36\2\u015f\u0160\7\62\2\2\u01609\3\2\2\2\u0161\u0162"+
		"\7\6\2\2\u0162\u0163\5:\36\2\u0163\u0164\7\62\2\2\u0164\u016b\3\2\2\2"+
		"\u0165\u0166\7\37\2\2\u0166\u0167\5:\36\2\u0167\u0168\7\16\2\2\u0168\u016b"+
		"\3\2\2\2\u0169\u016b\5B\"\2\u016a\u0161\3\2\2\2\u016a\u0165\3\2\2\2\u016a"+
		"\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2"+
		"\2\2\u016d;\3\2\2\2\u016e\u016f\n\f\2\2\u016f=\3\2\2\2\u0170\u0171\n\r"+
		"\2\2\u0171?\3\2\2\2\u0172\u0173\n\16\2\2\u0173A\3\2\2\2\u0174\u0175\n"+
		"\17\2\2\u0175C\3\2\2\2\u0176\u0177\n\20\2\2\u0177E\3\2\2\2\u0178\u0179"+
		"\n\21\2\2\u0179G\3\2\2\2\u017a\u017b\n\22\2\2\u017bI\3\2\2\2\u017c\u017d"+
		"\n\23\2\2\u017dK\3\2\2\2\u017e\u017f\n\24\2\2\u017fM\3\2\2\2\u0180\u0181"+
		"\n\25\2\2\u0181O\3\2\2\2\u0182\u0183\13\2\2\2\u0183Q\3\2\2\2\u0184\u0187"+
		"\5T+\2\u0185\u0186\7\34\2\2\u0186\u0188\5R*\2\u0187\u0185\3\2\2\2\u0187"+
		"\u0188\3\2\2\2\u0188S\3\2\2\2\u0189\u018d\5V,\2\u018a\u018b\5\64\33\2"+
		"\u018b\u018c\5T+\2\u018c\u018e\3\2\2\2\u018d\u018a\3\2\2\2\u018d\u018e"+
		"\3\2\2\2\u018eU\3\2\2\2\u018f\u0195\5X-\2\u0190\u0191\7\"\2\2\u0191\u0192"+
		"\5R*\2\u0192\u0193\7\36\2\2\u0193\u0194\5V,\2\u0194\u0196\3\2\2\2\u0195"+
		"\u0190\3\2\2\2\u0195\u0196\3\2\2\2\u0196W\3\2\2\2\u0197\u019a\5Z.\2\u0198"+
		"\u0199\7\61\2\2\u0199\u019b\5X-\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2"+
		"\2\2\u019bY\3\2\2\2\u019c\u019f\5\\/\2\u019d\u019e\7\60\2\2\u019e\u01a0"+
		"\5Z.\2\u019f\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0[\3\2\2\2\u01a1\u01a4"+
		"\5^\60\2\u01a2\u01a3\7\25\2\2\u01a3\u01a5\5\\/\2\u01a4\u01a2\3\2\2\2\u01a4"+
		"\u01a5\3\2\2\2\u01a5]\3\2\2\2\u01a6\u01a9\5`\61\2\u01a7\u01a8\7*\2\2\u01a8"+
		"\u01aa\5^\60\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa_\3\2\2\2"+
		"\u01ab\u01ae\5b\62\2\u01ac\u01ad\7\3\2\2\u01ad\u01af\5`\61\2\u01ae\u01ac"+
		"\3\2\2\2\u01ae\u01af\3\2\2\2\u01afa\3\2\2\2\u01b0\u01b4\5d\63\2\u01b1"+
		"\u01b2\5\66\34\2\u01b2\u01b3\5b\62\2\u01b3\u01b5\3\2\2\2\u01b4\u01b1\3"+
		"\2\2\2\u01b4\u01b5\3\2\2\2\u01b5c\3\2\2\2\u01b6\u01ba\5f\64\2\u01b7\u01b8"+
		"\5(\25\2\u01b8\u01b9\5d\63\2\u01b9\u01bb\3\2\2\2\u01ba\u01b7\3\2\2\2\u01ba"+
		"\u01bb\3\2\2\2\u01bbe\3\2\2\2\u01bc\u01bf\5h\65\2\u01bd\u01be\t\26\2\2"+
		"\u01be\u01c0\5f\64\2\u01bf\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0g\3"+
		"\2\2\2\u01c1\u01c4\5j\66\2\u01c2\u01c3\t\27\2\2\u01c3\u01c5\5h\65\2\u01c4"+
		"\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5i\3\2\2\2\u01c6\u01c9\5l\67\2"+
		"\u01c7\u01c8\t\30\2\2\u01c8\u01ca\5j\66\2\u01c9\u01c7\3\2\2\2\u01c9\u01ca"+
		"\3\2\2\2\u01cak\3\2\2\2\u01cb\u01cc\7\37\2\2\u01cc\u01cd\5n8\2\u01cd\u01ce"+
		"\7\16\2\2\u01ce\u01cf\5l\67\2\u01cf\u01d2\3\2\2\2\u01d0\u01d2\5p9\2\u01d1"+
		"\u01cb\3\2\2\2\u01d1\u01d0\3\2\2\2\u01d2m\3\2\2\2\u01d3\u01d7\5\u0096"+
		"L\2\u01d4\u01d6\5.\30\2\u01d5\u01d4\3\2\2\2\u01d6\u01d9\3\2\2\2\u01d7"+
		"\u01d5\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8o\3\2\2\2\u01d9\u01d7\3\2\2\2"+
		"\u01da\u01db\5r:\2\u01db\u01dc\5t;\2\u01dc\u01e1\5v<\2\u01dd\u01de\7\6"+
		"\2\2\u01de\u01df\5:\36\2\u01df\u01e0\7\62\2\2\u01e0\u01e2\3\2\2\2\u01e1"+
		"\u01dd\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e4\5x"+
		"=\2\u01e4\u01ea\3\2\2\2\u01e5\u01e6\5r:\2\u01e6\u01e7\5t;\2\u01e7\u01e8"+
		"\5v<\2\u01e8\u01ea\3\2\2\2\u01e9\u01da\3\2\2\2\u01e9\u01e5\3\2\2\2\u01ea"+
		"q\3\2\2\2\u01eb\u01ed\t\31\2\2\u01ec\u01eb\3\2\2\2\u01ed\u01f0\3\2\2\2"+
		"\u01ee\u01ec\3\2\2\2\u01ee\u01ef\3\2\2\2\u01efs\3\2\2\2\u01f0\u01ee\3"+
		"\2\2\2\u01f1\u01f3\5&\24\2\u01f2\u01f1\3\2\2\2\u01f3\u01f6\3\2\2\2\u01f4"+
		"\u01f2\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5u\3\2\2\2\u01f6\u01f4\3\2\2\2"+
		"\u01f7\u01fb\5~@\2\u01f8\u01fa\5|?\2\u01f9\u01f8\3\2\2\2\u01fa\u01fd\3"+
		"\2\2\2\u01fb\u01f9\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fcw\3\2\2\2\u01fd\u01fb"+
		"\3\2\2\2\u01fe\u0207\7\37\2\2\u01ff\u0204\5z>\2\u0200\u0201\7\34\2\2\u0201"+
		"\u0203\5z>\2\u0202\u0200\3\2\2\2\u0203\u0206\3\2\2\2\u0204\u0202\3\2\2"+
		"\2\u0204\u0205\3\2\2\2\u0205\u0208\3\2\2\2\u0206\u0204\3\2\2\2\u0207\u01ff"+
		"\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020a\7\16\2\2"+
		"\u020ay\3\2\2\2\u020b\u020c\5T+\2\u020c{\3\2\2\2\u020d\u020e\7,\2\2\u020e"+
		"\u0216\5\u00a4S\2\u020f\u0210\7\f\2\2\u0210\u0216\5\u00a4S\2\u0211\u0212"+
		"\7\4\2\2\u0212\u0213\5R*\2\u0213\u0214\7\30\2\2\u0214\u0216\3\2\2\2\u0215"+
		"\u020d\3\2\2\2\u0215\u020f\3\2\2\2\u0215\u0211\3\2\2\2\u0216\u021a\3\2"+
		"\2\2\u0217\u021a\7(\2\2\u0218\u021a\7\7\2\2\u0219\u0215\3\2\2\2\u0219"+
		"\u0217\3\2\2\2\u0219\u0218\3\2\2\2\u021a}\3\2\2\2\u021b\u0222\5\u00a4"+
		"S\2\u021c\u0222\5*\26\2\u021d\u021e\7\37\2\2\u021e\u021f\5R*\2\u021f\u0220"+
		"\7\16\2\2\u0220\u0222\3\2\2\2\u0221\u021b\3\2\2\2\u0221\u021c\3\2\2\2"+
		"\u0221\u021d\3\2\2\2\u0222\177\3\2\2\2\u0223\u0225\5\u00a8U\2\u0224\u0223"+
		"\3\2\2\2\u0224\u0225\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0228\5\u00a4S"+
		"\2\u0227\u0229\5\u0082B\2\u0228\u0227\3\2\2\2\u0228\u0229\3\2\2\2\u0229"+
		"\u0231\3\2\2\2\u022a\u022c\7\37\2\2\u022b\u022d\5R*\2\u022c\u022b\3\2"+
		"\2\2\u022c\u022d\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u0232\7\16\2\2\u022f"+
		"\u0230\7\22\2\2\u0230\u0232\5\u008aF\2\u0231\u022a\3\2\2\2\u0231\u022f"+
		"\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0081\3\2\2\2\u0233\u0235\7\4\2\2\u0234"+
		"\u0236\5V,\2\u0235\u0234\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u0237\3\2\2"+
		"\2\u0237\u023a\7\30\2\2\u0238\u023a\5\u009eP\2\u0239\u0233\3\2\2\2\u0239"+
		"\u0238\3\2\2\2\u023a\u0083\3\2\2\2\u023b\u023d\7D\2\2\u023c\u023b\3\2"+
		"\2\2\u023c\u023d\3\2\2\2\u023d\u023f\3\2\2\2\u023e\u0240\58\35\2\u023f"+
		"\u023e\3\2\2\2\u023f\u0240\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u0242\5\u0086"+
		"D\2\u0242\u0085\3\2\2\2\u0243\u0245\5\u008eH\2\u0244\u0246\5\u0088E\2"+
		"\u0245\u0244\3\2\2\2\u0245\u0246\3\2\2\2\u0246\u024b\3\2\2\2\u0247\u0248"+
		"\5\u0096L\2\u0248\u0249\5\u0088E\2\u0249\u024b\3\2\2\2\u024a\u0243\3\2"+
		"\2\2\u024a\u0247\3\2\2\2\u024b\u0087\3\2\2\2\u024c\u0251\5\u0080A\2\u024d"+
		"\u024e\7\34\2\2\u024e\u0250\5\u0080A\2\u024f\u024d\3\2\2\2\u0250\u0253"+
		"\3\2\2\2\u0251\u024f\3\2\2\2\u0251\u0252\3\2\2\2\u0252\u0254\3\2\2\2\u0253"+
		"\u0251\3\2\2\2\u0254\u0255\7/\2\2\u0255\u0089\3\2\2\2\u0256\u025c\5T+"+
		"\2\u0257\u0258\7V\2\2\u0258\u0259\5\u008cG\2\u0259\u025a\7W\2\2\u025a"+
		"\u025c\3\2\2\2\u025b\u0256\3\2\2\2\u025b\u0257\3\2\2\2\u025c\u008b\3\2"+
		"\2\2\u025d\u0262\5\u008aF\2\u025e\u025f\7\34\2\2\u025f\u0261\5\u008aF"+
		"\2\u0260\u025e\3\2\2\2\u0261\u0264\3\2\2\2\u0262\u0260\3\2\2\2\u0262\u0263"+
		"\3\2\2\2\u0263\u008d\3\2\2\2\u0264\u0262\3\2\2\2\u0265\u0267\7T\2\2\u0266"+
		"\u0268\5\u0090I\2\u0267\u0266\3\2\2\2\u0267\u0268\3\2\2\2\u0268\u026a"+
		"\3\2\2\2\u0269\u026b\5\u0092J\2\u026a\u0269\3\2\2\2\u026a\u026b\3\2\2"+
		"\2\u026b\u026c\3\2\2\2\u026c\u026d\7V\2\2\u026d\u026e\bH\1\2\u026e\u008f"+
		"\3\2\2\2\u026f\u0270\5\u00a4S\2\u0270\u0091\3\2\2\2\u0271\u0272\7\36\2"+
		"\2\u0272\u0277\5\u0094K\2\u0273\u0274\7\34\2\2\u0274\u0276\5\u0094K\2"+
		"\u0275\u0273\3\2\2\2\u0276\u0279\3\2\2\2\u0277\u0275\3\2\2\2\u0277\u0278"+
		"\3\2\2\2\u0278\u0093\3\2\2\2\u0279\u0277\3\2\2\2\u027a\u027c\7J\2\2\u027b"+
		"\u027a\3\2\2\2\u027b\u027c\3\2\2\2\u027c\u027e\3\2\2\2\u027d\u027f\5\60"+
		"\31\2\u027e\u027d\3\2\2\2\u027e\u027f\3\2\2\2\u027f\u0280\3\2\2\2\u0280"+
		"\u0281\5\u00a4S\2\u0281\u0095\3\2\2\2\u0282\u0284\7I\2\2\u0283\u0282\3"+
		"\2\2\2\u0284\u0287\3\2\2\2\u0285\u0283\3\2\2\2\u0285\u0286\3\2\2\2\u0286"+
		"\u0289\3\2\2\2\u0287\u0285\3\2\2\2\u0288\u028a\t\32\2\2\u0289\u0288\3"+
		"\2\2\2\u0289\u028a\3\2\2\2\u028a\u028b\3\2\2\2\u028b\u0290\5\u0098M\2"+
		"\u028c\u028d\7\6\2\2\u028d\u028e\5:\36\2\u028e\u028f\7\62\2\2\u028f\u0291"+
		"\3\2\2\2\u0290\u028c\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u029c\3\2\2\2\u0292"+
		"\u0293\7\21\2\2\u0293\u0298\5\u0098M\2\u0294\u0295\7\6\2\2\u0295\u0296"+
		"\5:\36\2\u0296\u0297\7\62\2\2\u0297\u0299\3\2\2\2\u0298\u0294\3\2\2\2"+
		"\u0298\u0299\3\2\2\2\u0299\u029b\3\2\2\2\u029a\u0292\3\2\2\2\u029b\u029e"+
		"\3\2\2\2\u029c\u029a\3\2\2\2\u029c\u029d\3\2\2\2\u029d\u02a2\3\2\2\2\u029e"+
		"\u029c\3\2\2\2\u029f\u02a2\7F\2\2\u02a0\u02a2\7G\2\2\u02a1\u0285\3\2\2"+
		"\2\u02a1\u029f\3\2\2\2\u02a1\u02a0\3\2\2\2\u02a2\u0097\3\2\2\2\u02a3\u02a9"+
		"\7U\2\2\u02a4\u02a9\7E\2\2\u02a5\u02a9\7H\2\2\u02a6\u02a7\7H\2\2\u02a7"+
		"\u02a9\7H\2\2\u02a8\u02a3\3\2\2\2\u02a8\u02a4\3\2\2\2\u02a8\u02a5\3\2"+
		"\2\2\u02a8\u02a6\3\2\2\2\u02a9\u0099\3\2\2\2\u02aa\u02ac\t\33\2\2\u02ab"+
		"\u02aa\3\2\2\2\u02ab\u02ac\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02ae\5\u0096"+
		"L\2\u02ae\u009b\3\2\2\2\u02af\u02b2\5\u00a4S\2\u02b0\u02b2\5\60\31\2\u02b1"+
		"\u02af\3\2\2\2\u02b1\u02b0\3\2\2\2\u02b2\u009d\3\2\2\2\u02b3\u02b4\7\37"+
		"\2\2\u02b4\u02b5\7E\2\2\u02b5\u02c3\7\16\2\2\u02b6\u02bf\7\37\2\2\u02b7"+
		"\u02bc\5\u00a0Q\2\u02b8\u02b9\7\34\2\2\u02b9\u02bb\5\u00a0Q\2\u02ba\u02b8"+
		"\3\2\2\2\u02bb\u02be\3\2\2\2\u02bc\u02ba\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bd"+
		"\u02c0\3\2\2\2\u02be\u02bc\3\2\2\2\u02bf\u02b7\3\2\2\2\u02bf\u02c0\3\2"+
		"\2\2\u02c0\u02c1\3\2\2\2\u02c1\u02c3\7\16\2\2\u02c2\u02b3\3\2\2\2\u02c2"+
		"\u02b6\3\2\2\2\u02c3\u009f\3\2\2\2\u02c4\u02c5\5\u009aN\2\u02c5\u02c6"+
		"\5\u00a2R\2\u02c6\u00a1\3\2\2\2\u02c7\u02c9\5\u00a8U\2\u02c8\u02c7\3\2"+
		"\2\2\u02c8\u02c9\3\2\2\2\u02c9\u02d1\3\2\2\2\u02ca\u02cb\7\37\2\2\u02cb"+
		"\u02cc\5\u00a2R\2\u02cc\u02cd\7\16\2\2\u02cd\u02d2\3\2\2\2\u02ce\u02d0"+
		"\5\u009cO\2\u02cf\u02ce\3\2\2\2\u02cf\u02d0\3\2\2\2\u02d0\u02d2\3\2\2"+
		"\2\u02d1\u02ca\3\2\2\2\u02d1\u02cf\3\2\2\2\u02d2\u02d4\3\2\2\2\u02d3\u02d5"+
		"\5\u0082B\2\u02d4\u02d3\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5\u00a3\3\2\2"+
		"\2\u02d6\u02db\7U\2\2\u02d7\u02d8\7\21\2\2\u02d8\u02da\7U\2\2\u02d9\u02d7"+
		"\3\2\2\2\u02da\u02dd\3\2\2\2\u02db\u02d9\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc"+
		"\u00a5\3\2\2\2\u02dd\u02db\3\2\2\2\u02de\u02df\t\34\2\2\u02df\u00a7\3"+
		"\2\2\2\u02e0\u02e2\5.\30\2\u02e1\u02e0\3\2\2\2\u02e2\u02e3\3\2\2\2\u02e3"+
		"\u02e1\3\2\2\2\u02e3\u02e4\3\2\2\2\u02e4\u00a9\3\2\2\2O\u00b0\u00b2\u00bd"+
		"\u00e2\u00ec\u00f7\u00fa\u00ff\u0107\u010d\u0111\u0114\u012c\u0156\u016a"+
		"\u016c\u0187\u018d\u0195\u019a\u019f\u01a4\u01a9\u01ae\u01b4\u01ba\u01bf"+
		"\u01c4\u01c9\u01d1\u01d7\u01e1\u01e9\u01ee\u01f4\u01fb\u0204\u0207\u0215"+
		"\u0219\u0221\u0224\u0228\u022c\u0231\u0235\u0239\u023c\u023f\u0245\u024a"+
		"\u0251\u025b\u0262\u0267\u026a\u0277\u027b\u027e\u0285\u0289\u0290\u0298"+
		"\u029c\u02a1\u02a8\u02ab\u02b1\u02bc\u02bf\u02c2\u02c8\u02cf\u02d1\u02d4"+
		"\u02db\u02e3";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}
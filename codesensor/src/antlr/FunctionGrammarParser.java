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
		T__58=1, T__57=2, T__56=3, T__55=4, T__54=5, T__53=6, T__52=7, T__51=8, 
		T__50=9, T__49=10, T__48=11, T__47=12, T__46=13, T__45=14, T__44=15, T__43=16, 
		T__42=17, T__41=18, T__40=19, T__39=20, T__38=21, T__37=22, T__36=23, 
		T__35=24, T__34=25, T__33=26, T__32=27, T__31=28, T__30=29, T__29=30, 
		T__28=31, T__27=32, T__26=33, T__25=34, T__24=35, T__23=36, T__22=37, 
		T__21=38, T__20=39, T__19=40, T__18=41, T__17=42, T__16=43, T__15=44, 
		T__14=45, T__13=46, T__12=47, T__11=48, T__10=49, T__9=50, T__8=51, T__7=52, 
		T__6=53, T__5=54, T__4=55, T__3=56, T__2=57, T__1=58, T__0=59, IF=60, 
		ELSE=61, FOR=62, WHILE=63, BREAK=64, CASE=65, CONTINUE=66, SWITCH=67, 
		GOTO=68, RETURN=69, TYPEDEF=70, VOID=71, UNSIGNED=72, SIGNED=73, LONG=74, 
		CV_QUALIFIER=75, VIRTUAL=76, TRY=77, CATCH=78, THROW=79, USING=80, NAMESPACE=81, 
		AUTO=82, REGISTER=83, OPERATOR=84, TEMPLATE=85, ALPHA_NUMERIC=86, OPENING_CURLY=87, 
		CLOSING_CURLY=88, PRE_IF=89, PRE_ELSE=90, PRE_ENDIF=91, HEX_LITERAL=92, 
		DECIMAL_LITERAL=93, OCTAL_LITERAL=94, FLOATING_POINT_LITERAL=95, CHAR=96, 
		STRING=97, COMMENT=98, WHITESPACE=99, CPPCOMMENT=100, OTHER=101;
	public static final String[] tokenNames = {
		"<INVALID>", "'&'", "'['", "'*'", "'<'", "'--'", "'!='", "'<='", "'<<'", 
		"'do'", "'%'", "'->'", "'union'", "'*='", "')'", "'explicit'", "'inline'", 
		"'::'", "'='", "'|='", "'new'", "'class'", "'|'", "'!'", "'enum'", "']'", 
		"'<<='", "'-='", "'->*'", "'public'", "','", "'-'", "'('", "':'", "'&='", 
		"'private'", "'?'", "'>>='", "'+='", "'^='", "'friend'", "'struct'", "'static'", 
		"'++'", "'>>'", "'^'", "'delete'", "'.'", "'+'", "'protected'", "';'", 
		"'&&'", "'||'", "'>'", "'%='", "'/='", "'/'", "'=='", "'~'", "'>='", "'if'", 
		"'else'", "'for'", "'while'", "'break'", "'case'", "'continue'", "'switch'", 
		"'goto'", "'return'", "'typedef'", "'void'", "'unsigned'", "'signed'", 
		"'long'", "CV_QUALIFIER", "'virtual'", "'try'", "'catch'", "'throw'", 
		"'using'", "'namespace'", "'auto'", "'register'", "'operator'", "'template'", 
		"ALPHA_NUMERIC", "'{'", "'}'", "PRE_IF", "PRE_ELSE", "PRE_ENDIF", "HEX_LITERAL", 
		"DECIMAL_LITERAL", "OCTAL_LITERAL", "FLOATING_POINT_LITERAL", "CHAR", 
		"STRING", "COMMENT", "WHITESPACE", "CPPCOMMENT", "OTHER"
	};
	public static final int
		RULE_statements = 0, RULE_statement = 1, RULE_statement_water = 2, RULE_pre_opener = 3, 
		RULE_pre_else = 4, RULE_pre_closer = 5, RULE_opening_curly = 6, RULE_closing_curly = 7, 
		RULE_non_expr_statement = 8, RULE_block_starter = 9, RULE_non_block_starter = 10, 
		RULE_selection_statement = 11, RULE_if_statement = 12, RULE_else_statement = 13, 
		RULE_switch_statement = 14, RULE_iteration_statement = 15, RULE_for_statement = 16, 
		RULE_while_statement = 17, RULE_do_statement = 18, RULE_do_statement1 = 19, 
		RULE_for_init_statement = 20, RULE_jump_statement = 21, RULE_break_or_continue = 22, 
		RULE_return_statement = 23, RULE_goto_statement = 24, RULE_try_block = 25, 
		RULE_catch_block = 26, RULE_param_type2 = 27, RULE_param_decl_specifiers2 = 28, 
		RULE_type_name2 = 29, RULE_label = 30, RULE_expr_statement = 31, RULE_condition = 32, 
		RULE_unary_operator = 33, RULE_relational_operator = 34, RULE_constant = 35, 
		RULE_function_decl_specifiers = 36, RULE_class_key = 37, RULE_ptr_operator = 38, 
		RULE_access_specifier = 39, RULE_operator_function_id = 40, RULE_operator = 41, 
		RULE_assignment_operator = 42, RULE_equality_operator = 43, RULE_template_decl_start = 44, 
		RULE_template_param_list = 45, RULE_no_brackets = 46, RULE_no_brackets_curlies_or_squares = 47, 
		RULE_no_brackets_or_semicolon = 48, RULE_no_angle_brackets_or_brackets = 49, 
		RULE_no_curlies = 50, RULE_no_squares = 51, RULE_no_squares_or_semicolon = 52, 
		RULE_no_comma_or_semicolon = 53, RULE_assign_water = 54, RULE_assign_water_l2 = 55, 
		RULE_water = 56, RULE_expr = 57, RULE_assign_expr = 58, RULE_conditional_expression = 59, 
		RULE_or_expression = 60, RULE_and_expression = 61, RULE_inclusive_or_expression = 62, 
		RULE_exclusive_or_expression = 63, RULE_bit_and_expression = 64, RULE_equality_expression = 65, 
		RULE_relational_expression = 66, RULE_shift_expression = 67, RULE_additive_expression = 68, 
		RULE_multiplicative_expression = 69, RULE_cast_expression = 70, RULE_unary_expression = 71, 
		RULE_postfix_expression = 72, RULE_field = 73, RULE_function_call_tail = 74, 
		RULE_call_template_list = 75, RULE_function_argument_list = 76, RULE_function_argument = 77, 
		RULE_postfix = 78, RULE_primary_expression = 79, RULE_simple_decl = 80, 
		RULE_var_decl = 81, RULE_init_declarator_list = 82, RULE_init_declarator = 83, 
		RULE_assign_expr_w_ = 84, RULE_assign_expr_w__l2 = 85, RULE_constant_expr_w_ = 86, 
		RULE_initializer = 87, RULE_initializer_list = 88, RULE_class_def = 89, 
		RULE_class_name = 90, RULE_base_classes = 91, RULE_base_class = 92, RULE_type_name = 93, 
		RULE_type_suffix = 94, RULE_base_type = 95, RULE_param_decl_specifiers = 96, 
		RULE_parameter_name = 97, RULE_param_type_list = 98, RULE_param_type = 99, 
		RULE_param_type_id = 100, RULE_identifier = 101, RULE_number = 102, RULE_ptrs = 103;
	public static final String[] ruleNames = {
		"statements", "statement", "statement_water", "pre_opener", "pre_else", 
		"pre_closer", "opening_curly", "closing_curly", "non_expr_statement", 
		"block_starter", "non_block_starter", "selection_statement", "if_statement", 
		"else_statement", "switch_statement", "iteration_statement", "for_statement", 
		"while_statement", "do_statement", "do_statement1", "for_init_statement", 
		"jump_statement", "break_or_continue", "return_statement", "goto_statement", 
		"try_block", "catch_block", "param_type2", "param_decl_specifiers2", "type_name2", 
		"label", "expr_statement", "condition", "unary_operator", "relational_operator", 
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
		"function_argument", "postfix", "primary_expression", "simple_decl", "var_decl", 
		"init_declarator_list", "init_declarator", "assign_expr_w_", "assign_expr_w__l2", 
		"constant_expr_w_", "initializer", "initializer_list", "class_def", "class_name", 
		"base_classes", "base_class", "type_name", "type_suffix", "base_type", 
		"param_decl_specifiers", "parameter_name", "param_type_list", "param_type", 
		"param_type_id", "identifier", "number", "ptrs"
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
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)) | (1L << (5 - 64)) | (1L << (9 - 64)) | (1L << (12 - 64)) | (1L << (21 - 64)) | (1L << (23 - 64)) | (1L << (24 - 64)) | (1L << (29 - 64)) | (1L << (31 - 64)) | (1L << (32 - 64)) | (1L << (35 - 64)) | (1L << (41 - 64)) | (1L << (43 - 64)) | (1L << (48 - 64)) | (1L << (49 - 64)) | (1L << (58 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)))) != 0)) {
				{
				setState(214);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(208); pre_opener();
					}
					break;

				case 2:
					{
					setState(209); pre_closer();
					}
					break;

				case 3:
					{
					setState(210); pre_else();
					preProcSkipToEnd(); 
					}
					break;

				case 4:
					{
					setState(213); statement();
					}
					break;
				}
				}
				setState(218);
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
		public Statement_waterContext statement_water() {
			return getRuleContext(Statement_waterContext.class,0);
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
		public Non_expr_statementContext non_expr_statement() {
			return getRuleContext(Non_expr_statementContext.class,0);
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
			setState(224);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(219); opening_curly();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(220); closing_curly();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(221); non_expr_statement();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(222); expr_statement();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(223); statement_water();
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

	public static class Statement_waterContext extends ParserRuleContext {
		public Statement_waterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_water; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterStatement_water(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitStatement_water(this);
		}
	}

	public final Statement_waterContext statement_water() throws RecognitionException {
		Statement_waterContext _localctx = new Statement_waterContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement_water);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
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

	public static class Pre_openerContext extends ParserRuleContext {
		public TerminalNode PRE_IF() { return getToken(FunctionGrammarParser.PRE_IF, 0); }
		public Pre_openerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pre_opener; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterPre_opener(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitPre_opener(this);
		}
	}

	public final Pre_openerContext pre_opener() throws RecognitionException {
		Pre_openerContext _localctx = new Pre_openerContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pre_opener);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228); match(PRE_IF);
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
		public TerminalNode PRE_ELSE() { return getToken(FunctionGrammarParser.PRE_ELSE, 0); }
		public Pre_elseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pre_else; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterPre_else(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitPre_else(this);
		}
	}

	public final Pre_elseContext pre_else() throws RecognitionException {
		Pre_elseContext _localctx = new Pre_elseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_pre_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230); match(PRE_ELSE);
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
		public TerminalNode PRE_ENDIF() { return getToken(FunctionGrammarParser.PRE_ENDIF, 0); }
		public Pre_closerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pre_closer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterPre_closer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitPre_closer(this);
		}
	}

	public final Pre_closerContext pre_closer() throws RecognitionException {
		Pre_closerContext _localctx = new Pre_closerContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_pre_closer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232); match(PRE_ENDIF);
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
		enterRule(_localctx, 12, RULE_opening_curly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234); match(OPENING_CURLY);
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
		enterRule(_localctx, 14, RULE_closing_curly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236); match(CLOSING_CURLY);
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

	public static class Non_expr_statementContext extends ParserRuleContext {
		public Non_block_starterContext non_block_starter() {
			return getRuleContext(Non_block_starterContext.class,0);
		}
		public Block_starterContext block_starter() {
			return getRuleContext(Block_starterContext.class,0);
		}
		public Non_expr_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_expr_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterNon_expr_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitNon_expr_statement(this);
		}
	}

	public final Non_expr_statementContext non_expr_statement() throws RecognitionException {
		Non_expr_statementContext _localctx = new Non_expr_statementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_non_expr_statement);
		try {
			setState(240);
			switch (_input.LA(1)) {
			case 9:
			case IF:
			case ELSE:
			case FOR:
			case WHILE:
			case SWITCH:
			case TRY:
			case CATCH:
				enterOuterAlt(_localctx, 1);
				{
				setState(238); block_starter();
				}
				break;
			case 12:
			case 21:
			case 24:
			case 29:
			case 35:
			case 41:
			case 49:
			case BREAK:
			case CASE:
			case CONTINUE:
			case GOTO:
			case RETURN:
			case TYPEDEF:
			case VOID:
			case UNSIGNED:
			case SIGNED:
			case LONG:
			case CV_QUALIFIER:
			case TEMPLATE:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(239); non_block_starter();
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
		enterRule(_localctx, 18, RULE_block_starter);
		try {
			setState(246);
			switch (_input.LA(1)) {
			case IF:
			case ELSE:
			case SWITCH:
				enterOuterAlt(_localctx, 1);
				{
				setState(242); selection_statement();
				}
				break;
			case 9:
			case FOR:
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(243); iteration_statement();
				}
				break;
			case TRY:
				enterOuterAlt(_localctx, 3);
				{
				setState(244); try_block();
				}
				break;
			case CATCH:
				enterOuterAlt(_localctx, 4);
				{
				setState(245); catch_block();
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

	public static class Non_block_starterContext extends ParserRuleContext {
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public Jump_statementContext jump_statement() {
			return getRuleContext(Jump_statementContext.class,0);
		}
		public Simple_declContext simple_decl() {
			return getRuleContext(Simple_declContext.class,0);
		}
		public Non_block_starterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_block_starter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterNon_block_starter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitNon_block_starter(this);
		}
	}

	public final Non_block_starterContext non_block_starter() throws RecognitionException {
		Non_block_starterContext _localctx = new Non_block_starterContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_non_block_starter);
		try {
			setState(251);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(248); jump_statement();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(249); simple_decl();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(250); label();
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
		enterRule(_localctx, 22, RULE_selection_statement);
		try {
			setState(256);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(253); if_statement();
				}
				break;
			case ELSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(254); else_statement();
				}
				break;
			case SWITCH:
				enterOuterAlt(_localctx, 3);
				{
				setState(255); switch_statement();
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
		enterRule(_localctx, 24, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258); match(IF);
			setState(259); match(32);
			setState(260); condition();
			setState(261); match(14);
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
		enterRule(_localctx, 26, RULE_else_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263); match(ELSE);
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
		enterRule(_localctx, 28, RULE_switch_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265); match(SWITCH);
			setState(266); match(32);
			setState(267); condition();
			setState(268); match(14);
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
		enterRule(_localctx, 30, RULE_iteration_statement);
		try {
			setState(273);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(270); for_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 2);
				{
				setState(271); do_statement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(272); while_statement();
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
		enterRule(_localctx, 32, RULE_for_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275); match(FOR);
			setState(276); match(32);
			setState(277); for_init_statement();
			setState(278); condition();
			setState(279); match(50);
			setState(281);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 23) | (1L << 31) | (1L << 32) | (1L << 43) | (1L << 48) | (1L << 58))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (ALPHA_NUMERIC - 86)) | (1L << (HEX_LITERAL - 86)) | (1L << (DECIMAL_LITERAL - 86)) | (1L << (OCTAL_LITERAL - 86)) | (1L << (FLOATING_POINT_LITERAL - 86)) | (1L << (CHAR - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				setState(280); expr();
				}
			}

			setState(283); match(14);
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
		enterRule(_localctx, 34, RULE_while_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285); match(WHILE);
			setState(286); match(32);
			setState(287); condition();
			setState(288); match(14);
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
		enterRule(_localctx, 36, RULE_do_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290); match(9);
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
		enterRule(_localctx, 38, RULE_do_statement1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292); match(9);
			setState(293); statement();
			setState(294); match(WHILE);
			setState(295); match(32);
			setState(296); expr();
			setState(297); match(14);
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
		enterRule(_localctx, 40, RULE_for_init_statement);
		int _la;
		try {
			setState(304);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(299); simple_decl();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(301);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 23) | (1L << 31) | (1L << 32) | (1L << 43) | (1L << 48) | (1L << 58))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (ALPHA_NUMERIC - 86)) | (1L << (HEX_LITERAL - 86)) | (1L << (DECIMAL_LITERAL - 86)) | (1L << (OCTAL_LITERAL - 86)) | (1L << (FLOATING_POINT_LITERAL - 86)) | (1L << (CHAR - 86)) | (1L << (STRING - 86)))) != 0)) {
					{
					setState(300); expr();
					}
				}

				setState(303); match(50);
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
		enterRule(_localctx, 42, RULE_jump_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			switch (_input.LA(1)) {
			case BREAK:
			case CONTINUE:
				{
				setState(306); break_or_continue();
				}
				break;
			case RETURN:
				{
				setState(307); return_statement();
				}
				break;
			case GOTO:
				{
				setState(308); goto_statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(311); match(50);
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
		enterRule(_localctx, 44, RULE_break_or_continue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
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
		enterRule(_localctx, 46, RULE_return_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315); match(RETURN);
			setState(317);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 23) | (1L << 31) | (1L << 32) | (1L << 43) | (1L << 48) | (1L << 58))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (ALPHA_NUMERIC - 86)) | (1L << (HEX_LITERAL - 86)) | (1L << (DECIMAL_LITERAL - 86)) | (1L << (OCTAL_LITERAL - 86)) | (1L << (FLOATING_POINT_LITERAL - 86)) | (1L << (CHAR - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				setState(316); expr();
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
		enterRule(_localctx, 48, RULE_goto_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319); match(GOTO);
			setState(320); identifier();
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
		enterRule(_localctx, 50, RULE_try_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322); match(TRY);
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
		public Param_type2Context param_type2() {
			return getRuleContext(Param_type2Context.class,0);
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
		enterRule(_localctx, 52, RULE_catch_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324); match(CATCH);
			setState(325); match(32);
			setState(326); param_type2();
			setState(327); match(14);
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

	public static class Param_type2Context extends ParserRuleContext {
		public Param_type_idContext param_type_id() {
			return getRuleContext(Param_type_idContext.class,0);
		}
		public Param_decl_specifiers2Context param_decl_specifiers2() {
			return getRuleContext(Param_decl_specifiers2Context.class,0);
		}
		public Param_type2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_type2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterParam_type2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitParam_type2(this);
		}
	}

	public final Param_type2Context param_type2() throws RecognitionException {
		Param_type2Context _localctx = new Param_type2Context(_ctx, getState());
		enterRule(_localctx, 54, RULE_param_type2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329); param_decl_specifiers2();
			setState(330); param_type_id();
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

	public static class Param_decl_specifiers2Context extends ParserRuleContext {
		public TerminalNode REGISTER() { return getToken(FunctionGrammarParser.REGISTER, 0); }
		public Type_name2Context type_name2() {
			return getRuleContext(Type_name2Context.class,0);
		}
		public TerminalNode AUTO() { return getToken(FunctionGrammarParser.AUTO, 0); }
		public Param_decl_specifiers2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl_specifiers2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterParam_decl_specifiers2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitParam_decl_specifiers2(this);
		}
	}

	public final Param_decl_specifiers2Context param_decl_specifiers2() throws RecognitionException {
		Param_decl_specifiers2Context _localctx = new Param_decl_specifiers2Context(_ctx, getState());
		enterRule(_localctx, 56, RULE_param_decl_specifiers2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			_la = _input.LA(1);
			if (_la==AUTO || _la==REGISTER) {
				{
				setState(332);
				_la = _input.LA(1);
				if ( !(_la==AUTO || _la==REGISTER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(335); type_name2();
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

	public static class Type_name2Context extends ParserRuleContext {
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
		public Type_name2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterType_name2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitType_name2(this);
		}
	}

	public final Type_name2Context type_name2() throws RecognitionException {
		Type_name2Context _localctx = new Type_name2Context(_ctx, getState());
		enterRule(_localctx, 58, RULE_type_name2);
		int _la;
		try {
			setState(369);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(340);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CV_QUALIFIER) {
					{
					{
					setState(337); match(CV_QUALIFIER);
					}
					}
					setState(342);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(346);
				switch (_input.LA(1)) {
				case 12:
				case 21:
				case 24:
				case 41:
					{
					setState(343); class_key();
					}
					break;
				case UNSIGNED:
					{
					setState(344); match(UNSIGNED);
					}
					break;
				case SIGNED:
					{
					setState(345); match(SIGNED);
					}
					break;
				case VOID:
				case LONG:
				case ALPHA_NUMERIC:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(348); base_type();
				setState(353);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(349); match(4);
					setState(350); template_param_list();
					setState(351); match(53);
					}
				}

				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==17) {
					{
					{
					setState(355); match(17);
					setState(356); base_type();
					setState(361);
					_la = _input.LA(1);
					if (_la==4) {
						{
						setState(357); match(4);
						setState(358); template_param_list();
						setState(359); match(53);
						}
					}

					}
					}
					setState(367);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(368);
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
		enterRule(_localctx, 60, RULE_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			switch (_input.LA(1)) {
			case CASE:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
				{
				{
				setState(372);
				_la = _input.LA(1);
				if (_la==CASE) {
					{
					setState(371); match(CASE);
					}
				}

				setState(376);
				switch (_input.LA(1)) {
				case ALPHA_NUMERIC:
					{
					setState(374); identifier();
					}
					break;
				case HEX_LITERAL:
				case DECIMAL_LITERAL:
				case OCTAL_LITERAL:
					{
					setState(375); number();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				break;
			case 29:
			case 35:
			case 49:
				{
				setState(378); access_specifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(381); match(33);
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
		enterRule(_localctx, 62, RULE_expr_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383); expr();
			setState(384); match(50);
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
		enterRule(_localctx, 64, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386); expr();
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
		enterRule(_localctx, 66, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 23) | (1L << 31) | (1L << 48) | (1L << 58))) != 0)) ) {
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
		enterRule(_localctx, 68, RULE_relational_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 53) | (1L << 59))) != 0)) ) {
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
		enterRule(_localctx, 70, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
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
		enterRule(_localctx, 72, RULE_function_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			_la = _input.LA(1);
			if ( !(((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (15 - 15)) | (1L << (16 - 15)) | (1L << (40 - 15)) | (1L << (42 - 15)) | (1L << (VIRTUAL - 15)))) != 0)) ) {
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
		enterRule(_localctx, 74, RULE_class_key);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 21) | (1L << 24) | (1L << 41))) != 0)) ) {
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
		enterRule(_localctx, 76, RULE_ptr_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
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
		enterRule(_localctx, 78, RULE_access_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 29) | (1L << 35) | (1L << 49))) != 0)) ) {
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
		enterRule(_localctx, 80, RULE_operator_function_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402); match(OPERATOR);
			setState(403); operator();
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
		enterRule(_localctx, 82, RULE_operator);
		int _la;
		try {
			setState(450);
			switch (_input.LA(1)) {
			case 20:
			case 46:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(405);
				_la = _input.LA(1);
				if ( !(_la==20 || _la==46) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(408);
				_la = _input.LA(1);
				if (_la==2) {
					{
					setState(406); match(2);
					setState(407); match(25);
					}
				}

				}
				}
				break;
			case 48:
				enterOuterAlt(_localctx, 2);
				{
				setState(410); match(48);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 3);
				{
				setState(411); match(31);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 4);
				{
				setState(412); match(3);
				}
				break;
			case 56:
				enterOuterAlt(_localctx, 5);
				{
				setState(413); match(56);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 6);
				{
				setState(414); match(10);
				}
				break;
			case 45:
				enterOuterAlt(_localctx, 7);
				{
				setState(415); match(45);
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 8);
				{
				setState(416); match(1);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 9);
				{
				setState(417); match(22);
				}
				break;
			case 58:
				enterOuterAlt(_localctx, 10);
				{
				setState(418); match(58);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 11);
				{
				setState(419); match(23);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 12);
				{
				setState(420); match(18);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 13);
				{
				setState(421); match(4);
				}
				break;
			case 53:
				enterOuterAlt(_localctx, 14);
				{
				setState(422); match(53);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 15);
				{
				setState(423); match(38);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 16);
				{
				setState(424); match(27);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 17);
				{
				setState(425); match(13);
				}
				break;
			case 55:
				enterOuterAlt(_localctx, 18);
				{
				setState(426); match(55);
				}
				break;
			case 54:
				enterOuterAlt(_localctx, 19);
				{
				setState(427); match(54);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 20);
				{
				setState(428); match(39);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 21);
				{
				setState(429); match(34);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 22);
				{
				setState(430); match(19);
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 23);
				{
				setState(431); match(44);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 24);
				{
				setState(432); match(8);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 25);
				{
				setState(433); match(37);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(434); match(26);
				}
				break;
			case 57:
				enterOuterAlt(_localctx, 27);
				{
				setState(435); match(57);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 28);
				{
				setState(436); match(6);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 29);
				{
				setState(437); match(7);
				}
				break;
			case 59:
				enterOuterAlt(_localctx, 30);
				{
				setState(438); match(59);
				}
				break;
			case 51:
				enterOuterAlt(_localctx, 31);
				{
				setState(439); match(51);
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 32);
				{
				setState(440); match(52);
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 33);
				{
				setState(441); match(43);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 34);
				{
				setState(442); match(5);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 35);
				{
				setState(443); match(30);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 36);
				{
				setState(444); match(28);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 37);
				{
				setState(445); match(11);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 38);
				{
				setState(446); match(32);
				setState(447); match(14);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 39);
				{
				setState(448); match(2);
				setState(449); match(25);
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
		enterRule(_localctx, 84, RULE_assignment_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 18) | (1L << 19) | (1L << 26) | (1L << 27) | (1L << 34) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 54) | (1L << 55))) != 0)) ) {
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
		enterRule(_localctx, 86, RULE_equality_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			_la = _input.LA(1);
			if ( !(_la==6 || _la==57) ) {
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
		enterRule(_localctx, 88, RULE_template_decl_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456); match(TEMPLATE);
			setState(457); match(4);
			setState(458); template_param_list();
			setState(459); match(53);
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
		enterRule(_localctx, 90, RULE_template_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				setState(470);
				switch (_input.LA(1)) {
				case 4:
					{
					{
					setState(461); match(4);
					setState(462); template_param_list();
					setState(463); match(53);
					}
					}
					break;
				case 32:
					{
					{
					setState(465); match(32);
					setState(466); template_param_list();
					setState(467); match(14);
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
				case 13:
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
				case 31:
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
				case 52:
				case 54:
				case 55:
				case 56:
				case 57:
				case 58:
				case 59:
				case IF:
				case ELSE:
				case FOR:
				case WHILE:
				case BREAK:
				case CASE:
				case CONTINUE:
				case SWITCH:
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
					setState(469); no_angle_brackets_or_brackets();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(474);
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
		enterRule(_localctx, 92, RULE_no_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==14 || _la==32) ) {
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
		enterRule(_localctx, 94, RULE_no_brackets_curlies_or_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 14) | (1L << 25) | (1L << 32))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
		enterRule(_localctx, 96, RULE_no_brackets_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 14) | (1L << 32) | (1L << 50))) != 0)) ) {
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
		enterRule(_localctx, 98, RULE_no_angle_brackets_or_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 14) | (1L << 32) | (1L << 53))) != 0)) ) {
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
		enterRule(_localctx, 100, RULE_no_curlies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
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
		enterRule(_localctx, 102, RULE_no_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==2 || _la==25) ) {
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
		enterRule(_localctx, 104, RULE_no_squares_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 25) | (1L << 50))) != 0)) ) {
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
		enterRule(_localctx, 106, RULE_no_comma_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==30 || _la==50) ) {
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
		enterRule(_localctx, 108, RULE_assign_water);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 14) | (1L << 25) | (1L << 30) | (1L << 32) | (1L << 50))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
		enterRule(_localctx, 110, RULE_assign_water_l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 14) | (1L << 25) | (1L << 32))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
		enterRule(_localctx, 112, RULE_water);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
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
		enterRule(_localctx, 114, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497); assign_expr();
			setState(500);
			_la = _input.LA(1);
			if (_la==30) {
				{
				setState(498); match(30);
				setState(499); assign_expr();
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
		enterRule(_localctx, 116, RULE_assign_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(502); conditional_expression();
			setState(506);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 18) | (1L << 19) | (1L << 26) | (1L << 27) | (1L << 34) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 54) | (1L << 55))) != 0)) {
				{
				setState(503); assignment_operator();
				setState(504); assign_expr();
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
		enterRule(_localctx, 118, RULE_conditional_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508); or_expression();
			setState(514);
			_la = _input.LA(1);
			if (_la==36) {
				{
				setState(509); match(36);
				setState(510); expr();
				setState(511); match(33);
				setState(512); conditional_expression();
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
		enterRule(_localctx, 120, RULE_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516); and_expression();
			setState(519);
			_la = _input.LA(1);
			if (_la==52) {
				{
				setState(517); match(52);
				setState(518); or_expression();
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
		enterRule(_localctx, 122, RULE_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521); inclusive_or_expression();
			setState(524);
			_la = _input.LA(1);
			if (_la==51) {
				{
				setState(522); match(51);
				setState(523); and_expression();
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
		enterRule(_localctx, 124, RULE_inclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526); exclusive_or_expression();
			setState(529);
			_la = _input.LA(1);
			if (_la==22) {
				{
				setState(527); match(22);
				setState(528); inclusive_or_expression();
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
		enterRule(_localctx, 126, RULE_exclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531); bit_and_expression();
			setState(534);
			_la = _input.LA(1);
			if (_la==45) {
				{
				setState(532); match(45);
				setState(533); exclusive_or_expression();
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
		enterRule(_localctx, 128, RULE_bit_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536); equality_expression();
			setState(539);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(537); match(1);
				setState(538); bit_and_expression();
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
		enterRule(_localctx, 130, RULE_equality_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541); relational_expression();
			setState(545);
			_la = _input.LA(1);
			if (_la==6 || _la==57) {
				{
				setState(542); equality_operator();
				setState(543); equality_expression();
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
		enterRule(_localctx, 132, RULE_relational_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(547); shift_expression();
			setState(551);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 53) | (1L << 59))) != 0)) {
				{
				setState(548); relational_operator();
				setState(549); relational_expression();
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
		enterRule(_localctx, 134, RULE_shift_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553); additive_expression();
			setState(556);
			_la = _input.LA(1);
			if (_la==8 || _la==44) {
				{
				setState(554);
				_la = _input.LA(1);
				if ( !(_la==8 || _la==44) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(555); shift_expression();
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
		enterRule(_localctx, 136, RULE_additive_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(558); multiplicative_expression();
			setState(561);
			_la = _input.LA(1);
			if (_la==31 || _la==48) {
				{
				setState(559);
				_la = _input.LA(1);
				if ( !(_la==31 || _la==48) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(560); additive_expression();
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
		enterRule(_localctx, 138, RULE_multiplicative_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(563); cast_expression();
			setState(566);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 10) | (1L << 56))) != 0)) {
				{
				setState(564);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 10) | (1L << 56))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(565); cast_expression();
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
		enterRule(_localctx, 140, RULE_cast_expression);
		int _la;
		try {
			setState(580);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(568); match(32);
				setState(569); type_name();
				setState(573);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1 || _la==3) {
					{
					{
					setState(570); ptr_operator();
					}
					}
					setState(575);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(576); match(14);
				setState(577); cast_expression();
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(579); unary_expression();
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
		enterRule(_localctx, 142, RULE_unary_expression);
		int _la;
		try {
			setState(594);
			switch (_input.LA(1)) {
			case 32:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case CHAR:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(582); postfix_expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 2);
				{
				setState(583); match(5);
				setState(584); unary_expression();
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 3);
				{
				setState(585); match(43);
				setState(586); unary_expression();
				}
				break;
			case 1:
			case 3:
			case 23:
			case 31:
			case 48:
			case 58:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(588); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(587); unary_operator();
					}
					}
					setState(590); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 23) | (1L << 31) | (1L << 48) | (1L << 58))) != 0) );
				setState(592); postfix_expression();
				}
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
		enterRule(_localctx, 144, RULE_postfix_expression);
		try {
			setState(600);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(596); field();
				setState(597); function_call_tail();
				}
				break;

			case 2:
				_localctx = new FieldOnlyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(599); field();
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
		enterRule(_localctx, 146, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(602); primary_expression();
			setState(606);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 5) | (1L << 11) | (1L << 43) | (1L << 47))) != 0)) {
				{
				{
				setState(603); postfix();
				}
				}
				setState(608);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
		enterRule(_localctx, 148, RULE_function_call_tail);
		try {
			setState(613);
			switch (_input.LA(1)) {
			case 4:
				enterOuterAlt(_localctx, 1);
				{
				setState(609); call_template_list();
				setState(610); function_argument_list();
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 2);
				{
				setState(612); function_argument_list();
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
		enterRule(_localctx, 150, RULE_call_template_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(615); match(4);
			setState(616); template_param_list();
			setState(617); match(53);
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
		enterRule(_localctx, 152, RULE_function_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(619); match(32);
			setState(628);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 23) | (1L << 31) | (1L << 32) | (1L << 43) | (1L << 48) | (1L << 58))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (ALPHA_NUMERIC - 86)) | (1L << (HEX_LITERAL - 86)) | (1L << (DECIMAL_LITERAL - 86)) | (1L << (OCTAL_LITERAL - 86)) | (1L << (FLOATING_POINT_LITERAL - 86)) | (1L << (CHAR - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				setState(620); function_argument();
				setState(625);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==30) {
					{
					{
					setState(621); match(30);
					setState(622); function_argument();
					}
					}
					setState(627);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(630); match(14);
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
		enterRule(_localctx, 154, RULE_function_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(632); assign_expr();
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
		enterRule(_localctx, 156, RULE_postfix);
		try {
			setState(646);
			switch (_input.LA(1)) {
			case 2:
			case 11:
			case 47:
				enterOuterAlt(_localctx, 1);
				{
				setState(642);
				switch (_input.LA(1)) {
				case 47:
					{
					setState(634); match(47);
					setState(635); identifier();
					}
					break;
				case 11:
					{
					setState(636); match(11);
					setState(637); identifier();
					}
					break;
				case 2:
					{
					setState(638); match(2);
					setState(639); expr();
					setState(640); match(25);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 2);
				{
				setState(644); match(43);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 3);
				{
				setState(645); match(5);
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
		enterRule(_localctx, 158, RULE_primary_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(654);
			switch (_input.LA(1)) {
			case 32:
				{
				setState(648); match(32);
				setState(649); expr();
				setState(650); match(14);
				}
				break;
			case ALPHA_NUMERIC:
				{
				setState(652); identifier();
				}
				break;
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case CHAR:
			case STRING:
				{
				setState(653); constant();
				}
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
		enterRule(_localctx, 160, RULE_simple_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(657);
			_la = _input.LA(1);
			if (_la==TYPEDEF) {
				{
				setState(656); match(TYPEDEF);
				}
			}

			setState(660);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(659); template_decl_start();
				}
			}

			setState(662); var_decl();
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
		enterRule(_localctx, 162, RULE_var_decl);
		try {
			setState(671);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				_localctx = new DeclByTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(664); type_name();
				setState(665); init_declarator_list();
				}
				break;

			case 2:
				_localctx = new DeclByClassContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(667); class_def();
				setState(669);
				switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
				case 1:
					{
					setState(668); init_declarator_list();
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
		enterRule(_localctx, 164, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(673); init_declarator();
			setState(678);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==30) {
				{
				{
				setState(674); match(30);
				setState(675); init_declarator();
				}
				}
				setState(680);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(681); match(50);
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
		public Assign_expr_w_Context assign_expr_w_() {
			return getRuleContext(Assign_expr_w_Context.class,0);
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
		enterRule(_localctx, 166, RULE_init_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(684);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(683); ptrs();
				}
			}

			setState(686); identifier();
			setState(688);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(687); type_suffix();
				}
				break;
			}
			}
			setState(697);
			switch (_input.LA(1)) {
			case 32:
				{
				{
				setState(690); match(32);
				setState(692);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 23) | (1L << 31) | (1L << 32) | (1L << 43) | (1L << 48) | (1L << 58))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (ALPHA_NUMERIC - 86)) | (1L << (HEX_LITERAL - 86)) | (1L << (DECIMAL_LITERAL - 86)) | (1L << (OCTAL_LITERAL - 86)) | (1L << (FLOATING_POINT_LITERAL - 86)) | (1L << (CHAR - 86)) | (1L << (STRING - 86)))) != 0)) {
					{
					setState(691); expr();
					}
				}

				setState(694); match(14);
				}
				}
				break;
			case 18:
				{
				{
				setState(695); match(18);
				setState(696); assign_expr_w_();
				}
				}
				break;
			case 30:
			case 50:
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

	public static class Assign_expr_w_Context extends ParserRuleContext {
		public List<Assign_expr_w__l2Context> assign_expr_w__l2() {
			return getRuleContexts(Assign_expr_w__l2Context.class);
		}
		public Assign_waterContext assign_water(int i) {
			return getRuleContext(Assign_waterContext.class,i);
		}
		public Assign_expr_w__l2Context assign_expr_w__l2(int i) {
			return getRuleContext(Assign_expr_w__l2Context.class,i);
		}
		public List<Assign_waterContext> assign_water() {
			return getRuleContexts(Assign_waterContext.class);
		}
		public Assign_expr_w_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_expr_w_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterAssign_expr_w_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitAssign_expr_w_(this);
		}
	}

	public final Assign_expr_w_Context assign_expr_w_() throws RecognitionException {
		Assign_expr_w_Context _localctx = new Assign_expr_w_Context(_ctx, getState());
		enterRule(_localctx, 168, RULE_assign_expr_w_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(702);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 31) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(699); assign_water();
				}
				}
				setState(704);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(727);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2 || _la==32 || _la==OPENING_CURLY) {
				{
				{
				setState(717);
				switch (_input.LA(1)) {
				case OPENING_CURLY:
					{
					setState(705); match(OPENING_CURLY);
					setState(706); assign_expr_w__l2();
					setState(707); match(CLOSING_CURLY);
					}
					break;
				case 32:
					{
					setState(709); match(32);
					setState(710); assign_expr_w__l2();
					setState(711); match(14);
					}
					break;
				case 2:
					{
					setState(713); match(2);
					setState(714); assign_expr_w__l2();
					setState(715); match(25);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(722);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 31) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(719); assign_water();
					}
					}
					setState(724);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(729);
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

	public static class Assign_expr_w__l2Context extends ParserRuleContext {
		public List<Assign_expr_w__l2Context> assign_expr_w__l2() {
			return getRuleContexts(Assign_expr_w__l2Context.class);
		}
		public List<Assign_water_l2Context> assign_water_l2() {
			return getRuleContexts(Assign_water_l2Context.class);
		}
		public Assign_water_l2Context assign_water_l2(int i) {
			return getRuleContext(Assign_water_l2Context.class,i);
		}
		public Assign_expr_w__l2Context assign_expr_w__l2(int i) {
			return getRuleContext(Assign_expr_w__l2Context.class,i);
		}
		public Assign_expr_w__l2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_expr_w__l2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterAssign_expr_w__l2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitAssign_expr_w__l2(this);
		}
	}

	public final Assign_expr_w__l2Context assign_expr_w__l2() throws RecognitionException {
		Assign_expr_w__l2Context _localctx = new Assign_expr_w__l2Context(_ctx, getState());
		enterRule(_localctx, 170, RULE_assign_expr_w__l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(733);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(730); assign_water_l2();
				}
				}
				setState(735);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(758);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2 || _la==32 || _la==OPENING_CURLY) {
				{
				{
				setState(748);
				switch (_input.LA(1)) {
				case OPENING_CURLY:
					{
					setState(736); match(OPENING_CURLY);
					setState(737); assign_expr_w__l2();
					setState(738); match(CLOSING_CURLY);
					}
					break;
				case 32:
					{
					setState(740); match(32);
					setState(741); assign_expr_w__l2();
					setState(742); match(14);
					}
					break;
				case 2:
					{
					setState(744); match(2);
					setState(745); assign_expr_w__l2();
					setState(746); match(25);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(753);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(750); assign_water_l2();
					}
					}
					setState(755);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(760);
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

	public static class Constant_expr_w_Context extends ParserRuleContext {
		public Constant_expr_w_Context constant_expr_w_(int i) {
			return getRuleContext(Constant_expr_w_Context.class,i);
		}
		public List<No_squaresContext> no_squares() {
			return getRuleContexts(No_squaresContext.class);
		}
		public No_squaresContext no_squares(int i) {
			return getRuleContext(No_squaresContext.class,i);
		}
		public List<Constant_expr_w_Context> constant_expr_w_() {
			return getRuleContexts(Constant_expr_w_Context.class);
		}
		public Constant_expr_w_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant_expr_w_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterConstant_expr_w_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitConstant_expr_w_(this);
		}
	}

	public final Constant_expr_w_Context constant_expr_w_() throws RecognitionException {
		Constant_expr_w_Context _localctx = new Constant_expr_w_Context(_ctx, getState());
		enterRule(_localctx, 172, RULE_constant_expr_w_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(764);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(761); no_squares();
				}
				}
				setState(766);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(778);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2) {
				{
				{
				setState(767); match(2);
				setState(768); constant_expr_w_();
				setState(769); match(25);
				setState(773);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(770); no_squares();
					}
					}
					setState(775);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(780);
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
		enterRule(_localctx, 174, RULE_initializer);
		try {
			setState(786);
			switch (_input.LA(1)) {
			case 1:
			case 3:
			case 5:
			case 23:
			case 31:
			case 32:
			case 43:
			case 48:
			case 58:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case CHAR:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(781); assign_expr();
				}
				break;
			case OPENING_CURLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(782); match(OPENING_CURLY);
				setState(783); initializer_list();
				setState(784); match(CLOSING_CURLY);
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
		enterRule(_localctx, 176, RULE_initializer_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(788); initializer();
			setState(793);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==30) {
				{
				{
				setState(789); match(30);
				setState(790); initializer();
				}
				}
				setState(795);
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
		enterRule(_localctx, 178, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(796); class_key();
			setState(798);
			_la = _input.LA(1);
			if (_la==ALPHA_NUMERIC) {
				{
				setState(797); class_name();
				}
			}

			setState(801);
			_la = _input.LA(1);
			if (_la==33) {
				{
				setState(800); base_classes();
				}
			}

			setState(803); match(OPENING_CURLY);
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
		enterRule(_localctx, 180, RULE_class_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(806); identifier();
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
		enterRule(_localctx, 182, RULE_base_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(808); match(33);
			setState(809); base_class();
			setState(814);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==30) {
				{
				{
				setState(810); match(30);
				setState(811); base_class();
				}
				}
				setState(816);
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
		enterRule(_localctx, 184, RULE_base_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(818);
			_la = _input.LA(1);
			if (_la==VIRTUAL) {
				{
				setState(817); match(VIRTUAL);
				}
			}

			setState(821);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 29) | (1L << 35) | (1L << 49))) != 0)) {
				{
				setState(820); access_specifier();
				}
			}

			setState(823); identifier();
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
		enterRule(_localctx, 186, RULE_type_name);
		int _la;
		try {
			setState(857);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(828);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CV_QUALIFIER) {
					{
					{
					setState(825); match(CV_QUALIFIER);
					}
					}
					setState(830);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(834);
				switch (_input.LA(1)) {
				case 12:
				case 21:
				case 24:
				case 41:
					{
					setState(831); class_key();
					}
					break;
				case UNSIGNED:
					{
					setState(832); match(UNSIGNED);
					}
					break;
				case SIGNED:
					{
					setState(833); match(SIGNED);
					}
					break;
				case VOID:
				case LONG:
				case ALPHA_NUMERIC:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(836); base_type();
				setState(841);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(837); match(4);
					setState(838); template_param_list();
					setState(839); match(53);
					}
				}

				setState(853);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==17) {
					{
					{
					setState(843); match(17);
					setState(844); base_type();
					setState(849);
					_la = _input.LA(1);
					if (_la==4) {
						{
						setState(845); match(4);
						setState(846); template_param_list();
						setState(847); match(53);
						}
					}

					}
					}
					setState(855);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(856);
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

	public static class Type_suffixContext extends ParserRuleContext {
		public Param_type_listContext param_type_list() {
			return getRuleContext(Param_type_listContext.class,0);
		}
		public Constant_expr_w_Context constant_expr_w_() {
			return getRuleContext(Constant_expr_w_Context.class,0);
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
		enterRule(_localctx, 188, RULE_type_suffix);
		try {
			setState(864);
			switch (_input.LA(1)) {
			case 2:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(859); match(2);
				setState(860); constant_expr_w_();
				setState(861); match(25);
				}
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 2);
				{
				setState(863); param_type_list();
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
		enterRule(_localctx, 190, RULE_base_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(871);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				{
				setState(866); match(ALPHA_NUMERIC);
				}
				break;

			case 2:
				{
				setState(867); match(VOID);
				}
				break;

			case 3:
				{
				setState(868); match(LONG);
				}
				break;

			case 4:
				{
				setState(869); match(LONG);
				setState(870); match(LONG);
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
		enterRule(_localctx, 192, RULE_param_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(874);
			_la = _input.LA(1);
			if (_la==AUTO || _la==REGISTER) {
				{
				setState(873);
				_la = _input.LA(1);
				if ( !(_la==AUTO || _la==REGISTER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(876); type_name();
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
		enterRule(_localctx, 194, RULE_parameter_name);
		try {
			setState(880);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(878); identifier();
				}
				break;
			case 29:
			case 35:
			case 49:
				enterOuterAlt(_localctx, 2);
				{
				setState(879); access_specifier();
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
		enterRule(_localctx, 196, RULE_param_type_list);
		int _la;
		try {
			setState(897);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(882); match(32);
				setState(883); match(VOID);
				setState(884); match(14);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(885); match(32);
				setState(894);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 21) | (1L << 24) | (1L << 41))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (VOID - 71)) | (1L << (UNSIGNED - 71)) | (1L << (SIGNED - 71)) | (1L << (LONG - 71)) | (1L << (CV_QUALIFIER - 71)) | (1L << (AUTO - 71)) | (1L << (REGISTER - 71)) | (1L << (ALPHA_NUMERIC - 71)))) != 0)) {
					{
					setState(886); param_type();
					setState(891);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==30) {
						{
						{
						setState(887); match(30);
						setState(888); param_type();
						}
						}
						setState(893);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(896); match(14);
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
		enterRule(_localctx, 198, RULE_param_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(899); param_decl_specifiers();
			setState(900); param_type_id();
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
		enterRule(_localctx, 200, RULE_param_type_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(903);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(902); ptrs();
				}
			}

			setState(912);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				{
				setState(905); match(32);
				setState(906); param_type_id();
				setState(907); match(14);
				}
				break;

			case 2:
				{
				setState(910);
				_la = _input.LA(1);
				if (((((_la - 29)) & ~0x3f) == 0 && ((1L << (_la - 29)) & ((1L << (29 - 29)) | (1L << (35 - 29)) | (1L << (49 - 29)) | (1L << (ALPHA_NUMERIC - 29)))) != 0)) {
					{
					setState(909); parameter_name();
					}
				}

				}
				break;
			}
			setState(915);
			_la = _input.LA(1);
			if (_la==2 || _la==32) {
				{
				setState(914); type_suffix();
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
		enterRule(_localctx, 202, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(917); match(ALPHA_NUMERIC);
			setState(922);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==17) {
				{
				{
				setState(918); match(17);
				setState(919); match(ALPHA_NUMERIC);
				}
				}
				setState(924);
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
		enterRule(_localctx, 204, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(925);
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
		enterRule(_localctx, 206, RULE_ptrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(928); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(927); ptr_operator();
				}
				}
				setState(930); 
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
		"\2\3g\u03a7\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\t"+
		"F\4G\tG\4H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4"+
		"R\tR\4S\tS\4T\tT\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]"+
		"\t]\4^\t^\4_\t_\4`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th"+
		"\4i\ti\3\2\3\2\3\2\3\2\3\2\3\2\7\2\u00d9\n\2\f\2\16\2\u00dc\13\2\3\3\3"+
		"\3\3\3\3\3\3\3\5\3\u00e3\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\5\n\u00f3\n\n\3\13\3\13\3\13\3\13\5\13\u00f9\n\13\3\f\3"+
		"\f\3\f\5\f\u00fe\n\f\3\r\3\r\3\r\5\r\u0103\n\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\5\21\u0114\n\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u011c\n\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\5\26\u0130"+
		"\n\26\3\26\5\26\u0133\n\26\3\27\3\27\3\27\5\27\u0138\n\27\3\27\3\27\3"+
		"\30\3\30\3\31\3\31\5\31\u0140\n\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\36\5\36\u0150\n\36\3\36\3\36\3\37\7\37"+
		"\u0155\n\37\f\37\16\37\u0158\13\37\3\37\3\37\3\37\5\37\u015d\n\37\3\37"+
		"\3\37\3\37\3\37\3\37\5\37\u0164\n\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37"+
		"\u016c\n\37\7\37\u016e\n\37\f\37\16\37\u0171\13\37\3\37\5\37\u0174\n\37"+
		"\3 \5 \u0177\n \3 \3 \5 \u017b\n \3 \5 \u017e\n \3 \3 \3!\3!\3!\3\"\3"+
		"\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3+\3+\3+\5+\u019b"+
		"\n+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+"+
		"\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\5+\u01c5\n+\3,"+
		"\3,\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\7/\u01d9\n/\f/\16"+
		"/\u01dc\13/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65"+
		"\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3;\5;\u01f7\n;\3<\3<\3<\3"+
		"<\5<\u01fd\n<\3=\3=\3=\3=\3=\3=\5=\u0205\n=\3>\3>\3>\5>\u020a\n>\3?\3"+
		"?\3?\5?\u020f\n?\3@\3@\3@\5@\u0214\n@\3A\3A\3A\5A\u0219\nA\3B\3B\3B\5"+
		"B\u021e\nB\3C\3C\3C\3C\5C\u0224\nC\3D\3D\3D\3D\5D\u022a\nD\3E\3E\3E\5"+
		"E\u022f\nE\3F\3F\3F\5F\u0234\nF\3G\3G\3G\5G\u0239\nG\3H\3H\3H\7H\u023e"+
		"\nH\fH\16H\u0241\13H\3H\3H\3H\3H\5H\u0247\nH\3I\3I\3I\3I\3I\3I\6I\u024f"+
		"\nI\rI\16I\u0250\3I\3I\5I\u0255\nI\3J\3J\3J\3J\5J\u025b\nJ\3K\3K\7K\u025f"+
		"\nK\fK\16K\u0262\13K\3L\3L\3L\3L\5L\u0268\nL\3M\3M\3M\3M\3N\3N\3N\3N\7"+
		"N\u0272\nN\fN\16N\u0275\13N\5N\u0277\nN\3N\3N\3O\3O\3P\3P\3P\3P\3P\3P"+
		"\3P\3P\5P\u0285\nP\3P\3P\5P\u0289\nP\3Q\3Q\3Q\3Q\3Q\3Q\5Q\u0291\nQ\3R"+
		"\5R\u0294\nR\3R\5R\u0297\nR\3R\3R\3S\3S\3S\3S\3S\5S\u02a0\nS\5S\u02a2"+
		"\nS\3T\3T\3T\7T\u02a7\nT\fT\16T\u02aa\13T\3T\3T\3U\5U\u02af\nU\3U\3U\5"+
		"U\u02b3\nU\3U\3U\5U\u02b7\nU\3U\3U\3U\5U\u02bc\nU\3V\7V\u02bf\nV\fV\16"+
		"V\u02c2\13V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\5V\u02d0\nV\3V\7V\u02d3"+
		"\nV\fV\16V\u02d6\13V\7V\u02d8\nV\fV\16V\u02db\13V\3W\7W\u02de\nW\fW\16"+
		"W\u02e1\13W\3W\3W\3W\3W\3W\3W\3W\3W\3W\3W\3W\3W\5W\u02ef\nW\3W\7W\u02f2"+
		"\nW\fW\16W\u02f5\13W\7W\u02f7\nW\fW\16W\u02fa\13W\3X\7X\u02fd\nX\fX\16"+
		"X\u0300\13X\3X\3X\3X\3X\7X\u0306\nX\fX\16X\u0309\13X\7X\u030b\nX\fX\16"+
		"X\u030e\13X\3Y\3Y\3Y\3Y\3Y\5Y\u0315\nY\3Z\3Z\3Z\7Z\u031a\nZ\fZ\16Z\u031d"+
		"\13Z\3[\3[\5[\u0321\n[\3[\5[\u0324\n[\3[\3[\3[\3\\\3\\\3]\3]\3]\3]\7]"+
		"\u032f\n]\f]\16]\u0332\13]\3^\5^\u0335\n^\3^\5^\u0338\n^\3^\3^\3_\7_\u033d"+
		"\n_\f_\16_\u0340\13_\3_\3_\3_\5_\u0345\n_\3_\3_\3_\3_\3_\5_\u034c\n_\3"+
		"_\3_\3_\3_\3_\3_\5_\u0354\n_\7_\u0356\n_\f_\16_\u0359\13_\3_\5_\u035c"+
		"\n_\3`\3`\3`\3`\3`\5`\u0363\n`\3a\3a\3a\3a\3a\5a\u036a\na\3b\5b\u036d"+
		"\nb\3b\3b\3c\3c\5c\u0373\nc\3d\3d\3d\3d\3d\3d\3d\7d\u037c\nd\fd\16d\u037f"+
		"\13d\5d\u0381\nd\3d\5d\u0384\nd\3e\3e\3e\3f\5f\u038a\nf\3f\3f\3f\3f\3"+
		"f\5f\u0391\nf\5f\u0393\nf\3f\5f\u0396\nf\3g\3g\3g\7g\u039b\ng\fg\16g\u039e"+
		"\13g\3h\3h\3i\6i\u03a3\ni\ri\16i\u03a4\3i\2j\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|"+
		"~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096"+
		"\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae"+
		"\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6"+
		"\u00c8\u00ca\u00cc\u00ce\u00d0\2\37\4BBDD\3TU\3JK\b\3\3\5\5\31\31!!\62"+
		"\62<<\6\6\6\t\t\67\67==\3^c\6\21\22**,,NN\6\16\16\27\27\32\32++\4\3\3"+
		"\5\5\5\37\37%%\63\63\4\26\26\60\60\b\17\17\24\25\34\35$$\')89\4\b\b;;"+
		"\4\20\20\"\"\7\4\4\20\20\33\33\"\"YZ\5\20\20\"\"\64\64\6\6\6\20\20\"\""+
		"\67\67\3YZ\4\4\4\33\33\5\4\4\33\33\64\64\4  \64\64\t\4\4\20\20\33\33 "+
		" \"\"\64\64YZ\7\4\4\20\20\33\33\"\"YZ\4\n\n..\4!!\62\62\5\5\5\f\f::\3"+
		"JK\3TU\3^`\u03df\2\u00da\3\2\2\2\4\u00e2\3\2\2\2\6\u00e4\3\2\2\2\b\u00e6"+
		"\3\2\2\2\n\u00e8\3\2\2\2\f\u00ea\3\2\2\2\16\u00ec\3\2\2\2\20\u00ee\3\2"+
		"\2\2\22\u00f2\3\2\2\2\24\u00f8\3\2\2\2\26\u00fd\3\2\2\2\30\u0102\3\2\2"+
		"\2\32\u0104\3\2\2\2\34\u0109\3\2\2\2\36\u010b\3\2\2\2 \u0113\3\2\2\2\""+
		"\u0115\3\2\2\2$\u011f\3\2\2\2&\u0124\3\2\2\2(\u0126\3\2\2\2*\u0132\3\2"+
		"\2\2,\u0137\3\2\2\2.\u013b\3\2\2\2\60\u013d\3\2\2\2\62\u0141\3\2\2\2\64"+
		"\u0144\3\2\2\2\66\u0146\3\2\2\28\u014b\3\2\2\2:\u014f\3\2\2\2<\u0173\3"+
		"\2\2\2>\u017d\3\2\2\2@\u0181\3\2\2\2B\u0184\3\2\2\2D\u0186\3\2\2\2F\u0188"+
		"\3\2\2\2H\u018a\3\2\2\2J\u018c\3\2\2\2L\u018e\3\2\2\2N\u0190\3\2\2\2P"+
		"\u0192\3\2\2\2R\u0194\3\2\2\2T\u01c4\3\2\2\2V\u01c6\3\2\2\2X\u01c8\3\2"+
		"\2\2Z\u01ca\3\2\2\2\\\u01da\3\2\2\2^\u01dd\3\2\2\2`\u01df\3\2\2\2b\u01e1"+
		"\3\2\2\2d\u01e3\3\2\2\2f\u01e5\3\2\2\2h\u01e7\3\2\2\2j\u01e9\3\2\2\2l"+
		"\u01eb\3\2\2\2n\u01ed\3\2\2\2p\u01ef\3\2\2\2r\u01f1\3\2\2\2t\u01f3\3\2"+
		"\2\2v\u01f8\3\2\2\2x\u01fe\3\2\2\2z\u0206\3\2\2\2|\u020b\3\2\2\2~\u0210"+
		"\3\2\2\2\u0080\u0215\3\2\2\2\u0082\u021a\3\2\2\2\u0084\u021f\3\2\2\2\u0086"+
		"\u0225\3\2\2\2\u0088\u022b\3\2\2\2\u008a\u0230\3\2\2\2\u008c\u0235\3\2"+
		"\2\2\u008e\u0246\3\2\2\2\u0090\u0254\3\2\2\2\u0092\u025a\3\2\2\2\u0094"+
		"\u025c\3\2\2\2\u0096\u0267\3\2\2\2\u0098\u0269\3\2\2\2\u009a\u026d\3\2"+
		"\2\2\u009c\u027a\3\2\2\2\u009e\u0288\3\2\2\2\u00a0\u0290\3\2\2\2\u00a2"+
		"\u0293\3\2\2\2\u00a4\u02a1\3\2\2\2\u00a6\u02a3\3\2\2\2\u00a8\u02ae\3\2"+
		"\2\2\u00aa\u02c0\3\2\2\2\u00ac\u02df\3\2\2\2\u00ae\u02fe\3\2\2\2\u00b0"+
		"\u0314\3\2\2\2\u00b2\u0316\3\2\2\2\u00b4\u031e\3\2\2\2\u00b6\u0328\3\2"+
		"\2\2\u00b8\u032a\3\2\2\2\u00ba\u0334\3\2\2\2\u00bc\u035b\3\2\2\2\u00be"+
		"\u0362\3\2\2\2\u00c0\u0369\3\2\2\2\u00c2\u036c\3\2\2\2\u00c4\u0372\3\2"+
		"\2\2\u00c6\u0383\3\2\2\2\u00c8\u0385\3\2\2\2\u00ca\u0389\3\2\2\2\u00cc"+
		"\u0397\3\2\2\2\u00ce\u039f\3\2\2\2\u00d0\u03a2\3\2\2\2\u00d2\u00d9\5\b"+
		"\5\2\u00d3\u00d9\5\f\7\2\u00d4\u00d5\5\n\6\2\u00d5\u00d6\b\2\1\2\u00d6"+
		"\u00d9\3\2\2\2\u00d7\u00d9\5\4\3\2\u00d8\u00d2\3\2\2\2\u00d8\u00d3\3\2"+
		"\2\2\u00d8\u00d4\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da"+
		"\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\3\3\2\2\2\u00dc\u00da\3\2\2\2"+
		"\u00dd\u00e3\5\16\b\2\u00de\u00e3\5\20\t\2\u00df\u00e3\5\22\n\2\u00e0"+
		"\u00e3\5@!\2\u00e1\u00e3\5\6\4\2\u00e2\u00dd\3\2\2\2\u00e2\u00de\3\2\2"+
		"\2\u00e2\u00df\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e1\3\2\2\2\u00e3\5"+
		"\3\2\2\2\u00e4\u00e5\13\2\2\2\u00e5\7\3\2\2\2\u00e6\u00e7\7[\2\2\u00e7"+
		"\t\3\2\2\2\u00e8\u00e9\7\\\2\2\u00e9\13\3\2\2\2\u00ea\u00eb\7]\2\2\u00eb"+
		"\r\3\2\2\2\u00ec\u00ed\7Y\2\2\u00ed\17\3\2\2\2\u00ee\u00ef\7Z\2\2\u00ef"+
		"\21\3\2\2\2\u00f0\u00f3\5\24\13\2\u00f1\u00f3\5\26\f\2\u00f2\u00f0\3\2"+
		"\2\2\u00f2\u00f1\3\2\2\2\u00f3\23\3\2\2\2\u00f4\u00f9\5\30\r\2\u00f5\u00f9"+
		"\5 \21\2\u00f6\u00f9\5\64\33\2\u00f7\u00f9\5\66\34\2\u00f8\u00f4\3\2\2"+
		"\2\u00f8\u00f5\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9\25"+
		"\3\2\2\2\u00fa\u00fe\5,\27\2\u00fb\u00fe\5\u00a2R\2\u00fc\u00fe\5> \2"+
		"\u00fd\u00fa\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc\3\2\2\2\u00fe\27"+
		"\3\2\2\2\u00ff\u0103\5\32\16\2\u0100\u0103\5\34\17\2\u0101\u0103\5\36"+
		"\20\2\u0102\u00ff\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0101\3\2\2\2\u0103"+
		"\31\3\2\2\2\u0104\u0105\7>\2\2\u0105\u0106\7\"\2\2\u0106\u0107\5B\"\2"+
		"\u0107\u0108\7\20\2\2\u0108\33\3\2\2\2\u0109\u010a\7?\2\2\u010a\35\3\2"+
		"\2\2\u010b\u010c\7E\2\2\u010c\u010d\7\"\2\2\u010d\u010e\5B\"\2\u010e\u010f"+
		"\7\20\2\2\u010f\37\3\2\2\2\u0110\u0114\5\"\22\2\u0111\u0114\5&\24\2\u0112"+
		"\u0114\5$\23\2\u0113\u0110\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0112\3\2"+
		"\2\2\u0114!\3\2\2\2\u0115\u0116\7@\2\2\u0116\u0117\7\"\2\2\u0117\u0118"+
		"\5*\26\2\u0118\u0119\5B\"\2\u0119\u011b\7\64\2\2\u011a\u011c\5t;\2\u011b"+
		"\u011a\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\7\20"+
		"\2\2\u011e#\3\2\2\2\u011f\u0120\7A\2\2\u0120\u0121\7\"\2\2\u0121\u0122"+
		"\5B\"\2\u0122\u0123\7\20\2\2\u0123%\3\2\2\2\u0124\u0125\7\13\2\2\u0125"+
		"\'\3\2\2\2\u0126\u0127\7\13\2\2\u0127\u0128\5\4\3\2\u0128\u0129\7A\2\2"+
		"\u0129\u012a\7\"\2\2\u012a\u012b\5t;\2\u012b\u012c\7\20\2\2\u012c)\3\2"+
		"\2\2\u012d\u0133\5\u00a2R\2\u012e\u0130\5t;\2\u012f\u012e\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0133\7\64\2\2\u0132\u012d\3"+
		"\2\2\2\u0132\u012f\3\2\2\2\u0133+\3\2\2\2\u0134\u0138\5.\30\2\u0135\u0138"+
		"\5\60\31\2\u0136\u0138\5\62\32\2\u0137\u0134\3\2\2\2\u0137\u0135\3\2\2"+
		"\2\u0137\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013a\7\64\2\2\u013a"+
		"-\3\2\2\2\u013b\u013c\t\2\2\2\u013c/\3\2\2\2\u013d\u013f\7G\2\2\u013e"+
		"\u0140\5t;\2\u013f\u013e\3\2\2\2\u013f\u0140\3\2\2\2\u0140\61\3\2\2\2"+
		"\u0141\u0142\7F\2\2\u0142\u0143\5\u00ccg\2\u0143\63\3\2\2\2\u0144\u0145"+
		"\7O\2\2\u0145\65\3\2\2\2\u0146\u0147\7P\2\2\u0147\u0148\7\"\2\2\u0148"+
		"\u0149\58\35\2\u0149\u014a\7\20\2\2\u014a\67\3\2\2\2\u014b\u014c\5:\36"+
		"\2\u014c\u014d\5\u00caf\2\u014d9\3\2\2\2\u014e\u0150\t\3\2\2\u014f\u014e"+
		"\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0152\5<\37\2\u0152"+
		";\3\2\2\2\u0153\u0155\7M\2\2\u0154\u0153\3\2\2\2\u0155\u0158\3\2\2\2\u0156"+
		"\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u015c\3\2\2\2\u0158\u0156\3\2"+
		"\2\2\u0159\u015d\5L\'\2\u015a\u015d\7J\2\2\u015b\u015d\7K\2\2\u015c\u0159"+
		"\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015b\3\2\2\2\u015c\u015d\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e\u0163\5\u00c0a\2\u015f\u0160\7\6\2\2\u0160\u0161"+
		"\5\\/\2\u0161\u0162\7\67\2\2\u0162\u0164\3\2\2\2\u0163\u015f\3\2\2\2\u0163"+
		"\u0164\3\2\2\2\u0164\u016f\3\2\2\2\u0165\u0166\7\23\2\2\u0166\u016b\5"+
		"\u00c0a\2\u0167\u0168\7\6\2\2\u0168\u0169\5\\/\2\u0169\u016a\7\67\2\2"+
		"\u016a\u016c\3\2\2\2\u016b\u0167\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016e"+
		"\3\2\2\2\u016d\u0165\3\2\2\2\u016e\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u016f"+
		"\u0170\3\2\2\2\u0170\u0174\3\2\2\2\u0171\u016f\3\2\2\2\u0172\u0174\t\4"+
		"\2\2\u0173\u0156\3\2\2\2\u0173\u0172\3\2\2\2\u0174=\3\2\2\2\u0175\u0177"+
		"\7C\2\2\u0176\u0175\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u017a\3\2\2\2\u0178"+
		"\u017b\5\u00ccg\2\u0179\u017b\5\u00ceh\2\u017a\u0178\3\2\2\2\u017a\u0179"+
		"\3\2\2\2\u017b\u017e\3\2\2\2\u017c\u017e\5P)\2\u017d\u0176\3\2\2\2\u017d"+
		"\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\7#\2\2\u0180?\3\2\2\2\u0181"+
		"\u0182\5t;\2\u0182\u0183\7\64\2\2\u0183A\3\2\2\2\u0184\u0185\5t;\2\u0185"+
		"C\3\2\2\2\u0186\u0187\t\5\2\2\u0187E\3\2\2\2\u0188\u0189\t\6\2\2\u0189"+
		"G\3\2\2\2\u018a\u018b\t\7\2\2\u018bI\3\2\2\2\u018c\u018d\t\b\2\2\u018d"+
		"K\3\2\2\2\u018e\u018f\t\t\2\2\u018fM\3\2\2\2\u0190\u0191\t\n\2\2\u0191"+
		"O\3\2\2\2\u0192\u0193\t\13\2\2\u0193Q\3\2\2\2\u0194\u0195\7V\2\2\u0195"+
		"\u0196\5T+\2\u0196S\3\2\2\2\u0197\u019a\t\f\2\2\u0198\u0199\7\4\2\2\u0199"+
		"\u019b\7\33\2\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u01c5\3"+
		"\2\2\2\u019c\u01c5\7\62\2\2\u019d\u01c5\7!\2\2\u019e\u01c5\7\5\2\2\u019f"+
		"\u01c5\7:\2\2\u01a0\u01c5\7\f\2\2\u01a1\u01c5\7/\2\2\u01a2\u01c5\7\3\2"+
		"\2\u01a3\u01c5\7\30\2\2\u01a4\u01c5\7<\2\2\u01a5\u01c5\7\31\2\2\u01a6"+
		"\u01c5\7\24\2\2\u01a7\u01c5\7\6\2\2\u01a8\u01c5\7\67\2\2\u01a9\u01c5\7"+
		"(\2\2\u01aa\u01c5\7\35\2\2\u01ab\u01c5\7\17\2\2\u01ac\u01c5\79\2\2\u01ad"+
		"\u01c5\78\2\2\u01ae\u01c5\7)\2\2\u01af\u01c5\7$\2\2\u01b0\u01c5\7\25\2"+
		"\2\u01b1\u01c5\7.\2\2\u01b2\u01c5\7\n\2\2\u01b3\u01c5\7\'\2\2\u01b4\u01c5"+
		"\7\34\2\2\u01b5\u01c5\7;\2\2\u01b6\u01c5\7\b\2\2\u01b7\u01c5\7\t\2\2\u01b8"+
		"\u01c5\7=\2\2\u01b9\u01c5\7\65\2\2\u01ba\u01c5\7\66\2\2\u01bb\u01c5\7"+
		"-\2\2\u01bc\u01c5\7\7\2\2\u01bd\u01c5\7 \2\2\u01be\u01c5\7\36\2\2\u01bf"+
		"\u01c5\7\r\2\2\u01c0\u01c1\7\"\2\2\u01c1\u01c5\7\20\2\2\u01c2\u01c3\7"+
		"\4\2\2\u01c3\u01c5\7\33\2\2\u01c4\u0197\3\2\2\2\u01c4\u019c\3\2\2\2\u01c4"+
		"\u019d\3\2\2\2\u01c4\u019e\3\2\2\2\u01c4\u019f\3\2\2\2\u01c4\u01a0\3\2"+
		"\2\2\u01c4\u01a1\3\2\2\2\u01c4\u01a2\3\2\2\2\u01c4\u01a3\3\2\2\2\u01c4"+
		"\u01a4\3\2\2\2\u01c4\u01a5\3\2\2\2\u01c4\u01a6\3\2\2\2\u01c4\u01a7\3\2"+
		"\2\2\u01c4\u01a8\3\2\2\2\u01c4\u01a9\3\2\2\2\u01c4\u01aa\3\2\2\2\u01c4"+
		"\u01ab\3\2\2\2\u01c4\u01ac\3\2\2\2\u01c4\u01ad\3\2\2\2\u01c4\u01ae\3\2"+
		"\2\2\u01c4\u01af\3\2\2\2\u01c4\u01b0\3\2\2\2\u01c4\u01b1\3\2\2\2\u01c4"+
		"\u01b2\3\2\2\2\u01c4\u01b3\3\2\2\2\u01c4\u01b4\3\2\2\2\u01c4\u01b5\3\2"+
		"\2\2\u01c4\u01b6\3\2\2\2\u01c4\u01b7\3\2\2\2\u01c4\u01b8\3\2\2\2\u01c4"+
		"\u01b9\3\2\2\2\u01c4\u01ba\3\2\2\2\u01c4\u01bb\3\2\2\2\u01c4\u01bc\3\2"+
		"\2\2\u01c4\u01bd\3\2\2\2\u01c4\u01be\3\2\2\2\u01c4\u01bf\3\2\2\2\u01c4"+
		"\u01c0\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c5U\3\2\2\2\u01c6\u01c7\t\r\2\2"+
		"\u01c7W\3\2\2\2\u01c8\u01c9\t\16\2\2\u01c9Y\3\2\2\2\u01ca\u01cb\7W\2\2"+
		"\u01cb\u01cc\7\6\2\2\u01cc\u01cd\5\\/\2\u01cd\u01ce\7\67\2\2\u01ce[\3"+
		"\2\2\2\u01cf\u01d0\7\6\2\2\u01d0\u01d1\5\\/\2\u01d1\u01d2\7\67\2\2\u01d2"+
		"\u01d9\3\2\2\2\u01d3\u01d4\7\"\2\2\u01d4\u01d5\5\\/\2\u01d5\u01d6\7\20"+
		"\2\2\u01d6\u01d9\3\2\2\2\u01d7\u01d9\5d\63\2\u01d8\u01cf\3\2\2\2\u01d8"+
		"\u01d3\3\2\2\2\u01d8\u01d7\3\2\2\2\u01d9\u01dc\3\2\2\2\u01da\u01d8\3\2"+
		"\2\2\u01da\u01db\3\2\2\2\u01db]\3\2\2\2\u01dc\u01da\3\2\2\2\u01dd\u01de"+
		"\n\17\2\2\u01de_\3\2\2\2\u01df\u01e0\n\20\2\2\u01e0a\3\2\2\2\u01e1\u01e2"+
		"\n\21\2\2\u01e2c\3\2\2\2\u01e3\u01e4\n\22\2\2\u01e4e\3\2\2\2\u01e5\u01e6"+
		"\n\23\2\2\u01e6g\3\2\2\2\u01e7\u01e8\n\24\2\2\u01e8i\3\2\2\2\u01e9\u01ea"+
		"\n\25\2\2\u01eak\3\2\2\2\u01eb\u01ec\n\26\2\2\u01ecm\3\2\2\2\u01ed\u01ee"+
		"\n\27\2\2\u01eeo\3\2\2\2\u01ef\u01f0\n\30\2\2\u01f0q\3\2\2\2\u01f1\u01f2"+
		"\13\2\2\2\u01f2s\3\2\2\2\u01f3\u01f6\5v<\2\u01f4\u01f5\7 \2\2\u01f5\u01f7"+
		"\5v<\2\u01f6\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7u\3\2\2\2\u01f8\u01fc"+
		"\5x=\2\u01f9\u01fa\5V,\2\u01fa\u01fb\5v<\2\u01fb\u01fd\3\2\2\2\u01fc\u01f9"+
		"\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fdw\3\2\2\2\u01fe\u0204\5z>\2\u01ff\u0200"+
		"\7&\2\2\u0200\u0201\5t;\2\u0201\u0202\7#\2\2\u0202\u0203\5x=\2\u0203\u0205"+
		"\3\2\2\2\u0204\u01ff\3\2\2\2\u0204\u0205\3\2\2\2\u0205y\3\2\2\2\u0206"+
		"\u0209\5|?\2\u0207\u0208\7\66\2\2\u0208\u020a\5z>\2\u0209\u0207\3\2\2"+
		"\2\u0209\u020a\3\2\2\2\u020a{\3\2\2\2\u020b\u020e\5~@\2\u020c\u020d\7"+
		"\65\2\2\u020d\u020f\5|?\2\u020e\u020c\3\2\2\2\u020e\u020f\3\2\2\2\u020f"+
		"}\3\2\2\2\u0210\u0213\5\u0080A\2\u0211\u0212\7\30\2\2\u0212\u0214\5~@"+
		"\2\u0213\u0211\3\2\2\2\u0213\u0214\3\2\2\2\u0214\177\3\2\2\2\u0215\u0218"+
		"\5\u0082B\2\u0216\u0217\7/\2\2\u0217\u0219\5\u0080A\2\u0218\u0216\3\2"+
		"\2\2\u0218\u0219\3\2\2\2\u0219\u0081\3\2\2\2\u021a\u021d\5\u0084C\2\u021b"+
		"\u021c\7\3\2\2\u021c\u021e\5\u0082B\2\u021d\u021b\3\2\2\2\u021d\u021e"+
		"\3\2\2\2\u021e\u0083\3\2\2\2\u021f\u0223\5\u0086D\2\u0220\u0221\5X-\2"+
		"\u0221\u0222\5\u0084C\2\u0222\u0224\3\2\2\2\u0223\u0220\3\2\2\2\u0223"+
		"\u0224\3\2\2\2\u0224\u0085\3\2\2\2\u0225\u0229\5\u0088E\2\u0226\u0227"+
		"\5F$\2\u0227\u0228\5\u0086D\2\u0228\u022a\3\2\2\2\u0229\u0226\3\2\2\2"+
		"\u0229\u022a\3\2\2\2\u022a\u0087\3\2\2\2\u022b\u022e\5\u008aF\2\u022c"+
		"\u022d\t\31\2\2\u022d\u022f\5\u0088E\2\u022e\u022c\3\2\2\2\u022e\u022f"+
		"\3\2\2\2\u022f\u0089\3\2\2\2\u0230\u0233\5\u008cG\2\u0231\u0232\t\32\2"+
		"\2\u0232\u0234\5\u008aF\2\u0233\u0231\3\2\2\2\u0233\u0234\3\2\2\2\u0234"+
		"\u008b\3\2\2\2\u0235\u0238\5\u008eH\2\u0236\u0237\t\33\2\2\u0237\u0239"+
		"\5\u008eH\2\u0238\u0236\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u008d\3\2\2"+
		"\2\u023a\u023b\7\"\2\2\u023b\u023f\5\u00bc_\2\u023c\u023e\5N(\2\u023d"+
		"\u023c\3\2\2\2\u023e\u0241\3\2\2\2\u023f\u023d\3\2\2\2\u023f\u0240\3\2"+
		"\2\2\u0240\u0242\3\2\2\2\u0241\u023f\3\2\2\2\u0242\u0243\7\20\2\2\u0243"+
		"\u0244\5\u008eH\2\u0244\u0247\3\2\2\2\u0245\u0247\5\u0090I\2\u0246\u023a"+
		"\3\2\2\2\u0246\u0245\3\2\2\2\u0247\u008f\3\2\2\2\u0248\u0255\5\u0092J"+
		"\2\u0249\u024a\7\7\2\2\u024a\u0255\5\u0090I\2\u024b\u024c\7-\2\2\u024c"+
		"\u0255\5\u0090I\2\u024d\u024f\5D#\2\u024e\u024d\3\2\2\2\u024f\u0250\3"+
		"\2\2\2\u0250\u024e\3\2\2\2\u0250\u0251\3\2\2\2\u0251\u0252\3\2\2\2\u0252"+
		"\u0253\5\u0092J\2\u0253\u0255\3\2\2\2\u0254\u0248\3\2\2\2\u0254\u0249"+
		"\3\2\2\2\u0254\u024b\3\2\2\2\u0254\u024e\3\2\2\2\u0255\u0091\3\2\2\2\u0256"+
		"\u0257\5\u0094K\2\u0257\u0258\5\u0096L\2\u0258\u025b\3\2\2\2\u0259\u025b"+
		"\5\u0094K\2\u025a\u0256\3\2\2\2\u025a\u0259\3\2\2\2\u025b\u0093\3\2\2"+
		"\2\u025c\u0260\5\u00a0Q\2\u025d\u025f\5\u009eP\2\u025e\u025d\3\2\2\2\u025f"+
		"\u0262\3\2\2\2\u0260\u025e\3\2\2\2\u0260\u0261\3\2\2\2\u0261\u0095\3\2"+
		"\2\2\u0262\u0260\3\2\2\2\u0263\u0264\5\u0098M\2\u0264\u0265\5\u009aN\2"+
		"\u0265\u0268\3\2\2\2\u0266\u0268\5\u009aN\2\u0267\u0263\3\2\2\2\u0267"+
		"\u0266\3\2\2\2\u0268\u0097\3\2\2\2\u0269\u026a\7\6\2\2\u026a\u026b\5\\"+
		"/\2\u026b\u026c\7\67\2\2\u026c\u0099\3\2\2\2\u026d\u0276\7\"\2\2\u026e"+
		"\u0273\5\u009cO\2\u026f\u0270\7 \2\2\u0270\u0272\5\u009cO\2\u0271\u026f"+
		"\3\2\2\2\u0272\u0275\3\2\2\2\u0273\u0271\3\2\2\2\u0273\u0274\3\2\2\2\u0274"+
		"\u0277\3\2\2\2\u0275\u0273\3\2\2\2\u0276\u026e\3\2\2\2\u0276\u0277\3\2"+
		"\2\2\u0277\u0278\3\2\2\2\u0278\u0279\7\20\2\2\u0279\u009b\3\2\2\2\u027a"+
		"\u027b\5v<\2\u027b\u009d\3\2\2\2\u027c\u027d\7\61\2\2\u027d\u0285\5\u00cc"+
		"g\2\u027e\u027f\7\r\2\2\u027f\u0285\5\u00ccg\2\u0280\u0281\7\4\2\2\u0281"+
		"\u0282\5t;\2\u0282\u0283\7\33\2\2\u0283\u0285\3\2\2\2\u0284\u027c\3\2"+
		"\2\2\u0284\u027e\3\2\2\2\u0284\u0280\3\2\2\2\u0285\u0289\3\2\2\2\u0286"+
		"\u0289\7-\2\2\u0287\u0289\7\7\2\2\u0288\u0284\3\2\2\2\u0288\u0286\3\2"+
		"\2\2\u0288\u0287\3\2\2\2\u0289\u009f\3\2\2\2\u028a\u028b\7\"\2\2\u028b"+
		"\u028c\5t;\2\u028c\u028d\7\20\2\2\u028d\u0291\3\2\2\2\u028e\u0291\5\u00cc"+
		"g\2\u028f\u0291\5H%\2\u0290\u028a\3\2\2\2\u0290\u028e\3\2\2\2\u0290\u028f"+
		"\3\2\2\2\u0291\u00a1\3\2\2\2\u0292\u0294\7H\2\2\u0293\u0292\3\2\2\2\u0293"+
		"\u0294\3\2\2\2\u0294\u0296\3\2\2\2\u0295\u0297\5Z.\2\u0296\u0295\3\2\2"+
		"\2\u0296\u0297\3\2\2\2\u0297\u0298\3\2\2\2\u0298\u0299\5\u00a4S\2\u0299"+
		"\u00a3\3\2\2\2\u029a\u029b\5\u00bc_\2\u029b\u029c\5\u00a6T\2\u029c\u02a2"+
		"\3\2\2\2\u029d\u029f\5\u00b4[\2\u029e\u02a0\5\u00a6T\2\u029f\u029e\3\2"+
		"\2\2\u029f\u02a0\3\2\2\2\u02a0\u02a2\3\2\2\2\u02a1\u029a\3\2\2\2\u02a1"+
		"\u029d\3\2\2\2\u02a2\u00a5\3\2\2\2\u02a3\u02a8\5\u00a8U\2\u02a4\u02a5"+
		"\7 \2\2\u02a5\u02a7\5\u00a8U\2\u02a6\u02a4\3\2\2\2\u02a7\u02aa\3\2\2\2"+
		"\u02a8\u02a6\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9\u02ab\3\2\2\2\u02aa\u02a8"+
		"\3\2\2\2\u02ab\u02ac\7\64\2\2\u02ac\u00a7\3\2\2\2\u02ad\u02af\5\u00d0"+
		"i\2\u02ae\u02ad\3\2\2\2\u02ae\u02af\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0"+
		"\u02b2\5\u00ccg\2\u02b1\u02b3\5\u00be`\2\u02b2\u02b1\3\2\2\2\u02b2\u02b3"+
		"\3\2\2\2\u02b3\u02bb\3\2\2\2\u02b4\u02b6\7\"\2\2\u02b5\u02b7\5t;\2\u02b6"+
		"\u02b5\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8\u02bc\7\20"+
		"\2\2\u02b9\u02ba\7\24\2\2\u02ba\u02bc\5\u00aaV\2\u02bb\u02b4\3\2\2\2\u02bb"+
		"\u02b9\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u00a9\3\2\2\2\u02bd\u02bf\5n"+
		"8\2\u02be\u02bd\3\2\2\2\u02bf\u02c2\3\2\2\2\u02c0\u02be\3\2\2\2\u02c0"+
		"\u02c1\3\2\2\2\u02c1\u02d9\3\2\2\2\u02c2\u02c0\3\2\2\2\u02c3\u02c4\7Y"+
		"\2\2\u02c4\u02c5\5\u00acW\2\u02c5\u02c6\7Z\2\2\u02c6\u02d0\3\2\2\2\u02c7"+
		"\u02c8\7\"\2\2\u02c8\u02c9\5\u00acW\2\u02c9\u02ca\7\20\2\2\u02ca\u02d0"+
		"\3\2\2\2\u02cb\u02cc\7\4\2\2\u02cc\u02cd\5\u00acW\2\u02cd\u02ce\7\33\2"+
		"\2\u02ce\u02d0\3\2\2\2\u02cf\u02c3\3\2\2\2\u02cf\u02c7\3\2\2\2\u02cf\u02cb"+
		"\3\2\2\2\u02d0\u02d4\3\2\2\2\u02d1\u02d3\5n8\2\u02d2\u02d1\3\2\2\2\u02d3"+
		"\u02d6\3\2\2\2\u02d4\u02d2\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5\u02d8\3\2"+
		"\2\2\u02d6\u02d4\3\2\2\2\u02d7\u02cf\3\2\2\2\u02d8\u02db\3\2\2\2\u02d9"+
		"\u02d7\3\2\2\2\u02d9\u02da\3\2\2\2\u02da\u00ab\3\2\2\2\u02db\u02d9\3\2"+
		"\2\2\u02dc\u02de\5p9\2\u02dd\u02dc\3\2\2\2\u02de\u02e1\3\2\2\2\u02df\u02dd"+
		"\3\2\2\2\u02df\u02e0\3\2\2\2\u02e0\u02f8\3\2\2\2\u02e1\u02df\3\2\2\2\u02e2"+
		"\u02e3\7Y\2\2\u02e3\u02e4\5\u00acW\2\u02e4\u02e5\7Z\2\2\u02e5\u02ef\3"+
		"\2\2\2\u02e6\u02e7\7\"\2\2\u02e7\u02e8\5\u00acW\2\u02e8\u02e9\7\20\2\2"+
		"\u02e9\u02ef\3\2\2\2\u02ea\u02eb\7\4\2\2\u02eb\u02ec\5\u00acW\2\u02ec"+
		"\u02ed\7\33\2\2\u02ed\u02ef\3\2\2\2\u02ee\u02e2\3\2\2\2\u02ee\u02e6\3"+
		"\2\2\2\u02ee\u02ea\3\2\2\2\u02ef\u02f3\3\2\2\2\u02f0\u02f2\5p9\2\u02f1"+
		"\u02f0\3\2\2\2\u02f2\u02f5\3\2\2\2\u02f3\u02f1\3\2\2\2\u02f3\u02f4\3\2"+
		"\2\2\u02f4\u02f7\3\2\2\2\u02f5\u02f3\3\2\2\2\u02f6\u02ee\3\2\2\2\u02f7"+
		"\u02fa\3\2\2\2\u02f8\u02f6\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9\u00ad\3\2"+
		"\2\2\u02fa\u02f8\3\2\2\2\u02fb\u02fd\5h\65\2\u02fc\u02fb\3\2\2\2\u02fd"+
		"\u0300\3\2\2\2\u02fe\u02fc\3\2\2\2\u02fe\u02ff\3\2\2\2\u02ff\u030c\3\2"+
		"\2\2\u0300\u02fe\3\2\2\2\u0301\u0302\7\4\2\2\u0302\u0303\5\u00aeX\2\u0303"+
		"\u0307\7\33\2\2\u0304\u0306\5h\65\2\u0305\u0304\3\2\2\2\u0306\u0309\3"+
		"\2\2\2\u0307\u0305\3\2\2\2\u0307\u0308\3\2\2\2\u0308\u030b\3\2\2\2\u0309"+
		"\u0307\3\2\2\2\u030a\u0301\3\2\2\2\u030b\u030e\3\2\2\2\u030c\u030a\3\2"+
		"\2\2\u030c\u030d\3\2\2\2\u030d\u00af\3\2\2\2\u030e\u030c\3\2\2\2\u030f"+
		"\u0315\5v<\2\u0310\u0311\7Y\2\2\u0311\u0312\5\u00b2Z\2\u0312\u0313\7Z"+
		"\2\2\u0313\u0315\3\2\2\2\u0314\u030f\3\2\2\2\u0314\u0310\3\2\2\2\u0315"+
		"\u00b1\3\2\2\2\u0316\u031b\5\u00b0Y\2\u0317\u0318\7 \2\2\u0318\u031a\5"+
		"\u00b0Y\2\u0319\u0317\3\2\2\2\u031a\u031d\3\2\2\2\u031b\u0319\3\2\2\2"+
		"\u031b\u031c\3\2\2\2\u031c\u00b3\3\2\2\2\u031d\u031b\3\2\2\2\u031e\u0320"+
		"\5L\'\2\u031f\u0321\5\u00b6\\\2\u0320\u031f\3\2\2\2\u0320\u0321\3\2\2"+
		"\2\u0321\u0323\3\2\2\2\u0322\u0324\5\u00b8]\2\u0323\u0322\3\2\2\2\u0323"+
		"\u0324\3\2\2\2\u0324\u0325\3\2\2\2\u0325\u0326\7Y\2\2\u0326\u0327\b[\1"+
		"\2\u0327\u00b5\3\2\2\2\u0328\u0329\5\u00ccg\2\u0329\u00b7\3\2\2\2\u032a"+
		"\u032b\7#\2\2\u032b\u0330\5\u00ba^\2\u032c\u032d\7 \2\2\u032d\u032f\5"+
		"\u00ba^\2\u032e\u032c\3\2\2\2\u032f\u0332\3\2\2\2\u0330\u032e\3\2\2\2"+
		"\u0330\u0331\3\2\2\2\u0331\u00b9\3\2\2\2\u0332\u0330\3\2\2\2\u0333\u0335"+
		"\7N\2\2\u0334\u0333\3\2\2\2\u0334\u0335\3\2\2\2\u0335\u0337\3\2\2\2\u0336"+
		"\u0338\5P)\2\u0337\u0336\3\2\2\2\u0337\u0338\3\2\2\2\u0338\u0339\3\2\2"+
		"\2\u0339\u033a\5\u00ccg\2\u033a\u00bb\3\2\2\2\u033b\u033d\7M\2\2\u033c"+
		"\u033b\3\2\2\2\u033d\u0340\3\2\2\2\u033e\u033c\3\2\2\2\u033e\u033f\3\2"+
		"\2\2\u033f\u0344\3\2\2\2\u0340\u033e\3\2\2\2\u0341\u0345\5L\'\2\u0342"+
		"\u0345\7J\2\2\u0343\u0345\7K\2\2\u0344\u0341\3\2\2\2\u0344\u0342\3\2\2"+
		"\2\u0344\u0343\3\2\2\2\u0344\u0345\3\2\2\2\u0345\u0346\3\2\2\2\u0346\u034b"+
		"\5\u00c0a\2\u0347\u0348\7\6\2\2\u0348\u0349\5\\/\2\u0349\u034a\7\67\2"+
		"\2\u034a\u034c\3\2\2\2\u034b\u0347\3\2\2\2\u034b\u034c\3\2\2\2\u034c\u0357"+
		"\3\2\2\2\u034d\u034e\7\23\2\2\u034e\u0353\5\u00c0a\2\u034f\u0350\7\6\2"+
		"\2\u0350\u0351\5\\/\2\u0351\u0352\7\67\2\2\u0352\u0354\3\2\2\2\u0353\u034f"+
		"\3\2\2\2\u0353\u0354\3\2\2\2\u0354\u0356\3\2\2\2\u0355\u034d\3\2\2\2\u0356"+
		"\u0359\3\2\2\2\u0357\u0355\3\2\2\2\u0357\u0358\3\2\2\2\u0358\u035c\3\2"+
		"\2\2\u0359\u0357\3\2\2\2\u035a\u035c\t\34\2\2\u035b\u033e\3\2\2\2\u035b"+
		"\u035a\3\2\2\2\u035c\u00bd\3\2\2\2\u035d\u035e\7\4\2\2\u035e\u035f\5\u00ae"+
		"X\2\u035f\u0360\7\33\2\2\u0360\u0363\3\2\2\2\u0361\u0363\5\u00c6d\2\u0362"+
		"\u035d\3\2\2\2\u0362\u0361\3\2\2\2\u0363\u00bf\3\2\2\2\u0364\u036a\7X"+
		"\2\2\u0365\u036a\7I\2\2\u0366\u036a\7L\2\2\u0367\u0368\7L\2\2\u0368\u036a"+
		"\7L\2\2\u0369\u0364\3\2\2\2\u0369\u0365\3\2\2\2\u0369\u0366\3\2\2\2\u0369"+
		"\u0367\3\2\2\2\u036a\u00c1\3\2\2\2\u036b\u036d\t\35\2\2\u036c\u036b\3"+
		"\2\2\2\u036c\u036d\3\2\2\2\u036d\u036e\3\2\2\2\u036e\u036f\5\u00bc_\2"+
		"\u036f\u00c3\3\2\2\2\u0370\u0373\5\u00ccg\2\u0371\u0373\5P)\2\u0372\u0370"+
		"\3\2\2\2\u0372\u0371\3\2\2\2\u0373\u00c5\3\2\2\2\u0374\u0375\7\"\2\2\u0375"+
		"\u0376\7I\2\2\u0376\u0384\7\20\2\2\u0377\u0380\7\"\2\2\u0378\u037d\5\u00c8"+
		"e\2\u0379\u037a\7 \2\2\u037a\u037c\5\u00c8e\2\u037b\u0379\3\2\2\2\u037c"+
		"\u037f\3\2\2\2\u037d\u037b\3\2\2\2\u037d\u037e\3\2\2\2\u037e\u0381\3\2"+
		"\2\2\u037f\u037d\3\2\2\2\u0380\u0378\3\2\2\2\u0380\u0381\3\2\2\2\u0381"+
		"\u0382\3\2\2\2\u0382\u0384\7\20\2\2\u0383\u0374\3\2\2\2\u0383\u0377\3"+
		"\2\2\2\u0384\u00c7\3\2\2\2\u0385\u0386\5\u00c2b\2\u0386\u0387\5\u00ca"+
		"f\2\u0387\u00c9\3\2\2\2\u0388\u038a\5\u00d0i\2\u0389\u0388\3\2\2\2\u0389"+
		"\u038a\3\2\2\2\u038a\u0392\3\2\2\2\u038b\u038c\7\"\2\2\u038c\u038d\5\u00ca"+
		"f\2\u038d\u038e\7\20\2\2\u038e\u0393\3\2\2\2\u038f\u0391\5\u00c4c\2\u0390"+
		"\u038f\3\2\2\2\u0390\u0391\3\2\2\2\u0391\u0393\3\2\2\2\u0392\u038b\3\2"+
		"\2\2\u0392\u0390\3\2\2\2\u0393\u0395\3\2\2\2\u0394\u0396\5\u00be`\2\u0395"+
		"\u0394\3\2\2\2\u0395\u0396\3\2\2\2\u0396\u00cb\3\2\2\2\u0397\u039c\7X"+
		"\2\2\u0398\u0399\7\23\2\2\u0399\u039b\7X\2\2\u039a\u0398\3\2\2\2\u039b"+
		"\u039e\3\2\2\2\u039c\u039a\3\2\2\2\u039c\u039d\3\2\2\2\u039d\u00cd\3\2"+
		"\2\2\u039e\u039c\3\2\2\2\u039f\u03a0\t\36\2\2\u03a0\u00cf\3\2\2\2\u03a1"+
		"\u03a3\5N(\2\u03a2\u03a1\3\2\2\2\u03a3\u03a4\3\2\2\2\u03a4\u03a2\3\2\2"+
		"\2\u03a4\u03a5\3\2\2\2\u03a5\u00d1\3\2\2\2d\u00d8\u00da\u00e2\u00f2\u00f8"+
		"\u00fd\u0102\u0113\u011b\u012f\u0132\u0137\u013f\u014f\u0156\u015c\u0163"+
		"\u016b\u016f\u0173\u0176\u017a\u017d\u019a\u01c4\u01d8\u01da\u01f6\u01fc"+
		"\u0204\u0209\u020e\u0213\u0218\u021d\u0223\u0229\u022e\u0233\u0238\u023f"+
		"\u0246\u0250\u0254\u025a\u0260\u0267\u0273\u0276\u0284\u0288\u0290\u0293"+
		"\u0296\u029f\u02a1\u02a8\u02ae\u02b2\u02b6\u02bb\u02c0\u02cf\u02d4\u02d9"+
		"\u02df\u02ee\u02f3\u02f8\u02fe\u0307\u030c\u0314\u031b\u0320\u0323\u0330"+
		"\u0334\u0337\u033e\u0344\u034b\u0353\u0357\u035b\u0362\u0369\u036c\u0372"+
		"\u037d\u0380\u0383\u0389\u0390\u0392\u0395\u039c\u03a4";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}
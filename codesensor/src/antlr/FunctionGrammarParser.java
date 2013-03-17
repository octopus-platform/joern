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
		T__70=1, T__69=2, T__68=3, T__67=4, T__66=5, T__65=6, T__64=7, T__63=8, 
		T__62=9, T__61=10, T__60=11, T__59=12, T__58=13, T__57=14, T__56=15, T__55=16, 
		T__54=17, T__53=18, T__52=19, T__51=20, T__50=21, T__49=22, T__48=23, 
		T__47=24, T__46=25, T__45=26, T__44=27, T__43=28, T__42=29, T__41=30, 
		T__40=31, T__39=32, T__38=33, T__37=34, T__36=35, T__35=36, T__34=37, 
		T__33=38, T__32=39, T__31=40, T__30=41, T__29=42, T__28=43, T__27=44, 
		T__26=45, T__25=46, T__24=47, T__23=48, T__22=49, T__21=50, T__20=51, 
		T__19=52, T__18=53, T__17=54, T__16=55, T__15=56, T__14=57, T__13=58, 
		T__12=59, T__11=60, T__10=61, T__9=62, T__8=63, T__7=64, T__6=65, T__5=66, 
		T__4=67, T__3=68, T__2=69, T__1=70, T__0=71, IF=72, ELSE=73, FOR=74, WHILE=75, 
		SWITCH=76, CONTINUE=77, BREAK=78, GOTO=79, RETURN=80, CASE=81, TRY=82, 
		CATCH=83, ALPHA_NUMERIC=84, PRE_IF=85, PRE_ELSE=86, PRE_ENDIF=87, CPPCOMMENT=88, 
		COMMENT=89, STRING=90, OPENING_CURLY=91, CLOSING_CURLY=92, HEX_LITERAL=93, 
		DECIMAL_LITERAL=94, OCTAL_LITERAL=95, FLOATING_POINT_LITERAL=96, WHITESPACE=97, 
		OTHER=98;
	public static final String[] tokenNames = {
		"<INVALID>", "'&'", "'register'", "'*'", "'['", "'<'", "'--'", "'!='", 
		"'<='", "'<<'", "'do'", "'%'", "'->'", "'auto'", "'union'", "'*='", "')'", 
		"'virtual'", "'signed'", "'explicit'", "'inline'", "'::'", "'unsigned'", 
		"'template'", "'='", "'const'", "'|='", "'new'", "'class'", "'|'", "'!'", 
		"'enum'", "'long'", "']'", "'<<='", "'-='", "'->*'", "'public'", "','", 
		"'-'", "'('", "':'", "'&='", "'private'", "'?'", "'void'", "'>>='", "'+='", 
		"'^='", "'friend'", "'struct'", "'static'", "'++'", "'>>'", "'delete'", 
		"'^'", "'.'", "'+'", "'protected'", "'operator'", "'typedef'", "'volatile'", 
		"';'", "'&&'", "'||'", "'>'", "'%='", "'/='", "'/'", "'=='", "'~'", "'>='", 
		"'if'", "'else'", "'for'", "'while'", "'switch'", "'continue'", "'break'", 
		"'goto'", "'return'", "'case'", "'try'", "'catch'", "ALPHA_NUMERIC", "PRE_IF", 
		"PRE_ELSE", "'#endif'", "CPPCOMMENT", "COMMENT", "STRING", "'{'", "'}'", 
		"HEX_LITERAL", "DECIMAL_LITERAL", "OCTAL_LITERAL", "FLOATING_POINT_LITERAL", 
		"WHITESPACE", "OTHER"
	};
	public static final int
		RULE_statements = 0, RULE_statement = 1, RULE_pre_opener = 2, RULE_pre_else = 3, 
		RULE_pre_closer = 4, RULE_opening_curly = 5, RULE_closing_curly = 6, RULE_non_expr_statement = 7, 
		RULE_block_starter = 8, RULE_non_block_starter = 9, RULE_selection_statement = 10, 
		RULE_if_statement = 11, RULE_else_statement = 12, RULE_switch_statement = 13, 
		RULE_iteration_statement = 14, RULE_for_statement = 15, RULE_while_statement = 16, 
		RULE_do_statement = 17, RULE_for_init_statement = 18, RULE_jump_statement = 19, 
		RULE_break_or_continue = 20, RULE_return_statement = 21, RULE_goto_statement = 22, 
		RULE_try_block = 23, RULE_catch_block = 24, RULE_label = 25, RULE_expr_statement = 26, 
		RULE_statement_water = 27, RULE_condition = 28, RULE_simple_decl = 29, 
		RULE_var_decl = 30, RULE_init_declarator_list = 31, RULE_init_declarator = 32, 
		RULE_assign_expr_w_ = 33, RULE_assign_expr_w__l2 = 34, RULE_class_def = 35, 
		RULE_class_name = 36, RULE_base_classes = 37, RULE_base_class = 38, RULE_type_name = 39, 
		RULE_type_suffix = 40, RULE_base_type = 41, RULE_constant_expr_w_ = 42, 
		RULE_param_decl_specifiers = 43, RULE_parameter_name = 44, RULE_param_type_list = 45, 
		RULE_param_type = 46, RULE_param_type_id = 47, RULE_identifier = 48, RULE_number = 49, 
		RULE_ptrs = 50, RULE_unary_operator = 51, RULE_relational_operator = 52, 
		RULE_constant = 53, RULE_cv_qualifier = 54, RULE_function_decl_specifiers = 55, 
		RULE_class_key = 56, RULE_ptr_operator = 57, RULE_access_specifier = 58, 
		RULE_operator_function_id = 59, RULE_operator = 60, RULE_assignment_operator = 61, 
		RULE_equality_operator = 62, RULE_template_decl_start = 63, RULE_template_param_list = 64, 
		RULE_no_brackets = 65, RULE_no_brackets_curlies_or_squares = 66, RULE_no_brackets_or_semicolon = 67, 
		RULE_no_angle_brackets_or_brackets = 68, RULE_no_curlies = 69, RULE_no_squares = 70, 
		RULE_no_squares_or_semicolon = 71, RULE_no_comma_or_semicolon = 72, RULE_assign_water = 73, 
		RULE_assign_water_l2 = 74, RULE_water = 75, RULE_expr = 76, RULE_assign_expr = 77, 
		RULE_conditional_expression = 78, RULE_or_expression = 79, RULE_and_expression = 80, 
		RULE_inclusive_or_expression = 81, RULE_exclusive_or_expression = 82, 
		RULE_bit_and_expression = 83, RULE_equality_expression = 84, RULE_relational_expression = 85, 
		RULE_shift_expression = 86, RULE_additive_expression = 87, RULE_multiplicative_expression = 88, 
		RULE_cast_expression = 89, RULE_unary_expression = 90, RULE_postfix_expression = 91, 
		RULE_callee = 92, RULE_function_call_tail = 93, RULE_call_template_list = 94, 
		RULE_function_argument_list = 95, RULE_function_argument = 96, RULE_postfix = 97, 
		RULE_primary_expression = 98;
	public static final String[] ruleNames = {
		"statements", "statement", "pre_opener", "pre_else", "pre_closer", "opening_curly", 
		"closing_curly", "non_expr_statement", "block_starter", "non_block_starter", 
		"selection_statement", "if_statement", "else_statement", "switch_statement", 
		"iteration_statement", "for_statement", "while_statement", "do_statement", 
		"for_init_statement", "jump_statement", "break_or_continue", "return_statement", 
		"goto_statement", "try_block", "catch_block", "label", "expr_statement", 
		"statement_water", "condition", "simple_decl", "var_decl", "init_declarator_list", 
		"init_declarator", "assign_expr_w_", "assign_expr_w__l2", "class_def", 
		"class_name", "base_classes", "base_class", "type_name", "type_suffix", 
		"base_type", "constant_expr_w_", "param_decl_specifiers", "parameter_name", 
		"param_type_list", "param_type", "param_type_id", "identifier", "number", 
		"ptrs", "unary_operator", "relational_operator", "constant", "cv_qualifier", 
		"function_decl_specifiers", "class_key", "ptr_operator", "access_specifier", 
		"operator_function_id", "operator", "assignment_operator", "equality_operator", 
		"template_decl_start", "template_param_list", "no_brackets", "no_brackets_curlies_or_squares", 
		"no_brackets_or_semicolon", "no_angle_brackets_or_brackets", "no_curlies", 
		"no_squares", "no_squares_or_semicolon", "no_comma_or_semicolon", "assign_water", 
		"assign_water_l2", "water", "expr", "assign_expr", "conditional_expression", 
		"or_expression", "and_expression", "inclusive_or_expression", "exclusive_or_expression", 
		"bit_and_expression", "equality_expression", "relational_expression", 
		"shift_expression", "additive_expression", "multiplicative_expression", 
		"cast_expression", "unary_expression", "postfix_expression", "callee", 
		"function_call_tail", "call_template_list", "function_argument_list", 
		"function_argument", "postfix", "primary_expression"
	};

	@Override
	public String getGrammarFileName() { return "FunctionGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


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


	            public boolean skipToEndOfObject()
	            {
	                Stack<Object> CurlyStack = new Stack<Object>();
	                Object o = new Object();
	                int t = _input.LA(1);

	                while(t != EOF && !(CurlyStack.empty() && t == CLOSING_CURLY)){
	                    
	                    if(t == PRE_IF){
	                        Stack<Object> ifdefStack = new Stack<Object>();
	                        consume();
	                        t = _input.LA(1);
	                        
	                        while(t != EOF && !(ifdefStack.empty() && (t == PRE_ELSE || t == PRE_ENDIF))){
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
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)) | (1L << (6 - 64)) | (1L << (10 - 64)) | (1L << (14 - 64)) | (1L << (18 - 64)) | (1L << (22 - 64)) | (1L << (23 - 64)) | (1L << (25 - 64)) | (1L << (28 - 64)) | (1L << (30 - 64)) | (1L << (31 - 64)) | (1L << (32 - 64)) | (1L << (37 - 64)) | (1L << (39 - 64)) | (1L << (40 - 64)) | (1L << (43 - 64)) | (1L << (45 - 64)) | (1L << (50 - 64)) | (1L << (52 - 64)) | (1L << (57 - 64)) | (1L << (58 - 64)) | (1L << (60 - 64)) | (1L << (61 - 64)) | (1L << (70 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (STRING - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)))) != 0)) {
				{
				setState(204);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(198); pre_opener();
					}
					break;

				case 2:
					{
					setState(199); pre_closer();
					}
					break;

				case 3:
					{
					setState(200); pre_else();
					preProcSkipToEnd(); 
					}
					break;

				case 4:
					{
					setState(203); statement();
					}
					break;
				}
				}
				setState(208);
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
			setState(214);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(209); opening_curly();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(210); closing_curly();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(211); non_expr_statement();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(212); expr_statement();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(213); statement_water();
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
		enterRule(_localctx, 4, RULE_pre_opener);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216); match(PRE_IF);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 6, RULE_pre_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218); match(PRE_ELSE);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 8, RULE_pre_closer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220); match(PRE_ENDIF);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 10, RULE_opening_curly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222); match(OPENING_CURLY);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 12, RULE_closing_curly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224); match(CLOSING_CURLY);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 14, RULE_non_expr_statement);
		try {
			setState(228);
			switch (_input.LA(1)) {
			case 10:
			case IF:
			case ELSE:
			case FOR:
			case WHILE:
			case SWITCH:
			case TRY:
			case CATCH:
				enterOuterAlt(_localctx, 1);
				{
				setState(226); block_starter();
				}
				break;
			case 14:
			case 18:
			case 22:
			case 23:
			case 25:
			case 28:
			case 31:
			case 32:
			case 37:
			case 43:
			case 45:
			case 50:
			case 58:
			case 60:
			case 61:
			case CONTINUE:
			case BREAK:
			case GOTO:
			case RETURN:
			case CASE:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(227); non_block_starter();
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
		enterRule(_localctx, 16, RULE_block_starter);
		try {
			setState(234);
			switch (_input.LA(1)) {
			case IF:
			case ELSE:
			case SWITCH:
				enterOuterAlt(_localctx, 1);
				{
				setState(230); selection_statement();
				}
				break;
			case 10:
			case FOR:
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(231); iteration_statement();
				}
				break;
			case TRY:
				enterOuterAlt(_localctx, 3);
				{
				setState(232); try_block();
				}
				break;
			case CATCH:
				enterOuterAlt(_localctx, 4);
				{
				setState(233); catch_block();
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
		enterRule(_localctx, 18, RULE_non_block_starter);
		try {
			setState(239);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(236); jump_statement();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(237); simple_decl();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(238); label();
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
		enterRule(_localctx, 20, RULE_selection_statement);
		try {
			setState(244);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(241); if_statement();
				}
				break;
			case ELSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(242); else_statement();
				}
				break;
			case SWITCH:
				enterOuterAlt(_localctx, 3);
				{
				setState(243); switch_statement();
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
		enterRule(_localctx, 22, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246); match(IF);
			setState(247); match(40);
			setState(248); condition();
			setState(249); match(16);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 24, RULE_else_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251); match(ELSE);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 26, RULE_switch_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253); match(SWITCH);
			setState(254); match(40);
			setState(255); condition();
			setState(256); match(16);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 28, RULE_iteration_statement);
		try {
			setState(261);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(258); for_statement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(259); while_statement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 3);
				{
				setState(260); do_statement();
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
		enterRule(_localctx, 30, RULE_for_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263); match(FOR);
			setState(264); match(40);
			setState(265); for_init_statement();
			setState(266); condition();
			setState(267); match(62);
			setState(269);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 6) | (1L << 30) | (1L << 39) | (1L << 40) | (1L << 52) | (1L << 57))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (70 - 70)) | (1L << (ALPHA_NUMERIC - 70)) | (1L << (STRING - 70)) | (1L << (HEX_LITERAL - 70)) | (1L << (DECIMAL_LITERAL - 70)) | (1L << (OCTAL_LITERAL - 70)) | (1L << (FLOATING_POINT_LITERAL - 70)))) != 0)) {
				{
				setState(268); expr();
				}
			}

			setState(271); match(16);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 32, RULE_while_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273); match(WHILE);
			setState(274); match(40);
			setState(275); condition();
			setState(276); match(16);
			}
		}
		catch (RecognitionException re) {
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
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
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
		enterRule(_localctx, 34, RULE_do_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278); match(10);
			setState(279); statement();
			setState(280); match(WHILE);
			setState(281); match(40);
			setState(282); expr();
			setState(283); match(16);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 36, RULE_for_init_statement);
		int _la;
		try {
			setState(290);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(285); simple_decl();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(287);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 6) | (1L << 30) | (1L << 39) | (1L << 40) | (1L << 52) | (1L << 57))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (70 - 70)) | (1L << (ALPHA_NUMERIC - 70)) | (1L << (STRING - 70)) | (1L << (HEX_LITERAL - 70)) | (1L << (DECIMAL_LITERAL - 70)) | (1L << (OCTAL_LITERAL - 70)) | (1L << (FLOATING_POINT_LITERAL - 70)))) != 0)) {
					{
					setState(286); expr();
					}
				}

				setState(289); match(62);
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
		enterRule(_localctx, 38, RULE_jump_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			switch (_input.LA(1)) {
			case CONTINUE:
			case BREAK:
				{
				setState(292); break_or_continue();
				}
				break;
			case RETURN:
				{
				setState(293); return_statement();
				}
				break;
			case GOTO:
				{
				setState(294); goto_statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(297); match(62);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 40, RULE_break_or_continue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			_la = _input.LA(1);
			if ( !(_la==CONTINUE || _la==BREAK) ) {
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
		enterRule(_localctx, 42, RULE_return_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301); match(RETURN);
			setState(303);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 6) | (1L << 30) | (1L << 39) | (1L << 40) | (1L << 52) | (1L << 57))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (70 - 70)) | (1L << (ALPHA_NUMERIC - 70)) | (1L << (STRING - 70)) | (1L << (HEX_LITERAL - 70)) | (1L << (DECIMAL_LITERAL - 70)) | (1L << (OCTAL_LITERAL - 70)) | (1L << (FLOATING_POINT_LITERAL - 70)))) != 0)) {
				{
				setState(302); expr();
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
		enterRule(_localctx, 44, RULE_goto_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305); match(GOTO);
			setState(306); identifier();
			}
		}
		catch (RecognitionException re) {
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
		public Opening_curlyContext opening_curly() {
			return getRuleContext(Opening_curlyContext.class,0);
		}
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
		enterRule(_localctx, 46, RULE_try_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308); match(TRY);
			setState(309); opening_curly();
			}
		}
		catch (RecognitionException re) {
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
		public Param_decl_specifiersContext param_decl_specifiers() {
			return getRuleContext(Param_decl_specifiersContext.class,0);
		}
		public Opening_curlyContext opening_curly() {
			return getRuleContext(Opening_curlyContext.class,0);
		}
		public TerminalNode CATCH() { return getToken(FunctionGrammarParser.CATCH, 0); }
		public Parameter_nameContext parameter_name() {
			return getRuleContext(Parameter_nameContext.class,0);
		}
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
		enterRule(_localctx, 48, RULE_catch_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311); match(CATCH);
			setState(312); match(40);
			setState(313); param_decl_specifiers();
			setState(315);
			_la = _input.LA(1);
			if (((((_la - 37)) & ~0x3f) == 0 && ((1L << (_la - 37)) & ((1L << (37 - 37)) | (1L << (43 - 37)) | (1L << (58 - 37)) | (1L << (ALPHA_NUMERIC - 37)))) != 0)) {
				{
				setState(314); parameter_name();
				}
			}

			setState(317); match(16);
			setState(318); opening_curly();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 50, RULE_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			switch (_input.LA(1)) {
			case CASE:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
				{
				{
				setState(321);
				_la = _input.LA(1);
				if (_la==CASE) {
					{
					setState(320); match(CASE);
					}
				}

				setState(325);
				switch (_input.LA(1)) {
				case ALPHA_NUMERIC:
					{
					setState(323); identifier();
					}
					break;
				case HEX_LITERAL:
				case DECIMAL_LITERAL:
				case OCTAL_LITERAL:
					{
					setState(324); number();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				break;
			case 37:
			case 43:
			case 58:
				{
				setState(327); access_specifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(330); match(41);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 52, RULE_expr_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332); expr();
			setState(333); match(62);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 54, RULE_statement_water);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
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
		enterRule(_localctx, 56, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337); expr();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 58, RULE_simple_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			_la = _input.LA(1);
			if (_la==60) {
				{
				setState(339); match(60);
				}
			}

			setState(343);
			_la = _input.LA(1);
			if (_la==23) {
				{
				setState(342); template_decl_start();
				}
			}

			setState(345); var_decl();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 60, RULE_var_decl);
		try {
			setState(354);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new DeclByTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(347); type_name();
				setState(348); init_declarator_list();
				}
				break;

			case 2:
				_localctx = new DeclByClassContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(350); class_def();
				setState(352);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(351); init_declarator_list();
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
		enterRule(_localctx, 62, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356); init_declarator();
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==38) {
				{
				{
				setState(357); match(38);
				setState(358); init_declarator();
				}
				}
				setState(363);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(364); match(62);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 64, RULE_init_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(367);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(366); ptrs();
				}
			}

			setState(369); identifier();
			setState(371);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(370); type_suffix();
				}
				break;
			}
			}
			setState(380);
			switch (_input.LA(1)) {
			case 40:
				{
				{
				setState(373); match(40);
				setState(375);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 6) | (1L << 30) | (1L << 39) | (1L << 40) | (1L << 52) | (1L << 57))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (70 - 70)) | (1L << (ALPHA_NUMERIC - 70)) | (1L << (STRING - 70)) | (1L << (HEX_LITERAL - 70)) | (1L << (DECIMAL_LITERAL - 70)) | (1L << (OCTAL_LITERAL - 70)) | (1L << (FLOATING_POINT_LITERAL - 70)))) != 0)) {
					{
					setState(374); expr();
					}
				}

				setState(377); match(16);
				}
				}
				break;
			case 24:
				{
				{
				setState(378); match(24);
				setState(379); assign_expr_w_();
				}
				}
				break;
			case 38:
			case 62:
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
		enterRule(_localctx, 66, RULE_assign_expr_w_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 39) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(382); assign_water();
				}
				}
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(410);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4 || _la==40 || _la==OPENING_CURLY) {
				{
				{
				setState(400);
				switch (_input.LA(1)) {
				case OPENING_CURLY:
					{
					setState(388); match(OPENING_CURLY);
					setState(389); assign_expr_w__l2();
					setState(390); match(CLOSING_CURLY);
					}
					break;
				case 40:
					{
					setState(392); match(40);
					setState(393); assign_expr_w__l2();
					setState(394); match(16);
					}
					break;
				case 4:
					{
					setState(396); match(4);
					setState(397); assign_expr_w__l2();
					setState(398); match(33);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(405);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 39) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(402); assign_water();
					}
					}
					setState(407);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(412);
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
		enterRule(_localctx, 68, RULE_assign_expr_w__l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(413); assign_water_l2();
				}
				}
				setState(418);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(441);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4 || _la==40 || _la==OPENING_CURLY) {
				{
				{
				setState(431);
				switch (_input.LA(1)) {
				case OPENING_CURLY:
					{
					setState(419); match(OPENING_CURLY);
					setState(420); assign_expr_w__l2();
					setState(421); match(CLOSING_CURLY);
					}
					break;
				case 40:
					{
					setState(423); match(40);
					setState(424); assign_expr_w__l2();
					setState(425); match(16);
					}
					break;
				case 4:
					{
					setState(427); match(4);
					setState(428); assign_expr_w__l2();
					setState(429); match(33);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(436);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(433); assign_water_l2();
					}
					}
					setState(438);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(443);
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
		enterRule(_localctx, 70, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444); class_key();
			setState(446);
			_la = _input.LA(1);
			if (_la==ALPHA_NUMERIC) {
				{
				setState(445); class_name();
				}
			}

			setState(449);
			_la = _input.LA(1);
			if (_la==41) {
				{
				setState(448); base_classes();
				}
			}

			setState(451); match(OPENING_CURLY);
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
		enterRule(_localctx, 72, RULE_class_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 74, RULE_base_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456); match(41);
			setState(457); base_class();
			setState(462);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==38) {
				{
				{
				setState(458); match(38);
				setState(459); base_class();
				}
				}
				setState(464);
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
		enterRule(_localctx, 76, RULE_base_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			_la = _input.LA(1);
			if (_la==17) {
				{
				setState(465); match(17);
				}
			}

			setState(469);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 37) | (1L << 43) | (1L << 58))) != 0)) {
				{
				setState(468); access_specifier();
				}
			}

			setState(471); identifier();
			}
		}
		catch (RecognitionException re) {
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
		public Template_param_listContext template_param_list(int i) {
			return getRuleContext(Template_param_listContext.class,i);
		}
		public List<Cv_qualifierContext> cv_qualifier() {
			return getRuleContexts(Cv_qualifierContext.class);
		}
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
		public Cv_qualifierContext cv_qualifier(int i) {
			return getRuleContext(Cv_qualifierContext.class,i);
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
		enterRule(_localctx, 78, RULE_type_name);
		int _la;
		try {
			setState(505);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(476);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==25 || _la==61) {
					{
					{
					setState(473); cv_qualifier();
					}
					}
					setState(478);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(482);
				switch (_input.LA(1)) {
				case 14:
				case 28:
				case 31:
				case 50:
					{
					setState(479); class_key();
					}
					break;
				case 22:
					{
					setState(480); match(22);
					}
					break;
				case 18:
					{
					setState(481); match(18);
					}
					break;
				case 32:
				case 45:
				case ALPHA_NUMERIC:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(484); base_type();
				setState(489);
				_la = _input.LA(1);
				if (_la==5) {
					{
					setState(485); match(5);
					setState(486); template_param_list();
					setState(487); match(65);
					}
				}

				setState(501);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==21) {
					{
					{
					setState(491); match(21);
					setState(492); base_type();
					setState(497);
					_la = _input.LA(1);
					if (_la==5) {
						{
						setState(493); match(5);
						setState(494); template_param_list();
						setState(495); match(65);
						}
					}

					}
					}
					setState(503);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(504);
				_la = _input.LA(1);
				if ( !(_la==18 || _la==22) ) {
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
		enterRule(_localctx, 80, RULE_type_suffix);
		try {
			setState(512);
			switch (_input.LA(1)) {
			case 4:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(507); match(4);
				setState(508); constant_expr_w_();
				setState(509); match(33);
				}
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 2);
				{
				setState(511); param_type_list();
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
		public TerminalNode ALPHA_NUMERIC() { return getToken(FunctionGrammarParser.ALPHA_NUMERIC, 0); }
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
		enterRule(_localctx, 82, RULE_base_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(514); match(ALPHA_NUMERIC);
				}
				break;

			case 2:
				{
				setState(515); match(45);
				}
				break;

			case 3:
				{
				setState(516); match(32);
				}
				break;

			case 4:
				{
				setState(517); match(32);
				setState(518); match(32);
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
		enterRule(_localctx, 84, RULE_constant_expr_w_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(521); no_squares();
				}
				}
				setState(526);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(538);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(527); match(4);
				setState(528); constant_expr_w_();
				setState(529); match(33);
				setState(533);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(530); no_squares();
					}
					}
					setState(535);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(540);
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

	public static class Param_decl_specifiersContext extends ParserRuleContext {
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
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
		enterRule(_localctx, 86, RULE_param_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(542);
			_la = _input.LA(1);
			if (_la==2 || _la==13) {
				{
				setState(541);
				_la = _input.LA(1);
				if ( !(_la==2 || _la==13) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(544); type_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 88, RULE_parameter_name);
		try {
			setState(548);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(546); identifier();
				}
				break;
			case 37:
			case 43:
			case 58:
				enterOuterAlt(_localctx, 2);
				{
				setState(547); access_specifier();
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
		enterRule(_localctx, 90, RULE_param_type_list);
		int _la;
		try {
			setState(565);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(550); match(40);
				setState(551); match(45);
				setState(552); match(16);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(553); match(40);
				setState(562);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 13) | (1L << 14) | (1L << 18) | (1L << 22) | (1L << 25) | (1L << 28) | (1L << 31) | (1L << 32) | (1L << 45) | (1L << 50) | (1L << 61))) != 0) || _la==ALPHA_NUMERIC) {
					{
					setState(554); param_type();
					setState(559);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==38) {
						{
						{
						setState(555); match(38);
						setState(556); param_type();
						}
						}
						setState(561);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(564); match(16);
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
		enterRule(_localctx, 92, RULE_param_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(567); param_decl_specifiers();
			setState(568); param_type_id();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 94, RULE_param_type_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(570); ptrs();
				}
			}

			setState(580);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(573); match(40);
				setState(574); param_type_id();
				setState(575); match(16);
				}
				break;

			case 2:
				{
				setState(578);
				_la = _input.LA(1);
				if (((((_la - 37)) & ~0x3f) == 0 && ((1L << (_la - 37)) & ((1L << (37 - 37)) | (1L << (43 - 37)) | (1L << (58 - 37)) | (1L << (ALPHA_NUMERIC - 37)))) != 0)) {
					{
					setState(577); parameter_name();
					}
				}

				}
				break;
			}
			setState(583);
			_la = _input.LA(1);
			if (_la==4 || _la==40) {
				{
				setState(582); type_suffix();
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
		enterRule(_localctx, 96, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(585); match(ALPHA_NUMERIC);
			setState(590);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==21) {
				{
				{
				setState(586); match(21);
				setState(587); match(ALPHA_NUMERIC);
				}
				}
				setState(592);
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
		enterRule(_localctx, 98, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
			_la = _input.LA(1);
			if ( !(((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (HEX_LITERAL - 93)) | (1L << (DECIMAL_LITERAL - 93)) | (1L << (OCTAL_LITERAL - 93)))) != 0)) ) {
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
		enterRule(_localctx, 100, RULE_ptrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(596); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(595); ptr_operator();
				}
				}
				setState(598); 
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
		enterRule(_localctx, 102, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(600);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 30) | (1L << 39) | (1L << 57))) != 0) || _la==70) ) {
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
		enterRule(_localctx, 104, RULE_relational_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(602);
			_la = _input.LA(1);
			if ( !(_la==5 || _la==8 || _la==65 || _la==71) ) {
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
		enterRule(_localctx, 106, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(604);
			_la = _input.LA(1);
			if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (STRING - 90)) | (1L << (HEX_LITERAL - 90)) | (1L << (DECIMAL_LITERAL - 90)) | (1L << (OCTAL_LITERAL - 90)) | (1L << (FLOATING_POINT_LITERAL - 90)))) != 0)) ) {
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

	public static class Cv_qualifierContext extends ParserRuleContext {
		public Cv_qualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cv_qualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterCv_qualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitCv_qualifier(this);
		}
	}

	public final Cv_qualifierContext cv_qualifier() throws RecognitionException {
		Cv_qualifierContext _localctx = new Cv_qualifierContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_cv_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(606);
			_la = _input.LA(1);
			if ( !(_la==25 || _la==61) ) {
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
		enterRule(_localctx, 110, RULE_function_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 17) | (1L << 19) | (1L << 20) | (1L << 49) | (1L << 51))) != 0)) ) {
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
		enterRule(_localctx, 112, RULE_class_key);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(610);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 14) | (1L << 28) | (1L << 31) | (1L << 50))) != 0)) ) {
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
		enterRule(_localctx, 114, RULE_ptr_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(612);
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
		enterRule(_localctx, 116, RULE_access_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 37) | (1L << 43) | (1L << 58))) != 0)) ) {
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
		enterRule(_localctx, 118, RULE_operator_function_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(616); match(59);
			setState(617); operator();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 120, RULE_operator);
		int _la;
		try {
			setState(664);
			switch (_input.LA(1)) {
			case 27:
			case 54:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(619);
				_la = _input.LA(1);
				if ( !(_la==27 || _la==54) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(622);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(620); match(4);
					setState(621); match(33);
					}
				}

				}
				}
				break;
			case 57:
				enterOuterAlt(_localctx, 2);
				{
				setState(624); match(57);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 3);
				{
				setState(625); match(39);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 4);
				{
				setState(626); match(3);
				}
				break;
			case 68:
				enterOuterAlt(_localctx, 5);
				{
				setState(627); match(68);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 6);
				{
				setState(628); match(11);
				}
				break;
			case 55:
				enterOuterAlt(_localctx, 7);
				{
				setState(629); match(55);
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 8);
				{
				setState(630); match(1);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 9);
				{
				setState(631); match(29);
				}
				break;
			case 70:
				enterOuterAlt(_localctx, 10);
				{
				setState(632); match(70);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 11);
				{
				setState(633); match(30);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 12);
				{
				setState(634); match(24);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 13);
				{
				setState(635); match(5);
				}
				break;
			case 65:
				enterOuterAlt(_localctx, 14);
				{
				setState(636); match(65);
				}
				break;
			case 47:
				enterOuterAlt(_localctx, 15);
				{
				setState(637); match(47);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 16);
				{
				setState(638); match(35);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 17);
				{
				setState(639); match(15);
				}
				break;
			case 67:
				enterOuterAlt(_localctx, 18);
				{
				setState(640); match(67);
				}
				break;
			case 66:
				enterOuterAlt(_localctx, 19);
				{
				setState(641); match(66);
				}
				break;
			case 48:
				enterOuterAlt(_localctx, 20);
				{
				setState(642); match(48);
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 21);
				{
				setState(643); match(42);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 22);
				{
				setState(644); match(26);
				}
				break;
			case 53:
				enterOuterAlt(_localctx, 23);
				{
				setState(645); match(53);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 24);
				{
				setState(646); match(9);
				}
				break;
			case 46:
				enterOuterAlt(_localctx, 25);
				{
				setState(647); match(46);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 26);
				{
				setState(648); match(34);
				}
				break;
			case 69:
				enterOuterAlt(_localctx, 27);
				{
				setState(649); match(69);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 28);
				{
				setState(650); match(7);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 29);
				{
				setState(651); match(8);
				}
				break;
			case 71:
				enterOuterAlt(_localctx, 30);
				{
				setState(652); match(71);
				}
				break;
			case 63:
				enterOuterAlt(_localctx, 31);
				{
				setState(653); match(63);
				}
				break;
			case 64:
				enterOuterAlt(_localctx, 32);
				{
				setState(654); match(64);
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 33);
				{
				setState(655); match(52);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 34);
				{
				setState(656); match(6);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 35);
				{
				setState(657); match(38);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 36);
				{
				setState(658); match(36);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 37);
				{
				setState(659); match(12);
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 38);
				{
				setState(660); match(40);
				setState(661); match(16);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 39);
				{
				setState(662); match(4);
				setState(663); match(33);
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
		enterRule(_localctx, 122, RULE_assignment_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(666);
			_la = _input.LA(1);
			if ( !(((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (15 - 15)) | (1L << (24 - 15)) | (1L << (26 - 15)) | (1L << (34 - 15)) | (1L << (35 - 15)) | (1L << (42 - 15)) | (1L << (46 - 15)) | (1L << (47 - 15)) | (1L << (48 - 15)) | (1L << (66 - 15)) | (1L << (67 - 15)))) != 0)) ) {
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
		enterRule(_localctx, 124, RULE_equality_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(668);
			_la = _input.LA(1);
			if ( !(_la==7 || _la==69) ) {
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
		enterRule(_localctx, 126, RULE_template_decl_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(670); match(23);
			setState(671); match(5);
			setState(672); template_param_list();
			setState(673); match(65);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 128, RULE_template_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(686);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				setState(684);
				switch (_input.LA(1)) {
				case 5:
					{
					{
					setState(675); match(5);
					setState(676); template_param_list();
					setState(677); match(65);
					}
					}
					break;
				case 40:
					{
					{
					setState(679); match(40);
					setState(680); template_param_list();
					setState(681); match(16);
					}
					}
					break;
				case 1:
				case 2:
				case 3:
				case 4:
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
				case 11:
				case 12:
				case 13:
				case 14:
				case 15:
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
				case 32:
				case 33:
				case 34:
				case 35:
				case 36:
				case 37:
				case 38:
				case 39:
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
				case 53:
				case 54:
				case 55:
				case 56:
				case 57:
				case 58:
				case 59:
				case 60:
				case 61:
				case 62:
				case 63:
				case 64:
				case 66:
				case 67:
				case 68:
				case 69:
				case 70:
				case 71:
				case IF:
				case ELSE:
				case FOR:
				case WHILE:
				case SWITCH:
				case CONTINUE:
				case BREAK:
				case GOTO:
				case RETURN:
				case CASE:
				case TRY:
				case CATCH:
				case ALPHA_NUMERIC:
				case PRE_IF:
				case PRE_ELSE:
				case PRE_ENDIF:
				case CPPCOMMENT:
				case COMMENT:
				case STRING:
				case OPENING_CURLY:
				case CLOSING_CURLY:
				case HEX_LITERAL:
				case DECIMAL_LITERAL:
				case OCTAL_LITERAL:
				case FLOATING_POINT_LITERAL:
				case WHITESPACE:
				case OTHER:
					{
					setState(683); no_angle_brackets_or_brackets();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(688);
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
		enterRule(_localctx, 130, RULE_no_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(689);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==16 || _la==40) ) {
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
		enterRule(_localctx, 132, RULE_no_brackets_curlies_or_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(691);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 16) | (1L << 33) | (1L << 40))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
		enterRule(_localctx, 134, RULE_no_brackets_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(693);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 16) | (1L << 40) | (1L << 62))) != 0)) ) {
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
		enterRule(_localctx, 136, RULE_no_angle_brackets_or_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(695);
			_la = _input.LA(1);
			if ( _la <= 0 || (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & ((1L << (5 - 5)) | (1L << (16 - 5)) | (1L << (40 - 5)) | (1L << (65 - 5)))) != 0)) ) {
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
		enterRule(_localctx, 138, RULE_no_curlies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(697);
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
		enterRule(_localctx, 140, RULE_no_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(699);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==4 || _la==33) ) {
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
		enterRule(_localctx, 142, RULE_no_squares_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(701);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 33) | (1L << 62))) != 0)) ) {
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
		enterRule(_localctx, 144, RULE_no_comma_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(703);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==38 || _la==62) ) {
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
		enterRule(_localctx, 146, RULE_assign_water);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(705);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 16) | (1L << 33) | (1L << 38) | (1L << 40) | (1L << 62))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
		enterRule(_localctx, 148, RULE_assign_water_l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(707);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 16) | (1L << 33) | (1L << 40))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
		public TerminalNode OTHER() { return getToken(FunctionGrammarParser.OTHER, 0); }
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
		enterRule(_localctx, 150, RULE_water);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(709);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==OTHER) ) {
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
		enterRule(_localctx, 152, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(711); assign_expr();
			setState(714);
			_la = _input.LA(1);
			if (_la==38) {
				{
				setState(712); match(38);
				setState(713); assign_expr();
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
		enterRule(_localctx, 154, RULE_assign_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(716); conditional_expression();
			setState(720);
			_la = _input.LA(1);
			if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (15 - 15)) | (1L << (24 - 15)) | (1L << (26 - 15)) | (1L << (34 - 15)) | (1L << (35 - 15)) | (1L << (42 - 15)) | (1L << (46 - 15)) | (1L << (47 - 15)) | (1L << (48 - 15)) | (1L << (66 - 15)) | (1L << (67 - 15)))) != 0)) {
				{
				setState(717); assignment_operator();
				setState(718); assign_expr();
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
		enterRule(_localctx, 156, RULE_conditional_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(722); or_expression();
			setState(728);
			_la = _input.LA(1);
			if (_la==44) {
				{
				setState(723); match(44);
				setState(724); expr();
				setState(725); match(41);
				setState(726); conditional_expression();
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
		enterRule(_localctx, 158, RULE_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(730); and_expression();
			setState(733);
			_la = _input.LA(1);
			if (_la==64) {
				{
				setState(731); match(64);
				setState(732); or_expression();
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
		enterRule(_localctx, 160, RULE_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(735); inclusive_or_expression();
			setState(738);
			_la = _input.LA(1);
			if (_la==63) {
				{
				setState(736); match(63);
				setState(737); and_expression();
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
		enterRule(_localctx, 162, RULE_inclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(740); exclusive_or_expression();
			setState(743);
			_la = _input.LA(1);
			if (_la==29) {
				{
				setState(741); match(29);
				setState(742); inclusive_or_expression();
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
		enterRule(_localctx, 164, RULE_exclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(745); bit_and_expression();
			setState(748);
			_la = _input.LA(1);
			if (_la==55) {
				{
				setState(746); match(55);
				setState(747); exclusive_or_expression();
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
		enterRule(_localctx, 166, RULE_bit_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(750); equality_expression();
			setState(753);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(751); match(1);
				setState(752); bit_and_expression();
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
		enterRule(_localctx, 168, RULE_equality_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(755); relational_expression();
			setState(759);
			_la = _input.LA(1);
			if (_la==7 || _la==69) {
				{
				setState(756); equality_operator();
				setState(757); equality_expression();
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
		enterRule(_localctx, 170, RULE_relational_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(761); shift_expression();
			setState(765);
			_la = _input.LA(1);
			if (_la==5 || _la==8 || _la==65 || _la==71) {
				{
				setState(762); relational_operator();
				setState(763); relational_expression();
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
		enterRule(_localctx, 172, RULE_shift_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(767); additive_expression();
			setState(770);
			_la = _input.LA(1);
			if (_la==9 || _la==53) {
				{
				setState(768);
				_la = _input.LA(1);
				if ( !(_la==9 || _la==53) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(769); shift_expression();
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
		enterRule(_localctx, 174, RULE_additive_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(772); multiplicative_expression();
			setState(775);
			_la = _input.LA(1);
			if (_la==39 || _la==57) {
				{
				setState(773);
				_la = _input.LA(1);
				if ( !(_la==39 || _la==57) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(774); additive_expression();
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
		enterRule(_localctx, 176, RULE_multiplicative_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(777); cast_expression();
			setState(780);
			_la = _input.LA(1);
			if (_la==3 || _la==11 || _la==68) {
				{
				setState(778);
				_la = _input.LA(1);
				if ( !(_la==3 || _la==11 || _la==68) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(779); cast_expression();
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
		enterRule(_localctx, 178, RULE_cast_expression);
		int _la;
		try {
			setState(794);
			switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(782); match(40);
				setState(783); type_name();
				setState(787);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1 || _la==3) {
					{
					{
					setState(784); ptr_operator();
					}
					}
					setState(789);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(790); match(16);
				setState(791); cast_expression();
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(793); unary_expression();
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
		enterRule(_localctx, 180, RULE_unary_expression);
		int _la;
		try {
			setState(808);
			switch (_input.LA(1)) {
			case 40:
			case ALPHA_NUMERIC:
			case STRING:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(796); postfix_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 2);
				{
				setState(797); match(6);
				setState(798); unary_expression();
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 3);
				{
				setState(799); match(52);
				setState(800); unary_expression();
				}
				break;
			case 1:
			case 3:
			case 30:
			case 39:
			case 57:
			case 70:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(802); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(801); unary_operator();
					}
					}
					setState(804); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 30) | (1L << 39) | (1L << 57))) != 0) || _la==70 );
				setState(806); postfix_expression();
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
		public Function_call_tailContext function_call_tail() {
			return getRuleContext(Function_call_tailContext.class,0);
		}
		public CalleeContext callee() {
			return getRuleContext(CalleeContext.class,0);
		}
		public Postfix_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterPostfix_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitPostfix_expression(this);
		}
	}

	public final Postfix_expressionContext postfix_expression() throws RecognitionException {
		Postfix_expressionContext _localctx = new Postfix_expressionContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_postfix_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(810); callee();
			setState(812);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				{
				setState(811); function_call_tail();
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

	public static class CalleeContext extends ParserRuleContext {
		public PostfixContext postfix(int i) {
			return getRuleContext(PostfixContext.class,i);
		}
		public List<PostfixContext> postfix() {
			return getRuleContexts(PostfixContext.class);
		}
		public Primary_expressionContext primary_expression() {
			return getRuleContext(Primary_expressionContext.class,0);
		}
		public CalleeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callee; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).enterCallee(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionGrammarListener ) ((FunctionGrammarListener)listener).exitCallee(this);
		}
	}

	public final CalleeContext callee() throws RecognitionException {
		CalleeContext _localctx = new CalleeContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_callee);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(814); primary_expression();
			setState(818);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 6) | (1L << 12) | (1L << 52) | (1L << 56))) != 0)) {
				{
				{
				setState(815); postfix();
				}
				}
				setState(820);
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
		enterRule(_localctx, 186, RULE_function_call_tail);
		try {
			setState(825);
			switch (_input.LA(1)) {
			case 5:
				enterOuterAlt(_localctx, 1);
				{
				setState(821); call_template_list();
				setState(822); function_argument_list();
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 2);
				{
				setState(824); function_argument_list();
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
		enterRule(_localctx, 188, RULE_call_template_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(827); match(5);
			setState(828); template_param_list();
			setState(829); match(65);
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
		enterRule(_localctx, 190, RULE_function_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(831); match(40);
			setState(840);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 6) | (1L << 30) | (1L << 39) | (1L << 40) | (1L << 52) | (1L << 57))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (70 - 70)) | (1L << (ALPHA_NUMERIC - 70)) | (1L << (STRING - 70)) | (1L << (HEX_LITERAL - 70)) | (1L << (DECIMAL_LITERAL - 70)) | (1L << (OCTAL_LITERAL - 70)) | (1L << (FLOATING_POINT_LITERAL - 70)))) != 0)) {
				{
				setState(832); function_argument();
				setState(837);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==38) {
					{
					{
					setState(833); match(38);
					setState(834); function_argument();
					}
					}
					setState(839);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(842); match(16);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 192, RULE_function_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(844); assign_expr();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 194, RULE_postfix);
		try {
			setState(858);
			switch (_input.LA(1)) {
			case 4:
			case 12:
			case 56:
				enterOuterAlt(_localctx, 1);
				{
				setState(854);
				switch (_input.LA(1)) {
				case 56:
					{
					setState(846); match(56);
					setState(847); identifier();
					}
					break;
				case 12:
					{
					setState(848); match(12);
					setState(849); identifier();
					}
					break;
				case 4:
					{
					setState(850); match(4);
					setState(851); expr();
					setState(852); match(33);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 2);
				{
				setState(856); match(52);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 3);
				{
				setState(857); match(6);
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
		enterRule(_localctx, 196, RULE_primary_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(866);
			switch (_input.LA(1)) {
			case 40:
				{
				setState(860); match(40);
				setState(861); expr();
				setState(862); match(16);
				}
				break;
			case ALPHA_NUMERIC:
				{
				setState(864); identifier();
				}
				break;
			case STRING:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
				{
				setState(865); constant();
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

	public static final String _serializedATN =
		"\2\3d\u0367\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\t"+
		"F\4G\tG\4H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4"+
		"R\tR\4S\tS\4T\tT\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]"+
		"\t]\4^\t^\4_\t_\4`\t`\4a\ta\4b\tb\4c\tc\4d\td\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\7\2\u00cf\n\2\f\2\16\2\u00d2\13\2\3\3\3\3\3\3\3\3\3\3\5\3\u00d9\n\3\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\5\t\u00e7\n\t\3\n\3\n\3"+
		"\n\3\n\5\n\u00ed\n\n\3\13\3\13\3\13\5\13\u00f2\n\13\3\f\3\f\3\f\5\f\u00f7"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\5\20\u0108\n\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0110\n\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\24\3\24\5\24\u0122\n\24\3\24\5\24\u0125\n\24\3\25\3\25\3\25\5\25\u012a"+
		"\n\25\3\25\3\25\3\26\3\26\3\27\3\27\5\27\u0132\n\27\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\5\32\u013e\n\32\3\32\3\32\3\32\3\33\5\33"+
		"\u0144\n\33\3\33\3\33\5\33\u0148\n\33\3\33\5\33\u014b\n\33\3\33\3\33\3"+
		"\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\5\37\u0157\n\37\3\37\5\37\u015a"+
		"\n\37\3\37\3\37\3 \3 \3 \3 \3 \5 \u0163\n \5 \u0165\n \3!\3!\3!\7!\u016a"+
		"\n!\f!\16!\u016d\13!\3!\3!\3\"\5\"\u0172\n\"\3\"\3\"\5\"\u0176\n\"\3\""+
		"\3\"\5\"\u017a\n\"\3\"\3\"\3\"\5\"\u017f\n\"\3#\7#\u0182\n#\f#\16#\u0185"+
		"\13#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u0193\n#\3#\7#\u0196\n#\f"+
		"#\16#\u0199\13#\7#\u019b\n#\f#\16#\u019e\13#\3$\7$\u01a1\n$\f$\16$\u01a4"+
		"\13$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u01b2\n$\3$\7$\u01b5\n$\f"+
		"$\16$\u01b8\13$\7$\u01ba\n$\f$\16$\u01bd\13$\3%\3%\5%\u01c1\n%\3%\5%\u01c4"+
		"\n%\3%\3%\3%\3&\3&\3\'\3\'\3\'\3\'\7\'\u01cf\n\'\f\'\16\'\u01d2\13\'\3"+
		"(\5(\u01d5\n(\3(\5(\u01d8\n(\3(\3(\3)\7)\u01dd\n)\f)\16)\u01e0\13)\3)"+
		"\3)\3)\5)\u01e5\n)\3)\3)\3)\3)\3)\5)\u01ec\n)\3)\3)\3)\3)\3)\3)\5)\u01f4"+
		"\n)\7)\u01f6\n)\f)\16)\u01f9\13)\3)\5)\u01fc\n)\3*\3*\3*\3*\3*\5*\u0203"+
		"\n*\3+\3+\3+\3+\3+\5+\u020a\n+\3,\7,\u020d\n,\f,\16,\u0210\13,\3,\3,\3"+
		",\3,\7,\u0216\n,\f,\16,\u0219\13,\7,\u021b\n,\f,\16,\u021e\13,\3-\5-\u0221"+
		"\n-\3-\3-\3.\3.\5.\u0227\n.\3/\3/\3/\3/\3/\3/\3/\7/\u0230\n/\f/\16/\u0233"+
		"\13/\5/\u0235\n/\3/\5/\u0238\n/\3\60\3\60\3\60\3\61\5\61\u023e\n\61\3"+
		"\61\3\61\3\61\3\61\3\61\5\61\u0245\n\61\5\61\u0247\n\61\3\61\5\61\u024a"+
		"\n\61\3\62\3\62\3\62\7\62\u024f\n\62\f\62\16\62\u0252\13\62\3\63\3\63"+
		"\3\64\6\64\u0257\n\64\r\64\16\64\u0258\3\65\3\65\3\66\3\66\3\67\3\67\3"+
		"8\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3=\3>\3>\3>\5>\u0271\n>\3>\3>\3>\3"+
		">\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3"+
		">\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\5>\u029b\n>\3?\3?\3@\3@\3A\3"+
		"A\3A\3A\3A\3B\3B\3B\3B\3B\3B\3B\3B\3B\7B\u02af\nB\fB\16B\u02b2\13B\3C"+
		"\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N"+
		"\3N\5N\u02cd\nN\3O\3O\3O\3O\5O\u02d3\nO\3P\3P\3P\3P\3P\3P\5P\u02db\nP"+
		"\3Q\3Q\3Q\5Q\u02e0\nQ\3R\3R\3R\5R\u02e5\nR\3S\3S\3S\5S\u02ea\nS\3T\3T"+
		"\3T\5T\u02ef\nT\3U\3U\3U\5U\u02f4\nU\3V\3V\3V\3V\5V\u02fa\nV\3W\3W\3W"+
		"\3W\5W\u0300\nW\3X\3X\3X\5X\u0305\nX\3Y\3Y\3Y\5Y\u030a\nY\3Z\3Z\3Z\5Z"+
		"\u030f\nZ\3[\3[\3[\7[\u0314\n[\f[\16[\u0317\13[\3[\3[\3[\3[\5[\u031d\n"+
		"[\3\\\3\\\3\\\3\\\3\\\3\\\6\\\u0325\n\\\r\\\16\\\u0326\3\\\3\\\5\\\u032b"+
		"\n\\\3]\3]\5]\u032f\n]\3^\3^\7^\u0333\n^\f^\16^\u0336\13^\3_\3_\3_\3_"+
		"\5_\u033c\n_\3`\3`\3`\3`\3a\3a\3a\3a\7a\u0346\na\fa\16a\u0349\13a\5a\u034b"+
		"\na\3a\3a\3b\3b\3c\3c\3c\3c\3c\3c\3c\3c\5c\u0359\nc\3c\3c\5c\u035d\nc"+
		"\3d\3d\3d\3d\3d\3d\5d\u0365\nd\3d\2e\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080"+
		"\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098"+
		"\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0"+
		"\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\2\37"+
		"\3OP\4\24\24\30\30\4\4\4\17\17\3_a\b\3\3\5\5  ));;HH\6\7\7\n\nCCII\4\\"+
		"\\_b\4\33\33??\6\23\23\25\26\63\63\65\65\6\20\20\36\36!!\64\64\4\3\3\5"+
		"\5\5\'\'--<<\4\35\3588\t\21\21\32\32\34\34$%,,\60\62DE\4\t\tGG\4\22\22"+
		"**\7\6\6\22\22##**]^\5\22\22**@@\6\7\7\22\22**CC\3]^\4\6\6##\5\6\6##@"+
		"@\4((@@\t\6\6\22\22##((**@@]^\7\6\6\22\22##**]^\3dd\4\13\13\67\67\4))"+
		";;\5\5\5\r\rFF\u039a\2\u00d0\3\2\2\2\4\u00d8\3\2\2\2\6\u00da\3\2\2\2\b"+
		"\u00dc\3\2\2\2\n\u00de\3\2\2\2\f\u00e0\3\2\2\2\16\u00e2\3\2\2\2\20\u00e6"+
		"\3\2\2\2\22\u00ec\3\2\2\2\24\u00f1\3\2\2\2\26\u00f6\3\2\2\2\30\u00f8\3"+
		"\2\2\2\32\u00fd\3\2\2\2\34\u00ff\3\2\2\2\36\u0107\3\2\2\2 \u0109\3\2\2"+
		"\2\"\u0113\3\2\2\2$\u0118\3\2\2\2&\u0124\3\2\2\2(\u0129\3\2\2\2*\u012d"+
		"\3\2\2\2,\u012f\3\2\2\2.\u0133\3\2\2\2\60\u0136\3\2\2\2\62\u0139\3\2\2"+
		"\2\64\u014a\3\2\2\2\66\u014e\3\2\2\28\u0151\3\2\2\2:\u0153\3\2\2\2<\u0156"+
		"\3\2\2\2>\u0164\3\2\2\2@\u0166\3\2\2\2B\u0171\3\2\2\2D\u0183\3\2\2\2F"+
		"\u01a2\3\2\2\2H\u01be\3\2\2\2J\u01c8\3\2\2\2L\u01ca\3\2\2\2N\u01d4\3\2"+
		"\2\2P\u01fb\3\2\2\2R\u0202\3\2\2\2T\u0209\3\2\2\2V\u020e\3\2\2\2X\u0220"+
		"\3\2\2\2Z\u0226\3\2\2\2\\\u0237\3\2\2\2^\u0239\3\2\2\2`\u023d\3\2\2\2"+
		"b\u024b\3\2\2\2d\u0253\3\2\2\2f\u0256\3\2\2\2h\u025a\3\2\2\2j\u025c\3"+
		"\2\2\2l\u025e\3\2\2\2n\u0260\3\2\2\2p\u0262\3\2\2\2r\u0264\3\2\2\2t\u0266"+
		"\3\2\2\2v\u0268\3\2\2\2x\u026a\3\2\2\2z\u029a\3\2\2\2|\u029c\3\2\2\2~"+
		"\u029e\3\2\2\2\u0080\u02a0\3\2\2\2\u0082\u02b0\3\2\2\2\u0084\u02b3\3\2"+
		"\2\2\u0086\u02b5\3\2\2\2\u0088\u02b7\3\2\2\2\u008a\u02b9\3\2\2\2\u008c"+
		"\u02bb\3\2\2\2\u008e\u02bd\3\2\2\2\u0090\u02bf\3\2\2\2\u0092\u02c1\3\2"+
		"\2\2\u0094\u02c3\3\2\2\2\u0096\u02c5\3\2\2\2\u0098\u02c7\3\2\2\2\u009a"+
		"\u02c9\3\2\2\2\u009c\u02ce\3\2\2\2\u009e\u02d4\3\2\2\2\u00a0\u02dc\3\2"+
		"\2\2\u00a2\u02e1\3\2\2\2\u00a4\u02e6\3\2\2\2\u00a6\u02eb\3\2\2\2\u00a8"+
		"\u02f0\3\2\2\2\u00aa\u02f5\3\2\2\2\u00ac\u02fb\3\2\2\2\u00ae\u0301\3\2"+
		"\2\2\u00b0\u0306\3\2\2\2\u00b2\u030b\3\2\2\2\u00b4\u031c\3\2\2\2\u00b6"+
		"\u032a\3\2\2\2\u00b8\u032c\3\2\2\2\u00ba\u0330\3\2\2\2\u00bc\u033b\3\2"+
		"\2\2\u00be\u033d\3\2\2\2\u00c0\u0341\3\2\2\2\u00c2\u034e\3\2\2\2\u00c4"+
		"\u035c\3\2\2\2\u00c6\u0364\3\2\2\2\u00c8\u00cf\5\6\4\2\u00c9\u00cf\5\n"+
		"\6\2\u00ca\u00cb\5\b\5\2\u00cb\u00cc\b\2\1\2\u00cc\u00cf\3\2\2\2\u00cd"+
		"\u00cf\5\4\3\2\u00ce\u00c8\3\2\2\2\u00ce\u00c9\3\2\2\2\u00ce\u00ca\3\2"+
		"\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\3\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d9\5\f\7\2"+
		"\u00d4\u00d9\5\16\b\2\u00d5\u00d9\5\20\t\2\u00d6\u00d9\5\66\34\2\u00d7"+
		"\u00d9\58\35\2\u00d8\u00d3\3\2\2\2\u00d8\u00d4\3\2\2\2\u00d8\u00d5\3\2"+
		"\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d9\5\3\2\2\2\u00da\u00db"+
		"\7W\2\2\u00db\7\3\2\2\2\u00dc\u00dd\7X\2\2\u00dd\t\3\2\2\2\u00de\u00df"+
		"\7Y\2\2\u00df\13\3\2\2\2\u00e0\u00e1\7]\2\2\u00e1\r\3\2\2\2\u00e2\u00e3"+
		"\7^\2\2\u00e3\17\3\2\2\2\u00e4\u00e7\5\22\n\2\u00e5\u00e7\5\24\13\2\u00e6"+
		"\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\21\3\2\2\2\u00e8\u00ed\5\26\f"+
		"\2\u00e9\u00ed\5\36\20\2\u00ea\u00ed\5\60\31\2\u00eb\u00ed\5\62\32\2\u00ec"+
		"\u00e8\3\2\2\2\u00ec\u00e9\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2"+
		"\2\2\u00ed\23\3\2\2\2\u00ee\u00f2\5(\25\2\u00ef\u00f2\5<\37\2\u00f0\u00f2"+
		"\5\64\33\2\u00f1\u00ee\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f0\3\2\2\2"+
		"\u00f2\25\3\2\2\2\u00f3\u00f7\5\30\r\2\u00f4\u00f7\5\32\16\2\u00f5\u00f7"+
		"\5\34\17\2\u00f6\u00f3\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f5\3\2\2\2"+
		"\u00f7\27\3\2\2\2\u00f8\u00f9\7J\2\2\u00f9\u00fa\7*\2\2\u00fa\u00fb\5"+
		":\36\2\u00fb\u00fc\7\22\2\2\u00fc\31\3\2\2\2\u00fd\u00fe\7K\2\2\u00fe"+
		"\33\3\2\2\2\u00ff\u0100\7N\2\2\u0100\u0101\7*\2\2\u0101\u0102\5:\36\2"+
		"\u0102\u0103\7\22\2\2\u0103\35\3\2\2\2\u0104\u0108\5 \21\2\u0105\u0108"+
		"\5\"\22\2\u0106\u0108\5$\23\2\u0107\u0104\3\2\2\2\u0107\u0105\3\2\2\2"+
		"\u0107\u0106\3\2\2\2\u0108\37\3\2\2\2\u0109\u010a\7L\2\2\u010a\u010b\7"+
		"*\2\2\u010b\u010c\5&\24\2\u010c\u010d\5:\36\2\u010d\u010f\7@\2\2\u010e"+
		"\u0110\5\u009aN\2\u010f\u010e\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111"+
		"\3\2\2\2\u0111\u0112\7\22\2\2\u0112!\3\2\2\2\u0113\u0114\7M\2\2\u0114"+
		"\u0115\7*\2\2\u0115\u0116\5:\36\2\u0116\u0117\7\22\2\2\u0117#\3\2\2\2"+
		"\u0118\u0119\7\f\2\2\u0119\u011a\5\4\3\2\u011a\u011b\7M\2\2\u011b\u011c"+
		"\7*\2\2\u011c\u011d\5\u009aN\2\u011d\u011e\7\22\2\2\u011e%\3\2\2\2\u011f"+
		"\u0125\5<\37\2\u0120\u0122\5\u009aN\2\u0121\u0120\3\2\2\2\u0121\u0122"+
		"\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0125\7@\2\2\u0124\u011f\3\2\2\2\u0124"+
		"\u0121\3\2\2\2\u0125\'\3\2\2\2\u0126\u012a\5*\26\2\u0127\u012a\5,\27\2"+
		"\u0128\u012a\5.\30\2\u0129\u0126\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u0128"+
		"\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012c\7@\2\2\u012c)\3\2\2\2\u012d\u012e"+
		"\t\2\2\2\u012e+\3\2\2\2\u012f\u0131\7R\2\2\u0130\u0132\5\u009aN\2\u0131"+
		"\u0130\3\2\2\2\u0131\u0132\3\2\2\2\u0132-\3\2\2\2\u0133\u0134\7Q\2\2\u0134"+
		"\u0135\5b\62\2\u0135/\3\2\2\2\u0136\u0137\7T\2\2\u0137\u0138\5\f\7\2\u0138"+
		"\61\3\2\2\2\u0139\u013a\7U\2\2\u013a\u013b\7*\2\2\u013b\u013d\5X-\2\u013c"+
		"\u013e\5Z.\2\u013d\u013c\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013f\3\2\2"+
		"\2\u013f\u0140\7\22\2\2\u0140\u0141\5\f\7\2\u0141\63\3\2\2\2\u0142\u0144"+
		"\7S\2\2\u0143\u0142\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0147\3\2\2\2\u0145"+
		"\u0148\5b\62\2\u0146\u0148\5d\63\2\u0147\u0145\3\2\2\2\u0147\u0146\3\2"+
		"\2\2\u0148\u014b\3\2\2\2\u0149\u014b\5v<\2\u014a\u0143\3\2\2\2\u014a\u0149"+
		"\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014d\7+\2\2\u014d\65\3\2\2\2\u014e"+
		"\u014f\5\u009aN\2\u014f\u0150\7@\2\2\u0150\67\3\2\2\2\u0151\u0152\13\2"+
		"\2\2\u01529\3\2\2\2\u0153\u0154\5\u009aN\2\u0154;\3\2\2\2\u0155\u0157"+
		"\7>\2\2\u0156\u0155\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0159\3\2\2\2\u0158"+
		"\u015a\5\u0080A\2\u0159\u0158\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015b"+
		"\3\2\2\2\u015b\u015c\5> \2\u015c=\3\2\2\2\u015d\u015e\5P)\2\u015e\u015f"+
		"\5@!\2\u015f\u0165\3\2\2\2\u0160\u0162\5H%\2\u0161\u0163\5@!\2\u0162\u0161"+
		"\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0165\3\2\2\2\u0164\u015d\3\2\2\2\u0164"+
		"\u0160\3\2\2\2\u0165?\3\2\2\2\u0166\u016b\5B\"\2\u0167\u0168\7(\2\2\u0168"+
		"\u016a\5B\"\2\u0169\u0167\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169\3\2"+
		"\2\2\u016b\u016c\3\2\2\2\u016c\u016e\3\2\2\2\u016d\u016b\3\2\2\2\u016e"+
		"\u016f\7@\2\2\u016fA\3\2\2\2\u0170\u0172\5f\64\2\u0171\u0170\3\2\2\2\u0171"+
		"\u0172\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0175\5b\62\2\u0174\u0176\5R"+
		"*\2\u0175\u0174\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u017e\3\2\2\2\u0177"+
		"\u0179\7*\2\2\u0178\u017a\5\u009aN\2\u0179\u0178\3\2\2\2\u0179\u017a\3"+
		"\2\2\2\u017a\u017b\3\2\2\2\u017b\u017f\7\22\2\2\u017c\u017d\7\32\2\2\u017d"+
		"\u017f\5D#\2\u017e\u0177\3\2\2\2\u017e\u017c\3\2\2\2\u017e\u017f\3\2\2"+
		"\2\u017fC\3\2\2\2\u0180\u0182\5\u0094K\2\u0181\u0180\3\2\2\2\u0182\u0185"+
		"\3\2\2\2\u0183\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u019c\3\2\2\2\u0185"+
		"\u0183\3\2\2\2\u0186\u0187\7]\2\2\u0187\u0188\5F$\2\u0188\u0189\7^\2\2"+
		"\u0189\u0193\3\2\2\2\u018a\u018b\7*\2\2\u018b\u018c\5F$\2\u018c\u018d"+
		"\7\22\2\2\u018d\u0193\3\2\2\2\u018e\u018f\7\6\2\2\u018f\u0190\5F$\2\u0190"+
		"\u0191\7#\2\2\u0191\u0193\3\2\2\2\u0192\u0186\3\2\2\2\u0192\u018a\3\2"+
		"\2\2\u0192\u018e\3\2\2\2\u0193\u0197\3\2\2\2\u0194\u0196\5\u0094K\2\u0195"+
		"\u0194\3\2\2\2\u0196\u0199\3\2\2\2\u0197\u0195\3\2\2\2\u0197\u0198\3\2"+
		"\2\2\u0198\u019b\3\2\2\2\u0199\u0197\3\2\2\2\u019a\u0192\3\2\2\2\u019b"+
		"\u019e\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019dE\3\2\2\2"+
		"\u019e\u019c\3\2\2\2\u019f\u01a1\5\u0096L\2\u01a0\u019f\3\2\2\2\u01a1"+
		"\u01a4\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01bb\3\2"+
		"\2\2\u01a4\u01a2\3\2\2\2\u01a5\u01a6\7]\2\2\u01a6\u01a7\5F$\2\u01a7\u01a8"+
		"\7^\2\2\u01a8\u01b2\3\2\2\2\u01a9\u01aa\7*\2\2\u01aa\u01ab\5F$\2\u01ab"+
		"\u01ac\7\22\2\2\u01ac\u01b2\3\2\2\2\u01ad\u01ae\7\6\2\2\u01ae\u01af\5"+
		"F$\2\u01af\u01b0\7#\2\2\u01b0\u01b2\3\2\2\2\u01b1\u01a5\3\2\2\2\u01b1"+
		"\u01a9\3\2\2\2\u01b1\u01ad\3\2\2\2\u01b2\u01b6\3\2\2\2\u01b3\u01b5\5\u0096"+
		"L\2\u01b4\u01b3\3\2\2\2\u01b5\u01b8\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b6"+
		"\u01b7\3\2\2\2\u01b7\u01ba\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b9\u01b1\3\2"+
		"\2\2\u01ba\u01bd\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc"+
		"G\3\2\2\2\u01bd\u01bb\3\2\2\2\u01be\u01c0\5r:\2\u01bf\u01c1\5J&\2\u01c0"+
		"\u01bf\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c3\3\2\2\2\u01c2\u01c4\5L"+
		"\'\2\u01c3\u01c2\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5"+
		"\u01c6\7]\2\2\u01c6\u01c7\b%\1\2\u01c7I\3\2\2\2\u01c8\u01c9\5b\62\2\u01c9"+
		"K\3\2\2\2\u01ca\u01cb\7+\2\2\u01cb\u01d0\5N(\2\u01cc\u01cd\7(\2\2\u01cd"+
		"\u01cf\5N(\2\u01ce\u01cc\3\2\2\2\u01cf\u01d2\3\2\2\2\u01d0\u01ce\3\2\2"+
		"\2\u01d0\u01d1\3\2\2\2\u01d1M\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3\u01d5"+
		"\7\23\2\2\u01d4\u01d3\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d7\3\2\2\2"+
		"\u01d6\u01d8\5v<\2\u01d7\u01d6\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d9"+
		"\3\2\2\2\u01d9\u01da\5b\62\2\u01daO\3\2\2\2\u01db\u01dd\5n8\2\u01dc\u01db"+
		"\3\2\2\2\u01dd\u01e0\3\2\2\2\u01de\u01dc\3\2\2\2\u01de\u01df\3\2\2\2\u01df"+
		"\u01e4\3\2\2\2\u01e0\u01de\3\2\2\2\u01e1\u01e5\5r:\2\u01e2\u01e5\7\30"+
		"\2\2\u01e3\u01e5\7\24\2\2\u01e4\u01e1\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4"+
		"\u01e3\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01eb\5T"+
		"+\2\u01e7\u01e8\7\7\2\2\u01e8\u01e9\5\u0082B\2\u01e9\u01ea\7C\2\2\u01ea"+
		"\u01ec\3\2\2\2\u01eb\u01e7\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01f7\3\2"+
		"\2\2\u01ed\u01ee\7\27\2\2\u01ee\u01f3\5T+\2\u01ef\u01f0\7\7\2\2\u01f0"+
		"\u01f1\5\u0082B\2\u01f1\u01f2\7C\2\2\u01f2\u01f4\3\2\2\2\u01f3\u01ef\3"+
		"\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f6\3\2\2\2\u01f5\u01ed\3\2\2\2\u01f6"+
		"\u01f9\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01fc\3\2"+
		"\2\2\u01f9\u01f7\3\2\2\2\u01fa\u01fc\t\3\2\2\u01fb\u01de\3\2\2\2\u01fb"+
		"\u01fa\3\2\2\2\u01fcQ\3\2\2\2\u01fd\u01fe\7\6\2\2\u01fe\u01ff\5V,\2\u01ff"+
		"\u0200\7#\2\2\u0200\u0203\3\2\2\2\u0201\u0203\5\\/\2\u0202\u01fd\3\2\2"+
		"\2\u0202\u0201\3\2\2\2\u0203S\3\2\2\2\u0204\u020a\7V\2\2\u0205\u020a\7"+
		"/\2\2\u0206\u020a\7\"\2\2\u0207\u0208\7\"\2\2\u0208\u020a\7\"\2\2\u0209"+
		"\u0204\3\2\2\2\u0209\u0205\3\2\2\2\u0209\u0206\3\2\2\2\u0209\u0207\3\2"+
		"\2\2\u020aU\3\2\2\2\u020b\u020d\5\u008eH\2\u020c\u020b\3\2\2\2\u020d\u0210"+
		"\3\2\2\2\u020e\u020c\3\2\2\2\u020e\u020f\3\2\2\2\u020f\u021c\3\2\2\2\u0210"+
		"\u020e\3\2\2\2\u0211\u0212\7\6\2\2\u0212\u0213\5V,\2\u0213\u0217\7#\2"+
		"\2\u0214\u0216\5\u008eH\2\u0215\u0214\3\2\2\2\u0216\u0219\3\2\2\2\u0217"+
		"\u0215\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u021b\3\2\2\2\u0219\u0217\3\2"+
		"\2\2\u021a\u0211\3\2\2\2\u021b\u021e\3\2\2\2\u021c\u021a\3\2\2\2\u021c"+
		"\u021d\3\2\2\2\u021dW\3\2\2\2\u021e\u021c\3\2\2\2\u021f\u0221\t\4\2\2"+
		"\u0220\u021f\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u0222\3\2\2\2\u0222\u0223"+
		"\5P)\2\u0223Y\3\2\2\2\u0224\u0227\5b\62\2\u0225\u0227\5v<\2\u0226\u0224"+
		"\3\2\2\2\u0226\u0225\3\2\2\2\u0227[\3\2\2\2\u0228\u0229\7*\2\2\u0229\u022a"+
		"\7/\2\2\u022a\u0238\7\22\2\2\u022b\u0234\7*\2\2\u022c\u0231\5^\60\2\u022d"+
		"\u022e\7(\2\2\u022e\u0230\5^\60\2\u022f\u022d\3\2\2\2\u0230\u0233\3\2"+
		"\2\2\u0231\u022f\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0235\3\2\2\2\u0233"+
		"\u0231\3\2\2\2\u0234\u022c\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u0236\3\2"+
		"\2\2\u0236\u0238\7\22\2\2\u0237\u0228\3\2\2\2\u0237\u022b\3\2\2\2\u0238"+
		"]\3\2\2\2\u0239\u023a\5X-\2\u023a\u023b\5`\61\2\u023b_\3\2\2\2\u023c\u023e"+
		"\5f\64\2\u023d\u023c\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u0246\3\2\2\2\u023f"+
		"\u0240\7*\2\2\u0240\u0241\5`\61\2\u0241\u0242\7\22\2\2\u0242\u0247\3\2"+
		"\2\2\u0243\u0245\5Z.\2\u0244\u0243\3\2\2\2\u0244\u0245\3\2\2\2\u0245\u0247"+
		"\3\2\2\2\u0246\u023f\3\2\2\2\u0246\u0244\3\2\2\2\u0247\u0249\3\2\2\2\u0248"+
		"\u024a\5R*\2\u0249\u0248\3\2\2\2\u0249\u024a\3\2\2\2\u024aa\3\2\2\2\u024b"+
		"\u0250\7V\2\2\u024c\u024d\7\27\2\2\u024d\u024f\7V\2\2\u024e\u024c\3\2"+
		"\2\2\u024f\u0252\3\2\2\2\u0250\u024e\3\2\2\2\u0250\u0251\3\2\2\2\u0251"+
		"c\3\2\2\2\u0252\u0250\3\2\2\2\u0253\u0254\t\5\2\2\u0254e\3\2\2\2\u0255"+
		"\u0257\5t;\2\u0256\u0255\3\2\2\2\u0257\u0258\3\2\2\2\u0258\u0256\3\2\2"+
		"\2\u0258\u0259\3\2\2\2\u0259g\3\2\2\2\u025a\u025b\t\6\2\2\u025bi\3\2\2"+
		"\2\u025c\u025d\t\7\2\2\u025dk\3\2\2\2\u025e\u025f\t\b\2\2\u025fm\3\2\2"+
		"\2\u0260\u0261\t\t\2\2\u0261o\3\2\2\2\u0262\u0263\t\n\2\2\u0263q\3\2\2"+
		"\2\u0264\u0265\t\13\2\2\u0265s\3\2\2\2\u0266\u0267\t\f\2\2\u0267u\3\2"+
		"\2\2\u0268\u0269\t\r\2\2\u0269w\3\2\2\2\u026a\u026b\7=\2\2\u026b\u026c"+
		"\5z>\2\u026cy\3\2\2\2\u026d\u0270\t\16\2\2\u026e\u026f\7\6\2\2\u026f\u0271"+
		"\7#\2\2\u0270\u026e\3\2\2\2\u0270\u0271\3\2\2\2\u0271\u029b\3\2\2\2\u0272"+
		"\u029b\7;\2\2\u0273\u029b\7)\2\2\u0274\u029b\7\5\2\2\u0275\u029b\7F\2"+
		"\2\u0276\u029b\7\r\2\2\u0277\u029b\79\2\2\u0278\u029b\7\3\2\2\u0279\u029b"+
		"\7\37\2\2\u027a\u029b\7H\2\2\u027b\u029b\7 \2\2\u027c\u029b\7\32\2\2\u027d"+
		"\u029b\7\7\2\2\u027e\u029b\7C\2\2\u027f\u029b\7\61\2\2\u0280\u029b\7%"+
		"\2\2\u0281\u029b\7\21\2\2\u0282\u029b\7E\2\2\u0283\u029b\7D\2\2\u0284"+
		"\u029b\7\62\2\2\u0285\u029b\7,\2\2\u0286\u029b\7\34\2\2\u0287\u029b\7"+
		"\67\2\2\u0288\u029b\7\13\2\2\u0289\u029b\7\60\2\2\u028a\u029b\7$\2\2\u028b"+
		"\u029b\7G\2\2\u028c\u029b\7\t\2\2\u028d\u029b\7\n\2\2\u028e\u029b\7I\2"+
		"\2\u028f\u029b\7A\2\2\u0290\u029b\7B\2\2\u0291\u029b\7\66\2\2\u0292\u029b"+
		"\7\b\2\2\u0293\u029b\7(\2\2\u0294\u029b\7&\2\2\u0295\u029b\7\16\2\2\u0296"+
		"\u0297\7*\2\2\u0297\u029b\7\22\2\2\u0298\u0299\7\6\2\2\u0299\u029b\7#"+
		"\2\2\u029a\u026d\3\2\2\2\u029a\u0272\3\2\2\2\u029a\u0273\3\2\2\2\u029a"+
		"\u0274\3\2\2\2\u029a\u0275\3\2\2\2\u029a\u0276\3\2\2\2\u029a\u0277\3\2"+
		"\2\2\u029a\u0278\3\2\2\2\u029a\u0279\3\2\2\2\u029a\u027a\3\2\2\2\u029a"+
		"\u027b\3\2\2\2\u029a\u027c\3\2\2\2\u029a\u027d\3\2\2\2\u029a\u027e\3\2"+
		"\2\2\u029a\u027f\3\2\2\2\u029a\u0280\3\2\2\2\u029a\u0281\3\2\2\2\u029a"+
		"\u0282\3\2\2\2\u029a\u0283\3\2\2\2\u029a\u0284\3\2\2\2\u029a\u0285\3\2"+
		"\2\2\u029a\u0286\3\2\2\2\u029a\u0287\3\2\2\2\u029a\u0288\3\2\2\2\u029a"+
		"\u0289\3\2\2\2\u029a\u028a\3\2\2\2\u029a\u028b\3\2\2\2\u029a\u028c\3\2"+
		"\2\2\u029a\u028d\3\2\2\2\u029a\u028e\3\2\2\2\u029a\u028f\3\2\2\2\u029a"+
		"\u0290\3\2\2\2\u029a\u0291\3\2\2\2\u029a\u0292\3\2\2\2\u029a\u0293\3\2"+
		"\2\2\u029a\u0294\3\2\2\2\u029a\u0295\3\2\2\2\u029a\u0296\3\2\2\2\u029a"+
		"\u0298\3\2\2\2\u029b{\3\2\2\2\u029c\u029d\t\17\2\2\u029d}\3\2\2\2\u029e"+
		"\u029f\t\20\2\2\u029f\177\3\2\2\2\u02a0\u02a1\7\31\2\2\u02a1\u02a2\7\7"+
		"\2\2\u02a2\u02a3\5\u0082B\2\u02a3\u02a4\7C\2\2\u02a4\u0081\3\2\2\2\u02a5"+
		"\u02a6\7\7\2\2\u02a6\u02a7\5\u0082B\2\u02a7\u02a8\7C\2\2\u02a8\u02af\3"+
		"\2\2\2\u02a9\u02aa\7*\2\2\u02aa\u02ab\5\u0082B\2\u02ab\u02ac\7\22\2\2"+
		"\u02ac\u02af\3\2\2\2\u02ad\u02af\5\u008aF\2\u02ae\u02a5\3\2\2\2\u02ae"+
		"\u02a9\3\2\2\2\u02ae\u02ad\3\2\2\2\u02af\u02b2\3\2\2\2\u02b0\u02ae\3\2"+
		"\2\2\u02b0\u02b1\3\2\2\2\u02b1\u0083\3\2\2\2\u02b2\u02b0\3\2\2\2\u02b3"+
		"\u02b4\n\21\2\2\u02b4\u0085\3\2\2\2\u02b5\u02b6\n\22\2\2\u02b6\u0087\3"+
		"\2\2\2\u02b7\u02b8\n\23\2\2\u02b8\u0089\3\2\2\2\u02b9\u02ba\n\24\2\2\u02ba"+
		"\u008b\3\2\2\2\u02bb\u02bc\n\25\2\2\u02bc\u008d\3\2\2\2\u02bd\u02be\n"+
		"\26\2\2\u02be\u008f\3\2\2\2\u02bf\u02c0\n\27\2\2\u02c0\u0091\3\2\2\2\u02c1"+
		"\u02c2\n\30\2\2\u02c2\u0093\3\2\2\2\u02c3\u02c4\n\31\2\2\u02c4\u0095\3"+
		"\2\2\2\u02c5\u02c6\n\32\2\2\u02c6\u0097\3\2\2\2\u02c7\u02c8\n\33\2\2\u02c8"+
		"\u0099\3\2\2\2\u02c9\u02cc\5\u009cO\2\u02ca\u02cb\7(\2\2\u02cb\u02cd\5"+
		"\u009cO\2\u02cc\u02ca\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cd\u009b\3\2\2\2"+
		"\u02ce\u02d2\5\u009eP\2\u02cf\u02d0\5|?\2\u02d0\u02d1\5\u009cO\2\u02d1"+
		"\u02d3\3\2\2\2\u02d2\u02cf\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3\u009d\3\2"+
		"\2\2\u02d4\u02da\5\u00a0Q\2\u02d5\u02d6\7.\2\2\u02d6\u02d7\5\u009aN\2"+
		"\u02d7\u02d8\7+\2\2\u02d8\u02d9\5\u009eP\2\u02d9\u02db\3\2\2\2\u02da\u02d5"+
		"\3\2\2\2\u02da\u02db\3\2\2\2\u02db\u009f\3\2\2\2\u02dc\u02df\5\u00a2R"+
		"\2\u02dd\u02de\7B\2\2\u02de\u02e0\5\u00a0Q\2\u02df\u02dd\3\2\2\2\u02df"+
		"\u02e0\3\2\2\2\u02e0\u00a1\3\2\2\2\u02e1\u02e4\5\u00a4S\2\u02e2\u02e3"+
		"\7A\2\2\u02e3\u02e5\5\u00a2R\2\u02e4\u02e2\3\2\2\2\u02e4\u02e5\3\2\2\2"+
		"\u02e5\u00a3\3\2\2\2\u02e6\u02e9\5\u00a6T\2\u02e7\u02e8\7\37\2\2\u02e8"+
		"\u02ea\5\u00a4S\2\u02e9\u02e7\3\2\2\2\u02e9\u02ea\3\2\2\2\u02ea\u00a5"+
		"\3\2\2\2\u02eb\u02ee\5\u00a8U\2\u02ec\u02ed\79\2\2\u02ed\u02ef\5\u00a6"+
		"T\2\u02ee\u02ec\3\2\2\2\u02ee\u02ef\3\2\2\2\u02ef\u00a7\3\2\2\2\u02f0"+
		"\u02f3\5\u00aaV\2\u02f1\u02f2\7\3\2\2\u02f2\u02f4\5\u00a8U\2\u02f3\u02f1"+
		"\3\2\2\2\u02f3\u02f4\3\2\2\2\u02f4\u00a9\3\2\2\2\u02f5\u02f9\5\u00acW"+
		"\2\u02f6\u02f7\5~@\2\u02f7\u02f8\5\u00aaV\2\u02f8\u02fa\3\2\2\2\u02f9"+
		"\u02f6\3\2\2\2\u02f9\u02fa\3\2\2\2\u02fa\u00ab\3\2\2\2\u02fb\u02ff\5\u00ae"+
		"X\2\u02fc\u02fd\5j\66\2\u02fd\u02fe\5\u00acW\2\u02fe\u0300\3\2\2\2\u02ff"+
		"\u02fc\3\2\2\2\u02ff\u0300\3\2\2\2\u0300\u00ad\3\2\2\2\u0301\u0304\5\u00b0"+
		"Y\2\u0302\u0303\t\34\2\2\u0303\u0305\5\u00aeX\2\u0304\u0302\3\2\2\2\u0304"+
		"\u0305\3\2\2\2\u0305\u00af\3\2\2\2\u0306\u0309\5\u00b2Z\2\u0307\u0308"+
		"\t\35\2\2\u0308\u030a\5\u00b0Y\2\u0309\u0307\3\2\2\2\u0309\u030a\3\2\2"+
		"\2\u030a\u00b1\3\2\2\2\u030b\u030e\5\u00b4[\2\u030c\u030d\t\36\2\2\u030d"+
		"\u030f\5\u00b4[\2\u030e\u030c\3\2\2\2\u030e\u030f\3\2\2\2\u030f\u00b3"+
		"\3\2\2\2\u0310\u0311\7*\2\2\u0311\u0315\5P)\2\u0312\u0314\5t;\2\u0313"+
		"\u0312\3\2\2\2\u0314\u0317\3\2\2\2\u0315\u0313\3\2\2\2\u0315\u0316\3\2"+
		"\2\2\u0316\u0318\3\2\2\2\u0317\u0315\3\2\2\2\u0318\u0319\7\22\2\2\u0319"+
		"\u031a\5\u00b4[\2\u031a\u031d\3\2\2\2\u031b\u031d\5\u00b6\\\2\u031c\u0310"+
		"\3\2\2\2\u031c\u031b\3\2\2\2\u031d\u00b5\3\2\2\2\u031e\u032b\5\u00b8]"+
		"\2\u031f\u0320\7\b\2\2\u0320\u032b\5\u00b6\\\2\u0321\u0322\7\66\2\2\u0322"+
		"\u032b\5\u00b6\\\2\u0323\u0325\5h\65\2\u0324\u0323\3\2\2\2\u0325\u0326"+
		"\3\2\2\2\u0326\u0324\3\2\2\2\u0326\u0327\3\2\2\2\u0327\u0328\3\2\2\2\u0328"+
		"\u0329\5\u00b8]\2\u0329\u032b\3\2\2\2\u032a\u031e\3\2\2\2\u032a\u031f"+
		"\3\2\2\2\u032a\u0321\3\2\2\2\u032a\u0324\3\2\2\2\u032b\u00b7\3\2\2\2\u032c"+
		"\u032e\5\u00ba^\2\u032d\u032f\5\u00bc_\2\u032e\u032d\3\2\2\2\u032e\u032f"+
		"\3\2\2\2\u032f\u00b9\3\2\2\2\u0330\u0334\5\u00c6d\2\u0331\u0333\5\u00c4"+
		"c\2\u0332\u0331\3\2\2\2\u0333\u0336\3\2\2\2\u0334\u0332\3\2\2\2\u0334"+
		"\u0335\3\2\2\2\u0335\u00bb\3\2\2\2\u0336\u0334\3\2\2\2\u0337\u0338\5\u00be"+
		"`\2\u0338\u0339\5\u00c0a\2\u0339\u033c\3\2\2\2\u033a\u033c\5\u00c0a\2"+
		"\u033b\u0337\3\2\2\2\u033b\u033a\3\2\2\2\u033c\u00bd\3\2\2\2\u033d\u033e"+
		"\7\7\2\2\u033e\u033f\5\u0082B\2\u033f\u0340\7C\2\2\u0340\u00bf\3\2\2\2"+
		"\u0341\u034a\7*\2\2\u0342\u0347\5\u00c2b\2\u0343\u0344\7(\2\2\u0344\u0346"+
		"\5\u00c2b\2\u0345\u0343\3\2\2\2\u0346\u0349\3\2\2\2\u0347\u0345\3\2\2"+
		"\2\u0347\u0348\3\2\2\2\u0348\u034b\3\2\2\2\u0349\u0347\3\2\2\2\u034a\u0342"+
		"\3\2\2\2\u034a\u034b\3\2\2\2\u034b\u034c\3\2\2\2\u034c\u034d\7\22\2\2"+
		"\u034d\u00c1\3\2\2\2\u034e\u034f\5\u009cO\2\u034f\u00c3\3\2\2\2\u0350"+
		"\u0351\7:\2\2\u0351\u0359\5b\62\2\u0352\u0353\7\16\2\2\u0353\u0359\5b"+
		"\62\2\u0354\u0355\7\6\2\2\u0355\u0356\5\u009aN\2\u0356\u0357\7#\2\2\u0357"+
		"\u0359\3\2\2\2\u0358\u0350\3\2\2\2\u0358\u0352\3\2\2\2\u0358\u0354\3\2"+
		"\2\2\u0359\u035d\3\2\2\2\u035a\u035d\7\66\2\2\u035b\u035d\7\b\2\2\u035c"+
		"\u0358\3\2\2\2\u035c\u035a\3\2\2\2\u035c\u035b\3\2\2\2\u035d\u00c5\3\2"+
		"\2\2\u035e\u035f\7*\2\2\u035f\u0360\5\u009aN\2\u0360\u0361\7\22\2\2\u0361"+
		"\u0365\3\2\2\2\u0362\u0365\5b\62\2\u0363\u0365\5l\67\2\u0364\u035e\3\2"+
		"\2\2\u0364\u0362\3\2\2\2\u0364\u0363\3\2\2\2\u0365\u00c7\3\2\2\2\\\u00ce"+
		"\u00d0\u00d8\u00e6\u00ec\u00f1\u00f6\u0107\u010f\u0121\u0124\u0129\u0131"+
		"\u013d\u0143\u0147\u014a\u0156\u0159\u0162\u0164\u016b\u0171\u0175\u0179"+
		"\u017e\u0183\u0192\u0197\u019c\u01a2\u01b1\u01b6\u01bb\u01c0\u01c3\u01d0"+
		"\u01d4\u01d7\u01de\u01e4\u01eb\u01f3\u01f7\u01fb\u0202\u0209\u020e\u0217"+
		"\u021c\u0220\u0226\u0231\u0234\u0237\u023d\u0244\u0246\u0249\u0250\u0258"+
		"\u0270\u029a\u02ae\u02b0\u02cc\u02d2\u02da\u02df\u02e4\u02e9\u02ee\u02f3"+
		"\u02f9\u02ff\u0304\u0309\u030e\u0315\u031c\u0326\u032a\u032e\u0334\u033b"+
		"\u0347\u034a\u0358\u035c\u0364";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}
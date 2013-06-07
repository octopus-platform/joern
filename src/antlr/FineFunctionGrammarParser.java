// Generated from FineFunctionGrammar.g4 by ANTLR 4.0.1-SNAPSHOT

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

public class FineFunctionGrammarParser extends Parser<Token> {
	public static final int
		T__54=1, T__53=2, T__52=3, T__51=4, T__50=5, T__49=6, T__48=7, T__47=8, 
		T__46=9, T__45=10, T__44=11, T__43=12, T__42=13, T__41=14, T__40=15, T__39=16, 
		T__38=17, T__37=18, T__36=19, T__35=20, T__34=21, T__33=22, T__32=23, 
		T__31=24, T__30=25, T__29=26, T__28=27, T__27=28, T__26=29, T__25=30, 
		T__24=31, T__23=32, T__22=33, T__21=34, T__20=35, T__19=36, T__18=37, 
		T__17=38, T__16=39, T__15=40, T__14=41, T__13=42, T__12=43, T__11=44, 
		T__10=45, T__9=46, T__8=47, T__7=48, T__6=49, T__5=50, T__4=51, T__3=52, 
		T__2=53, T__1=54, T__0=55, IF=56, ELSE=57, FOR=58, WHILE=59, BREAK=60, 
		CASE=61, CONTINUE=62, SWITCH=63, DO=64, GOTO=65, RETURN=66, TYPEDEF=67, 
		VOID=68, UNSIGNED=69, SIGNED=70, LONG=71, CV_QUALIFIER=72, VIRTUAL=73, 
		TRY=74, CATCH=75, THROW=76, USING=77, NAMESPACE=78, AUTO=79, REGISTER=80, 
		OPERATOR=81, TEMPLATE=82, CLASS_KEY=83, ALPHA_NUMERIC=84, OPENING_CURLY=85, 
		CLOSING_CURLY=86, PRE_IF=87, PRE_ELSE=88, PRE_ENDIF=89, HEX_LITERAL=90, 
		DECIMAL_LITERAL=91, OCTAL_LITERAL=92, FLOATING_POINT_LITERAL=93, CHAR=94, 
		STRING=95, COMMENT=96, WHITESPACE=97, CPPCOMMENT=98, OTHER=99;
	public static final String[] tokenNames = {
		"<INVALID>", "'&'", "'['", "'*'", "'<'", "'--'", "'!='", "'<='", "'<<'", 
		"'%'", "'->'", "'*='", "')'", "'inline'", "'explicit'", "'::'", "'='", 
		"'|='", "'new'", "'|'", "'!'", "'sizeof'", "'<<='", "']'", "'-='", "'->*'", 
		"'public'", "','", "'-'", "':'", "'('", "'&='", "'private'", "'?'", "'>>='", 
		"'+='", "'^='", "'friend'", "'static'", "'++'", "'>>'", "'^'", "'delete'", 
		"'.'", "'+'", "'protected'", "';'", "'&&'", "'||'", "'>'", "'%='", "'/='", 
		"'=='", "'/'", "'~'", "'>='", "'if'", "'else'", "'for'", "'while'", "'break'", 
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
		RULE_jump_statement = 11, RULE_label = 12, RULE_expr_statement = 13, RULE_condition = 14, 
		RULE_unary_operator = 15, RULE_relational_operator = 16, RULE_constant = 17, 
		RULE_function_decl_specifiers = 18, RULE_ptr_operator = 19, RULE_access_specifier = 20, 
		RULE_operator = 21, RULE_assignment_operator = 22, RULE_equality_operator = 23, 
		RULE_template_decl_start = 24, RULE_template_param_list = 25, RULE_no_brackets = 26, 
		RULE_no_brackets_curlies_or_squares = 27, RULE_no_brackets_or_semicolon = 28, 
		RULE_no_angle_brackets_or_brackets = 29, RULE_no_curlies = 30, RULE_no_squares = 31, 
		RULE_no_squares_or_semicolon = 32, RULE_no_comma_or_semicolon = 33, RULE_assign_water = 34, 
		RULE_assign_water_l2 = 35, RULE_water = 36, RULE_expr = 37, RULE_assign_expr = 38, 
		RULE_conditional_expression = 39, RULE_or_expression = 40, RULE_and_expression = 41, 
		RULE_inclusive_or_expression = 42, RULE_exclusive_or_expression = 43, 
		RULE_bit_and_expression = 44, RULE_equality_expression = 45, RULE_relational_expression = 46, 
		RULE_shift_expression = 47, RULE_additive_expression = 48, RULE_multiplicative_expression = 49, 
		RULE_cast_expression = 50, RULE_cast_target = 51, RULE_unary_expression = 52, 
		RULE_inc_dec = 53, RULE_postfix_expression = 54, RULE_function_argument_list = 55, 
		RULE_function_argument = 56, RULE_primary_expression = 57, RULE_init_declarator = 58, 
		RULE_declarator = 59, RULE_type_suffix = 60, RULE_simple_decl = 61, RULE_var_decl = 62, 
		RULE_init_declarator_list = 63, RULE_initializer = 64, RULE_initializer_list = 65, 
		RULE_class_def = 66, RULE_class_name = 67, RULE_base_classes = 68, RULE_base_class = 69, 
		RULE_type_name = 70, RULE_base_type = 71, RULE_param_decl_specifiers = 72, 
		RULE_parameter_name = 73, RULE_param_type_list = 74, RULE_param_type = 75, 
		RULE_param_type_id = 76, RULE_identifier = 77, RULE_number = 78, RULE_ptrs = 79;
	public static final String[] ruleNames = {
		"statements", "statement", "pre_opener", "pre_else", "pre_closer", "opening_curly", 
		"closing_curly", "block_starter", "selection_or_iteration", "do_statement1", 
		"for_init_statement", "jump_statement", "label", "expr_statement", "condition", 
		"unary_operator", "relational_operator", "constant", "function_decl_specifiers", 
		"ptr_operator", "access_specifier", "operator", "assignment_operator", 
		"equality_operator", "template_decl_start", "template_param_list", "no_brackets", 
		"no_brackets_curlies_or_squares", "no_brackets_or_semicolon", "no_angle_brackets_or_brackets", 
		"no_curlies", "no_squares", "no_squares_or_semicolon", "no_comma_or_semicolon", 
		"assign_water", "assign_water_l2", "water", "expr", "assign_expr", "conditional_expression", 
		"or_expression", "and_expression", "inclusive_or_expression", "exclusive_or_expression", 
		"bit_and_expression", "equality_expression", "relational_expression", 
		"shift_expression", "additive_expression", "multiplicative_expression", 
		"cast_expression", "cast_target", "unary_expression", "inc_dec", "postfix_expression", 
		"function_argument_list", "function_argument", "primary_expression", "init_declarator", 
		"declarator", "type_suffix", "simple_decl", "var_decl", "init_declarator_list", 
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


	public FineFunctionGrammarParser(TokenStream<? extends Token> input) {
		super(input);
		_interp = new ParserATNSimulator<Token>(this,_ATN);
	}
	public static class StatementsContext extends ParserRuleContext<Token> {
		public List<? extends StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<? extends Pre_elseContext> pre_else() {
			return getRuleContexts(Pre_elseContext.class);
		}
		public List<? extends Pre_openerContext> pre_opener() {
			return getRuleContexts(Pre_openerContext.class);
		}
		public List<? extends Pre_closerContext> pre_closer() {
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
		public StatementsContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitStatements(this);
		}
	}

	@RuleVersion(0)
	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				setState(166);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(160); pre_opener();
					}
					break;
				case 2:
					{
					setState(161); pre_closer();
					}
					break;
				case 3:
					{
					setState(162); pre_else();
					preProcSkipToEnd(); 
					}
					break;
				case 4:
					{
					setState(165); statement();
					}
					break;
				}
				}
				setState(170);
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

	public static class StatementContext extends ParserRuleContext<Token> {
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
		public StatementContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitStatement(this);
		}
	}

	@RuleVersion(0)
	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(179);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(171); opening_curly();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(172); closing_curly();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(173); block_starter();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(174); jump_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(175); label();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(176); simple_decl();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(177); expr_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(178); water();
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

	public static class Pre_openerContext extends ParserRuleContext<Token> {
		public TerminalNode<Token> PRE_IF() { return getToken(FineFunctionGrammarParser.PRE_IF, 0); }
		public Pre_openerContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pre_opener; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterPre_opener(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitPre_opener(this);
		}
	}

	@RuleVersion(0)
	public final Pre_openerContext pre_opener() throws RecognitionException {
		Pre_openerContext _localctx = new Pre_openerContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pre_opener);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181); match(PRE_IF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pre_elseContext extends ParserRuleContext<Token> {
		public TerminalNode<Token> PRE_ELSE() { return getToken(FineFunctionGrammarParser.PRE_ELSE, 0); }
		public Pre_elseContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pre_else; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterPre_else(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitPre_else(this);
		}
	}

	@RuleVersion(0)
	public final Pre_elseContext pre_else() throws RecognitionException {
		Pre_elseContext _localctx = new Pre_elseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pre_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183); match(PRE_ELSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pre_closerContext extends ParserRuleContext<Token> {
		public TerminalNode<Token> PRE_ENDIF() { return getToken(FineFunctionGrammarParser.PRE_ENDIF, 0); }
		public Pre_closerContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pre_closer; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterPre_closer(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitPre_closer(this);
		}
	}

	@RuleVersion(0)
	public final Pre_closerContext pre_closer() throws RecognitionException {
		Pre_closerContext _localctx = new Pre_closerContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_pre_closer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185); match(PRE_ENDIF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Opening_curlyContext extends ParserRuleContext<Token> {
		public Opening_curlyContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opening_curly; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterOpening_curly(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitOpening_curly(this);
		}
	}

	@RuleVersion(0)
	public final Opening_curlyContext opening_curly() throws RecognitionException {
		Opening_curlyContext _localctx = new Opening_curlyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_opening_curly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187); match(OPENING_CURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Closing_curlyContext extends ParserRuleContext<Token> {
		public Closing_curlyContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closing_curly; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterClosing_curly(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitClosing_curly(this);
		}
	}

	@RuleVersion(0)
	public final Closing_curlyContext closing_curly() throws RecognitionException {
		Closing_curlyContext _localctx = new Closing_curlyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_closing_curly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189); match(CLOSING_CURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Block_starterContext extends ParserRuleContext<Token> {
		public Selection_or_iterationContext selection_or_iteration() {
			return getRuleContext(Selection_or_iterationContext.class,0);
		}
		public Block_starterContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_starter; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterBlock_starter(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitBlock_starter(this);
		}
	}

	@RuleVersion(0)
	public final Block_starterContext block_starter() throws RecognitionException {
		Block_starterContext _localctx = new Block_starterContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_block_starter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191); selection_or_iteration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Selection_or_iterationContext extends ParserRuleContext<Token> {
		public Selection_or_iterationContext(ParserRuleContext<Token> parent, int invokingState) {
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
		public TerminalNode<Token> CATCH() { return getToken(FineFunctionGrammarParser.CATCH, 0); }
		public Catch_statementContext(Selection_or_iterationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterCatch_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitCatch_statement(this);
		}
	}
	public static class Else_statementContext extends Selection_or_iterationContext {
		public TerminalNode<Token> ELSE() { return getToken(FineFunctionGrammarParser.ELSE, 0); }
		public Else_statementContext(Selection_or_iterationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterElse_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitElse_statement(this);
		}
	}
	public static class Switch_statementContext extends Selection_or_iterationContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode<Token> SWITCH() { return getToken(FineFunctionGrammarParser.SWITCH, 0); }
		public Switch_statementContext(Selection_or_iterationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterSwitch_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitSwitch_statement(this);
		}
	}
	public static class Do_statementContext extends Selection_or_iterationContext {
		public TerminalNode<Token> DO() { return getToken(FineFunctionGrammarParser.DO, 0); }
		public Do_statementContext(Selection_or_iterationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterDo_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitDo_statement(this);
		}
	}
	public static class If_statementContext extends Selection_or_iterationContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode<Token> IF() { return getToken(FineFunctionGrammarParser.IF, 0); }
		public If_statementContext(Selection_or_iterationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitIf_statement(this);
		}
	}
	public static class While_statementContext extends Selection_or_iterationContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode<Token> WHILE() { return getToken(FineFunctionGrammarParser.WHILE, 0); }
		public While_statementContext(Selection_or_iterationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterWhile_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitWhile_statement(this);
		}
	}
	public static class For_statementContext extends Selection_or_iterationContext {
		public TerminalNode<Token> FOR() { return getToken(FineFunctionGrammarParser.FOR, 0); }
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
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterFor_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitFor_statement(this);
		}
	}
	public static class Try_statementContext extends Selection_or_iterationContext {
		public TerminalNode<Token> TRY() { return getToken(FineFunctionGrammarParser.TRY, 0); }
		public Try_statementContext(Selection_or_iterationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterTry_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitTry_statement(this);
		}
	}

	@RuleVersion(0)
	public final Selection_or_iterationContext selection_or_iteration() throws RecognitionException {
		Selection_or_iterationContext _localctx = new Selection_or_iterationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_selection_or_iteration);
		int _la;
		try {
			setState(228);
			switch (_input.LA(1)) {
			case TRY:
				_localctx = new Try_statementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(193); match(TRY);
				}
				break;
			case CATCH:
				_localctx = new Catch_statementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(194); match(CATCH);
				setState(195); match(30);
				setState(196); param_type();
				setState(197); match(12);
				}
				break;
			case IF:
				_localctx = new If_statementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(199); match(IF);
				setState(200); match(30);
				setState(201); condition();
				setState(202); match(12);
				}
				break;
			case ELSE:
				_localctx = new Else_statementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(204); match(ELSE);
				}
				break;
			case SWITCH:
				_localctx = new Switch_statementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(205); match(SWITCH);
				setState(206); match(30);
				setState(207); condition();
				setState(208); match(12);
				}
				break;
			case FOR:
				_localctx = new For_statementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(210); match(FOR);
				setState(211); match(30);
				setState(212); for_init_statement();
				setState(214);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 20) | (1L << 21) | (1L << 28) | (1L << 30) | (1L << 39) | (1L << 44) | (1L << 54))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (VOID - 68)) | (1L << (UNSIGNED - 68)) | (1L << (SIGNED - 68)) | (1L << (LONG - 68)) | (1L << (CV_QUALIFIER - 68)) | (1L << (CLASS_KEY - 68)) | (1L << (ALPHA_NUMERIC - 68)) | (1L << (HEX_LITERAL - 68)) | (1L << (DECIMAL_LITERAL - 68)) | (1L << (OCTAL_LITERAL - 68)) | (1L << (FLOATING_POINT_LITERAL - 68)) | (1L << (CHAR - 68)) | (1L << (STRING - 68)))) != 0)) {
					{
					setState(213); condition();
					}
				}

				setState(216); match(46);
				setState(218);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 20) | (1L << 21) | (1L << 28) | (1L << 30) | (1L << 39) | (1L << 44) | (1L << 54))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (ALPHA_NUMERIC - 84)) | (1L << (HEX_LITERAL - 84)) | (1L << (DECIMAL_LITERAL - 84)) | (1L << (OCTAL_LITERAL - 84)) | (1L << (FLOATING_POINT_LITERAL - 84)) | (1L << (CHAR - 84)) | (1L << (STRING - 84)))) != 0)) {
					{
					setState(217); expr();
					}
				}

				setState(220); match(12);
				}
				break;
			case DO:
				_localctx = new Do_statementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(222); match(DO);
				}
				break;
			case WHILE:
				_localctx = new While_statementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(223); match(WHILE);
				setState(224); match(30);
				setState(225); condition();
				setState(226); match(12);
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

	public static class Do_statement1Context extends ParserRuleContext<Token> {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode<Token> DO() { return getToken(FineFunctionGrammarParser.DO, 0); }
		public TerminalNode<Token> WHILE() { return getToken(FineFunctionGrammarParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Do_statement1Context(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_do_statement1; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterDo_statement1(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitDo_statement1(this);
		}
	}

	@RuleVersion(0)
	public final Do_statement1Context do_statement1() throws RecognitionException {
		Do_statement1Context _localctx = new Do_statement1Context(_ctx, getState());
		enterRule(_localctx, 18, RULE_do_statement1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230); match(DO);
			setState(231); statement();
			setState(232); match(WHILE);
			setState(233); match(30);
			setState(234); expr();
			setState(235); match(12);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class For_init_statementContext extends ParserRuleContext<Token> {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Simple_declContext simple_decl() {
			return getRuleContext(Simple_declContext.class,0);
		}
		public For_init_statementContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_init_statement; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterFor_init_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitFor_init_statement(this);
		}
	}

	@RuleVersion(0)
	public final For_init_statementContext for_init_statement() throws RecognitionException {
		For_init_statementContext _localctx = new For_init_statementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_for_init_statement);
		int _la;
		try {
			setState(242);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(237); simple_decl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 20) | (1L << 21) | (1L << 28) | (1L << 30) | (1L << 39) | (1L << 44) | (1L << 54))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (ALPHA_NUMERIC - 84)) | (1L << (HEX_LITERAL - 84)) | (1L << (DECIMAL_LITERAL - 84)) | (1L << (OCTAL_LITERAL - 84)) | (1L << (FLOATING_POINT_LITERAL - 84)) | (1L << (CHAR - 84)) | (1L << (STRING - 84)))) != 0)) {
					{
					setState(238); expr();
					}
				}

				setState(241); match(46);
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

	public static class Jump_statementContext extends ParserRuleContext<Token> {
		public Jump_statementContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jump_statement; }
	 
		public Jump_statementContext() { }
		public void copyFrom(Jump_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GotoStatementContext extends Jump_statementContext {
		public TerminalNode<Token> GOTO() { return getToken(FineFunctionGrammarParser.GOTO, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public GotoStatementContext(Jump_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterGotoStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitGotoStatement(this);
		}
	}
	public static class ReturnStatementContext extends Jump_statementContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode<Token> RETURN() { return getToken(FineFunctionGrammarParser.RETURN, 0); }
		public ReturnStatementContext(Jump_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitReturnStatement(this);
		}
	}
	public static class BreakStatementContext extends Jump_statementContext {
		public TerminalNode<Token> BREAK() { return getToken(FineFunctionGrammarParser.BREAK, 0); }
		public BreakStatementContext(Jump_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitBreakStatement(this);
		}
	}
	public static class ContinueStatementContext extends Jump_statementContext {
		public TerminalNode<Token> CONTINUE() { return getToken(FineFunctionGrammarParser.CONTINUE, 0); }
		public ContinueStatementContext(Jump_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitContinueStatement(this);
		}
	}

	@RuleVersion(0)
	public final Jump_statementContext jump_statement() throws RecognitionException {
		Jump_statementContext _localctx = new Jump_statementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_jump_statement);
		int _la;
		try {
			setState(257);
			switch (_input.LA(1)) {
			case BREAK:
				_localctx = new BreakStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(244); match(BREAK);
				setState(245); match(46);
				}
				break;
			case CONTINUE:
				_localctx = new ContinueStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(246); match(CONTINUE);
				setState(247); match(46);
				}
				break;
			case GOTO:
				_localctx = new GotoStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(248); match(GOTO);
				setState(249); identifier();
				setState(250); match(46);
				}
				break;
			case RETURN:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(252); match(RETURN);
				setState(254);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 20) | (1L << 21) | (1L << 28) | (1L << 30) | (1L << 39) | (1L << 44) | (1L << 54))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (ALPHA_NUMERIC - 84)) | (1L << (HEX_LITERAL - 84)) | (1L << (DECIMAL_LITERAL - 84)) | (1L << (OCTAL_LITERAL - 84)) | (1L << (FLOATING_POINT_LITERAL - 84)) | (1L << (CHAR - 84)) | (1L << (STRING - 84)))) != 0)) {
					{
					setState(253); expr();
					}
				}

				setState(256); match(46);
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

	public static class LabelContext extends ParserRuleContext<Token> {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public Access_specifierContext access_specifier() {
			return getRuleContext(Access_specifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode<Token> CASE() { return getToken(FineFunctionGrammarParser.CASE, 0); }
		public LabelContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitLabel(this);
		}
	}

	@RuleVersion(0)
	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			_la = _input.LA(1);
			if (_la==CASE) {
				{
				setState(259); match(CASE);
				}
			}

			setState(265);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				{
				setState(262); identifier();
				}
				break;
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
				{
				setState(263); number();
				}
				break;
			case 26:
			case 32:
			case 45:
				{
				setState(264); access_specifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(267); match(29);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_statementContext extends ParserRuleContext<Token> {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_statementContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_statement; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterExpr_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitExpr_statement(this);
		}
	}

	@RuleVersion(0)
	public final Expr_statementContext expr_statement() throws RecognitionException {
		Expr_statementContext _localctx = new Expr_statementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 20) | (1L << 21) | (1L << 28) | (1L << 30) | (1L << 39) | (1L << 44) | (1L << 54))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (ALPHA_NUMERIC - 84)) | (1L << (HEX_LITERAL - 84)) | (1L << (DECIMAL_LITERAL - 84)) | (1L << (OCTAL_LITERAL - 84)) | (1L << (FLOATING_POINT_LITERAL - 84)) | (1L << (CHAR - 84)) | (1L << (STRING - 84)))) != 0)) {
				{
				setState(269); expr();
				}
			}

			setState(272); match(46);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext<Token> {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public ConditionContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitCondition(this);
		}
	}

	@RuleVersion(0)
	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_condition);
		try {
			setState(280);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(274); expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(275); type_name();
				setState(276); declarator();
				setState(277); match(16);
				setState(278); assign_expr();
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

	public static class Unary_operatorContext extends ParserRuleContext<Token> {
		public Unary_operatorContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitUnary_operator(this);
		}
	}

	@RuleVersion(0)
	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 20) | (1L << 28) | (1L << 44) | (1L << 54))) != 0)) ) {
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

	public static class Relational_operatorContext extends ParserRuleContext<Token> {
		public Relational_operatorContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_operator; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterRelational_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitRelational_operator(this);
		}
	}

	@RuleVersion(0)
	public final Relational_operatorContext relational_operator() throws RecognitionException {
		Relational_operatorContext _localctx = new Relational_operatorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_relational_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 49) | (1L << 55))) != 0)) ) {
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

	public static class ConstantContext extends ParserRuleContext<Token> {
		public TerminalNode<Token> CHAR() { return getToken(FineFunctionGrammarParser.CHAR, 0); }
		public TerminalNode<Token> OCTAL_LITERAL() { return getToken(FineFunctionGrammarParser.OCTAL_LITERAL, 0); }
		public TerminalNode<Token> HEX_LITERAL() { return getToken(FineFunctionGrammarParser.HEX_LITERAL, 0); }
		public TerminalNode<Token> FLOATING_POINT_LITERAL() { return getToken(FineFunctionGrammarParser.FLOATING_POINT_LITERAL, 0); }
		public TerminalNode<Token> DECIMAL_LITERAL() { return getToken(FineFunctionGrammarParser.DECIMAL_LITERAL, 0); }
		public TerminalNode<Token> STRING() { return getToken(FineFunctionGrammarParser.STRING, 0); }
		public ConstantContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitConstant(this);
		}
	}

	@RuleVersion(0)
	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			_la = _input.LA(1);
			if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (HEX_LITERAL - 90)) | (1L << (DECIMAL_LITERAL - 90)) | (1L << (OCTAL_LITERAL - 90)) | (1L << (FLOATING_POINT_LITERAL - 90)) | (1L << (CHAR - 90)) | (1L << (STRING - 90)))) != 0)) ) {
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

	public static class Function_decl_specifiersContext extends ParserRuleContext<Token> {
		public Function_decl_specifiersContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_decl_specifiers; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterFunction_decl_specifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitFunction_decl_specifiers(this);
		}
	}

	@RuleVersion(0)
	public final Function_decl_specifiersContext function_decl_specifiers() throws RecognitionException {
		Function_decl_specifiersContext _localctx = new Function_decl_specifiersContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_function_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			_la = _input.LA(1);
			if ( !(((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & ((1L << (13 - 13)) | (1L << (14 - 13)) | (1L << (37 - 13)) | (1L << (38 - 13)) | (1L << (VIRTUAL - 13)))) != 0)) ) {
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

	public static class Ptr_operatorContext extends ParserRuleContext<Token> {
		public Ptr_operatorContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ptr_operator; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterPtr_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitPtr_operator(this);
		}
	}

	@RuleVersion(0)
	public final Ptr_operatorContext ptr_operator() throws RecognitionException {
		Ptr_operatorContext _localctx = new Ptr_operatorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_ptr_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
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

	public static class Access_specifierContext extends ParserRuleContext<Token> {
		public Access_specifierContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_access_specifier; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterAccess_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitAccess_specifier(this);
		}
	}

	@RuleVersion(0)
	public final Access_specifierContext access_specifier() throws RecognitionException {
		Access_specifierContext _localctx = new Access_specifierContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_access_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 26) | (1L << 32) | (1L << 45))) != 0)) ) {
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

	public static class OperatorContext extends ParserRuleContext<Token> {
		public OperatorContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitOperator(this);
		}
	}

	@RuleVersion(0)
	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_operator);
		int _la;
		try {
			setState(339);
			switch (_input.LA(1)) {
			case 18:
			case 42:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(294);
				_la = _input.LA(1);
				if ( !(_la==18 || _la==42) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(297);
				_la = _input.LA(1);
				if (_la==2) {
					{
					setState(295); match(2);
					setState(296); match(23);
					}
				}

				}
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 2);
				{
				setState(299); match(44);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 3);
				{
				setState(300); match(28);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 4);
				{
				setState(301); match(3);
				}
				break;
			case 53:
				enterOuterAlt(_localctx, 5);
				{
				setState(302); match(53);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 6);
				{
				setState(303); match(9);
				}
				break;
			case 41:
				enterOuterAlt(_localctx, 7);
				{
				setState(304); match(41);
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 8);
				{
				setState(305); match(1);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 9);
				{
				setState(306); match(19);
				}
				break;
			case 54:
				enterOuterAlt(_localctx, 10);
				{
				setState(307); match(54);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 11);
				{
				setState(308); match(20);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 12);
				{
				setState(309); match(16);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 13);
				{
				setState(310); match(4);
				}
				break;
			case 49:
				enterOuterAlt(_localctx, 14);
				{
				setState(311); match(49);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 15);
				{
				setState(312); match(35);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 16);
				{
				setState(313); match(24);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 17);
				{
				setState(314); match(11);
				}
				break;
			case 51:
				enterOuterAlt(_localctx, 18);
				{
				setState(315); match(51);
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 19);
				{
				setState(316); match(50);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 20);
				{
				setState(317); match(36);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 21);
				{
				setState(318); match(31);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 22);
				{
				setState(319); match(17);
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 23);
				{
				setState(320); match(40);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 24);
				{
				setState(321); match(8);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 25);
				{
				setState(322); match(34);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 26);
				{
				setState(323); match(22);
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 27);
				{
				setState(324); match(52);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 28);
				{
				setState(325); match(6);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 29);
				{
				setState(326); match(7);
				}
				break;
			case 55:
				enterOuterAlt(_localctx, 30);
				{
				setState(327); match(55);
				}
				break;
			case 47:
				enterOuterAlt(_localctx, 31);
				{
				setState(328); match(47);
				}
				break;
			case 48:
				enterOuterAlt(_localctx, 32);
				{
				setState(329); match(48);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 33);
				{
				setState(330); match(39);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 34);
				{
				setState(331); match(5);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 35);
				{
				setState(332); match(27);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 36);
				{
				setState(333); match(25);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 37);
				{
				setState(334); match(10);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 38);
				{
				setState(335); match(30);
				setState(336); match(12);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 39);
				{
				setState(337); match(2);
				setState(338); match(23);
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

	public static class Assignment_operatorContext extends ParserRuleContext<Token> {
		public Assignment_operatorContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_operator; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterAssignment_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitAssignment_operator(this);
		}
	}

	@RuleVersion(0)
	public final Assignment_operatorContext assignment_operator() throws RecognitionException {
		Assignment_operatorContext _localctx = new Assignment_operatorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_assignment_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 16) | (1L << 17) | (1L << 22) | (1L << 24) | (1L << 31) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 50) | (1L << 51))) != 0)) ) {
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

	public static class Equality_operatorContext extends ParserRuleContext<Token> {
		public Equality_operatorContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_operator; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterEquality_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitEquality_operator(this);
		}
	}

	@RuleVersion(0)
	public final Equality_operatorContext equality_operator() throws RecognitionException {
		Equality_operatorContext _localctx = new Equality_operatorContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_equality_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			_la = _input.LA(1);
			if ( !(_la==6 || _la==52) ) {
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

	public static class Template_decl_startContext extends ParserRuleContext<Token> {
		public Template_param_listContext template_param_list() {
			return getRuleContext(Template_param_listContext.class,0);
		}
		public TerminalNode<Token> TEMPLATE() { return getToken(FineFunctionGrammarParser.TEMPLATE, 0); }
		public Template_decl_startContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_decl_start; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterTemplate_decl_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitTemplate_decl_start(this);
		}
	}

	@RuleVersion(0)
	public final Template_decl_startContext template_decl_start() throws RecognitionException {
		Template_decl_startContext _localctx = new Template_decl_startContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_template_decl_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345); match(TEMPLATE);
			setState(346); match(4);
			setState(347); template_param_list();
			setState(348); match(49);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Template_param_listContext extends ParserRuleContext<Token> {
		public Template_param_listContext template_param_list(int i) {
			return getRuleContext(Template_param_listContext.class,i);
		}
		public No_angle_brackets_or_bracketsContext no_angle_brackets_or_brackets(int i) {
			return getRuleContext(No_angle_brackets_or_bracketsContext.class,i);
		}
		public List<? extends No_angle_brackets_or_bracketsContext> no_angle_brackets_or_brackets() {
			return getRuleContexts(No_angle_brackets_or_bracketsContext.class);
		}
		public List<? extends Template_param_listContext> template_param_list() {
			return getRuleContexts(Template_param_listContext.class);
		}
		public Template_param_listContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_param_list; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterTemplate_param_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitTemplate_param_list(this);
		}
	}

	@RuleVersion(0)
	public final Template_param_listContext template_param_list() throws RecognitionException {
		Template_param_listContext _localctx = new Template_param_listContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_template_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(359);
				switch (_input.LA(1)) {
				case 4:
					{
					{
					setState(350); match(4);
					setState(351); template_param_list();
					setState(352); match(49);
					}
					}
					break;
				case 30:
					{
					{
					setState(354); match(30);
					setState(355); template_param_list();
					setState(356); match(12);
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
				case 29:
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
				case 48:
				case 50:
				case 51:
				case 52:
				case 53:
				case 54:
				case 55:
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
					setState(358); no_angle_brackets_or_brackets();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(361); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class No_bracketsContext extends ParserRuleContext<Token> {
		public No_bracketsContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_brackets; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterNo_brackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitNo_brackets(this);
		}
	}

	@RuleVersion(0)
	public final No_bracketsContext no_brackets() throws RecognitionException {
		No_bracketsContext _localctx = new No_bracketsContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_no_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==12 || _la==30) ) {
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

	public static class No_brackets_curlies_or_squaresContext extends ParserRuleContext<Token> {
		public No_brackets_curlies_or_squaresContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_brackets_curlies_or_squares; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterNo_brackets_curlies_or_squares(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitNo_brackets_curlies_or_squares(this);
		}
	}

	@RuleVersion(0)
	public final No_brackets_curlies_or_squaresContext no_brackets_curlies_or_squares() throws RecognitionException {
		No_brackets_curlies_or_squaresContext _localctx = new No_brackets_curlies_or_squaresContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_no_brackets_curlies_or_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 12) | (1L << 23) | (1L << 30))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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

	public static class No_brackets_or_semicolonContext extends ParserRuleContext<Token> {
		public No_brackets_or_semicolonContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_brackets_or_semicolon; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterNo_brackets_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitNo_brackets_or_semicolon(this);
		}
	}

	@RuleVersion(0)
	public final No_brackets_or_semicolonContext no_brackets_or_semicolon() throws RecognitionException {
		No_brackets_or_semicolonContext _localctx = new No_brackets_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_no_brackets_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 30) | (1L << 46))) != 0)) ) {
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

	public static class No_angle_brackets_or_bracketsContext extends ParserRuleContext<Token> {
		public No_angle_brackets_or_bracketsContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_angle_brackets_or_brackets; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterNo_angle_brackets_or_brackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitNo_angle_brackets_or_brackets(this);
		}
	}

	@RuleVersion(0)
	public final No_angle_brackets_or_bracketsContext no_angle_brackets_or_brackets() throws RecognitionException {
		No_angle_brackets_or_bracketsContext _localctx = new No_angle_brackets_or_bracketsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_no_angle_brackets_or_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 12) | (1L << 30) | (1L << 49))) != 0)) ) {
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

	public static class No_curliesContext extends ParserRuleContext<Token> {
		public No_curliesContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_curlies; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterNo_curlies(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitNo_curlies(this);
		}
	}

	@RuleVersion(0)
	public final No_curliesContext no_curlies() throws RecognitionException {
		No_curliesContext _localctx = new No_curliesContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_no_curlies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
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

	public static class No_squaresContext extends ParserRuleContext<Token> {
		public No_squaresContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_squares; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterNo_squares(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitNo_squares(this);
		}
	}

	@RuleVersion(0)
	public final No_squaresContext no_squares() throws RecognitionException {
		No_squaresContext _localctx = new No_squaresContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_no_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==2 || _la==23) ) {
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

	public static class No_squares_or_semicolonContext extends ParserRuleContext<Token> {
		public No_squares_or_semicolonContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_squares_or_semicolon; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterNo_squares_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitNo_squares_or_semicolon(this);
		}
	}

	@RuleVersion(0)
	public final No_squares_or_semicolonContext no_squares_or_semicolon() throws RecognitionException {
		No_squares_or_semicolonContext _localctx = new No_squares_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_no_squares_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 23) | (1L << 46))) != 0)) ) {
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

	public static class No_comma_or_semicolonContext extends ParserRuleContext<Token> {
		public No_comma_or_semicolonContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_comma_or_semicolon; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterNo_comma_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitNo_comma_or_semicolon(this);
		}
	}

	@RuleVersion(0)
	public final No_comma_or_semicolonContext no_comma_or_semicolon() throws RecognitionException {
		No_comma_or_semicolonContext _localctx = new No_comma_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_no_comma_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==27 || _la==46) ) {
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

	public static class Assign_waterContext extends ParserRuleContext<Token> {
		public Assign_waterContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_water; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterAssign_water(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitAssign_water(this);
		}
	}

	@RuleVersion(0)
	public final Assign_waterContext assign_water() throws RecognitionException {
		Assign_waterContext _localctx = new Assign_waterContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_assign_water);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 12) | (1L << 23) | (1L << 27) | (1L << 30) | (1L << 46))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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

	public static class Assign_water_l2Context extends ParserRuleContext<Token> {
		public Assign_water_l2Context(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_water_l2; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterAssign_water_l2(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitAssign_water_l2(this);
		}
	}

	@RuleVersion(0)
	public final Assign_water_l2Context assign_water_l2() throws RecognitionException {
		Assign_water_l2Context _localctx = new Assign_water_l2Context(_ctx, getState());
		enterRule(_localctx, 70, RULE_assign_water_l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 12) | (1L << 23) | (1L << 30))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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

	public static class WaterContext extends ParserRuleContext<Token> {
		public WaterContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_water; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterWater(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitWater(this);
		}
	}

	@RuleVersion(0)
	public final WaterContext water() throws RecognitionException {
		WaterContext _localctx = new WaterContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_water);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
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

	public static class ExprContext extends ParserRuleContext<Token> {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public ExprContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitExpr(this);
		}
	}

	@RuleVersion(0)
	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385); assign_expr();
			setState(388);
			_la = _input.LA(1);
			if (_la==27) {
				{
				setState(386); match(27);
				setState(387); expr();
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

	public static class Assign_exprContext extends ParserRuleContext<Token> {
		public Assignment_operatorContext assignment_operator() {
			return getRuleContext(Assignment_operatorContext.class,0);
		}
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public Assign_exprContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_expr; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterAssign_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitAssign_expr(this);
		}
	}

	@RuleVersion(0)
	public final Assign_exprContext assign_expr() throws RecognitionException {
		Assign_exprContext _localctx = new Assign_exprContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_assign_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390); conditional_expression();
			setState(394);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 16) | (1L << 17) | (1L << 22) | (1L << 24) | (1L << 31) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 50) | (1L << 51))) != 0)) {
				{
				setState(391); assignment_operator();
				setState(392); assign_expr();
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

	public static class Conditional_expressionContext extends ParserRuleContext<Token> {
		public Or_expressionContext or_expression() {
			return getRuleContext(Or_expressionContext.class,0);
		}
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Conditional_expressionContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_expression; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterConditional_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitConditional_expression(this);
		}
	}

	@RuleVersion(0)
	public final Conditional_expressionContext conditional_expression() throws RecognitionException {
		Conditional_expressionContext _localctx = new Conditional_expressionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_conditional_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396); or_expression();
			setState(402);
			_la = _input.LA(1);
			if (_la==33) {
				{
				setState(397); match(33);
				setState(398); expr();
				setState(399); match(29);
				setState(400); conditional_expression();
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

	public static class Or_expressionContext extends ParserRuleContext<Token> {
		public Or_expressionContext or_expression() {
			return getRuleContext(Or_expressionContext.class,0);
		}
		public And_expressionContext and_expression() {
			return getRuleContext(And_expressionContext.class,0);
		}
		public Or_expressionContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_expression; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterOr_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitOr_expression(this);
		}
	}

	@RuleVersion(0)
	public final Or_expressionContext or_expression() throws RecognitionException {
		Or_expressionContext _localctx = new Or_expressionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404); and_expression();
			setState(407);
			_la = _input.LA(1);
			if (_la==48) {
				{
				setState(405); match(48);
				setState(406); or_expression();
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

	public static class And_expressionContext extends ParserRuleContext<Token> {
		public Inclusive_or_expressionContext inclusive_or_expression() {
			return getRuleContext(Inclusive_or_expressionContext.class,0);
		}
		public And_expressionContext and_expression() {
			return getRuleContext(And_expressionContext.class,0);
		}
		public And_expressionContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expression; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterAnd_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitAnd_expression(this);
		}
	}

	@RuleVersion(0)
	public final And_expressionContext and_expression() throws RecognitionException {
		And_expressionContext _localctx = new And_expressionContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409); inclusive_or_expression();
			setState(412);
			_la = _input.LA(1);
			if (_la==47) {
				{
				setState(410); match(47);
				setState(411); and_expression();
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

	public static class Inclusive_or_expressionContext extends ParserRuleContext<Token> {
		public Inclusive_or_expressionContext inclusive_or_expression() {
			return getRuleContext(Inclusive_or_expressionContext.class,0);
		}
		public Exclusive_or_expressionContext exclusive_or_expression() {
			return getRuleContext(Exclusive_or_expressionContext.class,0);
		}
		public Inclusive_or_expressionContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inclusive_or_expression; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterInclusive_or_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitInclusive_or_expression(this);
		}
	}

	@RuleVersion(0)
	public final Inclusive_or_expressionContext inclusive_or_expression() throws RecognitionException {
		Inclusive_or_expressionContext _localctx = new Inclusive_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_inclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414); exclusive_or_expression();
			setState(417);
			_la = _input.LA(1);
			if (_la==19) {
				{
				setState(415); match(19);
				setState(416); inclusive_or_expression();
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

	public static class Exclusive_or_expressionContext extends ParserRuleContext<Token> {
		public Exclusive_or_expressionContext exclusive_or_expression() {
			return getRuleContext(Exclusive_or_expressionContext.class,0);
		}
		public Bit_and_expressionContext bit_and_expression() {
			return getRuleContext(Bit_and_expressionContext.class,0);
		}
		public Exclusive_or_expressionContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusive_or_expression; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterExclusive_or_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitExclusive_or_expression(this);
		}
	}

	@RuleVersion(0)
	public final Exclusive_or_expressionContext exclusive_or_expression() throws RecognitionException {
		Exclusive_or_expressionContext _localctx = new Exclusive_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_exclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419); bit_and_expression();
			setState(422);
			_la = _input.LA(1);
			if (_la==41) {
				{
				setState(420); match(41);
				setState(421); exclusive_or_expression();
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

	public static class Bit_and_expressionContext extends ParserRuleContext<Token> {
		public Equality_expressionContext equality_expression() {
			return getRuleContext(Equality_expressionContext.class,0);
		}
		public Bit_and_expressionContext bit_and_expression() {
			return getRuleContext(Bit_and_expressionContext.class,0);
		}
		public Bit_and_expressionContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bit_and_expression; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterBit_and_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitBit_and_expression(this);
		}
	}

	@RuleVersion(0)
	public final Bit_and_expressionContext bit_and_expression() throws RecognitionException {
		Bit_and_expressionContext _localctx = new Bit_and_expressionContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_bit_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424); equality_expression();
			setState(427);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(425); match(1);
				setState(426); bit_and_expression();
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

	public static class Equality_expressionContext extends ParserRuleContext<Token> {
		public Equality_expressionContext equality_expression() {
			return getRuleContext(Equality_expressionContext.class,0);
		}
		public Equality_operatorContext equality_operator() {
			return getRuleContext(Equality_operatorContext.class,0);
		}
		public Relational_expressionContext relational_expression() {
			return getRuleContext(Relational_expressionContext.class,0);
		}
		public Equality_expressionContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_expression; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterEquality_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitEquality_expression(this);
		}
	}

	@RuleVersion(0)
	public final Equality_expressionContext equality_expression() throws RecognitionException {
		Equality_expressionContext _localctx = new Equality_expressionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_equality_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429); relational_expression();
			setState(433);
			_la = _input.LA(1);
			if (_la==6 || _la==52) {
				{
				setState(430); equality_operator();
				setState(431); equality_expression();
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

	public static class Relational_expressionContext extends ParserRuleContext<Token> {
		public Shift_expressionContext shift_expression() {
			return getRuleContext(Shift_expressionContext.class,0);
		}
		public Relational_operatorContext relational_operator() {
			return getRuleContext(Relational_operatorContext.class,0);
		}
		public Relational_expressionContext relational_expression() {
			return getRuleContext(Relational_expressionContext.class,0);
		}
		public Relational_expressionContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_expression; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterRelational_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitRelational_expression(this);
		}
	}

	@RuleVersion(0)
	public final Relational_expressionContext relational_expression() throws RecognitionException {
		Relational_expressionContext _localctx = new Relational_expressionContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_relational_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435); shift_expression();
			setState(439);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 49) | (1L << 55))) != 0)) {
				{
				setState(436); relational_operator();
				setState(437); relational_expression();
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

	public static class Shift_expressionContext extends ParserRuleContext<Token> {
		public Additive_expressionContext additive_expression() {
			return getRuleContext(Additive_expressionContext.class,0);
		}
		public Shift_expressionContext shift_expression() {
			return getRuleContext(Shift_expressionContext.class,0);
		}
		public Shift_expressionContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_expression; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterShift_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitShift_expression(this);
		}
	}

	@RuleVersion(0)
	public final Shift_expressionContext shift_expression() throws RecognitionException {
		Shift_expressionContext _localctx = new Shift_expressionContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_shift_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(441); additive_expression();
			setState(444);
			_la = _input.LA(1);
			if (_la==8 || _la==40) {
				{
				setState(442);
				_la = _input.LA(1);
				if ( !(_la==8 || _la==40) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(443); shift_expression();
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

	public static class Additive_expressionContext extends ParserRuleContext<Token> {
		public Additive_expressionContext additive_expression() {
			return getRuleContext(Additive_expressionContext.class,0);
		}
		public Multiplicative_expressionContext multiplicative_expression() {
			return getRuleContext(Multiplicative_expressionContext.class,0);
		}
		public Additive_expressionContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive_expression; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterAdditive_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitAdditive_expression(this);
		}
	}

	@RuleVersion(0)
	public final Additive_expressionContext additive_expression() throws RecognitionException {
		Additive_expressionContext _localctx = new Additive_expressionContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_additive_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446); multiplicative_expression();
			setState(449);
			_la = _input.LA(1);
			if (_la==28 || _la==44) {
				{
				setState(447);
				_la = _input.LA(1);
				if ( !(_la==28 || _la==44) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(448); additive_expression();
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

	public static class Multiplicative_expressionContext extends ParserRuleContext<Token> {
		public Cast_expressionContext cast_expression() {
			return getRuleContext(Cast_expressionContext.class,0);
		}
		public Multiplicative_expressionContext multiplicative_expression() {
			return getRuleContext(Multiplicative_expressionContext.class,0);
		}
		public Multiplicative_expressionContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative_expression; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterMultiplicative_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitMultiplicative_expression(this);
		}
	}

	@RuleVersion(0)
	public final Multiplicative_expressionContext multiplicative_expression() throws RecognitionException {
		Multiplicative_expressionContext _localctx = new Multiplicative_expressionContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_multiplicative_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451); cast_expression();
			setState(454);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 9) | (1L << 53))) != 0)) {
				{
				setState(452);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 9) | (1L << 53))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(453); multiplicative_expression();
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

	public static class Cast_expressionContext extends ParserRuleContext<Token> {
		public Cast_expressionContext cast_expression() {
			return getRuleContext(Cast_expressionContext.class,0);
		}
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public Cast_targetContext cast_target() {
			return getRuleContext(Cast_targetContext.class,0);
		}
		public Cast_expressionContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast_expression; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterCast_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitCast_expression(this);
		}
	}

	@RuleVersion(0)
	public final Cast_expressionContext cast_expression() throws RecognitionException {
		Cast_expressionContext _localctx = new Cast_expressionContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_cast_expression);
		try {
			setState(462);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(456); match(30);
				setState(457); cast_target();
				setState(458); match(12);
				setState(459); cast_expression();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(461); unary_expression();
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

	public static class Cast_targetContext extends ParserRuleContext<Token> {
		public Ptr_operatorContext ptr_operator(int i) {
			return getRuleContext(Ptr_operatorContext.class,i);
		}
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public List<? extends Ptr_operatorContext> ptr_operator() {
			return getRuleContexts(Ptr_operatorContext.class);
		}
		public Cast_targetContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast_target; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterCast_target(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitCast_target(this);
		}
	}

	@RuleVersion(0)
	public final Cast_targetContext cast_target() throws RecognitionException {
		Cast_targetContext _localctx = new Cast_targetContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_cast_target);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464); type_name();
			setState(468);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1 || _la==3) {
				{
				{
				setState(465); ptr_operator();
				}
				}
				setState(470);
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

	public static class Unary_expressionContext extends ParserRuleContext<Token> {
		public Cast_expressionContext cast_expression() {
			return getRuleContext(Cast_expressionContext.class,0);
		}
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public Inc_decContext inc_dec() {
			return getRuleContext(Inc_decContext.class,0);
		}
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
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
		public List<? extends Ptr_operatorContext> ptr_operator() {
			return getRuleContexts(Ptr_operatorContext.class);
		}
		public Unary_expressionContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterUnary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitUnary_expression(this);
		}
	}

	@RuleVersion(0)
	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_unary_expression);
		int _la;
		try {
			setState(491);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(471); inc_dec();
				setState(472); cast_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(474); unary_operator();
				setState(475); cast_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(477); match(21);
				setState(478); match(30);
				setState(479); type_name();
				setState(483);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1 || _la==3) {
					{
					{
					setState(480); ptr_operator();
					}
					}
					setState(485);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(486); match(12);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(488); match(21);
				setState(489); unary_expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(490); postfix_expression(0);
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

	public static class Inc_decContext extends ParserRuleContext<Token> {
		public Inc_decContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inc_dec; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterInc_dec(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitInc_dec(this);
		}
	}

	@RuleVersion(0)
	public final Inc_decContext inc_dec() throws RecognitionException {
		Inc_decContext _localctx = new Inc_decContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_inc_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493);
			_la = _input.LA(1);
			if ( !(_la==5 || _la==39) ) {
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

	public static class Postfix_expressionContext extends ParserRuleContext<Token> {
		public Postfix_expressionContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix_expression; }
	 
		public Postfix_expressionContext() { }
		public void copyFrom(Postfix_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrimaryOnlyContext extends Postfix_expressionContext {
		public Primary_expressionContext primary_expression() {
			return getRuleContext(Primary_expressionContext.class,0);
		}
		public PrimaryOnlyContext(Postfix_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterPrimaryOnly(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitPrimaryOnly(this);
		}
	}
	public static class PtrMemberAccessContext extends Postfix_expressionContext {
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public TerminalNode<Token> TEMPLATE() { return getToken(FineFunctionGrammarParser.TEMPLATE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PtrMemberAccessContext(Postfix_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterPtrMemberAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitPtrMemberAccess(this);
		}
	}
	public static class ArrayIndexingContext extends Postfix_expressionContext {
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArrayIndexingContext(Postfix_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterArrayIndexing(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitArrayIndexing(this);
		}
	}
	public static class IncDecOpContext extends Postfix_expressionContext {
		public Inc_decContext inc_dec() {
			return getRuleContext(Inc_decContext.class,0);
		}
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public IncDecOpContext(Postfix_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterIncDecOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitIncDecOp(this);
		}
	}
	public static class MemberAccessContext extends Postfix_expressionContext {
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public TerminalNode<Token> TEMPLATE() { return getToken(FineFunctionGrammarParser.TEMPLATE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public MemberAccessContext(Postfix_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterMemberAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitMemberAccess(this);
		}
	}
	public static class FuncCallContext extends Postfix_expressionContext {
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public Function_argument_listContext function_argument_list() {
			return getRuleContext(Function_argument_listContext.class,0);
		}
		public FuncCallContext(Postfix_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitFuncCall(this);
		}
	}

	@RuleVersion(0)
	public final Postfix_expressionContext postfix_expression(int _p) throws RecognitionException {
		ParserRuleContext<Token> _parentctx = _ctx;
		int _parentState = getState();
		Postfix_expressionContext _localctx = new Postfix_expressionContext(_ctx, _parentState);
		Postfix_expressionContext _prevctx = _localctx;
		int _startState = 108;
		enterRecursionRule(_localctx, RULE_postfix_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PrimaryOnlyContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(496); primary_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(524);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(522);
					switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
					case 1:
						{
						_localctx = new ArrayIndexingContext(new Postfix_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(498);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(499); match(2);
						setState(500); expr();
						setState(501); match(23);
						}
						break;
					case 2:
						{
						_localctx = new FuncCallContext(new Postfix_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(503);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(504); match(30);
						setState(505); function_argument_list();
						setState(506); match(12);
						}
						break;
					case 3:
						{
						_localctx = new MemberAccessContext(new Postfix_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(508);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(509); match(43);
						setState(511);
						_la = _input.LA(1);
						if (_la==TEMPLATE) {
							{
							setState(510); match(TEMPLATE);
							}
						}

						setState(513); identifier();
						}
						break;
					case 4:
						{
						_localctx = new PtrMemberAccessContext(new Postfix_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(514);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(515); match(10);
						setState(517);
						_la = _input.LA(1);
						if (_la==TEMPLATE) {
							{
							setState(516); match(TEMPLATE);
							}
						}

						setState(519); identifier();
						}
						break;
					case 5:
						{
						_localctx = new IncDecOpContext(new Postfix_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(520);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(521); inc_dec();
						}
						break;
					}
					} 
				}
				setState(526);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Function_argument_listContext extends ParserRuleContext<Token> {
		public Function_argumentContext function_argument(int i) {
			return getRuleContext(Function_argumentContext.class,i);
		}
		public List<? extends Function_argumentContext> function_argument() {
			return getRuleContexts(Function_argumentContext.class);
		}
		public Function_argument_listContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_argument_list; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterFunction_argument_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitFunction_argument_list(this);
		}
	}

	@RuleVersion(0)
	public final Function_argument_listContext function_argument_list() throws RecognitionException {
		Function_argument_listContext _localctx = new Function_argument_listContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_function_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 20) | (1L << 21) | (1L << 28) | (1L << 30) | (1L << 39) | (1L << 44) | (1L << 54))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (ALPHA_NUMERIC - 84)) | (1L << (HEX_LITERAL - 84)) | (1L << (DECIMAL_LITERAL - 84)) | (1L << (OCTAL_LITERAL - 84)) | (1L << (FLOATING_POINT_LITERAL - 84)) | (1L << (CHAR - 84)) | (1L << (STRING - 84)))) != 0)) {
				{
				setState(527); function_argument();
				setState(532);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==27) {
					{
					{
					setState(528); match(27);
					setState(529); function_argument();
					}
					}
					setState(534);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class Function_argumentContext extends ParserRuleContext<Token> {
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public Function_argumentContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_argument; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterFunction_argument(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitFunction_argument(this);
		}
	}

	@RuleVersion(0)
	public final Function_argumentContext function_argument() throws RecognitionException {
		Function_argumentContext _localctx = new Function_argumentContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_function_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537); assign_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Primary_expressionContext extends ParserRuleContext<Token> {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Primary_expressionContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expression; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterPrimary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitPrimary_expression(this);
		}
	}

	@RuleVersion(0)
	public final Primary_expressionContext primary_expression() throws RecognitionException {
		Primary_expressionContext _localctx = new Primary_expressionContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_primary_expression);
		try {
			setState(545);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(539); identifier();
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
				setState(540); constant();
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 3);
				{
				setState(541); match(30);
				setState(542); expr();
				setState(543); match(12);
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

	public static class Init_declaratorContext extends ParserRuleContext<Token> {
		public Init_declaratorContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_declarator; }
	 
		public Init_declaratorContext() { }
		public void copyFrom(Init_declaratorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InitDeclWithCallContext extends Init_declaratorContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InitDeclWithCallContext(Init_declaratorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterInitDeclWithCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitInitDeclWithCall(this);
		}
	}
	public static class InitDeclSimpleContext extends Init_declaratorContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public InitDeclSimpleContext(Init_declaratorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterInitDeclSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitInitDeclSimple(this);
		}
	}
	public static class InitDeclWithAssignContext extends Init_declaratorContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public InitDeclWithAssignContext(Init_declaratorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterInitDeclWithAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitInitDeclWithAssign(this);
		}
	}

	@RuleVersion(0)
	public final Init_declaratorContext init_declarator() throws RecognitionException {
		Init_declaratorContext _localctx = new Init_declaratorContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_init_declarator);
		int _la;
		try {
			setState(559);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				_localctx = new InitDeclWithCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(547); declarator();
				setState(548); match(30);
				setState(550);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 20) | (1L << 21) | (1L << 28) | (1L << 30) | (1L << 39) | (1L << 44) | (1L << 54))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (ALPHA_NUMERIC - 84)) | (1L << (HEX_LITERAL - 84)) | (1L << (DECIMAL_LITERAL - 84)) | (1L << (OCTAL_LITERAL - 84)) | (1L << (FLOATING_POINT_LITERAL - 84)) | (1L << (CHAR - 84)) | (1L << (STRING - 84)))) != 0)) {
					{
					setState(549); expr();
					}
				}

				setState(552); match(12);
				}
				break;
			case 2:
				_localctx = new InitDeclWithAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(554); declarator();
				setState(555); match(16);
				setState(556); initializer();
				}
				break;
			case 3:
				_localctx = new InitDeclSimpleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(558); declarator();
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

	public static class DeclaratorContext extends ParserRuleContext<Token> {
		public Type_suffixContext type_suffix() {
			return getRuleContext(Type_suffixContext.class,0);
		}
		public PtrsContext ptrs() {
			return getRuleContext(PtrsContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitDeclarator(this);
		}
	}

	@RuleVersion(0)
	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(561); ptrs();
				}
			}

			setState(564); identifier();
			setState(566);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(565); type_suffix();
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

	public static class Type_suffixContext extends ParserRuleContext<Token> {
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public Param_type_listContext param_type_list() {
			return getRuleContext(Param_type_listContext.class,0);
		}
		public Type_suffixContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_suffix; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterType_suffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitType_suffix(this);
		}
	}

	@RuleVersion(0)
	public final Type_suffixContext type_suffix() throws RecognitionException {
		Type_suffixContext _localctx = new Type_suffixContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_type_suffix);
		int _la;
		try {
			setState(574);
			switch (_input.LA(1)) {
			case 2:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(568); match(2);
				setState(570);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 20) | (1L << 21) | (1L << 28) | (1L << 30) | (1L << 39) | (1L << 44) | (1L << 54))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (ALPHA_NUMERIC - 84)) | (1L << (HEX_LITERAL - 84)) | (1L << (DECIMAL_LITERAL - 84)) | (1L << (OCTAL_LITERAL - 84)) | (1L << (FLOATING_POINT_LITERAL - 84)) | (1L << (CHAR - 84)) | (1L << (STRING - 84)))) != 0)) {
					{
					setState(569); conditional_expression();
					}
				}

				setState(572); match(23);
				}
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 2);
				{
				setState(573); param_type_list();
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

	public static class Simple_declContext extends ParserRuleContext<Token> {
		public Template_decl_startContext template_decl_start() {
			return getRuleContext(Template_decl_startContext.class,0);
		}
		public TerminalNode<Token> TYPEDEF() { return getToken(FineFunctionGrammarParser.TYPEDEF, 0); }
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Simple_declContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_decl; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterSimple_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitSimple_decl(this);
		}
	}

	@RuleVersion(0)
	public final Simple_declContext simple_decl() throws RecognitionException {
		Simple_declContext _localctx = new Simple_declContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_simple_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(577);
			_la = _input.LA(1);
			if (_la==TYPEDEF) {
				{
				setState(576); match(TYPEDEF);
				}
			}

			setState(580);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(579); template_decl_start();
				}
			}

			}
			setState(582); var_decl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext<Token> {
		public Var_declContext(ParserRuleContext<Token> parent, int invokingState) {
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
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterDeclByClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
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
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterDeclByType(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitDeclByType(this);
		}
	}

	@RuleVersion(0)
	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_var_decl);
		try {
			setState(591);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				_localctx = new DeclByClassContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(584); class_def();
				setState(586);
				switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
				case 1:
					{
					setState(585); init_declarator_list();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new DeclByTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(588); type_name();
				setState(589); init_declarator_list();
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

	public static class Init_declarator_listContext extends ParserRuleContext<Token> {
		public List<? extends Init_declaratorContext> init_declarator() {
			return getRuleContexts(Init_declaratorContext.class);
		}
		public Init_declaratorContext init_declarator(int i) {
			return getRuleContext(Init_declaratorContext.class,i);
		}
		public Init_declarator_listContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_declarator_list; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterInit_declarator_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitInit_declarator_list(this);
		}
	}

	@RuleVersion(0)
	public final Init_declarator_listContext init_declarator_list() throws RecognitionException {
		Init_declarator_listContext _localctx = new Init_declarator_listContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593); init_declarator();
			setState(598);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==27) {
				{
				{
				setState(594); match(27);
				setState(595); init_declarator();
				}
				}
				setState(600);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(601); match(46);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerContext extends ParserRuleContext<Token> {
		public Initializer_listContext initializer_list() {
			return getRuleContext(Initializer_listContext.class,0);
		}
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public InitializerContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitInitializer(this);
		}
	}

	@RuleVersion(0)
	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_initializer);
		try {
			setState(608);
			switch (_input.LA(1)) {
			case 1:
			case 3:
			case 5:
			case 20:
			case 21:
			case 28:
			case 30:
			case 39:
			case 44:
			case 54:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case CHAR:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(603); assign_expr();
				}
				break;
			case OPENING_CURLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(604); match(OPENING_CURLY);
				setState(605); initializer_list();
				setState(606); match(CLOSING_CURLY);
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

	public static class Initializer_listContext extends ParserRuleContext<Token> {
		public InitializerContext initializer(int i) {
			return getRuleContext(InitializerContext.class,i);
		}
		public List<? extends InitializerContext> initializer() {
			return getRuleContexts(InitializerContext.class);
		}
		public Initializer_listContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer_list; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterInitializer_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitInitializer_list(this);
		}
	}

	@RuleVersion(0)
	public final Initializer_listContext initializer_list() throws RecognitionException {
		Initializer_listContext _localctx = new Initializer_listContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_initializer_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(610); initializer();
			setState(615);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==27) {
				{
				{
				setState(611); match(27);
				setState(612); initializer();
				}
				}
				setState(617);
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

	public static class Class_defContext extends ParserRuleContext<Token> {
		public Base_classesContext base_classes() {
			return getRuleContext(Base_classesContext.class,0);
		}
		public Class_nameContext class_name() {
			return getRuleContext(Class_nameContext.class,0);
		}
		public TerminalNode<Token> CLASS_KEY() { return getToken(FineFunctionGrammarParser.CLASS_KEY, 0); }
		public TerminalNode<Token> OPENING_CURLY() { return getToken(FineFunctionGrammarParser.OPENING_CURLY, 0); }
		public Class_defContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_def; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterClass_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitClass_def(this);
		}
	}

	@RuleVersion(0)
	public final Class_defContext class_def() throws RecognitionException {
		Class_defContext _localctx = new Class_defContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(618); match(CLASS_KEY);
			setState(620);
			_la = _input.LA(1);
			if (_la==ALPHA_NUMERIC) {
				{
				setState(619); class_name();
				}
			}

			setState(623);
			_la = _input.LA(1);
			if (_la==29) {
				{
				setState(622); base_classes();
				}
			}

			setState(625); match(OPENING_CURLY);
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

	public static class Class_nameContext extends ParserRuleContext<Token> {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Class_nameContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_name; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterClass_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitClass_name(this);
		}
	}

	@RuleVersion(0)
	public final Class_nameContext class_name() throws RecognitionException {
		Class_nameContext _localctx = new Class_nameContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_class_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(628); identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Base_classesContext extends ParserRuleContext<Token> {
		public Base_classContext base_class(int i) {
			return getRuleContext(Base_classContext.class,i);
		}
		public List<? extends Base_classContext> base_class() {
			return getRuleContexts(Base_classContext.class);
		}
		public Base_classesContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_classes; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterBase_classes(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitBase_classes(this);
		}
	}

	@RuleVersion(0)
	public final Base_classesContext base_classes() throws RecognitionException {
		Base_classesContext _localctx = new Base_classesContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_base_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(630); match(29);
			setState(631); base_class();
			setState(636);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==27) {
				{
				{
				setState(632); match(27);
				setState(633); base_class();
				}
				}
				setState(638);
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

	public static class Base_classContext extends ParserRuleContext<Token> {
		public TerminalNode<Token> VIRTUAL() { return getToken(FineFunctionGrammarParser.VIRTUAL, 0); }
		public Access_specifierContext access_specifier() {
			return getRuleContext(Access_specifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Base_classContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_class; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterBase_class(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitBase_class(this);
		}
	}

	@RuleVersion(0)
	public final Base_classContext base_class() throws RecognitionException {
		Base_classContext _localctx = new Base_classContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_base_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(640);
			_la = _input.LA(1);
			if (_la==VIRTUAL) {
				{
				setState(639); match(VIRTUAL);
				}
			}

			setState(643);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 26) | (1L << 32) | (1L << 45))) != 0)) {
				{
				setState(642); access_specifier();
				}
			}

			setState(645); identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_nameContext extends ParserRuleContext<Token> {
		public List<? extends TerminalNode<Token>> CV_QUALIFIER() { return getTokens(FineFunctionGrammarParser.CV_QUALIFIER); }
		public Template_param_listContext template_param_list(int i) {
			return getRuleContext(Template_param_listContext.class,i);
		}
		public TerminalNode<Token> SIGNED() { return getToken(FineFunctionGrammarParser.SIGNED, 0); }
		public TerminalNode<Token> UNSIGNED() { return getToken(FineFunctionGrammarParser.UNSIGNED, 0); }
		public List<? extends Template_param_listContext> template_param_list() {
			return getRuleContexts(Template_param_listContext.class);
		}
		public Base_typeContext base_type(int i) {
			return getRuleContext(Base_typeContext.class,i);
		}
		public List<? extends Base_typeContext> base_type() {
			return getRuleContexts(Base_typeContext.class);
		}
		public TerminalNode<Token> CV_QUALIFIER(int i) {
			return getToken(FineFunctionGrammarParser.CV_QUALIFIER, i);
		}
		public TerminalNode<Token> CLASS_KEY() { return getToken(FineFunctionGrammarParser.CLASS_KEY, 0); }
		public Type_nameContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterType_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitType_name(this);
		}
	}

	@RuleVersion(0)
	public final Type_nameContext type_name() throws RecognitionException {
		Type_nameContext _localctx = new Type_nameContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_type_name);
		int _la;
		try {
			setState(678);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(650);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CV_QUALIFIER) {
					{
					{
					setState(647); match(CV_QUALIFIER);
					}
					}
					setState(652);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(654);
				_la = _input.LA(1);
				if (((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (UNSIGNED - 69)) | (1L << (SIGNED - 69)) | (1L << (CLASS_KEY - 69)))) != 0)) {
					{
					setState(653);
					_la = _input.LA(1);
					if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (UNSIGNED - 69)) | (1L << (SIGNED - 69)) | (1L << (CLASS_KEY - 69)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(656); base_type();
				setState(661);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(657); match(4);
					setState(658); template_param_list();
					setState(659); match(49);
					}
				}

				setState(673);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==15) {
					{
					{
					setState(663); match(15);
					setState(664); base_type();
					setState(669);
					_la = _input.LA(1);
					if (_la==4) {
						{
						setState(665); match(4);
						setState(666); template_param_list();
						setState(667); match(49);
						}
					}

					}
					}
					setState(675);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(676); match(UNSIGNED);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(677); match(SIGNED);
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

	public static class Base_typeContext extends ParserRuleContext<Token> {
		public List<? extends TerminalNode<Token>> VOID() { return getTokens(FineFunctionGrammarParser.VOID); }
		public TerminalNode<Token> ALPHA_NUMERIC(int i) {
			return getToken(FineFunctionGrammarParser.ALPHA_NUMERIC, i);
		}
		public List<? extends TerminalNode<Token>> ALPHA_NUMERIC() { return getTokens(FineFunctionGrammarParser.ALPHA_NUMERIC); }
		public TerminalNode<Token> LONG(int i) {
			return getToken(FineFunctionGrammarParser.LONG, i);
		}
		public TerminalNode<Token> VOID(int i) {
			return getToken(FineFunctionGrammarParser.VOID, i);
		}
		public List<? extends TerminalNode<Token>> LONG() { return getTokens(FineFunctionGrammarParser.LONG); }
		public Base_typeContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterBase_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitBase_type(this);
		}
	}

	@RuleVersion(0)
	public final Base_typeContext base_type() throws RecognitionException {
		Base_typeContext _localctx = new Base_typeContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_base_type);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(681); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(680);
					_la = _input.LA(1);
					if ( !(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (VOID - 68)) | (1L << (LONG - 68)) | (1L << (ALPHA_NUMERIC - 68)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(683); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_decl_specifiersContext extends ParserRuleContext<Token> {
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public TerminalNode<Token> REGISTER() { return getToken(FineFunctionGrammarParser.REGISTER, 0); }
		public TerminalNode<Token> AUTO() { return getToken(FineFunctionGrammarParser.AUTO, 0); }
		public Param_decl_specifiersContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl_specifiers; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterParam_decl_specifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitParam_decl_specifiers(this);
		}
	}

	@RuleVersion(0)
	public final Param_decl_specifiersContext param_decl_specifiers() throws RecognitionException {
		Param_decl_specifiersContext _localctx = new Param_decl_specifiersContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_param_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(686);
			_la = _input.LA(1);
			if (_la==AUTO || _la==REGISTER) {
				{
				setState(685);
				_la = _input.LA(1);
				if ( !(_la==AUTO || _la==REGISTER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(688); type_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parameter_nameContext extends ParserRuleContext<Token> {
		public Access_specifierContext access_specifier() {
			return getRuleContext(Access_specifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Parameter_nameContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_name; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterParameter_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitParameter_name(this);
		}
	}

	@RuleVersion(0)
	public final Parameter_nameContext parameter_name() throws RecognitionException {
		Parameter_nameContext _localctx = new Parameter_nameContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_parameter_name);
		try {
			setState(692);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(690); identifier();
				}
				break;
			case 26:
			case 32:
			case 45:
				enterOuterAlt(_localctx, 2);
				{
				setState(691); access_specifier();
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

	public static class Param_type_listContext extends ParserRuleContext<Token> {
		public Param_typeContext param_type(int i) {
			return getRuleContext(Param_typeContext.class,i);
		}
		public List<? extends Param_typeContext> param_type() {
			return getRuleContexts(Param_typeContext.class);
		}
		public TerminalNode<Token> VOID() { return getToken(FineFunctionGrammarParser.VOID, 0); }
		public Param_type_listContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_type_list; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterParam_type_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitParam_type_list(this);
		}
	}

	@RuleVersion(0)
	public final Param_type_listContext param_type_list() throws RecognitionException {
		Param_type_listContext _localctx = new Param_type_listContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_param_type_list);
		int _la;
		try {
			setState(709);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(694); match(30);
				setState(695); match(VOID);
				setState(696); match(12);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(697); match(30);
				setState(706);
				_la = _input.LA(1);
				if (((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (VOID - 68)) | (1L << (UNSIGNED - 68)) | (1L << (SIGNED - 68)) | (1L << (LONG - 68)) | (1L << (CV_QUALIFIER - 68)) | (1L << (AUTO - 68)) | (1L << (REGISTER - 68)) | (1L << (CLASS_KEY - 68)) | (1L << (ALPHA_NUMERIC - 68)))) != 0)) {
					{
					setState(698); param_type();
					setState(703);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==27) {
						{
						{
						setState(699); match(27);
						setState(700); param_type();
						}
						}
						setState(705);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(708); match(12);
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

	public static class Param_typeContext extends ParserRuleContext<Token> {
		public Param_type_idContext param_type_id() {
			return getRuleContext(Param_type_idContext.class,0);
		}
		public Param_decl_specifiersContext param_decl_specifiers() {
			return getRuleContext(Param_decl_specifiersContext.class,0);
		}
		public Param_typeContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_type; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterParam_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitParam_type(this);
		}
	}

	@RuleVersion(0)
	public final Param_typeContext param_type() throws RecognitionException {
		Param_typeContext _localctx = new Param_typeContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_param_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(711); param_decl_specifiers();
			setState(712); param_type_id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_type_idContext extends ParserRuleContext<Token> {
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
		public Param_type_idContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_type_id; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterParam_type_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitParam_type_id(this);
		}
	}

	@RuleVersion(0)
	public final Param_type_idContext param_type_id() throws RecognitionException {
		Param_type_idContext _localctx = new Param_type_idContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_param_type_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(715);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(714); ptrs();
				}
			}

			setState(724);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				{
				setState(717); match(30);
				setState(718); param_type_id();
				setState(719); match(12);
				}
				break;
			case 2:
				{
				setState(722);
				_la = _input.LA(1);
				if (((((_la - 26)) & ~0x3f) == 0 && ((1L << (_la - 26)) & ((1L << (26 - 26)) | (1L << (32 - 26)) | (1L << (45 - 26)) | (1L << (ALPHA_NUMERIC - 26)))) != 0)) {
					{
					setState(721); parameter_name();
					}
				}

				}
				break;
			}
			setState(727);
			_la = _input.LA(1);
			if (_la==2 || _la==30) {
				{
				setState(726); type_suffix();
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

	public static class IdentifierContext extends ParserRuleContext<Token> {
		public TerminalNode<Token> ALPHA_NUMERIC(int i) {
			return getToken(FineFunctionGrammarParser.ALPHA_NUMERIC, i);
		}
		public List<? extends TerminalNode<Token>> ALPHA_NUMERIC() { return getTokens(FineFunctionGrammarParser.ALPHA_NUMERIC); }
		public IdentifierContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitIdentifier(this);
		}
	}

	@RuleVersion(0)
	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_identifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(729); match(ALPHA_NUMERIC);
			setState(734);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(730); match(15);
					setState(731); match(ALPHA_NUMERIC);
					}
					} 
				}
				setState(736);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
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

	public static class NumberContext extends ParserRuleContext<Token> {
		public TerminalNode<Token> OCTAL_LITERAL() { return getToken(FineFunctionGrammarParser.OCTAL_LITERAL, 0); }
		public TerminalNode<Token> HEX_LITERAL() { return getToken(FineFunctionGrammarParser.HEX_LITERAL, 0); }
		public TerminalNode<Token> DECIMAL_LITERAL() { return getToken(FineFunctionGrammarParser.DECIMAL_LITERAL, 0); }
		public NumberContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitNumber(this);
		}
	}

	@RuleVersion(0)
	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(737);
			_la = _input.LA(1);
			if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (HEX_LITERAL - 90)) | (1L << (DECIMAL_LITERAL - 90)) | (1L << (OCTAL_LITERAL - 90)))) != 0)) ) {
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

	public static class PtrsContext extends ParserRuleContext<Token> {
		public Ptr_operatorContext ptr_operator(int i) {
			return getRuleContext(Ptr_operatorContext.class,i);
		}
		public List<? extends Ptr_operatorContext> ptr_operator() {
			return getRuleContexts(Ptr_operatorContext.class);
		}
		public PtrsContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ptrs; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).enterPtrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof FineFunctionGrammarListener ) ((FineFunctionGrammarListener)listener).exitPtrs(this);
		}
	}

	@RuleVersion(0)
	public final PtrsContext ptrs() throws RecognitionException {
		PtrsContext _localctx = new PtrsContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_ptrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(740); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(739); ptr_operator();
				}
				}
				setState(742); 
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

	public boolean sempred(RuleContext<Token> _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 54: return postfix_expression_sempred((Postfix_expressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean postfix_expression_sempred(Postfix_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 6);
		case 1: return precpred(_ctx, 5);
		case 2: return precpred(_ctx, 4);
		case 3: return precpred(_ctx, 3);
		case 4: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\5\3e\u02eb\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\t"+
		"F\4G\tG\4H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\7\2\u00a9\n\2\f\2\16\2\u00ac\13\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\5\3\u00b6\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00d9\n\n\3\n\3\n\5\n\u00dd\n\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\n\u00e7\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\5\f\u00f2\n\f\3\f\5\f\u00f5\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u0101\n\r\3\r\5\r\u0104\n\r\3\16\5\16\u0107\n\16\3\16\3"+
		"\16\3\16\5\16\u010c\n\16\3\16\3\16\3\17\5\17\u0111\n\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u011b\n\20\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\5\27\u012c\n\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0156\n\27\3\30"+
		"\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\6\33\u016a\n\33\r\33\16\33\u016b\3\34\3\34\3\35\3\35\3"+
		"\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'"+
		"\3\'\5\'\u0187\n\'\3(\3(\3(\3(\5(\u018d\n(\3)\3)\3)\3)\3)\3)\5)\u0195"+
		"\n)\3*\3*\3*\5*\u019a\n*\3+\3+\3+\5+\u019f\n+\3,\3,\3,\5,\u01a4\n,\3-"+
		"\3-\3-\5-\u01a9\n-\3.\3.\3.\5.\u01ae\n.\3/\3/\3/\3/\5/\u01b4\n/\3\60\3"+
		"\60\3\60\3\60\5\60\u01ba\n\60\3\61\3\61\3\61\5\61\u01bf\n\61\3\62\3\62"+
		"\3\62\5\62\u01c4\n\62\3\63\3\63\3\63\5\63\u01c9\n\63\3\64\3\64\3\64\3"+
		"\64\3\64\3\64\5\64\u01d1\n\64\3\65\3\65\7\65\u01d5\n\65\f\65\16\65\u01d8"+
		"\13\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\7\66\u01e4\n"+
		"\66\f\66\16\66\u01e7\13\66\3\66\3\66\3\66\3\66\3\66\5\66\u01ee\n\66\3"+
		"\67\3\67\38\38\38\38\38\38\38\38\38\38\38\38\38\38\38\38\58\u0202\n8\3"+
		"8\38\38\38\58\u0208\n8\38\38\38\78\u020d\n8\f8\168\u0210\138\39\39\39"+
		"\79\u0215\n9\f9\169\u0218\139\59\u021a\n9\3:\3:\3;\3;\3;\3;\3;\3;\5;\u0224"+
		"\n;\3<\3<\3<\5<\u0229\n<\3<\3<\3<\3<\3<\3<\3<\5<\u0232\n<\3=\5=\u0235"+
		"\n=\3=\3=\5=\u0239\n=\3>\3>\5>\u023d\n>\3>\3>\5>\u0241\n>\3?\5?\u0244"+
		"\n?\3?\5?\u0247\n?\3?\3?\3@\3@\5@\u024d\n@\3@\3@\3@\5@\u0252\n@\3A\3A"+
		"\3A\7A\u0257\nA\fA\16A\u025a\13A\3A\3A\3B\3B\3B\3B\3B\5B\u0263\nB\3C\3"+
		"C\3C\7C\u0268\nC\fC\16C\u026b\13C\3D\3D\5D\u026f\nD\3D\5D\u0272\nD\3D"+
		"\3D\3D\3E\3E\3F\3F\3F\3F\7F\u027d\nF\fF\16F\u0280\13F\3G\5G\u0283\nG\3"+
		"G\5G\u0286\nG\3G\3G\3H\7H\u028b\nH\fH\16H\u028e\13H\3H\5H\u0291\nH\3H"+
		"\3H\3H\3H\3H\5H\u0298\nH\3H\3H\3H\3H\3H\3H\5H\u02a0\nH\7H\u02a2\nH\fH"+
		"\16H\u02a5\13H\3H\3H\5H\u02a9\nH\3I\6I\u02ac\nI\rI\16I\u02ad\3J\5J\u02b1"+
		"\nJ\3J\3J\3K\3K\5K\u02b7\nK\3L\3L\3L\3L\3L\3L\3L\7L\u02c0\nL\fL\16L\u02c3"+
		"\13L\5L\u02c5\nL\3L\5L\u02c8\nL\3M\3M\3M\3N\5N\u02ce\nN\3N\3N\3N\3N\3"+
		"N\5N\u02d5\nN\5N\u02d7\nN\3N\5N\u02da\nN\3O\3O\3O\7O\u02df\nO\fO\16O\u02e2"+
		"\13O\3P\3P\3Q\6Q\u02e7\nQ\rQ\16Q\u02e8\3Q\2\2\3nR\2\2\4\2\6\2\b\2\n\2"+
		"\f\2\16\2\20\2\22\2\24\2\26\2\30\2\32\2\34\2\36\2 \2\"\2$\2&\2(\2*\2,"+
		"\2.\2\60\2\62\2\64\2\66\28\2:\2<\2>\2@\2B\2D\2F\2H\2J\2L\2N\2P\2R\2T\2"+
		"V\2X\2Z\2\\\2^\2`\2b\2d\2f\2h\2j\2l\2n\2p\2r\2t\2v\2x\2z\2|\2~\2\u0080"+
		"\2\u0082\2\u0084\2\u0086\2\u0088\2\u008a\2\u008c\2\u008e\2\u0090\2\u0092"+
		"\2\u0094\2\u0096\2\u0098\2\u009a\2\u009c\2\u009e\2\u00a0\2\2\35\b\3\3"+
		"\5\5\26\26\36\36..88\6\6\6\t\t\63\6399\3\\a\5\17\20\'(KK\4\3\3\5\5\5\34"+
		"\34\"\"//\4\24\24,,\t\r\r\22\23\30\30\32\32!!$&\64\65\4\b\b\66\66\4\16"+
		"\16  \7\4\4\16\16\31\31  WX\5\16\16  \60\60\6\6\6\16\16  \63\63\3WX\4"+
		"\4\4\31\31\5\4\4\31\31\60\60\4\35\35\60\60\t\4\4\16\16\31\31\35\35  \60"+
		"\60WX\7\4\4\16\16\31\31  WX\4\n\n**\4\36\36..\5\5\5\13\13\67\67\4\7\7"+
		"))\4GHUU\5FFIIVV\3QR\3\\^\u0328\2\u00aa\3\2\2\2\4\u00b5\3\2\2\2\6\u00b7"+
		"\3\2\2\2\b\u00b9\3\2\2\2\n\u00bb\3\2\2\2\f\u00bd\3\2\2\2\16\u00bf\3\2"+
		"\2\2\20\u00c1\3\2\2\2\22\u00e6\3\2\2\2\24\u00e8\3\2\2\2\26\u00f4\3\2\2"+
		"\2\30\u0103\3\2\2\2\32\u0106\3\2\2\2\34\u0110\3\2\2\2\36\u011a\3\2\2\2"+
		" \u011c\3\2\2\2\"\u011e\3\2\2\2$\u0120\3\2\2\2&\u0122\3\2\2\2(\u0124\3"+
		"\2\2\2*\u0126\3\2\2\2,\u0155\3\2\2\2.\u0157\3\2\2\2\60\u0159\3\2\2\2\62"+
		"\u015b\3\2\2\2\64\u0169\3\2\2\2\66\u016d\3\2\2\28\u016f\3\2\2\2:\u0171"+
		"\3\2\2\2<\u0173\3\2\2\2>\u0175\3\2\2\2@\u0177\3\2\2\2B\u0179\3\2\2\2D"+
		"\u017b\3\2\2\2F\u017d\3\2\2\2H\u017f\3\2\2\2J\u0181\3\2\2\2L\u0183\3\2"+
		"\2\2N\u0188\3\2\2\2P\u018e\3\2\2\2R\u0196\3\2\2\2T\u019b\3\2\2\2V\u01a0"+
		"\3\2\2\2X\u01a5\3\2\2\2Z\u01aa\3\2\2\2\\\u01af\3\2\2\2^\u01b5\3\2\2\2"+
		"`\u01bb\3\2\2\2b\u01c0\3\2\2\2d\u01c5\3\2\2\2f\u01d0\3\2\2\2h\u01d2\3"+
		"\2\2\2j\u01ed\3\2\2\2l\u01ef\3\2\2\2n\u01f1\3\2\2\2p\u0219\3\2\2\2r\u021b"+
		"\3\2\2\2t\u0223\3\2\2\2v\u0231\3\2\2\2x\u0234\3\2\2\2z\u0240\3\2\2\2|"+
		"\u0243\3\2\2\2~\u0251\3\2\2\2\u0080\u0253\3\2\2\2\u0082\u0262\3\2\2\2"+
		"\u0084\u0264\3\2\2\2\u0086\u026c\3\2\2\2\u0088\u0276\3\2\2\2\u008a\u0278"+
		"\3\2\2\2\u008c\u0282\3\2\2\2\u008e\u02a8\3\2\2\2\u0090\u02ab\3\2\2\2\u0092"+
		"\u02b0\3\2\2\2\u0094\u02b6\3\2\2\2\u0096\u02c7\3\2\2\2\u0098\u02c9\3\2"+
		"\2\2\u009a\u02cd\3\2\2\2\u009c\u02db\3\2\2\2\u009e\u02e3\3\2\2\2\u00a0"+
		"\u02e6\3\2\2\2\u00a2\u00a9\5\6\4\2\u00a3\u00a9\5\n\6\2\u00a4\u00a5\5\b"+
		"\5\2\u00a5\u00a6\b\2\1\2\u00a6\u00a9\3\2\2\2\u00a7\u00a9\5\4\3\2\u00a8"+
		"\u00a2\3\2\2\2\u00a8\u00a3\3\2\2\2\u00a8\u00a4\3\2\2\2\u00a8\u00a7\3\2"+
		"\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\3\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00b6\5\f\7\2\u00ae\u00b6\5\16\b"+
		"\2\u00af\u00b6\5\20\t\2\u00b0\u00b6\5\30\r\2\u00b1\u00b6\5\32\16\2\u00b2"+
		"\u00b6\5|?\2\u00b3\u00b6\5\34\17\2\u00b4\u00b6\5J&\2\u00b5\u00ad\3\2\2"+
		"\2\u00b5\u00ae\3\2\2\2\u00b5\u00af\3\2\2\2\u00b5\u00b0\3\2\2\2\u00b5\u00b1"+
		"\3\2\2\2\u00b5\u00b2\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6"+
		"\5\3\2\2\2\u00b7\u00b8\7Y\2\2\u00b8\7\3\2\2\2\u00b9\u00ba\7Z\2\2\u00ba"+
		"\t\3\2\2\2\u00bb\u00bc\7[\2\2\u00bc\13\3\2\2\2\u00bd\u00be\7W\2\2\u00be"+
		"\r\3\2\2\2\u00bf\u00c0\7X\2\2\u00c0\17\3\2\2\2\u00c1\u00c2\5\22\n\2\u00c2"+
		"\21\3\2\2\2\u00c3\u00e7\7L\2\2\u00c4\u00c5\7M\2\2\u00c5\u00c6\7 \2\2\u00c6"+
		"\u00c7\5\u0098M\2\u00c7\u00c8\7\16\2\2\u00c8\u00e7\3\2\2\2\u00c9\u00ca"+
		"\7:\2\2\u00ca\u00cb\7 \2\2\u00cb\u00cc\5\36\20\2\u00cc\u00cd\7\16\2\2"+
		"\u00cd\u00e7\3\2\2\2\u00ce\u00e7\7;\2\2\u00cf\u00d0\7A\2\2\u00d0\u00d1"+
		"\7 \2\2\u00d1\u00d2\5\36\20\2\u00d2\u00d3\7\16\2\2\u00d3\u00e7\3\2\2\2"+
		"\u00d4\u00d5\7<\2\2\u00d5\u00d6\7 \2\2\u00d6\u00d8\5\26\f\2\u00d7\u00d9"+
		"\5\36\20\2\u00d8\u00d7\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\3\2\2\2"+
		"\u00da\u00dc\7\60\2\2\u00db\u00dd\5L\'\2\u00dc\u00db\3\2\2\2\u00dc\u00dd"+
		"\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\7\16\2\2\u00df\u00e7\3\2\2\2"+
		"\u00e0\u00e7\7B\2\2\u00e1\u00e2\7=\2\2\u00e2\u00e3\7 \2\2\u00e3\u00e4"+
		"\5\36\20\2\u00e4\u00e5\7\16\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00c3\3\2\2"+
		"\2\u00e6\u00c4\3\2\2\2\u00e6\u00c9\3\2\2\2\u00e6\u00ce\3\2\2\2\u00e6\u00cf"+
		"\3\2\2\2\u00e6\u00d4\3\2\2\2\u00e6\u00e0\3\2\2\2\u00e6\u00e1\3\2\2\2\u00e7"+
		"\23\3\2\2\2\u00e8\u00e9\7B\2\2\u00e9\u00ea\5\4\3\2\u00ea\u00eb\7=\2\2"+
		"\u00eb\u00ec\7 \2\2\u00ec\u00ed\5L\'\2\u00ed\u00ee\7\16\2\2\u00ee\25\3"+
		"\2\2\2\u00ef\u00f5\5|?\2\u00f0\u00f2\5L\'\2\u00f1\u00f0\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f5\7\60\2\2\u00f4\u00ef\3"+
		"\2\2\2\u00f4\u00f1\3\2\2\2\u00f5\27\3\2\2\2\u00f6\u00f7\7>\2\2\u00f7\u0104"+
		"\7\60\2\2\u00f8\u00f9\7@\2\2\u00f9\u0104\7\60\2\2\u00fa\u00fb\7C\2\2\u00fb"+
		"\u00fc\5\u009cO\2\u00fc\u00fd\7\60\2\2\u00fd\u0104\3\2\2\2\u00fe\u0100"+
		"\7D\2\2\u00ff\u0101\5L\'\2\u0100\u00ff\3\2\2\2\u0100\u0101\3\2\2\2\u0101"+
		"\u0102\3\2\2\2\u0102\u0104\7\60\2\2\u0103\u00f6\3\2\2\2\u0103\u00f8\3"+
		"\2\2\2\u0103\u00fa\3\2\2\2\u0103\u00fe\3\2\2\2\u0104\31\3\2\2\2\u0105"+
		"\u0107\7?\2\2\u0106\u0105\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u010b\3\2"+
		"\2\2\u0108\u010c\5\u009cO\2\u0109\u010c\5\u009eP\2\u010a\u010c\5*\26\2"+
		"\u010b\u0108\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010a\3\2\2\2\u010c\u010d"+
		"\3\2\2\2\u010d\u010e\7\37\2\2\u010e\33\3\2\2\2\u010f\u0111\5L\'\2\u0110"+
		"\u010f\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\7\60"+
		"\2\2\u0113\35\3\2\2\2\u0114\u011b\5L\'\2\u0115\u0116\5\u008eH\2\u0116"+
		"\u0117\5x=\2\u0117\u0118\7\22\2\2\u0118\u0119\5N(\2\u0119\u011b\3\2\2"+
		"\2\u011a\u0114\3\2\2\2\u011a\u0115\3\2\2\2\u011b\37\3\2\2\2\u011c\u011d"+
		"\t\2\2\2\u011d!\3\2\2\2\u011e\u011f\t\3\2\2\u011f#\3\2\2\2\u0120\u0121"+
		"\t\4\2\2\u0121%\3\2\2\2\u0122\u0123\t\5\2\2\u0123\'\3\2\2\2\u0124\u0125"+
		"\t\6\2\2\u0125)\3\2\2\2\u0126\u0127\t\7\2\2\u0127+\3\2\2\2\u0128\u012b"+
		"\t\b\2\2\u0129\u012a\7\4\2\2\u012a\u012c\7\31\2\2\u012b\u0129\3\2\2\2"+
		"\u012b\u012c\3\2\2\2\u012c\u0156\3\2\2\2\u012d\u0156\7.\2\2\u012e\u0156"+
		"\7\36\2\2\u012f\u0156\7\5\2\2\u0130\u0156\7\67\2\2\u0131\u0156\7\13\2"+
		"\2\u0132\u0156\7+\2\2\u0133\u0156\7\3\2\2\u0134\u0156\7\25\2\2\u0135\u0156"+
		"\78\2\2\u0136\u0156\7\26\2\2\u0137\u0156\7\22\2\2\u0138\u0156\7\6\2\2"+
		"\u0139\u0156\7\63\2\2\u013a\u0156\7%\2\2\u013b\u0156\7\32\2\2\u013c\u0156"+
		"\7\r\2\2\u013d\u0156\7\65\2\2\u013e\u0156\7\64\2\2\u013f\u0156\7&\2\2"+
		"\u0140\u0156\7!\2\2\u0141\u0156\7\23\2\2\u0142\u0156\7*\2\2\u0143\u0156"+
		"\7\n\2\2\u0144\u0156\7$\2\2\u0145\u0156\7\30\2\2\u0146\u0156\7\66\2\2"+
		"\u0147\u0156\7\b\2\2\u0148\u0156\7\t\2\2\u0149\u0156\79\2\2\u014a\u0156"+
		"\7\61\2\2\u014b\u0156\7\62\2\2\u014c\u0156\7)\2\2\u014d\u0156\7\7\2\2"+
		"\u014e\u0156\7\35\2\2\u014f\u0156\7\33\2\2\u0150\u0156\7\f\2\2\u0151\u0152"+
		"\7 \2\2\u0152\u0156\7\16\2\2\u0153\u0154\7\4\2\2\u0154\u0156\7\31\2\2"+
		"\u0155\u0128\3\2\2\2\u0155\u012d\3\2\2\2\u0155\u012e\3\2\2\2\u0155\u012f"+
		"\3\2\2\2\u0155\u0130\3\2\2\2\u0155\u0131\3\2\2\2\u0155\u0132\3\2\2\2\u0155"+
		"\u0133\3\2\2\2\u0155\u0134\3\2\2\2\u0155\u0135\3\2\2\2\u0155\u0136\3\2"+
		"\2\2\u0155\u0137\3\2\2\2\u0155\u0138\3\2\2\2\u0155\u0139\3\2\2\2\u0155"+
		"\u013a\3\2\2\2\u0155\u013b\3\2\2\2\u0155\u013c\3\2\2\2\u0155\u013d\3\2"+
		"\2\2\u0155\u013e\3\2\2\2\u0155\u013f\3\2\2\2\u0155\u0140\3\2\2\2\u0155"+
		"\u0141\3\2\2\2\u0155\u0142\3\2\2\2\u0155\u0143\3\2\2\2\u0155\u0144\3\2"+
		"\2\2\u0155\u0145\3\2\2\2\u0155\u0146\3\2\2\2\u0155\u0147\3\2\2\2\u0155"+
		"\u0148\3\2\2\2\u0155\u0149\3\2\2\2\u0155\u014a\3\2\2\2\u0155\u014b\3\2"+
		"\2\2\u0155\u014c\3\2\2\2\u0155\u014d\3\2\2\2\u0155\u014e\3\2\2\2\u0155"+
		"\u014f\3\2\2\2\u0155\u0150\3\2\2\2\u0155\u0151\3\2\2\2\u0155\u0153\3\2"+
		"\2\2\u0156-\3\2\2\2\u0157\u0158\t\t\2\2\u0158/\3\2\2\2\u0159\u015a\t\n"+
		"\2\2\u015a\61\3\2\2\2\u015b\u015c\7T\2\2\u015c\u015d\7\6\2\2\u015d\u015e"+
		"\5\64\33\2\u015e\u015f\7\63\2\2\u015f\63\3\2\2\2\u0160\u0161\7\6\2\2\u0161"+
		"\u0162\5\64\33\2\u0162\u0163\7\63\2\2\u0163\u016a\3\2\2\2\u0164\u0165"+
		"\7 \2\2\u0165\u0166\5\64\33\2\u0166\u0167\7\16\2\2\u0167\u016a\3\2\2\2"+
		"\u0168\u016a\5<\37\2\u0169\u0160\3\2\2\2\u0169\u0164\3\2\2\2\u0169\u0168"+
		"\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c"+
		"\65\3\2\2\2\u016d\u016e\n\13\2\2\u016e\67\3\2\2\2\u016f\u0170\n\f\2\2"+
		"\u01709\3\2\2\2\u0171\u0172\n\r\2\2\u0172;\3\2\2\2\u0173\u0174\n\16\2"+
		"\2\u0174=\3\2\2\2\u0175\u0176\n\17\2\2\u0176?\3\2\2\2\u0177\u0178\n\20"+
		"\2\2\u0178A\3\2\2\2\u0179\u017a\n\21\2\2\u017aC\3\2\2\2\u017b\u017c\n"+
		"\22\2\2\u017cE\3\2\2\2\u017d\u017e\n\23\2\2\u017eG\3\2\2\2\u017f\u0180"+
		"\n\24\2\2\u0180I\3\2\2\2\u0181\u0182\13\2\2\2\u0182K\3\2\2\2\u0183\u0186"+
		"\5N(\2\u0184\u0185\7\35\2\2\u0185\u0187\5L\'\2\u0186\u0184\3\2\2\2\u0186"+
		"\u0187\3\2\2\2\u0187M\3\2\2\2\u0188\u018c\5P)\2\u0189\u018a\5.\30\2\u018a"+
		"\u018b\5N(\2\u018b\u018d\3\2\2\2\u018c\u0189\3\2\2\2\u018c\u018d\3\2\2"+
		"\2\u018dO\3\2\2\2\u018e\u0194\5R*\2\u018f\u0190\7#\2\2\u0190\u0191\5L"+
		"\'\2\u0191\u0192\7\37\2\2\u0192\u0193\5P)\2\u0193\u0195\3\2\2\2\u0194"+
		"\u018f\3\2\2\2\u0194\u0195\3\2\2\2\u0195Q\3\2\2\2\u0196\u0199\5T+\2\u0197"+
		"\u0198\7\62\2\2\u0198\u019a\5R*\2\u0199\u0197\3\2\2\2\u0199\u019a\3\2"+
		"\2\2\u019aS\3\2\2\2\u019b\u019e\5V,\2\u019c\u019d\7\61\2\2\u019d\u019f"+
		"\5T+\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019fU\3\2\2\2\u01a0\u01a3"+
		"\5X-\2\u01a1\u01a2\7\25\2\2\u01a2\u01a4\5V,\2\u01a3\u01a1\3\2\2\2\u01a3"+
		"\u01a4\3\2\2\2\u01a4W\3\2\2\2\u01a5\u01a8\5Z.\2\u01a6\u01a7\7+\2\2\u01a7"+
		"\u01a9\5X-\2\u01a8\u01a6\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9Y\3\2\2\2\u01aa"+
		"\u01ad\5\\/\2\u01ab\u01ac\7\3\2\2\u01ac\u01ae\5Z.\2\u01ad\u01ab\3\2\2"+
		"\2\u01ad\u01ae\3\2\2\2\u01ae[\3\2\2\2\u01af\u01b3\5^\60\2\u01b0\u01b1"+
		"\5\60\31\2\u01b1\u01b2\5\\/\2\u01b2\u01b4\3\2\2\2\u01b3\u01b0\3\2\2\2"+
		"\u01b3\u01b4\3\2\2\2\u01b4]\3\2\2\2\u01b5\u01b9\5`\61\2\u01b6\u01b7\5"+
		"\"\22\2\u01b7\u01b8\5^\60\2\u01b8\u01ba\3\2\2\2\u01b9\u01b6\3\2\2\2\u01b9"+
		"\u01ba\3\2\2\2\u01ba_\3\2\2\2\u01bb\u01be\5b\62\2\u01bc\u01bd\t\25\2\2"+
		"\u01bd\u01bf\5`\61\2\u01be\u01bc\3\2\2\2\u01be\u01bf\3\2\2\2\u01bfa\3"+
		"\2\2\2\u01c0\u01c3\5d\63\2\u01c1\u01c2\t\26\2\2\u01c2\u01c4\5b\62\2\u01c3"+
		"\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4c\3\2\2\2\u01c5\u01c8\5f\64\2"+
		"\u01c6\u01c7\t\27\2\2\u01c7\u01c9\5d\63\2\u01c8\u01c6\3\2\2\2\u01c8\u01c9"+
		"\3\2\2\2\u01c9e\3\2\2\2\u01ca\u01cb\7 \2\2\u01cb\u01cc\5h\65\2\u01cc\u01cd"+
		"\7\16\2\2\u01cd\u01ce\5f\64\2\u01ce\u01d1\3\2\2\2\u01cf\u01d1\5j\66\2"+
		"\u01d0\u01ca\3\2\2\2\u01d0\u01cf\3\2\2\2\u01d1g\3\2\2\2\u01d2\u01d6\5"+
		"\u008eH\2\u01d3\u01d5\5(\25\2\u01d4\u01d3\3\2\2\2\u01d5\u01d8\3\2\2\2"+
		"\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7i\3\2\2\2\u01d8\u01d6\3"+
		"\2\2\2\u01d9\u01da\5l\67\2\u01da\u01db\5f\64\2\u01db\u01ee\3\2\2\2\u01dc"+
		"\u01dd\5 \21\2\u01dd\u01de\5f\64\2\u01de\u01ee\3\2\2\2\u01df\u01e0\7\27"+
		"\2\2\u01e0\u01e1\7 \2\2\u01e1\u01e5\5\u008eH\2\u01e2\u01e4\5(\25\2\u01e3"+
		"\u01e2\3\2\2\2\u01e4\u01e7\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e5\u01e6\3\2"+
		"\2\2\u01e6\u01e8\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e8\u01e9\7\16\2\2\u01e9"+
		"\u01ee\3\2\2\2\u01ea\u01eb\7\27\2\2\u01eb\u01ee\5j\66\2\u01ec\u01ee\5"+
		"n8\2\u01ed\u01d9\3\2\2\2\u01ed\u01dc\3\2\2\2\u01ed\u01df\3\2\2\2\u01ed"+
		"\u01ea\3\2\2\2\u01ed\u01ec\3\2\2\2\u01eek\3\2\2\2\u01ef\u01f0\t\30\2\2"+
		"\u01f0m\3\2\2\2\u01f1\u01f2\b8\1\2\u01f2\u01f3\5t;\2\u01f3\u020e\3\2\2"+
		"\2\u01f4\u01f5\f\b\2\2\u01f5\u01f6\7\4\2\2\u01f6\u01f7\5L\'\2\u01f7\u01f8"+
		"\7\31\2\2\u01f8\u020d\3\2\2\2\u01f9\u01fa\f\7\2\2\u01fa\u01fb\7 \2\2\u01fb"+
		"\u01fc\5p9\2\u01fc\u01fd\7\16\2\2\u01fd\u020d\3\2\2\2\u01fe\u01ff\f\6"+
		"\2\2\u01ff\u0201\7-\2\2\u0200\u0202\7T\2\2\u0201\u0200\3\2\2\2\u0201\u0202"+
		"\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u020d\5\u009cO\2\u0204\u0205\f\5\2"+
		"\2\u0205\u0207\7\f\2\2\u0206\u0208\7T\2\2\u0207\u0206\3\2\2\2\u0207\u0208"+
		"\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020d\5\u009cO\2\u020a\u020b\f\4\2"+
		"\2\u020b\u020d\5l\67\2\u020c\u01f4\3\2\2\2\u020c\u01f9\3\2\2\2\u020c\u01fe"+
		"\3\2\2\2\u020c\u0204\3\2\2\2\u020c\u020a\3\2\2\2\u020d\u0210\3\2\2\2\u020e"+
		"\u020c\3\2\2\2\u020e\u020f\3\2\2\2\u020fo\3\2\2\2\u0210\u020e\3\2\2\2"+
		"\u0211\u0216\5r:\2\u0212\u0213\7\35\2\2\u0213\u0215\5r:\2\u0214\u0212"+
		"\3\2\2\2\u0215\u0218\3\2\2\2\u0216\u0214\3\2\2\2\u0216\u0217\3\2\2\2\u0217"+
		"\u021a\3\2\2\2\u0218\u0216\3\2\2\2\u0219\u0211\3\2\2\2\u0219\u021a\3\2"+
		"\2\2\u021aq\3\2\2\2\u021b\u021c\5N(\2\u021cs\3\2\2\2\u021d\u0224\5\u009c"+
		"O\2\u021e\u0224\5$\23\2\u021f\u0220\7 \2\2\u0220\u0221\5L\'\2\u0221\u0222"+
		"\7\16\2\2\u0222\u0224\3\2\2\2\u0223\u021d\3\2\2\2\u0223\u021e\3\2\2\2"+
		"\u0223\u021f\3\2\2\2\u0224u\3\2\2\2\u0225\u0226\5x=\2\u0226\u0228\7 \2"+
		"\2\u0227\u0229\5L\'\2\u0228\u0227\3\2\2\2\u0228\u0229\3\2\2\2\u0229\u022a"+
		"\3\2\2\2\u022a\u022b\7\16\2\2\u022b\u0232\3\2\2\2\u022c\u022d\5x=\2\u022d"+
		"\u022e\7\22\2\2\u022e\u022f\5\u0082B\2\u022f\u0232\3\2\2\2\u0230\u0232"+
		"\5x=\2\u0231\u0225\3\2\2\2\u0231\u022c\3\2\2\2\u0231\u0230\3\2\2\2\u0232"+
		"w\3\2\2\2\u0233\u0235\5\u00a0Q\2\u0234\u0233\3\2\2\2\u0234\u0235\3\2\2"+
		"\2\u0235\u0236\3\2\2\2\u0236\u0238\5\u009cO\2\u0237\u0239\5z>\2\u0238"+
		"\u0237\3\2\2\2\u0238\u0239\3\2\2\2\u0239y\3\2\2\2\u023a\u023c\7\4\2\2"+
		"\u023b\u023d\5P)\2\u023c\u023b\3\2\2\2\u023c\u023d\3\2\2\2\u023d\u023e"+
		"\3\2\2\2\u023e\u0241\7\31\2\2\u023f\u0241\5\u0096L\2\u0240\u023a\3\2\2"+
		"\2\u0240\u023f\3\2\2\2\u0241{\3\2\2\2\u0242\u0244\7E\2\2\u0243\u0242\3"+
		"\2\2\2\u0243\u0244\3\2\2\2\u0244\u0246\3\2\2\2\u0245\u0247\5\62\32\2\u0246"+
		"\u0245\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u0249\5~"+
		"@\2\u0249}\3\2\2\2\u024a\u024c\5\u0086D\2\u024b\u024d\5\u0080A\2\u024c"+
		"\u024b\3\2\2\2\u024c\u024d\3\2\2\2\u024d\u0252\3\2\2\2\u024e\u024f\5\u008e"+
		"H\2\u024f\u0250\5\u0080A\2\u0250\u0252\3\2\2\2\u0251\u024a\3\2\2\2\u0251"+
		"\u024e\3\2\2\2\u0252\177\3\2\2\2\u0253\u0258\5v<\2\u0254\u0255\7\35\2"+
		"\2\u0255\u0257\5v<\2\u0256\u0254\3\2\2\2\u0257\u025a\3\2\2\2\u0258\u0256"+
		"\3\2\2\2\u0258\u0259\3\2\2\2\u0259\u025b\3\2\2\2\u025a\u0258\3\2\2\2\u025b"+
		"\u025c\7\60\2\2\u025c\u0081\3\2\2\2\u025d\u0263\5N(\2\u025e\u025f\7W\2"+
		"\2\u025f\u0260\5\u0084C\2\u0260\u0261\7X\2\2\u0261\u0263\3\2\2\2\u0262"+
		"\u025d\3\2\2\2\u0262\u025e\3\2\2\2\u0263\u0083\3\2\2\2\u0264\u0269\5\u0082"+
		"B\2\u0265\u0266\7\35\2\2\u0266\u0268\5\u0082B\2\u0267\u0265\3\2\2\2\u0268"+
		"\u026b\3\2\2\2\u0269\u0267\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u0085\3\2"+
		"\2\2\u026b\u0269\3\2\2\2\u026c\u026e\7U\2\2\u026d\u026f\5\u0088E\2\u026e"+
		"\u026d\3\2\2\2\u026e\u026f\3\2\2\2\u026f\u0271\3\2\2\2\u0270\u0272\5\u008a"+
		"F\2\u0271\u0270\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0273\3\2\2\2\u0273"+
		"\u0274\7W\2\2\u0274\u0275\bD\1\2\u0275\u0087\3\2\2\2\u0276\u0277\5\u009c"+
		"O\2\u0277\u0089\3\2\2\2\u0278\u0279\7\37\2\2\u0279\u027e\5\u008cG\2\u027a"+
		"\u027b\7\35\2\2\u027b\u027d\5\u008cG\2\u027c\u027a\3\2\2\2\u027d\u0280"+
		"\3\2\2\2\u027e\u027c\3\2\2\2\u027e\u027f\3\2\2\2\u027f\u008b\3\2\2\2\u0280"+
		"\u027e\3\2\2\2\u0281\u0283\7K\2\2\u0282\u0281\3\2\2\2\u0282\u0283\3\2"+
		"\2\2\u0283\u0285\3\2\2\2\u0284\u0286\5*\26\2\u0285\u0284\3\2\2\2\u0285"+
		"\u0286\3\2\2\2\u0286\u0287\3\2\2\2\u0287\u0288\5\u009cO\2\u0288\u008d"+
		"\3\2\2\2\u0289\u028b\7J\2\2\u028a\u0289\3\2\2\2\u028b\u028e\3\2\2\2\u028c"+
		"\u028a\3\2\2\2\u028c\u028d\3\2\2\2\u028d\u0290\3\2\2\2\u028e\u028c\3\2"+
		"\2\2\u028f\u0291\t\31\2\2\u0290\u028f\3\2\2\2\u0290\u0291\3\2\2\2\u0291"+
		"\u0292\3\2\2\2\u0292\u0297\5\u0090I\2\u0293\u0294\7\6\2\2\u0294\u0295"+
		"\5\64\33\2\u0295\u0296\7\63\2\2\u0296\u0298\3\2\2\2\u0297\u0293\3\2\2"+
		"\2\u0297\u0298\3\2\2\2\u0298\u02a3\3\2\2\2\u0299\u029a\7\21\2\2\u029a"+
		"\u029f\5\u0090I\2\u029b\u029c\7\6\2\2\u029c\u029d\5\64\33\2\u029d\u029e"+
		"\7\63\2\2\u029e\u02a0\3\2\2\2\u029f\u029b\3\2\2\2\u029f\u02a0\3\2\2\2"+
		"\u02a0\u02a2\3\2\2\2\u02a1\u0299\3\2\2\2\u02a2\u02a5\3\2\2\2\u02a3\u02a1"+
		"\3\2\2\2\u02a3\u02a4\3\2\2\2\u02a4\u02a9\3\2\2\2\u02a5\u02a3\3\2\2\2\u02a6"+
		"\u02a9\7G\2\2\u02a7\u02a9\7H\2\2\u02a8\u028c\3\2\2\2\u02a8\u02a6\3\2\2"+
		"\2\u02a8\u02a7\3\2\2\2\u02a9\u008f\3\2\2\2\u02aa\u02ac\t\32\2\2\u02ab"+
		"\u02aa\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02ab\3\2\2\2\u02ad\u02ae\3\2"+
		"\2\2\u02ae\u0091\3\2\2\2\u02af\u02b1\t\33\2\2\u02b0\u02af\3\2\2\2\u02b0"+
		"\u02b1\3\2\2\2\u02b1\u02b2\3\2\2\2\u02b2\u02b3\5\u008eH\2\u02b3\u0093"+
		"\3\2\2\2\u02b4\u02b7\5\u009cO\2\u02b5\u02b7\5*\26\2\u02b6\u02b4\3\2\2"+
		"\2\u02b6\u02b5\3\2\2\2\u02b7\u0095\3\2\2\2\u02b8\u02b9\7 \2\2\u02b9\u02ba"+
		"\7F\2\2\u02ba\u02c8\7\16\2\2\u02bb\u02c4\7 \2\2\u02bc\u02c1\5\u0098M\2"+
		"\u02bd\u02be\7\35\2\2\u02be\u02c0\5\u0098M\2\u02bf\u02bd\3\2\2\2\u02c0"+
		"\u02c3\3\2\2\2\u02c1\u02bf\3\2\2\2\u02c1\u02c2\3\2\2\2\u02c2\u02c5\3\2"+
		"\2\2\u02c3\u02c1\3\2\2\2\u02c4\u02bc\3\2\2\2\u02c4\u02c5\3\2\2\2\u02c5"+
		"\u02c6\3\2\2\2\u02c6\u02c8\7\16\2\2\u02c7\u02b8\3\2\2\2\u02c7\u02bb\3"+
		"\2\2\2\u02c8\u0097\3\2\2\2\u02c9\u02ca\5\u0092J\2\u02ca\u02cb\5\u009a"+
		"N\2\u02cb\u0099\3\2\2\2\u02cc\u02ce\5\u00a0Q\2\u02cd\u02cc\3\2\2\2\u02cd"+
		"\u02ce\3\2\2\2\u02ce\u02d6\3\2\2\2\u02cf\u02d0\7 \2\2\u02d0\u02d1\5\u009a"+
		"N\2\u02d1\u02d2\7\16\2\2\u02d2\u02d7\3\2\2\2\u02d3\u02d5\5\u0094K\2\u02d4"+
		"\u02d3\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5\u02d7\3\2\2\2\u02d6\u02cf\3\2"+
		"\2\2\u02d6\u02d4\3\2\2\2\u02d7\u02d9\3\2\2\2\u02d8\u02da\5z>\2\u02d9\u02d8"+
		"\3\2\2\2\u02d9\u02da\3\2\2\2\u02da\u009b\3\2\2\2\u02db\u02e0\7V\2\2\u02dc"+
		"\u02dd\7\21\2\2\u02dd\u02df\7V\2\2\u02de\u02dc\3\2\2\2\u02df\u02e2\3\2"+
		"\2\2\u02e0\u02de\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1\u009d\3\2\2\2\u02e2"+
		"\u02e0\3\2\2\2\u02e3\u02e4\t\34\2\2\u02e4\u009f\3\2\2\2\u02e5\u02e7\5"+
		"(\25\2\u02e6\u02e5\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8\u02e6\3\2\2\2\u02e8"+
		"\u02e9\3\2\2\2\u02e9\u00a1\3\2\2\2P\u00a8\u00aa\u00b5\u00d8\u00dc\u00e6"+
		"\u00f1\u00f4\u0100\u0103\u0106\u010b\u0110\u011a\u012b\u0155\u0169\u016b"+
		"\u0186\u018c\u0194\u0199\u019e\u01a3\u01a8\u01ad\u01b3\u01b9\u01be\u01c3"+
		"\u01c8\u01d0\u01d6\u01e5\u01ed\u0201\u0207\u020c\u020e\u0216\u0219\u0223"+
		"\u0228\u0231\u0234\u0238\u023c\u0240\u0243\u0246\u024c\u0251\u0258\u0262"+
		"\u0269\u026e\u0271\u027e\u0282\u0285\u028c\u0290\u0297\u029f\u02a3\u02a8"+
		"\u02ad\u02b0\u02b6\u02c1\u02c4\u02c7\u02cd\u02d4\u02d6\u02d9\u02e0\u02e8";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
	}
}
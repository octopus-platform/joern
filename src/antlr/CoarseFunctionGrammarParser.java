// Generated from CoarseFunctionGrammar.g4 by ANTLR 4.0.1-SNAPSHOT

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

public class CoarseFunctionGrammarParser extends Parser<Token> {
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
		"<INVALID>", "'&'", "'*'", "'['", "'--'", "'<'", "'!='", "'<='", "'<<'", 
		"'->'", "'%'", "'*='", "')'", "'inline'", "'explicit'", "'::'", "'='", 
		"'|='", "'new'", "'|'", "'!'", "'sizeof'", "'<<='", "']'", "'->*'", "'-='", 
		"'public'", "','", "'-'", "'('", "':'", "'&='", "'private'", "'?'", "'>>='", 
		"'+='", "'^='", "'friend'", "'++'", "'static'", "'>>'", "'^'", "'delete'", 
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
		RULE_coarse_content = 0, RULE_coarse_content_elem = 1, RULE_unary_operator = 2, 
		RULE_relational_operator = 3, RULE_constant = 4, RULE_function_decl_specifiers = 5, 
		RULE_ptr_operator = 6, RULE_access_specifier = 7, RULE_operator = 8, RULE_assignment_operator = 9, 
		RULE_equality_operator = 10, RULE_template_decl_start = 11, RULE_template_param_list = 12, 
		RULE_no_brackets = 13, RULE_no_brackets_curlies_or_squares = 14, RULE_no_brackets_or_semicolon = 15, 
		RULE_no_angle_brackets_or_brackets = 16, RULE_no_curlies = 17, RULE_no_squares = 18, 
		RULE_no_squares_or_semicolon = 19, RULE_no_comma_or_semicolon = 20, RULE_assign_water = 21, 
		RULE_assign_water_l2 = 22, RULE_water = 23, RULE_expr = 24, RULE_assign_expr = 25, 
		RULE_conditional_expression = 26, RULE_or_expression = 27, RULE_and_expression = 28, 
		RULE_inclusive_or_expression = 29, RULE_exclusive_or_expression = 30, 
		RULE_bit_and_expression = 31, RULE_equality_expression = 32, RULE_relational_expression = 33, 
		RULE_shift_expression = 34, RULE_additive_expression = 35, RULE_multiplicative_expression = 36, 
		RULE_cast_expression = 37, RULE_cast_target = 38, RULE_unary_expression = 39, 
		RULE_inc_dec = 40, RULE_postfix_expression = 41, RULE_function_argument_list = 42, 
		RULE_function_argument = 43, RULE_primary_expression = 44, RULE_init_declarator = 45, 
		RULE_declarator = 46, RULE_type_suffix = 47, RULE_simple_decl = 48, RULE_var_decl = 49, 
		RULE_init_declarator_list = 50, RULE_initializer = 51, RULE_initializer_list = 52, 
		RULE_class_def = 53, RULE_class_name = 54, RULE_base_classes = 55, RULE_base_class = 56, 
		RULE_type_name = 57, RULE_base_type = 58, RULE_param_decl_specifiers = 59, 
		RULE_parameter_name = 60, RULE_param_type_list = 61, RULE_param_type = 62, 
		RULE_param_type_id = 63, RULE_identifier = 64, RULE_number = 65, RULE_ptrs = 66;
	public static final String[] ruleNames = {
		"coarse_content", "coarse_content_elem", "unary_operator", "relational_operator", 
		"constant", "function_decl_specifiers", "ptr_operator", "access_specifier", 
		"operator", "assignment_operator", "equality_operator", "template_decl_start", 
		"template_param_list", "no_brackets", "no_brackets_curlies_or_squares", 
		"no_brackets_or_semicolon", "no_angle_brackets_or_brackets", "no_curlies", 
		"no_squares", "no_squares_or_semicolon", "no_comma_or_semicolon", "assign_water", 
		"assign_water_l2", "water", "expr", "assign_expr", "conditional_expression", 
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
	public String getGrammarFileName() { return "CoarseFunctionGrammar.g4"; }

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


	public CoarseFunctionGrammarParser(TokenStream<? extends Token> input) {
		super(input);
		_interp = new ParserATNSimulator<Token>(this,_ATN);
	}
	public static class Coarse_contentContext extends ParserRuleContext<Token> {
		public List<? extends Coarse_content_elemContext> coarse_content_elem() {
			return getRuleContexts(Coarse_content_elemContext.class);
		}
		public Coarse_content_elemContext coarse_content_elem(int i) {
			return getRuleContext(Coarse_content_elemContext.class,i);
		}
		public TerminalNode<Token> EOF() { return getToken(CoarseFunctionGrammarParser.EOF, 0); }
		public Coarse_contentContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coarse_content; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterCoarse_content(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitCoarse_content(this);
		}
	}

	@RuleVersion(0)
	public final Coarse_contentContext coarse_content() throws RecognitionException {
		Coarse_contentContext _localctx = new Coarse_contentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_coarse_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (DO - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(134); coarse_content_elem();
				}
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(140); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Coarse_content_elemContext extends ParserRuleContext<Token> {
		public WaterContext water() {
			return getRuleContext(WaterContext.class,0);
		}
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public Simple_declContext simple_decl() {
			return getRuleContext(Simple_declContext.class,0);
		}
		public Coarse_content_elemContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coarse_content_elem; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterCoarse_content_elem(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitCoarse_content_elem(this);
		}
	}

	@RuleVersion(0)
	public final Coarse_content_elemContext coarse_content_elem() throws RecognitionException {
		Coarse_content_elemContext _localctx = new Coarse_content_elemContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_coarse_content_elem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(142); simple_decl();
				}
				break;
			case 2:
				{
				setState(143); unary_expression();
				}
				break;
			case 3:
				{
				setState(144); water();
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

	public static class Unary_operatorContext extends ParserRuleContext<Token> {
		public Unary_operatorContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitUnary_operator(this);
		}
	}

	@RuleVersion(0)
	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 20) | (1L << 28) | (1L << 44) | (1L << 54))) != 0)) ) {
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterRelational_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitRelational_operator(this);
		}
	}

	@RuleVersion(0)
	public final Relational_operatorContext relational_operator() throws RecognitionException {
		Relational_operatorContext _localctx = new Relational_operatorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_relational_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 7) | (1L << 49) | (1L << 55))) != 0)) ) {
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
		public TerminalNode<Token> CHAR() { return getToken(CoarseFunctionGrammarParser.CHAR, 0); }
		public TerminalNode<Token> OCTAL_LITERAL() { return getToken(CoarseFunctionGrammarParser.OCTAL_LITERAL, 0); }
		public TerminalNode<Token> HEX_LITERAL() { return getToken(CoarseFunctionGrammarParser.HEX_LITERAL, 0); }
		public TerminalNode<Token> FLOATING_POINT_LITERAL() { return getToken(CoarseFunctionGrammarParser.FLOATING_POINT_LITERAL, 0); }
		public TerminalNode<Token> DECIMAL_LITERAL() { return getToken(CoarseFunctionGrammarParser.DECIMAL_LITERAL, 0); }
		public TerminalNode<Token> STRING() { return getToken(CoarseFunctionGrammarParser.STRING, 0); }
		public ConstantContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitConstant(this);
		}
	}

	@RuleVersion(0)
	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterFunction_decl_specifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitFunction_decl_specifiers(this);
		}
	}

	@RuleVersion(0)
	public final Function_decl_specifiersContext function_decl_specifiers() throws RecognitionException {
		Function_decl_specifiersContext _localctx = new Function_decl_specifiersContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_la = _input.LA(1);
			if ( !(((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & ((1L << (13 - 13)) | (1L << (14 - 13)) | (1L << (37 - 13)) | (1L << (39 - 13)) | (1L << (VIRTUAL - 13)))) != 0)) ) {
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterPtr_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitPtr_operator(this);
		}
	}

	@RuleVersion(0)
	public final Ptr_operatorContext ptr_operator() throws RecognitionException {
		Ptr_operatorContext _localctx = new Ptr_operatorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ptr_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_la = _input.LA(1);
			if ( !(_la==1 || _la==2) ) {
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterAccess_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitAccess_specifier(this);
		}
	}

	@RuleVersion(0)
	public final Access_specifierContext access_specifier() throws RecognitionException {
		Access_specifierContext _localctx = new Access_specifierContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_access_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitOperator(this);
		}
	}

	@RuleVersion(0)
	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_operator);
		int _la;
		try {
			setState(204);
			switch (_input.LA(1)) {
			case 18:
			case 42:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(159);
				_la = _input.LA(1);
				if ( !(_la==18 || _la==42) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(162);
				_la = _input.LA(1);
				if (_la==3) {
					{
					setState(160); match(3);
					setState(161); match(23);
					}
				}

				}
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 2);
				{
				setState(164); match(44);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 3);
				{
				setState(165); match(28);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 4);
				{
				setState(166); match(2);
				}
				break;
			case 53:
				enterOuterAlt(_localctx, 5);
				{
				setState(167); match(53);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 6);
				{
				setState(168); match(10);
				}
				break;
			case 41:
				enterOuterAlt(_localctx, 7);
				{
				setState(169); match(41);
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 8);
				{
				setState(170); match(1);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 9);
				{
				setState(171); match(19);
				}
				break;
			case 54:
				enterOuterAlt(_localctx, 10);
				{
				setState(172); match(54);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 11);
				{
				setState(173); match(20);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 12);
				{
				setState(174); match(16);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 13);
				{
				setState(175); match(5);
				}
				break;
			case 49:
				enterOuterAlt(_localctx, 14);
				{
				setState(176); match(49);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 15);
				{
				setState(177); match(35);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 16);
				{
				setState(178); match(25);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 17);
				{
				setState(179); match(11);
				}
				break;
			case 51:
				enterOuterAlt(_localctx, 18);
				{
				setState(180); match(51);
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 19);
				{
				setState(181); match(50);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 20);
				{
				setState(182); match(36);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 21);
				{
				setState(183); match(31);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 22);
				{
				setState(184); match(17);
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 23);
				{
				setState(185); match(40);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 24);
				{
				setState(186); match(8);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 25);
				{
				setState(187); match(34);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 26);
				{
				setState(188); match(22);
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 27);
				{
				setState(189); match(52);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 28);
				{
				setState(190); match(6);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 29);
				{
				setState(191); match(7);
				}
				break;
			case 55:
				enterOuterAlt(_localctx, 30);
				{
				setState(192); match(55);
				}
				break;
			case 47:
				enterOuterAlt(_localctx, 31);
				{
				setState(193); match(47);
				}
				break;
			case 48:
				enterOuterAlt(_localctx, 32);
				{
				setState(194); match(48);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 33);
				{
				setState(195); match(38);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 34);
				{
				setState(196); match(4);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 35);
				{
				setState(197); match(27);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 36);
				{
				setState(198); match(24);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 37);
				{
				setState(199); match(9);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 38);
				{
				setState(200); match(29);
				setState(201); match(12);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 39);
				{
				setState(202); match(3);
				setState(203); match(23);
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterAssignment_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitAssignment_operator(this);
		}
	}

	@RuleVersion(0)
	public final Assignment_operatorContext assignment_operator() throws RecognitionException {
		Assignment_operatorContext _localctx = new Assignment_operatorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignment_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 16) | (1L << 17) | (1L << 22) | (1L << 25) | (1L << 31) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 50) | (1L << 51))) != 0)) ) {
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterEquality_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitEquality_operator(this);
		}
	}

	@RuleVersion(0)
	public final Equality_operatorContext equality_operator() throws RecognitionException {
		Equality_operatorContext _localctx = new Equality_operatorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_equality_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
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
		public TerminalNode<Token> TEMPLATE() { return getToken(CoarseFunctionGrammarParser.TEMPLATE, 0); }
		public Template_decl_startContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_decl_start; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterTemplate_decl_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitTemplate_decl_start(this);
		}
	}

	@RuleVersion(0)
	public final Template_decl_startContext template_decl_start() throws RecognitionException {
		Template_decl_startContext _localctx = new Template_decl_startContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_template_decl_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210); match(TEMPLATE);
			setState(211); match(5);
			setState(212); template_param_list();
			setState(213); match(49);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterTemplate_param_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitTemplate_param_list(this);
		}
	}

	@RuleVersion(0)
	public final Template_param_listContext template_param_list() throws RecognitionException {
		Template_param_listContext _localctx = new Template_param_listContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_template_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(224);
				switch (_input.LA(1)) {
				case 5:
					{
					{
					setState(215); match(5);
					setState(216); template_param_list();
					setState(217); match(49);
					}
					}
					break;
				case 29:
					{
					{
					setState(219); match(29);
					setState(220); template_param_list();
					setState(221); match(12);
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
					setState(223); no_angle_brackets_or_brackets();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(226); 
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterNo_brackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitNo_brackets(this);
		}
	}

	@RuleVersion(0)
	public final No_bracketsContext no_brackets() throws RecognitionException {
		No_bracketsContext _localctx = new No_bracketsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_no_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
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

	public static class No_brackets_curlies_or_squaresContext extends ParserRuleContext<Token> {
		public No_brackets_curlies_or_squaresContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no_brackets_curlies_or_squares; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterNo_brackets_curlies_or_squares(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitNo_brackets_curlies_or_squares(this);
		}
	}

	@RuleVersion(0)
	public final No_brackets_curlies_or_squaresContext no_brackets_curlies_or_squares() throws RecognitionException {
		No_brackets_curlies_or_squaresContext _localctx = new No_brackets_curlies_or_squaresContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_no_brackets_curlies_or_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 12) | (1L << 23) | (1L << 29))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterNo_brackets_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitNo_brackets_or_semicolon(this);
		}
	}

	@RuleVersion(0)
	public final No_brackets_or_semicolonContext no_brackets_or_semicolon() throws RecognitionException {
		No_brackets_or_semicolonContext _localctx = new No_brackets_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_no_brackets_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 29) | (1L << 46))) != 0)) ) {
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterNo_angle_brackets_or_brackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitNo_angle_brackets_or_brackets(this);
		}
	}

	@RuleVersion(0)
	public final No_angle_brackets_or_bracketsContext no_angle_brackets_or_brackets() throws RecognitionException {
		No_angle_brackets_or_bracketsContext _localctx = new No_angle_brackets_or_bracketsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_no_angle_brackets_or_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 12) | (1L << 29) | (1L << 49))) != 0)) ) {
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterNo_curlies(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitNo_curlies(this);
		}
	}

	@RuleVersion(0)
	public final No_curliesContext no_curlies() throws RecognitionException {
		No_curliesContext _localctx = new No_curliesContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_no_curlies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterNo_squares(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitNo_squares(this);
		}
	}

	@RuleVersion(0)
	public final No_squaresContext no_squares() throws RecognitionException {
		No_squaresContext _localctx = new No_squaresContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_no_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==3 || _la==23) ) {
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterNo_squares_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitNo_squares_or_semicolon(this);
		}
	}

	@RuleVersion(0)
	public final No_squares_or_semicolonContext no_squares_or_semicolon() throws RecognitionException {
		No_squares_or_semicolonContext _localctx = new No_squares_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_no_squares_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 23) | (1L << 46))) != 0)) ) {
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterNo_comma_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitNo_comma_or_semicolon(this);
		}
	}

	@RuleVersion(0)
	public final No_comma_or_semicolonContext no_comma_or_semicolon() throws RecognitionException {
		No_comma_or_semicolonContext _localctx = new No_comma_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_no_comma_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterAssign_water(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitAssign_water(this);
		}
	}

	@RuleVersion(0)
	public final Assign_waterContext assign_water() throws RecognitionException {
		Assign_waterContext _localctx = new Assign_waterContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assign_water);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 12) | (1L << 23) | (1L << 27) | (1L << 29) | (1L << 46))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterAssign_water_l2(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitAssign_water_l2(this);
		}
	}

	@RuleVersion(0)
	public final Assign_water_l2Context assign_water_l2() throws RecognitionException {
		Assign_water_l2Context _localctx = new Assign_water_l2Context(_ctx, getState());
		enterRule(_localctx, 44, RULE_assign_water_l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 12) | (1L << 23) | (1L << 29))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterWater(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitWater(this);
		}
	}

	@RuleVersion(0)
	public final WaterContext water() throws RecognitionException {
		WaterContext _localctx = new WaterContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_water);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitExpr(this);
		}
	}

	@RuleVersion(0)
	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250); assign_expr();
			setState(253);
			_la = _input.LA(1);
			if (_la==27) {
				{
				setState(251); match(27);
				setState(252); expr();
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterAssign_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitAssign_expr(this);
		}
	}

	@RuleVersion(0)
	public final Assign_exprContext assign_expr() throws RecognitionException {
		Assign_exprContext _localctx = new Assign_exprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_assign_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255); conditional_expression();
			setState(259);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 16) | (1L << 17) | (1L << 22) | (1L << 25) | (1L << 31) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 50) | (1L << 51))) != 0)) {
				{
				setState(256); assignment_operator();
				setState(257); assign_expr();
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterConditional_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitConditional_expression(this);
		}
	}

	@RuleVersion(0)
	public final Conditional_expressionContext conditional_expression() throws RecognitionException {
		Conditional_expressionContext _localctx = new Conditional_expressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_conditional_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261); or_expression();
			setState(267);
			_la = _input.LA(1);
			if (_la==33) {
				{
				setState(262); match(33);
				setState(263); expr();
				setState(264); match(30);
				setState(265); conditional_expression();
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterOr_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitOr_expression(this);
		}
	}

	@RuleVersion(0)
	public final Or_expressionContext or_expression() throws RecognitionException {
		Or_expressionContext _localctx = new Or_expressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269); and_expression();
			setState(272);
			_la = _input.LA(1);
			if (_la==48) {
				{
				setState(270); match(48);
				setState(271); or_expression();
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterAnd_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitAnd_expression(this);
		}
	}

	@RuleVersion(0)
	public final And_expressionContext and_expression() throws RecognitionException {
		And_expressionContext _localctx = new And_expressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274); inclusive_or_expression();
			setState(277);
			_la = _input.LA(1);
			if (_la==47) {
				{
				setState(275); match(47);
				setState(276); and_expression();
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterInclusive_or_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitInclusive_or_expression(this);
		}
	}

	@RuleVersion(0)
	public final Inclusive_or_expressionContext inclusive_or_expression() throws RecognitionException {
		Inclusive_or_expressionContext _localctx = new Inclusive_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_inclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279); exclusive_or_expression();
			setState(282);
			_la = _input.LA(1);
			if (_la==19) {
				{
				setState(280); match(19);
				setState(281); inclusive_or_expression();
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterExclusive_or_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitExclusive_or_expression(this);
		}
	}

	@RuleVersion(0)
	public final Exclusive_or_expressionContext exclusive_or_expression() throws RecognitionException {
		Exclusive_or_expressionContext _localctx = new Exclusive_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_exclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284); bit_and_expression();
			setState(287);
			_la = _input.LA(1);
			if (_la==41) {
				{
				setState(285); match(41);
				setState(286); exclusive_or_expression();
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterBit_and_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitBit_and_expression(this);
		}
	}

	@RuleVersion(0)
	public final Bit_and_expressionContext bit_and_expression() throws RecognitionException {
		Bit_and_expressionContext _localctx = new Bit_and_expressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_bit_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289); equality_expression();
			setState(292);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(290); match(1);
				setState(291); bit_and_expression();
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterEquality_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitEquality_expression(this);
		}
	}

	@RuleVersion(0)
	public final Equality_expressionContext equality_expression() throws RecognitionException {
		Equality_expressionContext _localctx = new Equality_expressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_equality_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294); relational_expression();
			setState(298);
			_la = _input.LA(1);
			if (_la==6 || _la==52) {
				{
				setState(295); equality_operator();
				setState(296); equality_expression();
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterRelational_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitRelational_expression(this);
		}
	}

	@RuleVersion(0)
	public final Relational_expressionContext relational_expression() throws RecognitionException {
		Relational_expressionContext _localctx = new Relational_expressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_relational_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300); shift_expression();
			setState(304);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 7) | (1L << 49) | (1L << 55))) != 0)) {
				{
				setState(301); relational_operator();
				setState(302); relational_expression();
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterShift_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitShift_expression(this);
		}
	}

	@RuleVersion(0)
	public final Shift_expressionContext shift_expression() throws RecognitionException {
		Shift_expressionContext _localctx = new Shift_expressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_shift_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306); additive_expression();
			setState(309);
			_la = _input.LA(1);
			if (_la==8 || _la==40) {
				{
				setState(307);
				_la = _input.LA(1);
				if ( !(_la==8 || _la==40) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(308); shift_expression();
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterAdditive_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitAdditive_expression(this);
		}
	}

	@RuleVersion(0)
	public final Additive_expressionContext additive_expression() throws RecognitionException {
		Additive_expressionContext _localctx = new Additive_expressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_additive_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311); multiplicative_expression();
			setState(314);
			_la = _input.LA(1);
			if (_la==28 || _la==44) {
				{
				setState(312);
				_la = _input.LA(1);
				if ( !(_la==28 || _la==44) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(313); additive_expression();
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterMultiplicative_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitMultiplicative_expression(this);
		}
	}

	@RuleVersion(0)
	public final Multiplicative_expressionContext multiplicative_expression() throws RecognitionException {
		Multiplicative_expressionContext _localctx = new Multiplicative_expressionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_multiplicative_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316); cast_expression();
			setState(319);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 10) | (1L << 53))) != 0)) {
				{
				setState(317);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 10) | (1L << 53))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(318); multiplicative_expression();
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterCast_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitCast_expression(this);
		}
	}

	@RuleVersion(0)
	public final Cast_expressionContext cast_expression() throws RecognitionException {
		Cast_expressionContext _localctx = new Cast_expressionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_cast_expression);
		try {
			setState(327);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(321); match(29);
				setState(322); cast_target();
				setState(323); match(12);
				setState(324); cast_expression();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(326); unary_expression();
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterCast_target(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitCast_target(this);
		}
	}

	@RuleVersion(0)
	public final Cast_targetContext cast_target() throws RecognitionException {
		Cast_targetContext _localctx = new Cast_targetContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_cast_target);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329); type_name();
			setState(333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1 || _la==2) {
				{
				{
				setState(330); ptr_operator();
				}
				}
				setState(335);
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterUnary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitUnary_expression(this);
		}
	}

	@RuleVersion(0)
	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_unary_expression);
		int _la;
		try {
			setState(356);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(336); inc_dec();
				setState(337); cast_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(339); unary_operator();
				setState(340); cast_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(342); match(21);
				setState(343); match(29);
				setState(344); type_name();
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1 || _la==2) {
					{
					{
					setState(345); ptr_operator();
					}
					}
					setState(350);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(351); match(12);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(353); match(21);
				setState(354); unary_expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(355); postfix_expression(0);
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterInc_dec(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitInc_dec(this);
		}
	}

	@RuleVersion(0)
	public final Inc_decContext inc_dec() throws RecognitionException {
		Inc_decContext _localctx = new Inc_decContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_inc_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			_la = _input.LA(1);
			if ( !(_la==4 || _la==38) ) {
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterPrimaryOnly(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitPrimaryOnly(this);
		}
	}
	public static class PtrMemberAccessContext extends Postfix_expressionContext {
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public TerminalNode<Token> TEMPLATE() { return getToken(CoarseFunctionGrammarParser.TEMPLATE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PtrMemberAccessContext(Postfix_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterPtrMemberAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitPtrMemberAccess(this);
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterArrayIndexing(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitArrayIndexing(this);
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterIncDecOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitIncDecOp(this);
		}
	}
	public static class MemberAccessContext extends Postfix_expressionContext {
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public TerminalNode<Token> TEMPLATE() { return getToken(CoarseFunctionGrammarParser.TEMPLATE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public MemberAccessContext(Postfix_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterMemberAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitMemberAccess(this);
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitFuncCall(this);
		}
	}

	@RuleVersion(0)
	public final Postfix_expressionContext postfix_expression(int _p) throws RecognitionException {
		ParserRuleContext<Token> _parentctx = _ctx;
		int _parentState = getState();
		Postfix_expressionContext _localctx = new Postfix_expressionContext(_ctx, _parentState);
		Postfix_expressionContext _prevctx = _localctx;
		int _startState = 82;
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

			setState(361); primary_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(389);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(387);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new ArrayIndexingContext(new Postfix_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(363);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(364); match(3);
						setState(365); expr();
						setState(366); match(23);
						}
						break;
					case 2:
						{
						_localctx = new FuncCallContext(new Postfix_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(368);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(369); match(29);
						setState(370); function_argument_list();
						setState(371); match(12);
						}
						break;
					case 3:
						{
						_localctx = new MemberAccessContext(new Postfix_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(373);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(374); match(43);
						setState(376);
						_la = _input.LA(1);
						if (_la==TEMPLATE) {
							{
							setState(375); match(TEMPLATE);
							}
						}

						setState(378); identifier();
						}
						break;
					case 4:
						{
						_localctx = new PtrMemberAccessContext(new Postfix_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(379);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(380); match(9);
						setState(382);
						_la = _input.LA(1);
						if (_la==TEMPLATE) {
							{
							setState(381); match(TEMPLATE);
							}
						}

						setState(384); identifier();
						}
						break;
					case 5:
						{
						_localctx = new IncDecOpContext(new Postfix_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(385);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(386); inc_dec();
						}
						break;
					}
					} 
				}
				setState(391);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterFunction_argument_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitFunction_argument_list(this);
		}
	}

	@RuleVersion(0)
	public final Function_argument_listContext function_argument_list() throws RecognitionException {
		Function_argument_listContext _localctx = new Function_argument_listContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_function_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 4) | (1L << 20) | (1L << 21) | (1L << 28) | (1L << 29) | (1L << 38) | (1L << 44) | (1L << 54))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (ALPHA_NUMERIC - 84)) | (1L << (HEX_LITERAL - 84)) | (1L << (DECIMAL_LITERAL - 84)) | (1L << (OCTAL_LITERAL - 84)) | (1L << (FLOATING_POINT_LITERAL - 84)) | (1L << (CHAR - 84)) | (1L << (STRING - 84)))) != 0)) {
				{
				setState(392); function_argument();
				setState(397);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==27) {
					{
					{
					setState(393); match(27);
					setState(394); function_argument();
					}
					}
					setState(399);
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterFunction_argument(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitFunction_argument(this);
		}
	}

	@RuleVersion(0)
	public final Function_argumentContext function_argument() throws RecognitionException {
		Function_argumentContext _localctx = new Function_argumentContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_function_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402); assign_expr();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterPrimary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitPrimary_expression(this);
		}
	}

	@RuleVersion(0)
	public final Primary_expressionContext primary_expression() throws RecognitionException {
		Primary_expressionContext _localctx = new Primary_expressionContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_primary_expression);
		try {
			setState(410);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(404); identifier();
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
				setState(405); constant();
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 3);
				{
				setState(406); match(29);
				setState(407); expr();
				setState(408); match(12);
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterInitDeclWithCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitInitDeclWithCall(this);
		}
	}
	public static class InitDeclSimpleContext extends Init_declaratorContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public InitDeclSimpleContext(Init_declaratorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterInitDeclSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitInitDeclSimple(this);
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterInitDeclWithAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitInitDeclWithAssign(this);
		}
	}

	@RuleVersion(0)
	public final Init_declaratorContext init_declarator() throws RecognitionException {
		Init_declaratorContext _localctx = new Init_declaratorContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_init_declarator);
		int _la;
		try {
			setState(424);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				_localctx = new InitDeclWithCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(412); declarator();
				setState(413); match(29);
				setState(415);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 4) | (1L << 20) | (1L << 21) | (1L << 28) | (1L << 29) | (1L << 38) | (1L << 44) | (1L << 54))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (ALPHA_NUMERIC - 84)) | (1L << (HEX_LITERAL - 84)) | (1L << (DECIMAL_LITERAL - 84)) | (1L << (OCTAL_LITERAL - 84)) | (1L << (FLOATING_POINT_LITERAL - 84)) | (1L << (CHAR - 84)) | (1L << (STRING - 84)))) != 0)) {
					{
					setState(414); expr();
					}
				}

				setState(417); match(12);
				}
				break;
			case 2:
				_localctx = new InitDeclWithAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(419); declarator();
				setState(420); match(16);
				setState(421); initializer();
				}
				break;
			case 3:
				_localctx = new InitDeclSimpleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(423); declarator();
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitDeclarator(this);
		}
	}

	@RuleVersion(0)
	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			_la = _input.LA(1);
			if (_la==1 || _la==2) {
				{
				setState(426); ptrs();
				}
			}

			setState(429); identifier();
			setState(431);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(430); type_suffix();
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterType_suffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitType_suffix(this);
		}
	}

	@RuleVersion(0)
	public final Type_suffixContext type_suffix() throws RecognitionException {
		Type_suffixContext _localctx = new Type_suffixContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_type_suffix);
		int _la;
		try {
			setState(439);
			switch (_input.LA(1)) {
			case 3:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(433); match(3);
				setState(435);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 4) | (1L << 20) | (1L << 21) | (1L << 28) | (1L << 29) | (1L << 38) | (1L << 44) | (1L << 54))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (ALPHA_NUMERIC - 84)) | (1L << (HEX_LITERAL - 84)) | (1L << (DECIMAL_LITERAL - 84)) | (1L << (OCTAL_LITERAL - 84)) | (1L << (FLOATING_POINT_LITERAL - 84)) | (1L << (CHAR - 84)) | (1L << (STRING - 84)))) != 0)) {
					{
					setState(434); conditional_expression();
					}
				}

				setState(437); match(23);
				}
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 2);
				{
				setState(438); param_type_list();
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
		public TerminalNode<Token> TYPEDEF() { return getToken(CoarseFunctionGrammarParser.TYPEDEF, 0); }
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Simple_declContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_decl; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterSimple_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitSimple_decl(this);
		}
	}

	@RuleVersion(0)
	public final Simple_declContext simple_decl() throws RecognitionException {
		Simple_declContext _localctx = new Simple_declContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_simple_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(442);
			_la = _input.LA(1);
			if (_la==TYPEDEF) {
				{
				setState(441); match(TYPEDEF);
				}
			}

			setState(445);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(444); template_decl_start();
				}
			}

			}
			setState(447); var_decl();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterDeclByClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitDeclByClass(this);
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterDeclByType(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitDeclByType(this);
		}
	}

	@RuleVersion(0)
	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_var_decl);
		try {
			setState(456);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				_localctx = new DeclByClassContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(449); class_def();
				setState(451);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(450); init_declarator_list();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new DeclByTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(453); type_name();
				setState(454); init_declarator_list();
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterInit_declarator_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitInit_declarator_list(this);
		}
	}

	@RuleVersion(0)
	public final Init_declarator_listContext init_declarator_list() throws RecognitionException {
		Init_declarator_listContext _localctx = new Init_declarator_listContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458); init_declarator();
			setState(463);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==27) {
				{
				{
				setState(459); match(27);
				setState(460); init_declarator();
				}
				}
				setState(465);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(466); match(46);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitInitializer(this);
		}
	}

	@RuleVersion(0)
	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_initializer);
		try {
			setState(473);
			switch (_input.LA(1)) {
			case 1:
			case 2:
			case 4:
			case 20:
			case 21:
			case 28:
			case 29:
			case 38:
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
				setState(468); assign_expr();
				}
				break;
			case OPENING_CURLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(469); match(OPENING_CURLY);
				setState(470); initializer_list();
				setState(471); match(CLOSING_CURLY);
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterInitializer_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitInitializer_list(this);
		}
	}

	@RuleVersion(0)
	public final Initializer_listContext initializer_list() throws RecognitionException {
		Initializer_listContext _localctx = new Initializer_listContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_initializer_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475); initializer();
			setState(480);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==27) {
				{
				{
				setState(476); match(27);
				setState(477); initializer();
				}
				}
				setState(482);
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
		public TerminalNode<Token> CLASS_KEY() { return getToken(CoarseFunctionGrammarParser.CLASS_KEY, 0); }
		public TerminalNode<Token> OPENING_CURLY() { return getToken(CoarseFunctionGrammarParser.OPENING_CURLY, 0); }
		public Class_defContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_def; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterClass_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitClass_def(this);
		}
	}

	@RuleVersion(0)
	public final Class_defContext class_def() throws RecognitionException {
		Class_defContext _localctx = new Class_defContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483); match(CLASS_KEY);
			setState(485);
			_la = _input.LA(1);
			if (_la==ALPHA_NUMERIC) {
				{
				setState(484); class_name();
				}
			}

			setState(488);
			_la = _input.LA(1);
			if (_la==30) {
				{
				setState(487); base_classes();
				}
			}

			setState(490); match(OPENING_CURLY);
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterClass_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitClass_name(this);
		}
	}

	@RuleVersion(0)
	public final Class_nameContext class_name() throws RecognitionException {
		Class_nameContext _localctx = new Class_nameContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_class_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493); identifier();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterBase_classes(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitBase_classes(this);
		}
	}

	@RuleVersion(0)
	public final Base_classesContext base_classes() throws RecognitionException {
		Base_classesContext _localctx = new Base_classesContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_base_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495); match(30);
			setState(496); base_class();
			setState(501);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==27) {
				{
				{
				setState(497); match(27);
				setState(498); base_class();
				}
				}
				setState(503);
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
		public TerminalNode<Token> VIRTUAL() { return getToken(CoarseFunctionGrammarParser.VIRTUAL, 0); }
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterBase_class(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitBase_class(this);
		}
	}

	@RuleVersion(0)
	public final Base_classContext base_class() throws RecognitionException {
		Base_classContext _localctx = new Base_classContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_base_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			_la = _input.LA(1);
			if (_la==VIRTUAL) {
				{
				setState(504); match(VIRTUAL);
				}
			}

			setState(508);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 26) | (1L << 32) | (1L << 45))) != 0)) {
				{
				setState(507); access_specifier();
				}
			}

			setState(510); identifier();
			}
		}
		catch (RecognitionException re) {
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
		public List<? extends TerminalNode<Token>> CV_QUALIFIER() { return getTokens(CoarseFunctionGrammarParser.CV_QUALIFIER); }
		public Template_param_listContext template_param_list(int i) {
			return getRuleContext(Template_param_listContext.class,i);
		}
		public TerminalNode<Token> SIGNED() { return getToken(CoarseFunctionGrammarParser.SIGNED, 0); }
		public TerminalNode<Token> UNSIGNED() { return getToken(CoarseFunctionGrammarParser.UNSIGNED, 0); }
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
			return getToken(CoarseFunctionGrammarParser.CV_QUALIFIER, i);
		}
		public TerminalNode<Token> CLASS_KEY() { return getToken(CoarseFunctionGrammarParser.CLASS_KEY, 0); }
		public Type_nameContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterType_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitType_name(this);
		}
	}

	@RuleVersion(0)
	public final Type_nameContext type_name() throws RecognitionException {
		Type_nameContext _localctx = new Type_nameContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_type_name);
		int _la;
		try {
			setState(543);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(515);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CV_QUALIFIER) {
					{
					{
					setState(512); match(CV_QUALIFIER);
					}
					}
					setState(517);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(519);
				_la = _input.LA(1);
				if (((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (UNSIGNED - 69)) | (1L << (SIGNED - 69)) | (1L << (CLASS_KEY - 69)))) != 0)) {
					{
					setState(518);
					_la = _input.LA(1);
					if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (UNSIGNED - 69)) | (1L << (SIGNED - 69)) | (1L << (CLASS_KEY - 69)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(521); base_type();
				setState(526);
				_la = _input.LA(1);
				if (_la==5) {
					{
					setState(522); match(5);
					setState(523); template_param_list();
					setState(524); match(49);
					}
				}

				setState(538);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==15) {
					{
					{
					setState(528); match(15);
					setState(529); base_type();
					setState(534);
					_la = _input.LA(1);
					if (_la==5) {
						{
						setState(530); match(5);
						setState(531); template_param_list();
						setState(532); match(49);
						}
					}

					}
					}
					setState(540);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(541); match(UNSIGNED);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(542); match(SIGNED);
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
		public TerminalNode<Token> VOID() { return getToken(CoarseFunctionGrammarParser.VOID, 0); }
		public TerminalNode<Token> ALPHA_NUMERIC() { return getToken(CoarseFunctionGrammarParser.ALPHA_NUMERIC, 0); }
		public TerminalNode<Token> LONG(int i) {
			return getToken(CoarseFunctionGrammarParser.LONG, i);
		}
		public List<? extends TerminalNode<Token>> LONG() { return getTokens(CoarseFunctionGrammarParser.LONG); }
		public Base_typeContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterBase_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitBase_type(this);
		}
	}

	@RuleVersion(0)
	public final Base_typeContext base_type() throws RecognitionException {
		Base_typeContext _localctx = new Base_typeContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_base_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				setState(545); match(ALPHA_NUMERIC);
				}
				break;
			case 2:
				{
				setState(546); match(VOID);
				}
				break;
			case 3:
				{
				setState(547); match(LONG);
				}
				break;
			case 4:
				{
				setState(548); match(LONG);
				setState(549); match(LONG);
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

	public static class Param_decl_specifiersContext extends ParserRuleContext<Token> {
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public TerminalNode<Token> REGISTER() { return getToken(CoarseFunctionGrammarParser.REGISTER, 0); }
		public TerminalNode<Token> AUTO() { return getToken(CoarseFunctionGrammarParser.AUTO, 0); }
		public Param_decl_specifiersContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl_specifiers; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterParam_decl_specifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitParam_decl_specifiers(this);
		}
	}

	@RuleVersion(0)
	public final Param_decl_specifiersContext param_decl_specifiers() throws RecognitionException {
		Param_decl_specifiersContext _localctx = new Param_decl_specifiersContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_param_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			_la = _input.LA(1);
			if (_la==AUTO || _la==REGISTER) {
				{
				setState(552);
				_la = _input.LA(1);
				if ( !(_la==AUTO || _la==REGISTER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(555); type_name();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterParameter_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitParameter_name(this);
		}
	}

	@RuleVersion(0)
	public final Parameter_nameContext parameter_name() throws RecognitionException {
		Parameter_nameContext _localctx = new Parameter_nameContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_parameter_name);
		try {
			setState(559);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(557); identifier();
				}
				break;
			case 26:
			case 32:
			case 45:
				enterOuterAlt(_localctx, 2);
				{
				setState(558); access_specifier();
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
		public TerminalNode<Token> VOID() { return getToken(CoarseFunctionGrammarParser.VOID, 0); }
		public Param_type_listContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_type_list; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterParam_type_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitParam_type_list(this);
		}
	}

	@RuleVersion(0)
	public final Param_type_listContext param_type_list() throws RecognitionException {
		Param_type_listContext _localctx = new Param_type_listContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_param_type_list);
		int _la;
		try {
			setState(576);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(561); match(29);
				setState(562); match(VOID);
				setState(563); match(12);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(564); match(29);
				setState(573);
				_la = _input.LA(1);
				if (((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (VOID - 68)) | (1L << (UNSIGNED - 68)) | (1L << (SIGNED - 68)) | (1L << (LONG - 68)) | (1L << (CV_QUALIFIER - 68)) | (1L << (AUTO - 68)) | (1L << (REGISTER - 68)) | (1L << (CLASS_KEY - 68)) | (1L << (ALPHA_NUMERIC - 68)))) != 0)) {
					{
					setState(565); param_type();
					setState(570);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==27) {
						{
						{
						setState(566); match(27);
						setState(567); param_type();
						}
						}
						setState(572);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(575); match(12);
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterParam_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitParam_type(this);
		}
	}

	@RuleVersion(0)
	public final Param_typeContext param_type() throws RecognitionException {
		Param_typeContext _localctx = new Param_typeContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_param_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(578); param_decl_specifiers();
			setState(579); param_type_id();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterParam_type_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitParam_type_id(this);
		}
	}

	@RuleVersion(0)
	public final Param_type_idContext param_type_id() throws RecognitionException {
		Param_type_idContext _localctx = new Param_type_idContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_param_type_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582);
			_la = _input.LA(1);
			if (_la==1 || _la==2) {
				{
				setState(581); ptrs();
				}
			}

			setState(591);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				{
				setState(584); match(29);
				setState(585); param_type_id();
				setState(586); match(12);
				}
				break;
			case 2:
				{
				setState(589);
				_la = _input.LA(1);
				if (((((_la - 26)) & ~0x3f) == 0 && ((1L << (_la - 26)) & ((1L << (26 - 26)) | (1L << (32 - 26)) | (1L << (45 - 26)) | (1L << (ALPHA_NUMERIC - 26)))) != 0)) {
					{
					setState(588); parameter_name();
					}
				}

				}
				break;
			}
			setState(594);
			_la = _input.LA(1);
			if (_la==3 || _la==29) {
				{
				setState(593); type_suffix();
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
			return getToken(CoarseFunctionGrammarParser.ALPHA_NUMERIC, i);
		}
		public List<? extends TerminalNode<Token>> ALPHA_NUMERIC() { return getTokens(CoarseFunctionGrammarParser.ALPHA_NUMERIC); }
		public IdentifierContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitIdentifier(this);
		}
	}

	@RuleVersion(0)
	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_identifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(596); match(ALPHA_NUMERIC);
			setState(601);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(597); match(15);
					setState(598); match(ALPHA_NUMERIC);
					}
					} 
				}
				setState(603);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
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
		public TerminalNode<Token> OCTAL_LITERAL() { return getToken(CoarseFunctionGrammarParser.OCTAL_LITERAL, 0); }
		public TerminalNode<Token> HEX_LITERAL() { return getToken(CoarseFunctionGrammarParser.HEX_LITERAL, 0); }
		public TerminalNode<Token> DECIMAL_LITERAL() { return getToken(CoarseFunctionGrammarParser.DECIMAL_LITERAL, 0); }
		public NumberContext(ParserRuleContext<Token> parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitNumber(this);
		}
	}

	@RuleVersion(0)
	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(604);
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
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).enterPtrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener<? super Token> listener) {
			if ( listener instanceof CoarseFunctionGrammarListener ) ((CoarseFunctionGrammarListener)listener).exitPtrs(this);
		}
	}

	@RuleVersion(0)
	public final PtrsContext ptrs() throws RecognitionException {
		PtrsContext _localctx = new PtrsContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_ptrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(606); ptr_operator();
				}
				}
				setState(609); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==1 || _la==2 );
			}
		}
		catch (RecognitionException re) {
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
		case 41: return postfix_expression_sempred((Postfix_expressionContext)_localctx, predIndex);
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
		"\5\3e\u0266\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\3\2\7\2\u008a"+
		"\n\2\f\2\16\2\u008d\13\2\3\2\3\2\3\3\3\3\3\3\5\3\u0094\n\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\5\n\u00a5\n\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u00cf\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\6\16\u00e3\n\16\r\16\16\16\u00e4"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\5\32\u0100\n\32"+
		"\3\33\3\33\3\33\3\33\5\33\u0106\n\33\3\34\3\34\3\34\3\34\3\34\3\34\5\34"+
		"\u010e\n\34\3\35\3\35\3\35\5\35\u0113\n\35\3\36\3\36\3\36\5\36\u0118\n"+
		"\36\3\37\3\37\3\37\5\37\u011d\n\37\3 \3 \3 \5 \u0122\n \3!\3!\3!\5!\u0127"+
		"\n!\3\"\3\"\3\"\3\"\5\"\u012d\n\"\3#\3#\3#\3#\5#\u0133\n#\3$\3$\3$\5$"+
		"\u0138\n$\3%\3%\3%\5%\u013d\n%\3&\3&\3&\5&\u0142\n&\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\5\'\u014a\n\'\3(\3(\7(\u014e\n(\f(\16(\u0151\13(\3)\3)\3)\3)\3"+
		")\3)\3)\3)\3)\3)\7)\u015d\n)\f)\16)\u0160\13)\3)\3)\3)\3)\3)\5)\u0167"+
		"\n)\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\5+\u017b\n+"+
		"\3+\3+\3+\3+\5+\u0181\n+\3+\3+\3+\7+\u0186\n+\f+\16+\u0189\13+\3,\3,\3"+
		",\7,\u018e\n,\f,\16,\u0191\13,\5,\u0193\n,\3-\3-\3.\3.\3.\3.\3.\3.\5."+
		"\u019d\n.\3/\3/\3/\5/\u01a2\n/\3/\3/\3/\3/\3/\3/\3/\5/\u01ab\n/\3\60\5"+
		"\60\u01ae\n\60\3\60\3\60\5\60\u01b2\n\60\3\61\3\61\5\61\u01b6\n\61\3\61"+
		"\3\61\5\61\u01ba\n\61\3\62\5\62\u01bd\n\62\3\62\5\62\u01c0\n\62\3\62\3"+
		"\62\3\63\3\63\5\63\u01c6\n\63\3\63\3\63\3\63\5\63\u01cb\n\63\3\64\3\64"+
		"\3\64\7\64\u01d0\n\64\f\64\16\64\u01d3\13\64\3\64\3\64\3\65\3\65\3\65"+
		"\3\65\3\65\5\65\u01dc\n\65\3\66\3\66\3\66\7\66\u01e1\n\66\f\66\16\66\u01e4"+
		"\13\66\3\67\3\67\5\67\u01e8\n\67\3\67\5\67\u01eb\n\67\3\67\3\67\3\67\3"+
		"8\38\39\39\39\39\79\u01f6\n9\f9\169\u01f9\139\3:\5:\u01fc\n:\3:\5:\u01ff"+
		"\n:\3:\3:\3;\7;\u0204\n;\f;\16;\u0207\13;\3;\5;\u020a\n;\3;\3;\3;\3;\3"+
		";\5;\u0211\n;\3;\3;\3;\3;\3;\3;\5;\u0219\n;\7;\u021b\n;\f;\16;\u021e\13"+
		";\3;\3;\5;\u0222\n;\3<\3<\3<\3<\3<\5<\u0229\n<\3=\5=\u022c\n=\3=\3=\3"+
		">\3>\5>\u0232\n>\3?\3?\3?\3?\3?\3?\3?\7?\u023b\n?\f?\16?\u023e\13?\5?"+
		"\u0240\n?\3?\5?\u0243\n?\3@\3@\3@\3A\5A\u0249\nA\3A\3A\3A\3A\3A\5A\u0250"+
		"\nA\5A\u0252\nA\3A\5A\u0255\nA\3B\3B\3B\7B\u025a\nB\fB\16B\u025d\13B\3"+
		"C\3C\3D\6D\u0262\nD\rD\16D\u0263\3D\2\2\3TE\2\2\4\2\6\2\b\2\n\2\f\2\16"+
		"\2\20\2\22\2\24\2\26\2\30\2\32\2\34\2\36\2 \2\"\2$\2&\2(\2*\2,\2.\2\60"+
		"\2\62\2\64\2\66\28\2:\2<\2>\2@\2B\2D\2F\2H\2J\2L\2N\2P\2R\2T\2V\2X\2Z"+
		"\2\\\2^\2`\2b\2d\2f\2h\2j\2l\2n\2p\2r\2t\2v\2x\2z\2|\2~\2\u0080\2\u0082"+
		"\2\u0084\2\u0086\2\2\34\7\3\4\26\26\36\36..88\6\7\7\t\t\63\6399\3\\a\6"+
		"\17\20\'\'))KK\3\3\4\5\34\34\"\"//\4\24\24,,\t\r\r\22\23\30\30\33\33!"+
		"!$&\64\65\4\b\b\66\66\4\16\16\37\37\7\5\5\16\16\31\31\37\37WX\5\16\16"+
		"\37\37\60\60\6\7\7\16\16\37\37\63\63\3WX\4\5\5\31\31\5\5\5\31\31\60\60"+
		"\4\35\35\60\60\t\5\5\16\16\31\31\35\35\37\37\60\60WX\7\5\5\16\16\31\31"+
		"\37\37WX\4\n\n**\4\36\36..\5\4\4\f\f\67\67\4\6\6((\4GHUU\3QR\3\\^\u0296"+
		"\2\u008b\3\2\2\2\4\u0093\3\2\2\2\6\u0095\3\2\2\2\b\u0097\3\2\2\2\n\u0099"+
		"\3\2\2\2\f\u009b\3\2\2\2\16\u009d\3\2\2\2\20\u009f\3\2\2\2\22\u00ce\3"+
		"\2\2\2\24\u00d0\3\2\2\2\26\u00d2\3\2\2\2\30\u00d4\3\2\2\2\32\u00e2\3\2"+
		"\2\2\34\u00e6\3\2\2\2\36\u00e8\3\2\2\2 \u00ea\3\2\2\2\"\u00ec\3\2\2\2"+
		"$\u00ee\3\2\2\2&\u00f0\3\2\2\2(\u00f2\3\2\2\2*\u00f4\3\2\2\2,\u00f6\3"+
		"\2\2\2.\u00f8\3\2\2\2\60\u00fa\3\2\2\2\62\u00fc\3\2\2\2\64\u0101\3\2\2"+
		"\2\66\u0107\3\2\2\28\u010f\3\2\2\2:\u0114\3\2\2\2<\u0119\3\2\2\2>\u011e"+
		"\3\2\2\2@\u0123\3\2\2\2B\u0128\3\2\2\2D\u012e\3\2\2\2F\u0134\3\2\2\2H"+
		"\u0139\3\2\2\2J\u013e\3\2\2\2L\u0149\3\2\2\2N\u014b\3\2\2\2P\u0166\3\2"+
		"\2\2R\u0168\3\2\2\2T\u016a\3\2\2\2V\u0192\3\2\2\2X\u0194\3\2\2\2Z\u019c"+
		"\3\2\2\2\\\u01aa\3\2\2\2^\u01ad\3\2\2\2`\u01b9\3\2\2\2b\u01bc\3\2\2\2"+
		"d\u01ca\3\2\2\2f\u01cc\3\2\2\2h\u01db\3\2\2\2j\u01dd\3\2\2\2l\u01e5\3"+
		"\2\2\2n\u01ef\3\2\2\2p\u01f1\3\2\2\2r\u01fb\3\2\2\2t\u0221\3\2\2\2v\u0228"+
		"\3\2\2\2x\u022b\3\2\2\2z\u0231\3\2\2\2|\u0242\3\2\2\2~\u0244\3\2\2\2\u0080"+
		"\u0248\3\2\2\2\u0082\u0256\3\2\2\2\u0084\u025e\3\2\2\2\u0086\u0261\3\2"+
		"\2\2\u0088\u008a\5\4\3\2\u0089\u0088\3\2\2\2\u008a\u008d\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008e\u008f\7\1\2\2\u008f\3\3\2\2\2\u0090\u0094\5b\62\2\u0091\u0094"+
		"\5P)\2\u0092\u0094\5\60\31\2\u0093\u0090\3\2\2\2\u0093\u0091\3\2\2\2\u0093"+
		"\u0092\3\2\2\2\u0094\5\3\2\2\2\u0095\u0096\t\2\2\2\u0096\7\3\2\2\2\u0097"+
		"\u0098\t\3\2\2\u0098\t\3\2\2\2\u0099\u009a\t\4\2\2\u009a\13\3\2\2\2\u009b"+
		"\u009c\t\5\2\2\u009c\r\3\2\2\2\u009d\u009e\t\6\2\2\u009e\17\3\2\2\2\u009f"+
		"\u00a0\t\7\2\2\u00a0\21\3\2\2\2\u00a1\u00a4\t\b\2\2\u00a2\u00a3\7\5\2"+
		"\2\u00a3\u00a5\7\31\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00cf\3\2\2\2\u00a6\u00cf\7.\2\2\u00a7\u00cf\7\36\2\2\u00a8\u00cf\7\4"+
		"\2\2\u00a9\u00cf\7\67\2\2\u00aa\u00cf\7\f\2\2\u00ab\u00cf\7+\2\2\u00ac"+
		"\u00cf\7\3\2\2\u00ad\u00cf\7\25\2\2\u00ae\u00cf\78\2\2\u00af\u00cf\7\26"+
		"\2\2\u00b0\u00cf\7\22\2\2\u00b1\u00cf\7\7\2\2\u00b2\u00cf\7\63\2\2\u00b3"+
		"\u00cf\7%\2\2\u00b4\u00cf\7\33\2\2\u00b5\u00cf\7\r\2\2\u00b6\u00cf\7\65"+
		"\2\2\u00b7\u00cf\7\64\2\2\u00b8\u00cf\7&\2\2\u00b9\u00cf\7!\2\2\u00ba"+
		"\u00cf\7\23\2\2\u00bb\u00cf\7*\2\2\u00bc\u00cf\7\n\2\2\u00bd\u00cf\7$"+
		"\2\2\u00be\u00cf\7\30\2\2\u00bf\u00cf\7\66\2\2\u00c0\u00cf\7\b\2\2\u00c1"+
		"\u00cf\7\t\2\2\u00c2\u00cf\79\2\2\u00c3\u00cf\7\61\2\2\u00c4\u00cf\7\62"+
		"\2\2\u00c5\u00cf\7(\2\2\u00c6\u00cf\7\6\2\2\u00c7\u00cf\7\35\2\2\u00c8"+
		"\u00cf\7\32\2\2\u00c9\u00cf\7\13\2\2\u00ca\u00cb\7\37\2\2\u00cb\u00cf"+
		"\7\16\2\2\u00cc\u00cd\7\5\2\2\u00cd\u00cf\7\31\2\2\u00ce\u00a1\3\2\2\2"+
		"\u00ce\u00a6\3\2\2\2\u00ce\u00a7\3\2\2\2\u00ce\u00a8\3\2\2\2\u00ce\u00a9"+
		"\3\2\2\2\u00ce\u00aa\3\2\2\2\u00ce\u00ab\3\2\2\2\u00ce\u00ac\3\2\2\2\u00ce"+
		"\u00ad\3\2\2\2\u00ce\u00ae\3\2\2\2\u00ce\u00af\3\2\2\2\u00ce\u00b0\3\2"+
		"\2\2\u00ce\u00b1\3\2\2\2\u00ce\u00b2\3\2\2\2\u00ce\u00b3\3\2\2\2\u00ce"+
		"\u00b4\3\2\2\2\u00ce\u00b5\3\2\2\2\u00ce\u00b6\3\2\2\2\u00ce\u00b7\3\2"+
		"\2\2\u00ce\u00b8\3\2\2\2\u00ce\u00b9\3\2\2\2\u00ce\u00ba\3\2\2\2\u00ce"+
		"\u00bb\3\2\2\2\u00ce\u00bc\3\2\2\2\u00ce\u00bd\3\2\2\2\u00ce\u00be\3\2"+
		"\2\2\u00ce\u00bf\3\2\2\2\u00ce\u00c0\3\2\2\2\u00ce\u00c1\3\2\2\2\u00ce"+
		"\u00c2\3\2\2\2\u00ce\u00c3\3\2\2\2\u00ce\u00c4\3\2\2\2\u00ce\u00c5\3\2"+
		"\2\2\u00ce\u00c6\3\2\2\2\u00ce\u00c7\3\2\2\2\u00ce\u00c8\3\2\2\2\u00ce"+
		"\u00c9\3\2\2\2\u00ce\u00ca\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\23\3\2\2"+
		"\2\u00d0\u00d1\t\t\2\2\u00d1\25\3\2\2\2\u00d2\u00d3\t\n\2\2\u00d3\27\3"+
		"\2\2\2\u00d4\u00d5\7T\2\2\u00d5\u00d6\7\7\2\2\u00d6\u00d7\5\32\16\2\u00d7"+
		"\u00d8\7\63\2\2\u00d8\31\3\2\2\2\u00d9\u00da\7\7\2\2\u00da\u00db\5\32"+
		"\16\2\u00db\u00dc\7\63\2\2\u00dc\u00e3\3\2\2\2\u00dd\u00de\7\37\2\2\u00de"+
		"\u00df\5\32\16\2\u00df\u00e0\7\16\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00e3"+
		"\5\"\22\2\u00e2\u00d9\3\2\2\2\u00e2\u00dd\3\2\2\2\u00e2\u00e1\3\2\2\2"+
		"\u00e3\u00e4\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\33"+
		"\3\2\2\2\u00e6\u00e7\n\13\2\2\u00e7\35\3\2\2\2\u00e8\u00e9\n\f\2\2\u00e9"+
		"\37\3\2\2\2\u00ea\u00eb\n\r\2\2\u00eb!\3\2\2\2\u00ec\u00ed\n\16\2\2\u00ed"+
		"#\3\2\2\2\u00ee\u00ef\n\17\2\2\u00ef%\3\2\2\2\u00f0\u00f1\n\20\2\2\u00f1"+
		"\'\3\2\2\2\u00f2\u00f3\n\21\2\2\u00f3)\3\2\2\2\u00f4\u00f5\n\22\2\2\u00f5"+
		"+\3\2\2\2\u00f6\u00f7\n\23\2\2\u00f7-\3\2\2\2\u00f8\u00f9\n\24\2\2\u00f9"+
		"/\3\2\2\2\u00fa\u00fb\13\2\2\2\u00fb\61\3\2\2\2\u00fc\u00ff\5\64\33\2"+
		"\u00fd\u00fe\7\35\2\2\u00fe\u0100\5\62\32\2\u00ff\u00fd\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\63\3\2\2\2\u0101\u0105\5\66\34\2\u0102\u0103\5\24"+
		"\13\2\u0103\u0104\5\64\33\2\u0104\u0106\3\2\2\2\u0105\u0102\3\2\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\65\3\2\2\2\u0107\u010d\58\35\2\u0108\u0109\7#\2\2"+
		"\u0109\u010a\5\62\32\2\u010a\u010b\7 \2\2\u010b\u010c\5\66\34\2\u010c"+
		"\u010e\3\2\2\2\u010d\u0108\3\2\2\2\u010d\u010e\3\2\2\2\u010e\67\3\2\2"+
		"\2\u010f\u0112\5:\36\2\u0110\u0111\7\62\2\2\u0111\u0113\58\35\2\u0112"+
		"\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u01139\3\2\2\2\u0114\u0117\5<\37\2"+
		"\u0115\u0116\7\61\2\2\u0116\u0118\5:\36\2\u0117\u0115\3\2\2\2\u0117\u0118"+
		"\3\2\2\2\u0118;\3\2\2\2\u0119\u011c\5> \2\u011a\u011b\7\25\2\2\u011b\u011d"+
		"\5<\37\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d=\3\2\2\2\u011e"+
		"\u0121\5@!\2\u011f\u0120\7+\2\2\u0120\u0122\5> \2\u0121\u011f\3\2\2\2"+
		"\u0121\u0122\3\2\2\2\u0122?\3\2\2\2\u0123\u0126\5B\"\2\u0124\u0125\7\3"+
		"\2\2\u0125\u0127\5@!\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127A"+
		"\3\2\2\2\u0128\u012c\5D#\2\u0129\u012a\5\26\f\2\u012a\u012b\5B\"\2\u012b"+
		"\u012d\3\2\2\2\u012c\u0129\3\2\2\2\u012c\u012d\3\2\2\2\u012dC\3\2\2\2"+
		"\u012e\u0132\5F$\2\u012f\u0130\5\b\5\2\u0130\u0131\5D#\2\u0131\u0133\3"+
		"\2\2\2\u0132\u012f\3\2\2\2\u0132\u0133\3\2\2\2\u0133E\3\2\2\2\u0134\u0137"+
		"\5H%\2\u0135\u0136\t\25\2\2\u0136\u0138\5F$\2\u0137\u0135\3\2\2\2\u0137"+
		"\u0138\3\2\2\2\u0138G\3\2\2\2\u0139\u013c\5J&\2\u013a\u013b\t\26\2\2\u013b"+
		"\u013d\5H%\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013dI\3\2\2\2\u013e"+
		"\u0141\5L\'\2\u013f\u0140\t\27\2\2\u0140\u0142\5J&\2\u0141\u013f\3\2\2"+
		"\2\u0141\u0142\3\2\2\2\u0142K\3\2\2\2\u0143\u0144\7\37\2\2\u0144\u0145"+
		"\5N(\2\u0145\u0146\7\16\2\2\u0146\u0147\5L\'\2\u0147\u014a\3\2\2\2\u0148"+
		"\u014a\5P)\2\u0149\u0143\3\2\2\2\u0149\u0148\3\2\2\2\u014aM\3\2\2\2\u014b"+
		"\u014f\5t;\2\u014c\u014e\5\16\b\2\u014d\u014c\3\2\2\2\u014e\u0151\3\2"+
		"\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150O\3\2\2\2\u0151\u014f"+
		"\3\2\2\2\u0152\u0153\5R*\2\u0153\u0154\5L\'\2\u0154\u0167\3\2\2\2\u0155"+
		"\u0156\5\6\4\2\u0156\u0157\5L\'\2\u0157\u0167\3\2\2\2\u0158\u0159\7\27"+
		"\2\2\u0159\u015a\7\37\2\2\u015a\u015e\5t;\2\u015b\u015d\5\16\b\2\u015c"+
		"\u015b\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f\3\2"+
		"\2\2\u015f\u0161\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0162\7\16\2\2\u0162"+
		"\u0167\3\2\2\2\u0163\u0164\7\27\2\2\u0164\u0167\5P)\2\u0165\u0167\5T+"+
		"\2\u0166\u0152\3\2\2\2\u0166\u0155\3\2\2\2\u0166\u0158\3\2\2\2\u0166\u0163"+
		"\3\2\2\2\u0166\u0165\3\2\2\2\u0167Q\3\2\2\2\u0168\u0169\t\30\2\2\u0169"+
		"S\3\2\2\2\u016a\u016b\b+\1\2\u016b\u016c\5Z.\2\u016c\u0187\3\2\2\2\u016d"+
		"\u016e\f\b\2\2\u016e\u016f\7\5\2\2\u016f\u0170\5\62\32\2\u0170\u0171\7"+
		"\31\2\2\u0171\u0186\3\2\2\2\u0172\u0173\f\7\2\2\u0173\u0174\7\37\2\2\u0174"+
		"\u0175\5V,\2\u0175\u0176\7\16\2\2\u0176\u0186\3\2\2\2\u0177\u0178\f\6"+
		"\2\2\u0178\u017a\7-\2\2\u0179\u017b\7T\2\2\u017a\u0179\3\2\2\2\u017a\u017b"+
		"\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u0186\5\u0082B\2\u017d\u017e\f\5\2"+
		"\2\u017e\u0180\7\13\2\2\u017f\u0181\7T\2\2\u0180\u017f\3\2\2\2\u0180\u0181"+
		"\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0186\5\u0082B\2\u0183\u0184\f\4\2"+
		"\2\u0184\u0186\5R*\2\u0185\u016d\3\2\2\2\u0185\u0172\3\2\2\2\u0185\u0177"+
		"\3\2\2\2\u0185\u017d\3\2\2\2\u0185\u0183\3\2\2\2\u0186\u0189\3\2\2\2\u0187"+
		"\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188U\3\2\2\2\u0189\u0187\3\2\2\2"+
		"\u018a\u018f\5X-\2\u018b\u018c\7\35\2\2\u018c\u018e\5X-\2\u018d\u018b"+
		"\3\2\2\2\u018e\u0191\3\2\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190"+
		"\u0193\3\2\2\2\u0191\u018f\3\2\2\2\u0192\u018a\3\2\2\2\u0192\u0193\3\2"+
		"\2\2\u0193W\3\2\2\2\u0194\u0195\5\64\33\2\u0195Y\3\2\2\2\u0196\u019d\5"+
		"\u0082B\2\u0197\u019d\5\n\6\2\u0198\u0199\7\37\2\2\u0199\u019a\5\62\32"+
		"\2\u019a\u019b\7\16\2\2\u019b\u019d\3\2\2\2\u019c\u0196\3\2\2\2\u019c"+
		"\u0197\3\2\2\2\u019c\u0198\3\2\2\2\u019d[\3\2\2\2\u019e\u019f\5^\60\2"+
		"\u019f\u01a1\7\37\2\2\u01a0\u01a2\5\62\32\2\u01a1\u01a0\3\2\2\2\u01a1"+
		"\u01a2\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a4\7\16\2\2\u01a4\u01ab\3"+
		"\2\2\2\u01a5\u01a6\5^\60\2\u01a6\u01a7\7\22\2\2\u01a7\u01a8\5h\65\2\u01a8"+
		"\u01ab\3\2\2\2\u01a9\u01ab\5^\60\2\u01aa\u019e\3\2\2\2\u01aa\u01a5\3\2"+
		"\2\2\u01aa\u01a9\3\2\2\2\u01ab]\3\2\2\2\u01ac\u01ae\5\u0086D\2\u01ad\u01ac"+
		"\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b1\5\u0082B"+
		"\2\u01b0\u01b2\5`\61\2\u01b1\u01b0\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2_"+
		"\3\2\2\2\u01b3\u01b5\7\5\2\2\u01b4\u01b6\5\66\34\2\u01b5\u01b4\3\2\2\2"+
		"\u01b5\u01b6\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01ba\7\31\2\2\u01b8\u01ba"+
		"\5|?\2\u01b9\u01b3\3\2\2\2\u01b9\u01b8\3\2\2\2\u01baa\3\2\2\2\u01bb\u01bd"+
		"\7E\2\2\u01bc\u01bb\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01bf\3\2\2\2\u01be"+
		"\u01c0\5\30\r\2\u01bf\u01be\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1\3"+
		"\2\2\2\u01c1\u01c2\5d\63\2\u01c2c\3\2\2\2\u01c3\u01c5\5l\67\2\u01c4\u01c6"+
		"\5f\64\2\u01c5\u01c4\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01cb\3\2\2\2\u01c7"+
		"\u01c8\5t;\2\u01c8\u01c9\5f\64\2\u01c9\u01cb\3\2\2\2\u01ca\u01c3\3\2\2"+
		"\2\u01ca\u01c7\3\2\2\2\u01cbe\3\2\2\2\u01cc\u01d1\5\\/\2\u01cd\u01ce\7"+
		"\35\2\2\u01ce\u01d0\5\\/\2\u01cf\u01cd\3\2\2\2\u01d0\u01d3\3\2\2\2\u01d1"+
		"\u01cf\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d4\3\2\2\2\u01d3\u01d1\3\2"+
		"\2\2\u01d4\u01d5\7\60\2\2\u01d5g\3\2\2\2\u01d6\u01dc\5\64\33\2\u01d7\u01d8"+
		"\7W\2\2\u01d8\u01d9\5j\66\2\u01d9\u01da\7X\2\2\u01da\u01dc\3\2\2\2\u01db"+
		"\u01d6\3\2\2\2\u01db\u01d7\3\2\2\2\u01dci\3\2\2\2\u01dd\u01e2\5h\65\2"+
		"\u01de\u01df\7\35\2\2\u01df\u01e1\5h\65\2\u01e0\u01de\3\2\2\2\u01e1\u01e4"+
		"\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3k\3\2\2\2\u01e4"+
		"\u01e2\3\2\2\2\u01e5\u01e7\7U\2\2\u01e6\u01e8\5n8\2\u01e7\u01e6\3\2\2"+
		"\2\u01e7\u01e8\3\2\2\2\u01e8\u01ea\3\2\2\2\u01e9\u01eb\5p9\2\u01ea\u01e9"+
		"\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ed\7W\2\2\u01ed"+
		"\u01ee\b\67\1\2\u01eem\3\2\2\2\u01ef\u01f0\5\u0082B\2\u01f0o\3\2\2\2\u01f1"+
		"\u01f2\7 \2\2\u01f2\u01f7\5r:\2\u01f3\u01f4\7\35\2\2\u01f4\u01f6\5r:\2"+
		"\u01f5\u01f3\3\2\2\2\u01f6\u01f9\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8"+
		"\3\2\2\2\u01f8q\3\2\2\2\u01f9\u01f7\3\2\2\2\u01fa\u01fc\7K\2\2\u01fb\u01fa"+
		"\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fe\3\2\2\2\u01fd\u01ff\5\20\t\2"+
		"\u01fe\u01fd\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u0201"+
		"\5\u0082B\2\u0201s\3\2\2\2\u0202\u0204\7J\2\2\u0203\u0202\3\2\2\2\u0204"+
		"\u0207\3\2\2\2\u0205\u0203\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0209\3\2"+
		"\2\2\u0207\u0205\3\2\2\2\u0208\u020a\t\31\2\2\u0209\u0208\3\2\2\2\u0209"+
		"\u020a\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u0210\5v<\2\u020c\u020d\7\7\2"+
		"\2\u020d\u020e\5\32\16\2\u020e\u020f\7\63\2\2\u020f\u0211\3\2\2\2\u0210"+
		"\u020c\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u021c\3\2\2\2\u0212\u0213\7\21"+
		"\2\2\u0213\u0218\5v<\2\u0214\u0215\7\7\2\2\u0215\u0216\5\32\16\2\u0216"+
		"\u0217\7\63\2\2\u0217\u0219\3\2\2\2\u0218\u0214\3\2\2\2\u0218\u0219\3"+
		"\2\2\2\u0219\u021b\3\2\2\2\u021a\u0212\3\2\2\2\u021b\u021e\3\2\2\2\u021c"+
		"\u021a\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u0222\3\2\2\2\u021e\u021c\3\2"+
		"\2\2\u021f\u0222\7G\2\2\u0220\u0222\7H\2\2\u0221\u0205\3\2\2\2\u0221\u021f"+
		"\3\2\2\2\u0221\u0220\3\2\2\2\u0222u\3\2\2\2\u0223\u0229\7V\2\2\u0224\u0229"+
		"\7F\2\2\u0225\u0229\7I\2\2\u0226\u0227\7I\2\2\u0227\u0229\7I\2\2\u0228"+
		"\u0223\3\2\2\2\u0228\u0224\3\2\2\2\u0228\u0225\3\2\2\2\u0228\u0226\3\2"+
		"\2\2\u0229w\3\2\2\2\u022a\u022c\t\32\2\2\u022b\u022a\3\2\2\2\u022b\u022c"+
		"\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u022e\5t;\2\u022ey\3\2\2\2\u022f\u0232"+
		"\5\u0082B\2\u0230\u0232\5\20\t\2\u0231\u022f\3\2\2\2\u0231\u0230\3\2\2"+
		"\2\u0232{\3\2\2\2\u0233\u0234\7\37\2\2\u0234\u0235\7F\2\2\u0235\u0243"+
		"\7\16\2\2\u0236\u023f\7\37\2\2\u0237\u023c\5~@\2\u0238\u0239\7\35\2\2"+
		"\u0239\u023b\5~@\2\u023a\u0238\3\2\2\2\u023b\u023e\3\2\2\2\u023c\u023a"+
		"\3\2\2\2\u023c\u023d\3\2\2\2\u023d\u0240\3\2\2\2\u023e\u023c\3\2\2\2\u023f"+
		"\u0237\3\2\2\2\u023f\u0240\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u0243\7\16"+
		"\2\2\u0242\u0233\3\2\2\2\u0242\u0236\3\2\2\2\u0243}\3\2\2\2\u0244\u0245"+
		"\5x=\2\u0245\u0246\5\u0080A\2\u0246\177\3\2\2\2\u0247\u0249\5\u0086D\2"+
		"\u0248\u0247\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u0251\3\2\2\2\u024a\u024b"+
		"\7\37\2\2\u024b\u024c\5\u0080A\2\u024c\u024d\7\16\2\2\u024d\u0252\3\2"+
		"\2\2\u024e\u0250\5z>\2\u024f\u024e\3\2\2\2\u024f\u0250\3\2\2\2\u0250\u0252"+
		"\3\2\2\2\u0251\u024a\3\2\2\2\u0251\u024f\3\2\2\2\u0252\u0254\3\2\2\2\u0253"+
		"\u0255\5`\61\2\u0254\u0253\3\2\2\2\u0254\u0255\3\2\2\2\u0255\u0081\3\2"+
		"\2\2\u0256\u025b\7V\2\2\u0257\u0258\7\21\2\2\u0258\u025a\7V\2\2\u0259"+
		"\u0257\3\2\2\2\u025a\u025d\3\2\2\2\u025b\u0259\3\2\2\2\u025b\u025c\3\2"+
		"\2\2\u025c\u0083\3\2\2\2\u025d\u025b\3\2\2\2\u025e\u025f\t\33\2\2\u025f"+
		"\u0085\3\2\2\2\u0260\u0262\5\16\b\2\u0261\u0260\3\2\2\2\u0262\u0263\3"+
		"\2\2\2\u0263\u0261\3\2\2\2\u0263\u0264\3\2\2\2\u0264\u0087\3\2\2\2D\u008b"+
		"\u0093\u00a4\u00ce\u00e2\u00e4\u00ff\u0105\u010d\u0112\u0117\u011c\u0121"+
		"\u0126\u012c\u0132\u0137\u013c\u0141\u0149\u014f\u015e\u0166\u017a\u0180"+
		"\u0185\u0187\u018f\u0192\u019c\u01a1\u01aa\u01ad\u01b1\u01b5\u01b9\u01bc"+
		"\u01bf\u01c5\u01ca\u01d1\u01db\u01e2\u01e7\u01ea\u01f7\u01fb\u01fe\u0205"+
		"\u0209\u0210\u0218\u021c\u0221\u0228\u022b\u0231\u023c\u023f\u0242\u0248"+
		"\u024f\u0251\u0254\u025b\u0263";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
	}
}
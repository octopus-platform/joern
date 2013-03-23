// Generated from ./Symbols.g4 by ANTLR 4.0

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
public class SymbolsParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__51=1, T__50=2, T__49=3, T__48=4, T__47=5, T__46=6, T__45=7, T__44=8, 
		T__43=9, T__42=10, T__41=11, T__40=12, T__39=13, T__38=14, T__37=15, T__36=16, 
		T__35=17, T__34=18, T__33=19, T__32=20, T__31=21, T__30=22, T__29=23, 
		T__28=24, T__27=25, T__26=26, T__25=27, T__24=28, T__23=29, T__22=30, 
		T__21=31, T__20=32, T__19=33, T__18=34, T__17=35, T__16=36, T__15=37, 
		T__14=38, T__13=39, T__12=40, T__11=41, T__10=42, T__9=43, T__8=44, T__7=45, 
		T__6=46, T__5=47, T__4=48, T__3=49, T__2=50, T__1=51, T__0=52, IF=53, 
		ELSE=54, FOR=55, WHILE=56, BREAK=57, CASE=58, CONTINUE=59, SWITCH=60, 
		DO=61, GOTO=62, RETURN=63, TYPEDEF=64, VOID=65, UNSIGNED=66, SIGNED=67, 
		LONG=68, CV_QUALIFIER=69, VIRTUAL=70, TRY=71, CATCH=72, THROW=73, USING=74, 
		NAMESPACE=75, AUTO=76, REGISTER=77, OPERATOR=78, TEMPLATE=79, CLASS_KEY=80, 
		ALPHA_NUMERIC=81, OPENING_CURLY=82, CLOSING_CURLY=83, SMALLER=84, LARGER=85, 
		PRE_IF=86, PRE_ELSE=87, PRE_ENDIF=88, HEX_LITERAL=89, DECIMAL_LITERAL=90, 
		OCTAL_LITERAL=91, FLOATING_POINT_LITERAL=92, CHAR=93, STRING=94, COMMENT=95, 
		WHITESPACE=96, CPPCOMMENT=97, OTHER=98;
	public static final String[] tokenNames = {
		"<INVALID>", "'&'", "'*'", "'['", "'--'", "'!='", "'<='", "'<<'", "'->'", 
		"'%'", "'*='", "')'", "'inline'", "'explicit'", "'::'", "'='", "'|='", 
		"'new'", "'|'", "'!'", "'<<='", "']'", "'->*'", "'-='", "'public'", "','", 
		"'-'", "'('", "':'", "'&='", "'private'", "'?'", "'>>='", "'+='", "'^='", 
		"'friend'", "'++'", "'static'", "'>>'", "'^'", "'delete'", "'.'", "'+'", 
		"'protected'", "';'", "'&&'", "'||'", "'%='", "'/='", "'=='", "'/'", "'~'", 
		"'>='", "'if'", "'else'", "'for'", "'while'", "'break'", "'case'", "'continue'", 
		"'switch'", "'do'", "'goto'", "'return'", "'typedef'", "'void'", "'unsigned'", 
		"'signed'", "'long'", "CV_QUALIFIER", "'virtual'", "'try'", "'catch'", 
		"'throw'", "'using'", "'namespace'", "'auto'", "'register'", "'operator'", 
		"'template'", "CLASS_KEY", "ALPHA_NUMERIC", "'{'", "'}'", "'<'", "'>'", 
		"PRE_IF", "PRE_ELSE", "PRE_ENDIF", "HEX_LITERAL", "DECIMAL_LITERAL", "OCTAL_LITERAL", 
		"FLOATING_POINT_LITERAL", "CHAR", "STRING", "COMMENT", "WHITESPACE", "CPPCOMMENT", 
		"OTHER"
	};
	public static final int
		RULE_coarse_content = 0, RULE_unary_operator = 1, RULE_relational_operator = 2, 
		RULE_constant = 3, RULE_function_decl_specifiers = 4, RULE_ptr_operator = 5, 
		RULE_access_specifier = 6, RULE_operator_function_id = 7, RULE_operator = 8, 
		RULE_assignment_operator = 9, RULE_equality_operator = 10, RULE_template_decl_start = 11, 
		RULE_template_param_list = 12, RULE_no_brackets = 13, RULE_no_brackets_curlies_or_squares = 14, 
		RULE_no_brackets_or_semicolon = 15, RULE_no_angle_brackets_or_brackets = 16, 
		RULE_no_curlies = 17, RULE_no_squares = 18, RULE_no_squares_or_semicolon = 19, 
		RULE_no_comma_or_semicolon = 20, RULE_assign_water = 21, RULE_assign_water_l2 = 22, 
		RULE_water = 23, RULE_expr = 24, RULE_assign_expr = 25, RULE_conditional_expression = 26, 
		RULE_or_expression = 27, RULE_and_expression = 28, RULE_inclusive_or_expression = 29, 
		RULE_exclusive_or_expression = 30, RULE_bit_and_expression = 31, RULE_equality_expression = 32, 
		RULE_relational_expression = 33, RULE_shift_expression = 34, RULE_additive_expression = 35, 
		RULE_multiplicative_expression = 36, RULE_cast_expression = 37, RULE_unary_expression = 38, 
		RULE_postfix_expression = 39, RULE_field = 40, RULE_function_call_tail = 41, 
		RULE_call_template_list = 42, RULE_function_argument_list = 43, RULE_function_argument = 44, 
		RULE_postfix = 45, RULE_primary_expression = 46, RULE_init_declarator = 47, 
		RULE_type_suffix = 48, RULE_simple_decl = 49, RULE_var_decl = 50, RULE_init_declarator_list = 51, 
		RULE_initializer = 52, RULE_initializer_list = 53, RULE_class_def = 54, 
		RULE_class_name = 55, RULE_base_classes = 56, RULE_base_class = 57, RULE_type_name = 58, 
		RULE_base_type = 59, RULE_param_decl_specifiers = 60, RULE_parameter_name = 61, 
		RULE_param_type_list = 62, RULE_param_type = 63, RULE_param_type_id = 64, 
		RULE_identifier = 65, RULE_number = 66, RULE_ptrs = 67;
	public static final String[] ruleNames = {
		"coarse_content", "unary_operator", "relational_operator", "constant", 
		"function_decl_specifiers", "ptr_operator", "access_specifier", "operator_function_id", 
		"operator", "assignment_operator", "equality_operator", "template_decl_start", 
		"template_param_list", "no_brackets", "no_brackets_curlies_or_squares", 
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
	public String getGrammarFileName() { return "Symbols.g4"; }

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


	public SymbolsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Coarse_contentContext extends ParserRuleContext {
		public List<WaterContext> water() {
			return getRuleContexts(WaterContext.class);
		}
		public List<Unary_expressionContext> unary_expression() {
			return getRuleContexts(Unary_expressionContext.class);
		}
		public Simple_declContext simple_decl(int i) {
			return getRuleContext(Simple_declContext.class,i);
		}
		public TerminalNode EOF() { return getToken(SymbolsParser.EOF, 0); }
		public List<Simple_declContext> simple_decl() {
			return getRuleContexts(Simple_declContext.class);
		}
		public WaterContext water(int i) {
			return getRuleContext(WaterContext.class,i);
		}
		public Unary_expressionContext unary_expression(int i) {
			return getRuleContext(Unary_expressionContext.class,i);
		}
		public Coarse_contentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coarse_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterCoarse_content(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitCoarse_content(this);
		}
	}

	public final Coarse_contentContext coarse_content() throws RecognitionException {
		Coarse_contentContext _localctx = new Coarse_contentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_coarse_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH) | (1L << DO) | (1L << GOTO) | (1L << RETURN))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (SMALLER - 64)) | (1L << (LARGER - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)) | (1L << (19 - 64)) | (1L << (26 - 64)) | (1L << (27 - 64)) | (1L << (36 - 64)) | (1L << (42 - 64)) | (1L << (51 - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)))) != 0)) {
				{
				setState(139);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(136); simple_decl();
					}
					break;

				case 2:
					{
					setState(137); unary_expression();
					}
					break;

				case 3:
					{
					setState(138); water();
					}
					break;
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(144); match(EOF);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitUnary_operator(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 19) | (1L << 26) | (1L << 42) | (1L << 51))) != 0)) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterRelational_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitRelational_operator(this);
		}
	}

	public final Relational_operatorContext relational_operator() throws RecognitionException {
		Relational_operatorContext _localctx = new Relational_operatorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_relational_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_la = _input.LA(1);
			if ( !(_la==6 || _la==52 || _la==SMALLER || _la==LARGER) ) {
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
		public TerminalNode CHAR() { return getToken(SymbolsParser.CHAR, 0); }
		public TerminalNode OCTAL_LITERAL() { return getToken(SymbolsParser.OCTAL_LITERAL, 0); }
		public TerminalNode HEX_LITERAL() { return getToken(SymbolsParser.HEX_LITERAL, 0); }
		public TerminalNode FLOATING_POINT_LITERAL() { return getToken(SymbolsParser.FLOATING_POINT_LITERAL, 0); }
		public TerminalNode DECIMAL_LITERAL() { return getToken(SymbolsParser.DECIMAL_LITERAL, 0); }
		public TerminalNode STRING() { return getToken(SymbolsParser.STRING, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterFunction_decl_specifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitFunction_decl_specifiers(this);
		}
	}

	public final Function_decl_specifiersContext function_decl_specifiers() throws RecognitionException {
		Function_decl_specifiersContext _localctx = new Function_decl_specifiersContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_function_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_la = _input.LA(1);
			if ( !(((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (12 - 12)) | (1L << (13 - 12)) | (1L << (35 - 12)) | (1L << (37 - 12)) | (1L << (VIRTUAL - 12)))) != 0)) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterPtr_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitPtr_operator(this);
		}
	}

	public final Ptr_operatorContext ptr_operator() throws RecognitionException {
		Ptr_operatorContext _localctx = new Ptr_operatorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ptr_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
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

	public static class Access_specifierContext extends ParserRuleContext {
		public Access_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_access_specifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterAccess_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitAccess_specifier(this);
		}
	}

	public final Access_specifierContext access_specifier() throws RecognitionException {
		Access_specifierContext _localctx = new Access_specifierContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_access_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 24) | (1L << 30) | (1L << 43))) != 0)) ) {
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
		public TerminalNode OPERATOR() { return getToken(SymbolsParser.OPERATOR, 0); }
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public Operator_function_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_function_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterOperator_function_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitOperator_function_id(this);
		}
	}

	public final Operator_function_idContext operator_function_id() throws RecognitionException {
		Operator_function_idContext _localctx = new Operator_function_idContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_operator_function_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158); match(OPERATOR);
			setState(159); operator();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitOperator(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_operator);
		int _la;
		try {
			setState(206);
			switch (_input.LA(1)) {
			case 17:
			case 40:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(161);
				_la = _input.LA(1);
				if ( !(_la==17 || _la==40) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(164);
				_la = _input.LA(1);
				if (_la==3) {
					{
					setState(162); match(3);
					setState(163); match(21);
					}
				}

				}
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 2);
				{
				setState(166); match(42);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 3);
				{
				setState(167); match(26);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 4);
				{
				setState(168); match(2);
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 5);
				{
				setState(169); match(50);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 6);
				{
				setState(170); match(9);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 7);
				{
				setState(171); match(39);
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 8);
				{
				setState(172); match(1);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 9);
				{
				setState(173); match(18);
				}
				break;
			case 51:
				enterOuterAlt(_localctx, 10);
				{
				setState(174); match(51);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 11);
				{
				setState(175); match(19);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 12);
				{
				setState(176); match(15);
				}
				break;
			case SMALLER:
				enterOuterAlt(_localctx, 13);
				{
				setState(177); match(SMALLER);
				}
				break;
			case LARGER:
				enterOuterAlt(_localctx, 14);
				{
				setState(178); match(LARGER);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 15);
				{
				setState(179); match(33);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 16);
				{
				setState(180); match(23);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 17);
				{
				setState(181); match(10);
				}
				break;
			case 48:
				enterOuterAlt(_localctx, 18);
				{
				setState(182); match(48);
				}
				break;
			case 47:
				enterOuterAlt(_localctx, 19);
				{
				setState(183); match(47);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 20);
				{
				setState(184); match(34);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 21);
				{
				setState(185); match(29);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 22);
				{
				setState(186); match(16);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 23);
				{
				setState(187); match(38);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 24);
				{
				setState(188); match(7);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 25);
				{
				setState(189); match(32);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 26);
				{
				setState(190); match(20);
				}
				break;
			case 49:
				enterOuterAlt(_localctx, 27);
				{
				setState(191); match(49);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 28);
				{
				setState(192); match(5);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 29);
				{
				setState(193); match(6);
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 30);
				{
				setState(194); match(52);
				}
				break;
			case 45:
				enterOuterAlt(_localctx, 31);
				{
				setState(195); match(45);
				}
				break;
			case 46:
				enterOuterAlt(_localctx, 32);
				{
				setState(196); match(46);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 33);
				{
				setState(197); match(36);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 34);
				{
				setState(198); match(4);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 35);
				{
				setState(199); match(25);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 36);
				{
				setState(200); match(22);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 37);
				{
				setState(201); match(8);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 38);
				{
				setState(202); match(27);
				setState(203); match(11);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 39);
				{
				setState(204); match(3);
				setState(205); match(21);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterAssignment_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitAssignment_operator(this);
		}
	}

	public final Assignment_operatorContext assignment_operator() throws RecognitionException {
		Assignment_operatorContext _localctx = new Assignment_operatorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignment_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 10) | (1L << 15) | (1L << 16) | (1L << 20) | (1L << 23) | (1L << 29) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 47) | (1L << 48))) != 0)) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterEquality_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitEquality_operator(this);
		}
	}

	public final Equality_operatorContext equality_operator() throws RecognitionException {
		Equality_operatorContext _localctx = new Equality_operatorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_equality_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			_la = _input.LA(1);
			if ( !(_la==5 || _la==49) ) {
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
		public TerminalNode TEMPLATE() { return getToken(SymbolsParser.TEMPLATE, 0); }
		public Template_decl_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_decl_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterTemplate_decl_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitTemplate_decl_start(this);
		}
	}

	public final Template_decl_startContext template_decl_start() throws RecognitionException {
		Template_decl_startContext _localctx = new Template_decl_startContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_template_decl_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212); match(TEMPLATE);
			setState(213); template_param_list();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterTemplate_param_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitTemplate_param_list(this);
		}
	}

	public final Template_param_listContext template_param_list() throws RecognitionException {
		Template_param_listContext _localctx = new Template_param_listContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_template_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215); match(SMALLER);
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << IF) | (1L << ELSE) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CASE) | (1L << CONTINUE) | (1L << SWITCH) | (1L << DO) | (1L << GOTO) | (1L << RETURN))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (CLASS_KEY - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (SMALLER - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				setState(225);
				switch (_input.LA(1)) {
				case SMALLER:
					{
					{
					setState(216); match(SMALLER);
					setState(217); template_param_list();
					setState(218); match(LARGER);
					}
					}
					break;
				case 27:
					{
					{
					setState(220); match(27);
					setState(221); template_param_list();
					setState(222); match(11);
					}
					}
					break;
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
				case 12:
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
					setState(224); no_angle_brackets_or_brackets();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(230); match(LARGER);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterNo_brackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitNo_brackets(this);
		}
	}

	public final No_bracketsContext no_brackets() throws RecognitionException {
		No_bracketsContext _localctx = new No_bracketsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_no_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==11 || _la==27) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterNo_brackets_curlies_or_squares(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitNo_brackets_curlies_or_squares(this);
		}
	}

	public final No_brackets_curlies_or_squaresContext no_brackets_curlies_or_squares() throws RecognitionException {
		No_brackets_curlies_or_squaresContext _localctx = new No_brackets_curlies_or_squaresContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_no_brackets_curlies_or_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 11) | (1L << 21) | (1L << 27))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterNo_brackets_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitNo_brackets_or_semicolon(this);
		}
	}

	public final No_brackets_or_semicolonContext no_brackets_or_semicolon() throws RecognitionException {
		No_brackets_or_semicolonContext _localctx = new No_brackets_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_no_brackets_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 27) | (1L << 44))) != 0)) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterNo_angle_brackets_or_brackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitNo_angle_brackets_or_brackets(this);
		}
	}

	public final No_angle_brackets_or_bracketsContext no_angle_brackets_or_brackets() throws RecognitionException {
		No_angle_brackets_or_bracketsContext _localctx = new No_angle_brackets_or_bracketsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_no_angle_brackets_or_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==11 || _la==27 || _la==SMALLER || _la==LARGER) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterNo_curlies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitNo_curlies(this);
		}
	}

	public final No_curliesContext no_curlies() throws RecognitionException {
		No_curliesContext _localctx = new No_curliesContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_no_curlies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterNo_squares(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitNo_squares(this);
		}
	}

	public final No_squaresContext no_squares() throws RecognitionException {
		No_squaresContext _localctx = new No_squaresContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_no_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==3 || _la==21) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterNo_squares_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitNo_squares_or_semicolon(this);
		}
	}

	public final No_squares_or_semicolonContext no_squares_or_semicolon() throws RecognitionException {
		No_squares_or_semicolonContext _localctx = new No_squares_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_no_squares_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 21) | (1L << 44))) != 0)) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterNo_comma_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitNo_comma_or_semicolon(this);
		}
	}

	public final No_comma_or_semicolonContext no_comma_or_semicolon() throws RecognitionException {
		No_comma_or_semicolonContext _localctx = new No_comma_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_no_comma_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==25 || _la==44) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterAssign_water(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitAssign_water(this);
		}
	}

	public final Assign_waterContext assign_water() throws RecognitionException {
		Assign_waterContext _localctx = new Assign_waterContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assign_water);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 11) | (1L << 21) | (1L << 25) | (1L << 27) | (1L << 44))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterAssign_water_l2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitAssign_water_l2(this);
		}
	}

	public final Assign_water_l2Context assign_water_l2() throws RecognitionException {
		Assign_water_l2Context _localctx = new Assign_water_l2Context(_ctx, getState());
		enterRule(_localctx, 44, RULE_assign_water_l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 11) | (1L << 21) | (1L << 27))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterWater(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitWater(this);
		}
	}

	public final WaterContext water() throws RecognitionException {
		WaterContext _localctx = new WaterContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_water);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254); assign_expr();
			setState(257);
			_la = _input.LA(1);
			if (_la==25) {
				{
				setState(255); match(25);
				setState(256); assign_expr();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterAssign_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitAssign_expr(this);
		}
	}

	public final Assign_exprContext assign_expr() throws RecognitionException {
		Assign_exprContext _localctx = new Assign_exprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_assign_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259); conditional_expression();
			setState(263);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 10) | (1L << 15) | (1L << 16) | (1L << 20) | (1L << 23) | (1L << 29) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 47) | (1L << 48))) != 0)) {
				{
				setState(260); assignment_operator();
				setState(261); assign_expr();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterConditional_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitConditional_expression(this);
		}
	}

	public final Conditional_expressionContext conditional_expression() throws RecognitionException {
		Conditional_expressionContext _localctx = new Conditional_expressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_conditional_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265); or_expression();
			setState(271);
			_la = _input.LA(1);
			if (_la==31) {
				{
				setState(266); match(31);
				setState(267); expr();
				setState(268); match(28);
				setState(269); conditional_expression();
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
		public List<And_expressionContext> and_expression() {
			return getRuleContexts(And_expressionContext.class);
		}
		public And_expressionContext and_expression(int i) {
			return getRuleContext(And_expressionContext.class,i);
		}
		public Or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterOr_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitOr_expression(this);
		}
	}

	public final Or_expressionContext or_expression() throws RecognitionException {
		Or_expressionContext _localctx = new Or_expressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273); and_expression();
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==46) {
				{
				{
				setState(274); match(46);
				setState(275); and_expression();
				}
				}
				setState(280);
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

	public static class And_expressionContext extends ParserRuleContext {
		public List<Inclusive_or_expressionContext> inclusive_or_expression() {
			return getRuleContexts(Inclusive_or_expressionContext.class);
		}
		public Inclusive_or_expressionContext inclusive_or_expression(int i) {
			return getRuleContext(Inclusive_or_expressionContext.class,i);
		}
		public And_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterAnd_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitAnd_expression(this);
		}
	}

	public final And_expressionContext and_expression() throws RecognitionException {
		And_expressionContext _localctx = new And_expressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281); inclusive_or_expression();
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==45) {
				{
				{
				setState(282); match(45);
				setState(283); inclusive_or_expression();
				}
				}
				setState(288);
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

	public static class Inclusive_or_expressionContext extends ParserRuleContext {
		public Exclusive_or_expressionContext exclusive_or_expression(int i) {
			return getRuleContext(Exclusive_or_expressionContext.class,i);
		}
		public List<Exclusive_or_expressionContext> exclusive_or_expression() {
			return getRuleContexts(Exclusive_or_expressionContext.class);
		}
		public Inclusive_or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inclusive_or_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterInclusive_or_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitInclusive_or_expression(this);
		}
	}

	public final Inclusive_or_expressionContext inclusive_or_expression() throws RecognitionException {
		Inclusive_or_expressionContext _localctx = new Inclusive_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_inclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289); exclusive_or_expression();
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==18) {
				{
				{
				setState(290); match(18);
				setState(291); exclusive_or_expression();
				}
				}
				setState(296);
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

	public static class Exclusive_or_expressionContext extends ParserRuleContext {
		public Bit_and_expressionContext bit_and_expression(int i) {
			return getRuleContext(Bit_and_expressionContext.class,i);
		}
		public List<Bit_and_expressionContext> bit_and_expression() {
			return getRuleContexts(Bit_and_expressionContext.class);
		}
		public Exclusive_or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusive_or_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterExclusive_or_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitExclusive_or_expression(this);
		}
	}

	public final Exclusive_or_expressionContext exclusive_or_expression() throws RecognitionException {
		Exclusive_or_expressionContext _localctx = new Exclusive_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_exclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297); bit_and_expression();
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==39) {
				{
				{
				setState(298); match(39);
				setState(299); bit_and_expression();
				}
				}
				setState(304);
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

	public static class Bit_and_expressionContext extends ParserRuleContext {
		public Equality_expressionContext equality_expression(int i) {
			return getRuleContext(Equality_expressionContext.class,i);
		}
		public List<Equality_expressionContext> equality_expression() {
			return getRuleContexts(Equality_expressionContext.class);
		}
		public Bit_and_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bit_and_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterBit_and_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitBit_and_expression(this);
		}
	}

	public final Bit_and_expressionContext bit_and_expression() throws RecognitionException {
		Bit_and_expressionContext _localctx = new Bit_and_expressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_bit_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305); equality_expression();
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(306); match(1);
				setState(307); equality_expression();
				}
				}
				setState(312);
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

	public static class Equality_expressionContext extends ParserRuleContext {
		public Equality_operatorContext equality_operator(int i) {
			return getRuleContext(Equality_operatorContext.class,i);
		}
		public List<Equality_operatorContext> equality_operator() {
			return getRuleContexts(Equality_operatorContext.class);
		}
		public Relational_expressionContext relational_expression(int i) {
			return getRuleContext(Relational_expressionContext.class,i);
		}
		public List<Relational_expressionContext> relational_expression() {
			return getRuleContexts(Relational_expressionContext.class);
		}
		public Equality_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterEquality_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitEquality_expression(this);
		}
	}

	public final Equality_expressionContext equality_expression() throws RecognitionException {
		Equality_expressionContext _localctx = new Equality_expressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_equality_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313); relational_expression();
			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==5 || _la==49) {
				{
				{
				setState(314); equality_operator();
				setState(315); relational_expression();
				}
				}
				setState(321);
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

	public static class Relational_expressionContext extends ParserRuleContext {
		public Relational_operatorContext relational_operator(int i) {
			return getRuleContext(Relational_operatorContext.class,i);
		}
		public List<Shift_expressionContext> shift_expression() {
			return getRuleContexts(Shift_expressionContext.class);
		}
		public List<Relational_operatorContext> relational_operator() {
			return getRuleContexts(Relational_operatorContext.class);
		}
		public Shift_expressionContext shift_expression(int i) {
			return getRuleContext(Shift_expressionContext.class,i);
		}
		public Relational_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterRelational_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitRelational_expression(this);
		}
	}

	public final Relational_expressionContext relational_expression() throws RecognitionException {
		Relational_expressionContext _localctx = new Relational_expressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_relational_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322); shift_expression();
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==6 || _la==52 || _la==SMALLER || _la==LARGER) {
				{
				{
				setState(323); relational_operator();
				setState(324); shift_expression();
				}
				}
				setState(330);
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

	public static class Shift_expressionContext extends ParserRuleContext {
		public List<Additive_expressionContext> additive_expression() {
			return getRuleContexts(Additive_expressionContext.class);
		}
		public Additive_expressionContext additive_expression(int i) {
			return getRuleContext(Additive_expressionContext.class,i);
		}
		public Shift_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterShift_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitShift_expression(this);
		}
	}

	public final Shift_expressionContext shift_expression() throws RecognitionException {
		Shift_expressionContext _localctx = new Shift_expressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_shift_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331); additive_expression();
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==7 || _la==38) {
				{
				{
				setState(332);
				_la = _input.LA(1);
				if ( !(_la==7 || _la==38) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(333); additive_expression();
				}
				}
				setState(338);
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

	public static class Additive_expressionContext extends ParserRuleContext {
		public Multiplicative_expressionContext multiplicative_expression(int i) {
			return getRuleContext(Multiplicative_expressionContext.class,i);
		}
		public List<Multiplicative_expressionContext> multiplicative_expression() {
			return getRuleContexts(Multiplicative_expressionContext.class);
		}
		public Additive_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterAdditive_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitAdditive_expression(this);
		}
	}

	public final Additive_expressionContext additive_expression() throws RecognitionException {
		Additive_expressionContext _localctx = new Additive_expressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_additive_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339); multiplicative_expression();
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==26 || _la==42) {
				{
				{
				setState(340);
				_la = _input.LA(1);
				if ( !(_la==26 || _la==42) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(341); multiplicative_expression();
				}
				}
				setState(346);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterMultiplicative_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitMultiplicative_expression(this);
		}
	}

	public final Multiplicative_expressionContext multiplicative_expression() throws RecognitionException {
		Multiplicative_expressionContext _localctx = new Multiplicative_expressionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_multiplicative_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347); cast_expression();
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 9) | (1L << 50))) != 0)) {
				{
				{
				setState(348);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 9) | (1L << 50))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(349); cast_expression();
				}
				}
				setState(354);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterCast_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitCast_expression(this);
		}
	}

	public final Cast_expressionContext cast_expression() throws RecognitionException {
		Cast_expressionContext _localctx = new Cast_expressionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_cast_expression);
		int _la;
		try {
			setState(367);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(355); match(27);
				setState(356); type_name();
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1 || _la==2) {
					{
					{
					setState(357); ptr_operator();
					}
					}
					setState(362);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(363); match(11);
				setState(364); cast_expression();
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(366); unary_expression();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterUnary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitUnary_expression(this);
		}
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_unary_expression);
		int _la;
		try {
			setState(380);
			switch (_input.LA(1)) {
			case 4:
				enterOuterAlt(_localctx, 1);
				{
				setState(369); match(4);
				setState(370); unary_expression();
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 2);
				{
				setState(371); match(36);
				setState(372); unary_expression();
				}
				break;
			case 1:
			case 2:
			case 19:
			case 26:
			case 27:
			case 42:
			case 51:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case CHAR:
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(376);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 19) | (1L << 26) | (1L << 42) | (1L << 51))) != 0)) {
					{
					{
					setState(373); unary_operator();
					}
					}
					setState(378);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(379); postfix_expression();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterFieldOnly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitFieldOnly(this);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitFuncCall(this);
		}
	}

	public final Postfix_expressionContext postfix_expression() throws RecognitionException {
		Postfix_expressionContext _localctx = new Postfix_expressionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_postfix_expression);
		try {
			setState(386);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(382); field();
				setState(383); function_call_tail();
				}
				break;

			case 2:
				_localctx = new FieldOnlyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(385); field();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_field);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(388); primary_expression();
			setState(392);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(389); postfix();
					}
					} 
				}
				setState(394);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterFunction_call_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitFunction_call_tail(this);
		}
	}

	public final Function_call_tailContext function_call_tail() throws RecognitionException {
		Function_call_tailContext _localctx = new Function_call_tailContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_function_call_tail);
		try {
			setState(399);
			switch (_input.LA(1)) {
			case SMALLER:
				enterOuterAlt(_localctx, 1);
				{
				setState(395); call_template_list();
				setState(396); function_argument_list();
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 2);
				{
				setState(398); function_argument_list();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterCall_template_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitCall_template_list(this);
		}
	}

	public final Call_template_listContext call_template_list() throws RecognitionException {
		Call_template_listContext _localctx = new Call_template_listContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_call_template_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401); template_param_list();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterFunction_argument_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitFunction_argument_list(this);
		}
	}

	public final Function_argument_listContext function_argument_list() throws RecognitionException {
		Function_argument_listContext _localctx = new Function_argument_listContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_function_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403); match(27);
			setState(412);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 4) | (1L << 19) | (1L << 26) | (1L << 27) | (1L << 36) | (1L << 42) | (1L << 51))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ALPHA_NUMERIC - 81)) | (1L << (HEX_LITERAL - 81)) | (1L << (DECIMAL_LITERAL - 81)) | (1L << (OCTAL_LITERAL - 81)) | (1L << (FLOATING_POINT_LITERAL - 81)) | (1L << (CHAR - 81)) | (1L << (STRING - 81)))) != 0)) {
				{
				setState(404); function_argument();
				setState(409);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==25) {
					{
					{
					setState(405); match(25);
					setState(406); function_argument();
					}
					}
					setState(411);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(414); match(11);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterFunction_argument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitFunction_argument(this);
		}
	}

	public final Function_argumentContext function_argument() throws RecognitionException {
		Function_argumentContext _localctx = new Function_argumentContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_function_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416); assign_expr();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterPostfix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitPostfix(this);
		}
	}

	public final PostfixContext postfix() throws RecognitionException {
		PostfixContext _localctx = new PostfixContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_postfix);
		try {
			setState(430);
			switch (_input.LA(1)) {
			case 3:
			case 8:
			case 41:
				enterOuterAlt(_localctx, 1);
				{
				setState(426);
				switch (_input.LA(1)) {
				case 41:
					{
					setState(418); match(41);
					setState(419); identifier();
					}
					break;
				case 8:
					{
					setState(420); match(8);
					setState(421); identifier();
					}
					break;
				case 3:
					{
					setState(422); match(3);
					setState(423); expr();
					setState(424); match(21);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 2);
				{
				setState(428); match(36);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 3);
				{
				setState(429); match(4);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterPrimary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitPrimary_expression(this);
		}
	}

	public final Primary_expressionContext primary_expression() throws RecognitionException {
		Primary_expressionContext _localctx = new Primary_expressionContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_primary_expression);
		try {
			setState(438);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(432); identifier();
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
				setState(433); constant();
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 3);
				{
				setState(434); match(27);
				setState(435); expr();
				setState(436); match(11);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterInit_declarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitInit_declarator(this);
		}
	}

	public final Init_declaratorContext init_declarator() throws RecognitionException {
		Init_declaratorContext _localctx = new Init_declaratorContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_init_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(441);
			_la = _input.LA(1);
			if (_la==1 || _la==2) {
				{
				setState(440); ptrs();
				}
			}

			setState(443); identifier();
			setState(445);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(444); type_suffix();
				}
				break;
			}
			}
			setState(454);
			switch (_input.LA(1)) {
			case 27:
				{
				{
				setState(447); match(27);
				setState(449);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 4) | (1L << 19) | (1L << 26) | (1L << 27) | (1L << 36) | (1L << 42) | (1L << 51))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ALPHA_NUMERIC - 81)) | (1L << (HEX_LITERAL - 81)) | (1L << (DECIMAL_LITERAL - 81)) | (1L << (OCTAL_LITERAL - 81)) | (1L << (FLOATING_POINT_LITERAL - 81)) | (1L << (CHAR - 81)) | (1L << (STRING - 81)))) != 0)) {
					{
					setState(448); expr();
					}
				}

				setState(451); match(11);
				}
				}
				break;
			case 15:
				{
				{
				setState(452); match(15);
				setState(453); initializer();
				}
				}
				break;
			case 25:
			case 44:
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterType_suffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitType_suffix(this);
		}
	}

	public final Type_suffixContext type_suffix() throws RecognitionException {
		Type_suffixContext _localctx = new Type_suffixContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_type_suffix);
		int _la;
		try {
			setState(462);
			switch (_input.LA(1)) {
			case 3:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(456); match(3);
				setState(458);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 4) | (1L << 19) | (1L << 26) | (1L << 27) | (1L << 36) | (1L << 42) | (1L << 51))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ALPHA_NUMERIC - 81)) | (1L << (HEX_LITERAL - 81)) | (1L << (DECIMAL_LITERAL - 81)) | (1L << (OCTAL_LITERAL - 81)) | (1L << (FLOATING_POINT_LITERAL - 81)) | (1L << (CHAR - 81)) | (1L << (STRING - 81)))) != 0)) {
					{
					setState(457); conditional_expression();
					}
				}

				setState(460); match(21);
				}
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 2);
				{
				setState(461); param_type_list();
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
		public TerminalNode TYPEDEF() { return getToken(SymbolsParser.TYPEDEF, 0); }
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Simple_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterSimple_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitSimple_decl(this);
		}
	}

	public final Simple_declContext simple_decl() throws RecognitionException {
		Simple_declContext _localctx = new Simple_declContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_simple_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(465);
			_la = _input.LA(1);
			if (_la==TYPEDEF) {
				{
				setState(464); match(TYPEDEF);
				}
			}

			setState(468);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(467); template_decl_start();
				}
			}

			}
			setState(470); var_decl();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterDeclByClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitDeclByClass(this);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterDeclByType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitDeclByType(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_var_decl);
		try {
			setState(479);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				_localctx = new DeclByClassContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(472); class_def();
				setState(474);
				switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
				case 1:
					{
					setState(473); init_declarator_list();
					}
					break;
				}
				}
				break;

			case 2:
				_localctx = new DeclByTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(476); type_name();
				setState(477); init_declarator_list();
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterInit_declarator_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitInit_declarator_list(this);
		}
	}

	public final Init_declarator_listContext init_declarator_list() throws RecognitionException {
		Init_declarator_listContext _localctx = new Init_declarator_listContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481); init_declarator();
			setState(486);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==25) {
				{
				{
				setState(482); match(25);
				setState(483); init_declarator();
				}
				}
				setState(488);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(489); match(44);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitInitializer(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_initializer);
		try {
			setState(496);
			switch (_input.LA(1)) {
			case 1:
			case 2:
			case 4:
			case 19:
			case 26:
			case 27:
			case 36:
			case 42:
			case 51:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case CHAR:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(491); assign_expr();
				}
				break;
			case OPENING_CURLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(492); match(OPENING_CURLY);
				setState(493); initializer_list();
				setState(494); match(CLOSING_CURLY);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterInitializer_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitInitializer_list(this);
		}
	}

	public final Initializer_listContext initializer_list() throws RecognitionException {
		Initializer_listContext _localctx = new Initializer_listContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_initializer_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498); initializer();
			setState(503);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==25) {
				{
				{
				setState(499); match(25);
				setState(500); initializer();
				}
				}
				setState(505);
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
		public TerminalNode CLASS_KEY() { return getToken(SymbolsParser.CLASS_KEY, 0); }
		public TerminalNode OPENING_CURLY() { return getToken(SymbolsParser.OPENING_CURLY, 0); }
		public Class_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterClass_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitClass_def(this);
		}
	}

	public final Class_defContext class_def() throws RecognitionException {
		Class_defContext _localctx = new Class_defContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(506); match(CLASS_KEY);
			setState(508);
			_la = _input.LA(1);
			if (_la==ALPHA_NUMERIC) {
				{
				setState(507); class_name();
				}
			}

			setState(511);
			_la = _input.LA(1);
			if (_la==28) {
				{
				setState(510); base_classes();
				}
			}

			setState(513); match(OPENING_CURLY);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterClass_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitClass_name(this);
		}
	}

	public final Class_nameContext class_name() throws RecognitionException {
		Class_nameContext _localctx = new Class_nameContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_class_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516); identifier();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterBase_classes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitBase_classes(this);
		}
	}

	public final Base_classesContext base_classes() throws RecognitionException {
		Base_classesContext _localctx = new Base_classesContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_base_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(518); match(28);
			setState(519); base_class();
			setState(524);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==25) {
				{
				{
				setState(520); match(25);
				setState(521); base_class();
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

	public static class Base_classContext extends ParserRuleContext {
		public TerminalNode VIRTUAL() { return getToken(SymbolsParser.VIRTUAL, 0); }
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterBase_class(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitBase_class(this);
		}
	}

	public final Base_classContext base_class() throws RecognitionException {
		Base_classContext _localctx = new Base_classContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_base_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(528);
			_la = _input.LA(1);
			if (_la==VIRTUAL) {
				{
				setState(527); match(VIRTUAL);
				}
			}

			setState(531);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 24) | (1L << 30) | (1L << 43))) != 0)) {
				{
				setState(530); access_specifier();
				}
			}

			setState(533); identifier();
			}
		}
		catch (RecognitionException re) {
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
		public List<TerminalNode> CV_QUALIFIER() { return getTokens(SymbolsParser.CV_QUALIFIER); }
		public Template_param_listContext template_param_list(int i) {
			return getRuleContext(Template_param_listContext.class,i);
		}
		public TerminalNode SIGNED() { return getToken(SymbolsParser.SIGNED, 0); }
		public TerminalNode UNSIGNED() { return getToken(SymbolsParser.UNSIGNED, 0); }
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
			return getToken(SymbolsParser.CV_QUALIFIER, i);
		}
		public TerminalNode CLASS_KEY() { return getToken(SymbolsParser.CLASS_KEY, 0); }
		public Type_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterType_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitType_name(this);
		}
	}

	public final Type_nameContext type_name() throws RecognitionException {
		Type_nameContext _localctx = new Type_nameContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_type_name);
		int _la;
		try {
			setState(560);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(538);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CV_QUALIFIER) {
					{
					{
					setState(535); match(CV_QUALIFIER);
					}
					}
					setState(540);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(542);
				_la = _input.LA(1);
				if (((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (UNSIGNED - 66)) | (1L << (SIGNED - 66)) | (1L << (CLASS_KEY - 66)))) != 0)) {
					{
					setState(541);
					_la = _input.LA(1);
					if ( !(((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (UNSIGNED - 66)) | (1L << (SIGNED - 66)) | (1L << (CLASS_KEY - 66)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(544); base_type();
				setState(546);
				_la = _input.LA(1);
				if (_la==SMALLER) {
					{
					setState(545); template_param_list();
					}
				}

				setState(555);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==14) {
					{
					{
					setState(548); match(14);
					setState(549); base_type();
					setState(551);
					_la = _input.LA(1);
					if (_la==SMALLER) {
						{
						setState(550); template_param_list();
						}
					}

					}
					}
					setState(557);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(558); match(UNSIGNED);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(559); match(SIGNED);
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
		public TerminalNode VOID() { return getToken(SymbolsParser.VOID, 0); }
		public TerminalNode ALPHA_NUMERIC() { return getToken(SymbolsParser.ALPHA_NUMERIC, 0); }
		public TerminalNode LONG(int i) {
			return getToken(SymbolsParser.LONG, i);
		}
		public List<TerminalNode> LONG() { return getTokens(SymbolsParser.LONG); }
		public Base_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterBase_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitBase_type(this);
		}
	}

	public final Base_typeContext base_type() throws RecognitionException {
		Base_typeContext _localctx = new Base_typeContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_base_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(567);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				setState(562); match(ALPHA_NUMERIC);
				}
				break;

			case 2:
				{
				setState(563); match(VOID);
				}
				break;

			case 3:
				{
				setState(564); match(LONG);
				}
				break;

			case 4:
				{
				setState(565); match(LONG);
				setState(566); match(LONG);
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
		public TerminalNode REGISTER() { return getToken(SymbolsParser.REGISTER, 0); }
		public TerminalNode AUTO() { return getToken(SymbolsParser.AUTO, 0); }
		public Param_decl_specifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl_specifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterParam_decl_specifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitParam_decl_specifiers(this);
		}
	}

	public final Param_decl_specifiersContext param_decl_specifiers() throws RecognitionException {
		Param_decl_specifiersContext _localctx = new Param_decl_specifiersContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_param_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
			_la = _input.LA(1);
			if (_la==AUTO || _la==REGISTER) {
				{
				setState(569);
				_la = _input.LA(1);
				if ( !(_la==AUTO || _la==REGISTER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(572); type_name();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterParameter_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitParameter_name(this);
		}
	}

	public final Parameter_nameContext parameter_name() throws RecognitionException {
		Parameter_nameContext _localctx = new Parameter_nameContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_parameter_name);
		try {
			setState(576);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(574); identifier();
				}
				break;
			case 24:
			case 30:
			case 43:
				enterOuterAlt(_localctx, 2);
				{
				setState(575); access_specifier();
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
		public TerminalNode VOID() { return getToken(SymbolsParser.VOID, 0); }
		public Param_type_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_type_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterParam_type_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitParam_type_list(this);
		}
	}

	public final Param_type_listContext param_type_list() throws RecognitionException {
		Param_type_listContext _localctx = new Param_type_listContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_param_type_list);
		int _la;
		try {
			setState(593);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(578); match(27);
				setState(579); match(VOID);
				setState(580); match(11);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(581); match(27);
				setState(590);
				_la = _input.LA(1);
				if (((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (VOID - 65)) | (1L << (UNSIGNED - 65)) | (1L << (SIGNED - 65)) | (1L << (LONG - 65)) | (1L << (CV_QUALIFIER - 65)) | (1L << (AUTO - 65)) | (1L << (REGISTER - 65)) | (1L << (CLASS_KEY - 65)) | (1L << (ALPHA_NUMERIC - 65)))) != 0)) {
					{
					setState(582); param_type();
					setState(587);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==25) {
						{
						{
						setState(583); match(25);
						setState(584); param_type();
						}
						}
						setState(589);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(592); match(11);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterParam_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitParam_type(this);
		}
	}

	public final Param_typeContext param_type() throws RecognitionException {
		Param_typeContext _localctx = new Param_typeContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_param_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595); param_decl_specifiers();
			setState(596); param_type_id();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterParam_type_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitParam_type_id(this);
		}
	}

	public final Param_type_idContext param_type_id() throws RecognitionException {
		Param_type_idContext _localctx = new Param_type_idContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_param_type_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			_la = _input.LA(1);
			if (_la==1 || _la==2) {
				{
				setState(598); ptrs();
				}
			}

			setState(608);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				{
				setState(601); match(27);
				setState(602); param_type_id();
				setState(603); match(11);
				}
				break;

			case 2:
				{
				setState(606);
				_la = _input.LA(1);
				if (((((_la - 24)) & ~0x3f) == 0 && ((1L << (_la - 24)) & ((1L << (24 - 24)) | (1L << (30 - 24)) | (1L << (43 - 24)) | (1L << (ALPHA_NUMERIC - 24)))) != 0)) {
					{
					setState(605); parameter_name();
					}
				}

				}
				break;
			}
			setState(611);
			_la = _input.LA(1);
			if (_la==3 || _la==27) {
				{
				setState(610); type_suffix();
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
			return getToken(SymbolsParser.ALPHA_NUMERIC, i);
		}
		public List<TerminalNode> ALPHA_NUMERIC() { return getTokens(SymbolsParser.ALPHA_NUMERIC); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_identifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(613); match(ALPHA_NUMERIC);
			setState(618);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(614); match(14);
					setState(615); match(ALPHA_NUMERIC);
					}
					} 
				}
				setState(620);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
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
		public TerminalNode OCTAL_LITERAL() { return getToken(SymbolsParser.OCTAL_LITERAL, 0); }
		public TerminalNode HEX_LITERAL() { return getToken(SymbolsParser.HEX_LITERAL, 0); }
		public TerminalNode DECIMAL_LITERAL() { return getToken(SymbolsParser.DECIMAL_LITERAL, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(621);
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
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).enterPtrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SymbolsListener ) ((SymbolsListener)listener).exitPtrs(this);
		}
	}

	public final PtrsContext ptrs() throws RecognitionException {
		PtrsContext _localctx = new PtrsContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_ptrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(623); ptr_operator();
				}
				}
				setState(626); 
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

	public static final String _serializedATN =
		"\2\3d\u0277\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\3\2\3"+
		"\2\3\2\7\2\u008e\n\2\f\2\16\2\u0091\13\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\5\n\u00a7\n\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\5\n\u00d1\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00e4\n\16\f\16\16\16\u00e7"+
		"\13\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32"+
		"\5\32\u0104\n\32\3\33\3\33\3\33\3\33\5\33\u010a\n\33\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\5\34\u0112\n\34\3\35\3\35\3\35\7\35\u0117\n\35\f\35\16\35"+
		"\u011a\13\35\3\36\3\36\3\36\7\36\u011f\n\36\f\36\16\36\u0122\13\36\3\37"+
		"\3\37\3\37\7\37\u0127\n\37\f\37\16\37\u012a\13\37\3 \3 \3 \7 \u012f\n"+
		" \f \16 \u0132\13 \3!\3!\3!\7!\u0137\n!\f!\16!\u013a\13!\3\"\3\"\3\"\3"+
		"\"\7\"\u0140\n\"\f\"\16\"\u0143\13\"\3#\3#\3#\3#\7#\u0149\n#\f#\16#\u014c"+
		"\13#\3$\3$\3$\7$\u0151\n$\f$\16$\u0154\13$\3%\3%\3%\7%\u0159\n%\f%\16"+
		"%\u015c\13%\3&\3&\3&\7&\u0161\n&\f&\16&\u0164\13&\3\'\3\'\3\'\7\'\u0169"+
		"\n\'\f\'\16\'\u016c\13\'\3\'\3\'\3\'\3\'\5\'\u0172\n\'\3(\3(\3(\3(\3("+
		"\7(\u0179\n(\f(\16(\u017c\13(\3(\5(\u017f\n(\3)\3)\3)\3)\5)\u0185\n)\3"+
		"*\3*\7*\u0189\n*\f*\16*\u018c\13*\3+\3+\3+\3+\5+\u0192\n+\3,\3,\3-\3-"+
		"\3-\3-\7-\u019a\n-\f-\16-\u019d\13-\5-\u019f\n-\3-\3-\3.\3.\3/\3/\3/\3"+
		"/\3/\3/\3/\3/\5/\u01ad\n/\3/\3/\5/\u01b1\n/\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\5\60\u01b9\n\60\3\61\5\61\u01bc\n\61\3\61\3\61\5\61\u01c0\n\61\3\61"+
		"\3\61\5\61\u01c4\n\61\3\61\3\61\3\61\5\61\u01c9\n\61\3\62\3\62\5\62\u01cd"+
		"\n\62\3\62\3\62\5\62\u01d1\n\62\3\63\5\63\u01d4\n\63\3\63\5\63\u01d7\n"+
		"\63\3\63\3\63\3\64\3\64\5\64\u01dd\n\64\3\64\3\64\3\64\5\64\u01e2\n\64"+
		"\3\65\3\65\3\65\7\65\u01e7\n\65\f\65\16\65\u01ea\13\65\3\65\3\65\3\66"+
		"\3\66\3\66\3\66\3\66\5\66\u01f3\n\66\3\67\3\67\3\67\7\67\u01f8\n\67\f"+
		"\67\16\67\u01fb\13\67\38\38\58\u01ff\n8\38\58\u0202\n8\38\38\38\39\39"+
		"\3:\3:\3:\3:\7:\u020d\n:\f:\16:\u0210\13:\3;\5;\u0213\n;\3;\5;\u0216\n"+
		";\3;\3;\3<\7<\u021b\n<\f<\16<\u021e\13<\3<\5<\u0221\n<\3<\3<\5<\u0225"+
		"\n<\3<\3<\3<\5<\u022a\n<\7<\u022c\n<\f<\16<\u022f\13<\3<\3<\5<\u0233\n"+
		"<\3=\3=\3=\3=\3=\5=\u023a\n=\3>\5>\u023d\n>\3>\3>\3?\3?\5?\u0243\n?\3"+
		"@\3@\3@\3@\3@\3@\3@\7@\u024c\n@\f@\16@\u024f\13@\5@\u0251\n@\3@\5@\u0254"+
		"\n@\3A\3A\3A\3B\5B\u025a\nB\3B\3B\3B\3B\3B\5B\u0261\nB\5B\u0263\nB\3B"+
		"\5B\u0266\nB\3C\3C\3C\7C\u026b\nC\fC\16C\u026e\13C\3D\3D\3E\6E\u0273\n"+
		"E\rE\16E\u0274\3E\2F\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\2\33\7\3\4\25\25\34\34,,\65\65\5\b\b\66\66VW\3[`\6\16\17%%\'\'"+
		"HH\3\3\4\5\32\32  --\4\23\23**\t\f\f\21\22\26\26\31\31\37\37\"$\61\62"+
		"\4\7\7\63\63\4\r\r\35\35\7\5\5\r\r\27\27\35\35TU\5\r\r\35\35..\5\r\r\35"+
		"\35VW\3TU\4\5\5\27\27\5\5\5\27\27..\4\33\33..\t\5\5\r\r\27\27\33\33\35"+
		"\35..TU\7\5\5\r\r\27\27\35\35TU\4\t\t((\4\34\34,,\5\4\4\13\13\64\64\4"+
		"DERR\3NO\3[]\u02a4\2\u008f\3\2\2\2\4\u0094\3\2\2\2\6\u0096\3\2\2\2\b\u0098"+
		"\3\2\2\2\n\u009a\3\2\2\2\f\u009c\3\2\2\2\16\u009e\3\2\2\2\20\u00a0\3\2"+
		"\2\2\22\u00d0\3\2\2\2\24\u00d2\3\2\2\2\26\u00d4\3\2\2\2\30\u00d6\3\2\2"+
		"\2\32\u00d9\3\2\2\2\34\u00ea\3\2\2\2\36\u00ec\3\2\2\2 \u00ee\3\2\2\2\""+
		"\u00f0\3\2\2\2$\u00f2\3\2\2\2&\u00f4\3\2\2\2(\u00f6\3\2\2\2*\u00f8\3\2"+
		"\2\2,\u00fa\3\2\2\2.\u00fc\3\2\2\2\60\u00fe\3\2\2\2\62\u0100\3\2\2\2\64"+
		"\u0105\3\2\2\2\66\u010b\3\2\2\28\u0113\3\2\2\2:\u011b\3\2\2\2<\u0123\3"+
		"\2\2\2>\u012b\3\2\2\2@\u0133\3\2\2\2B\u013b\3\2\2\2D\u0144\3\2\2\2F\u014d"+
		"\3\2\2\2H\u0155\3\2\2\2J\u015d\3\2\2\2L\u0171\3\2\2\2N\u017e\3\2\2\2P"+
		"\u0184\3\2\2\2R\u0186\3\2\2\2T\u0191\3\2\2\2V\u0193\3\2\2\2X\u0195\3\2"+
		"\2\2Z\u01a2\3\2\2\2\\\u01b0\3\2\2\2^\u01b8\3\2\2\2`\u01bb\3\2\2\2b\u01d0"+
		"\3\2\2\2d\u01d3\3\2\2\2f\u01e1\3\2\2\2h\u01e3\3\2\2\2j\u01f2\3\2\2\2l"+
		"\u01f4\3\2\2\2n\u01fc\3\2\2\2p\u0206\3\2\2\2r\u0208\3\2\2\2t\u0212\3\2"+
		"\2\2v\u0232\3\2\2\2x\u0239\3\2\2\2z\u023c\3\2\2\2|\u0242\3\2\2\2~\u0253"+
		"\3\2\2\2\u0080\u0255\3\2\2\2\u0082\u0259\3\2\2\2\u0084\u0267\3\2\2\2\u0086"+
		"\u026f\3\2\2\2\u0088\u0272\3\2\2\2\u008a\u008e\5d\63\2\u008b\u008e\5N"+
		"(\2\u008c\u008e\5\60\31\2\u008d\u008a\3\2\2\2\u008d\u008b\3\2\2\2\u008d"+
		"\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2"+
		"\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0093\7\1\2\2\u0093"+
		"\3\3\2\2\2\u0094\u0095\t\2\2\2\u0095\5\3\2\2\2\u0096\u0097\t\3\2\2\u0097"+
		"\7\3\2\2\2\u0098\u0099\t\4\2\2\u0099\t\3\2\2\2\u009a\u009b\t\5\2\2\u009b"+
		"\13\3\2\2\2\u009c\u009d\t\6\2\2\u009d\r\3\2\2\2\u009e\u009f\t\7\2\2\u009f"+
		"\17\3\2\2\2\u00a0\u00a1\7P\2\2\u00a1\u00a2\5\22\n\2\u00a2\21\3\2\2\2\u00a3"+
		"\u00a6\t\b\2\2\u00a4\u00a5\7\5\2\2\u00a5\u00a7\7\27\2\2\u00a6\u00a4\3"+
		"\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00d1\3\2\2\2\u00a8\u00d1\7,\2\2\u00a9"+
		"\u00d1\7\34\2\2\u00aa\u00d1\7\4\2\2\u00ab\u00d1\7\64\2\2\u00ac\u00d1\7"+
		"\13\2\2\u00ad\u00d1\7)\2\2\u00ae\u00d1\7\3\2\2\u00af\u00d1\7\24\2\2\u00b0"+
		"\u00d1\7\65\2\2\u00b1\u00d1\7\25\2\2\u00b2\u00d1\7\21\2\2\u00b3\u00d1"+
		"\7V\2\2\u00b4\u00d1\7W\2\2\u00b5\u00d1\7#\2\2\u00b6\u00d1\7\31\2\2\u00b7"+
		"\u00d1\7\f\2\2\u00b8\u00d1\7\62\2\2\u00b9\u00d1\7\61\2\2\u00ba\u00d1\7"+
		"$\2\2\u00bb\u00d1\7\37\2\2\u00bc\u00d1\7\22\2\2\u00bd\u00d1\7(\2\2\u00be"+
		"\u00d1\7\t\2\2\u00bf\u00d1\7\"\2\2\u00c0\u00d1\7\26\2\2\u00c1\u00d1\7"+
		"\63\2\2\u00c2\u00d1\7\7\2\2\u00c3\u00d1\7\b\2\2\u00c4\u00d1\7\66\2\2\u00c5"+
		"\u00d1\7/\2\2\u00c6\u00d1\7\60\2\2\u00c7\u00d1\7&\2\2\u00c8\u00d1\7\6"+
		"\2\2\u00c9\u00d1\7\33\2\2\u00ca\u00d1\7\30\2\2\u00cb\u00d1\7\n\2\2\u00cc"+
		"\u00cd\7\35\2\2\u00cd\u00d1\7\r\2\2\u00ce\u00cf\7\5\2\2\u00cf\u00d1\7"+
		"\27\2\2\u00d0\u00a3\3\2\2\2\u00d0\u00a8\3\2\2\2\u00d0\u00a9\3\2\2\2\u00d0"+
		"\u00aa\3\2\2\2\u00d0\u00ab\3\2\2\2\u00d0\u00ac\3\2\2\2\u00d0\u00ad\3\2"+
		"\2\2\u00d0\u00ae\3\2\2\2\u00d0\u00af\3\2\2\2\u00d0\u00b0\3\2\2\2\u00d0"+
		"\u00b1\3\2\2\2\u00d0\u00b2\3\2\2\2\u00d0\u00b3\3\2\2\2\u00d0\u00b4\3\2"+
		"\2\2\u00d0\u00b5\3\2\2\2\u00d0\u00b6\3\2\2\2\u00d0\u00b7\3\2\2\2\u00d0"+
		"\u00b8\3\2\2\2\u00d0\u00b9\3\2\2\2\u00d0\u00ba\3\2\2\2\u00d0\u00bb\3\2"+
		"\2\2\u00d0\u00bc\3\2\2\2\u00d0\u00bd\3\2\2\2\u00d0\u00be\3\2\2\2\u00d0"+
		"\u00bf\3\2\2\2\u00d0\u00c0\3\2\2\2\u00d0\u00c1\3\2\2\2\u00d0\u00c2\3\2"+
		"\2\2\u00d0\u00c3\3\2\2\2\u00d0\u00c4\3\2\2\2\u00d0\u00c5\3\2\2\2\u00d0"+
		"\u00c6\3\2\2\2\u00d0\u00c7\3\2\2\2\u00d0\u00c8\3\2\2\2\u00d0\u00c9\3\2"+
		"\2\2\u00d0\u00ca\3\2\2\2\u00d0\u00cb\3\2\2\2\u00d0\u00cc\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d1\23\3\2\2\2\u00d2\u00d3\t\t\2\2\u00d3\25\3\2\2\2\u00d4"+
		"\u00d5\t\n\2\2\u00d5\27\3\2\2\2\u00d6\u00d7\7Q\2\2\u00d7\u00d8\5\32\16"+
		"\2\u00d8\31\3\2\2\2\u00d9\u00e5\7V\2\2\u00da\u00db\7V\2\2\u00db\u00dc"+
		"\5\32\16\2\u00dc\u00dd\7W\2\2\u00dd\u00e4\3\2\2\2\u00de\u00df\7\35\2\2"+
		"\u00df\u00e0\5\32\16\2\u00e0\u00e1\7\r\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e4"+
		"\5\"\22\2\u00e3\u00da\3\2\2\2\u00e3\u00de\3\2\2\2\u00e3\u00e2\3\2\2\2"+
		"\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e8"+
		"\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00e9\7W\2\2\u00e9\33\3\2\2\2\u00ea"+
		"\u00eb\n\13\2\2\u00eb\35\3\2\2\2\u00ec\u00ed\n\f\2\2\u00ed\37\3\2\2\2"+
		"\u00ee\u00ef\n\r\2\2\u00ef!\3\2\2\2\u00f0\u00f1\n\16\2\2\u00f1#\3\2\2"+
		"\2\u00f2\u00f3\n\17\2\2\u00f3%\3\2\2\2\u00f4\u00f5\n\20\2\2\u00f5\'\3"+
		"\2\2\2\u00f6\u00f7\n\21\2\2\u00f7)\3\2\2\2\u00f8\u00f9\n\22\2\2\u00f9"+
		"+\3\2\2\2\u00fa\u00fb\n\23\2\2\u00fb-\3\2\2\2\u00fc\u00fd\n\24\2\2\u00fd"+
		"/\3\2\2\2\u00fe\u00ff\13\2\2\2\u00ff\61\3\2\2\2\u0100\u0103\5\64\33\2"+
		"\u0101\u0102\7\33\2\2\u0102\u0104\5\64\33\2\u0103\u0101\3\2\2\2\u0103"+
		"\u0104\3\2\2\2\u0104\63\3\2\2\2\u0105\u0109\5\66\34\2\u0106\u0107\5\24"+
		"\13\2\u0107\u0108\5\64\33\2\u0108\u010a\3\2\2\2\u0109\u0106\3\2\2\2\u0109"+
		"\u010a\3\2\2\2\u010a\65\3\2\2\2\u010b\u0111\58\35\2\u010c\u010d\7!\2\2"+
		"\u010d\u010e\5\62\32\2\u010e\u010f\7\36\2\2\u010f\u0110\5\66\34\2\u0110"+
		"\u0112\3\2\2\2\u0111\u010c\3\2\2\2\u0111\u0112\3\2\2\2\u0112\67\3\2\2"+
		"\2\u0113\u0118\5:\36\2\u0114\u0115\7\60\2\2\u0115\u0117\5:\36\2\u0116"+
		"\u0114\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2"+
		"\2\2\u01199\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u0120\5<\37\2\u011c\u011d"+
		"\7/\2\2\u011d\u011f\5<\37\2\u011e\u011c\3\2\2\2\u011f\u0122\3\2\2\2\u0120"+
		"\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121;\3\2\2\2\u0122\u0120\3\2\2\2"+
		"\u0123\u0128\5> \2\u0124\u0125\7\24\2\2\u0125\u0127\5> \2\u0126\u0124"+
		"\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129"+
		"=\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u0130\5@!\2\u012c\u012d\7)\2\2\u012d"+
		"\u012f\5@!\2\u012e\u012c\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e\3\2\2"+
		"\2\u0130\u0131\3\2\2\2\u0131?\3\2\2\2\u0132\u0130\3\2\2\2\u0133\u0138"+
		"\5B\"\2\u0134\u0135\7\3\2\2\u0135\u0137\5B\"\2\u0136\u0134\3\2\2\2\u0137"+
		"\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139A\3\2\2\2"+
		"\u013a\u0138\3\2\2\2\u013b\u0141\5D#\2\u013c\u013d\5\26\f\2\u013d\u013e"+
		"\5D#\2\u013e\u0140\3\2\2\2\u013f\u013c\3\2\2\2\u0140\u0143\3\2\2\2\u0141"+
		"\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142C\3\2\2\2\u0143\u0141\3\2\2\2"+
		"\u0144\u014a\5F$\2\u0145\u0146\5\6\4\2\u0146\u0147\5F$\2\u0147\u0149\3"+
		"\2\2\2\u0148\u0145\3\2\2\2\u0149\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014a"+
		"\u014b\3\2\2\2\u014bE\3\2\2\2\u014c\u014a\3\2\2\2\u014d\u0152\5H%\2\u014e"+
		"\u014f\t\25\2\2\u014f\u0151\5H%\2\u0150\u014e\3\2\2\2\u0151\u0154\3\2"+
		"\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153G\3\2\2\2\u0154\u0152"+
		"\3\2\2\2\u0155\u015a\5J&\2\u0156\u0157\t\26\2\2\u0157\u0159\5J&\2\u0158"+
		"\u0156\3\2\2\2\u0159\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2"+
		"\2\2\u015bI\3\2\2\2\u015c\u015a\3\2\2\2\u015d\u0162\5L\'\2\u015e\u015f"+
		"\t\27\2\2\u015f\u0161\5L\'\2\u0160\u015e\3\2\2\2\u0161\u0164\3\2\2\2\u0162"+
		"\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163K\3\2\2\2\u0164\u0162\3\2\2\2"+
		"\u0165\u0166\7\35\2\2\u0166\u016a\5v<\2\u0167\u0169\5\f\7\2\u0168\u0167"+
		"\3\2\2\2\u0169\u016c\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b"+
		"\u016d\3\2\2\2\u016c\u016a\3\2\2\2\u016d\u016e\7\r\2\2\u016e\u016f\5L"+
		"\'\2\u016f\u0172\3\2\2\2\u0170\u0172\5N(\2\u0171\u0165\3\2\2\2\u0171\u0170"+
		"\3\2\2\2\u0172M\3\2\2\2\u0173\u0174\7\6\2\2\u0174\u017f\5N(\2\u0175\u0176"+
		"\7&\2\2\u0176\u017f\5N(\2\u0177\u0179\5\4\3\2\u0178\u0177\3\2\2\2\u0179"+
		"\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017d\3\2"+
		"\2\2\u017c\u017a\3\2\2\2\u017d\u017f\5P)\2\u017e\u0173\3\2\2\2\u017e\u0175"+
		"\3\2\2\2\u017e\u017a\3\2\2\2\u017fO\3\2\2\2\u0180\u0181\5R*\2\u0181\u0182"+
		"\5T+\2\u0182\u0185\3\2\2\2\u0183\u0185\5R*\2\u0184\u0180\3\2\2\2\u0184"+
		"\u0183\3\2\2\2\u0185Q\3\2\2\2\u0186\u018a\5^\60\2\u0187\u0189\5\\/\2\u0188"+
		"\u0187\3\2\2\2\u0189\u018c\3\2\2\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2"+
		"\2\2\u018bS\3\2\2\2\u018c\u018a\3\2\2\2\u018d\u018e\5V,\2\u018e\u018f"+
		"\5X-\2\u018f\u0192\3\2\2\2\u0190\u0192\5X-\2\u0191\u018d\3\2\2\2\u0191"+
		"\u0190\3\2\2\2\u0192U\3\2\2\2\u0193\u0194\5\32\16\2\u0194W\3\2\2\2\u0195"+
		"\u019e\7\35\2\2\u0196\u019b\5Z.\2\u0197\u0198\7\33\2\2\u0198\u019a\5Z"+
		".\2\u0199\u0197\3\2\2\2\u019a\u019d\3\2\2\2\u019b\u0199\3\2\2\2\u019b"+
		"\u019c\3\2\2\2\u019c\u019f\3\2\2\2\u019d\u019b\3\2\2\2\u019e\u0196\3\2"+
		"\2\2\u019e\u019f\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a1\7\r\2\2\u01a1"+
		"Y\3\2\2\2\u01a2\u01a3\5\64\33\2\u01a3[\3\2\2\2\u01a4\u01a5\7+\2\2\u01a5"+
		"\u01ad\5\u0084C\2\u01a6\u01a7\7\n\2\2\u01a7\u01ad\5\u0084C\2\u01a8\u01a9"+
		"\7\5\2\2\u01a9\u01aa\5\62\32\2\u01aa\u01ab\7\27\2\2\u01ab\u01ad\3\2\2"+
		"\2\u01ac\u01a4\3\2\2\2\u01ac\u01a6\3\2\2\2\u01ac\u01a8\3\2\2\2\u01ad\u01b1"+
		"\3\2\2\2\u01ae\u01b1\7&\2\2\u01af\u01b1\7\6\2\2\u01b0\u01ac\3\2\2\2\u01b0"+
		"\u01ae\3\2\2\2\u01b0\u01af\3\2\2\2\u01b1]\3\2\2\2\u01b2\u01b9\5\u0084"+
		"C\2\u01b3\u01b9\5\b\5\2\u01b4\u01b5\7\35\2\2\u01b5\u01b6\5\62\32\2\u01b6"+
		"\u01b7\7\r\2\2\u01b7\u01b9\3\2\2\2\u01b8\u01b2\3\2\2\2\u01b8\u01b3\3\2"+
		"\2\2\u01b8\u01b4\3\2\2\2\u01b9_\3\2\2\2\u01ba\u01bc\5\u0088E\2\u01bb\u01ba"+
		"\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01bf\5\u0084C"+
		"\2\u01be\u01c0\5b\62\2\u01bf\u01be\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c8"+
		"\3\2\2\2\u01c1\u01c3\7\35\2\2\u01c2\u01c4\5\62\32\2\u01c3\u01c2\3\2\2"+
		"\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c9\7\r\2\2\u01c6\u01c7"+
		"\7\21\2\2\u01c7\u01c9\5j\66\2\u01c8\u01c1\3\2\2\2\u01c8\u01c6\3\2\2\2"+
		"\u01c8\u01c9\3\2\2\2\u01c9a\3\2\2\2\u01ca\u01cc\7\5\2\2\u01cb\u01cd\5"+
		"\66\34\2\u01cc\u01cb\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce"+
		"\u01d1\7\27\2\2\u01cf\u01d1\5~@\2\u01d0\u01ca\3\2\2\2\u01d0\u01cf\3\2"+
		"\2\2\u01d1c\3\2\2\2\u01d2\u01d4\7B\2\2\u01d3\u01d2\3\2\2\2\u01d3\u01d4"+
		"\3\2\2\2\u01d4\u01d6\3\2\2\2\u01d5\u01d7\5\30\r\2\u01d6\u01d5\3\2\2\2"+
		"\u01d6\u01d7\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d9\5f\64\2\u01d9e\3"+
		"\2\2\2\u01da\u01dc\5n8\2\u01db\u01dd\5h\65\2\u01dc\u01db\3\2\2\2\u01dc"+
		"\u01dd\3\2\2\2\u01dd\u01e2\3\2\2\2\u01de\u01df\5v<\2\u01df\u01e0\5h\65"+
		"\2\u01e0\u01e2\3\2\2\2\u01e1\u01da\3\2\2\2\u01e1\u01de\3\2\2\2\u01e2g"+
		"\3\2\2\2\u01e3\u01e8\5`\61\2\u01e4\u01e5\7\33\2\2\u01e5\u01e7\5`\61\2"+
		"\u01e6\u01e4\3\2\2\2\u01e7\u01ea\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e9"+
		"\3\2\2\2\u01e9\u01eb\3\2\2\2\u01ea\u01e8\3\2\2\2\u01eb\u01ec\7.\2\2\u01ec"+
		"i\3\2\2\2\u01ed\u01f3\5\64\33\2\u01ee\u01ef\7T\2\2\u01ef\u01f0\5l\67\2"+
		"\u01f0\u01f1\7U\2\2\u01f1\u01f3\3\2\2\2\u01f2\u01ed\3\2\2\2\u01f2\u01ee"+
		"\3\2\2\2\u01f3k\3\2\2\2\u01f4\u01f9\5j\66\2\u01f5\u01f6\7\33\2\2\u01f6"+
		"\u01f8\5j\66\2\u01f7\u01f5\3\2\2\2\u01f8\u01fb\3\2\2\2\u01f9\u01f7\3\2"+
		"\2\2\u01f9\u01fa\3\2\2\2\u01fam\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fc\u01fe"+
		"\7R\2\2\u01fd\u01ff\5p9\2\u01fe\u01fd\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff"+
		"\u0201\3\2\2\2\u0200\u0202\5r:\2\u0201\u0200\3\2\2\2\u0201\u0202\3\2\2"+
		"\2\u0202\u0203\3\2\2\2\u0203\u0204\7T\2\2\u0204\u0205\b8\1\2\u0205o\3"+
		"\2\2\2\u0206\u0207\5\u0084C\2\u0207q\3\2\2\2\u0208\u0209\7\36\2\2\u0209"+
		"\u020e\5t;\2\u020a\u020b\7\33\2\2\u020b\u020d\5t;\2\u020c\u020a\3\2\2"+
		"\2\u020d\u0210\3\2\2\2\u020e\u020c\3\2\2\2\u020e\u020f\3\2\2\2\u020fs"+
		"\3\2\2\2\u0210\u020e\3\2\2\2\u0211\u0213\7H\2\2\u0212\u0211\3\2\2\2\u0212"+
		"\u0213\3\2\2\2\u0213\u0215\3\2\2\2\u0214\u0216\5\16\b\2\u0215\u0214\3"+
		"\2\2\2\u0215\u0216\3\2\2\2\u0216\u0217\3\2\2\2\u0217\u0218\5\u0084C\2"+
		"\u0218u\3\2\2\2\u0219\u021b\7G\2\2\u021a\u0219\3\2\2\2\u021b\u021e\3\2"+
		"\2\2\u021c\u021a\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u0220\3\2\2\2\u021e"+
		"\u021c\3\2\2\2\u021f\u0221\t\30\2\2\u0220\u021f\3\2\2\2\u0220\u0221\3"+
		"\2\2\2\u0221\u0222\3\2\2\2\u0222\u0224\5x=\2\u0223\u0225\5\32\16\2\u0224"+
		"\u0223\3\2\2\2\u0224\u0225\3\2\2\2\u0225\u022d\3\2\2\2\u0226\u0227\7\20"+
		"\2\2\u0227\u0229\5x=\2\u0228\u022a\5\32\16\2\u0229\u0228\3\2\2\2\u0229"+
		"\u022a\3\2\2\2\u022a\u022c\3\2\2\2\u022b\u0226\3\2\2\2\u022c\u022f\3\2"+
		"\2\2\u022d\u022b\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u0233\3\2\2\2\u022f"+
		"\u022d\3\2\2\2\u0230\u0233\7D\2\2\u0231\u0233\7E\2\2\u0232\u021c\3\2\2"+
		"\2\u0232\u0230\3\2\2\2\u0232\u0231\3\2\2\2\u0233w\3\2\2\2\u0234\u023a"+
		"\7S\2\2\u0235\u023a\7C\2\2\u0236\u023a\7F\2\2\u0237\u0238\7F\2\2\u0238"+
		"\u023a\7F\2\2\u0239\u0234\3\2\2\2\u0239\u0235\3\2\2\2\u0239\u0236\3\2"+
		"\2\2\u0239\u0237\3\2\2\2\u023ay\3\2\2\2\u023b\u023d\t\31\2\2\u023c\u023b"+
		"\3\2\2\2\u023c\u023d\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u023f\5v<\2\u023f"+
		"{\3\2\2\2\u0240\u0243\5\u0084C\2\u0241\u0243\5\16\b\2\u0242\u0240\3\2"+
		"\2\2\u0242\u0241\3\2\2\2\u0243}\3\2\2\2\u0244\u0245\7\35\2\2\u0245\u0246"+
		"\7C\2\2\u0246\u0254\7\r\2\2\u0247\u0250\7\35\2\2\u0248\u024d\5\u0080A"+
		"\2\u0249\u024a\7\33\2\2\u024a\u024c\5\u0080A\2\u024b\u0249\3\2\2\2\u024c"+
		"\u024f\3\2\2\2\u024d\u024b\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u0251\3\2"+
		"\2\2\u024f\u024d\3\2\2\2\u0250\u0248\3\2\2\2\u0250\u0251\3\2\2\2\u0251"+
		"\u0252\3\2\2\2\u0252\u0254\7\r\2\2\u0253\u0244\3\2\2\2\u0253\u0247\3\2"+
		"\2\2\u0254\177\3\2\2\2\u0255\u0256\5z>\2\u0256\u0257\5\u0082B\2\u0257"+
		"\u0081\3\2\2\2\u0258\u025a\5\u0088E\2\u0259\u0258\3\2\2\2\u0259\u025a"+
		"\3\2\2\2\u025a\u0262\3\2\2\2\u025b\u025c\7\35\2\2\u025c\u025d\5\u0082"+
		"B\2\u025d\u025e\7\r\2\2\u025e\u0263\3\2\2\2\u025f\u0261\5|?\2\u0260\u025f"+
		"\3\2\2\2\u0260\u0261\3\2\2\2\u0261\u0263\3\2\2\2\u0262\u025b\3\2\2\2\u0262"+
		"\u0260\3\2\2\2\u0263\u0265\3\2\2\2\u0264\u0266\5b\62\2\u0265\u0264\3\2"+
		"\2\2\u0265\u0266\3\2\2\2\u0266\u0083\3\2\2\2\u0267\u026c\7S\2\2\u0268"+
		"\u0269\7\20\2\2\u0269\u026b\7S\2\2\u026a\u0268\3\2\2\2\u026b\u026e\3\2"+
		"\2\2\u026c\u026a\3\2\2\2\u026c\u026d\3\2\2\2\u026d\u0085\3\2\2\2\u026e"+
		"\u026c\3\2\2\2\u026f\u0270\t\32\2\2\u0270\u0087\3\2\2\2\u0271\u0273\5"+
		"\f\7\2\u0272\u0271\3\2\2\2\u0273\u0274\3\2\2\2\u0274\u0272\3\2\2\2\u0274"+
		"\u0275\3\2\2\2\u0275\u0089\3\2\2\2E\u008d\u008f\u00a6\u00d0\u00e3\u00e5"+
		"\u0103\u0109\u0111\u0118\u0120\u0128\u0130\u0138\u0141\u014a\u0152\u015a"+
		"\u0162\u016a\u0171\u017a\u017e\u0184\u018a\u0191\u019b\u019e\u01ac\u01b0"+
		"\u01b8\u01bb\u01bf\u01c3\u01c8\u01cc\u01d0\u01d3\u01d6\u01dc\u01e1\u01e8"+
		"\u01f2\u01f9\u01fe\u0201\u020e\u0212\u0215\u021c\u0220\u0224\u0229\u022d"+
		"\u0232\u0239\u023c\u0242\u024d\u0250\u0253\u0259\u0260\u0262\u0265\u026c"+
		"\u0274";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}
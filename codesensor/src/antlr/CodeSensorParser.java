// Generated from ./CodeSensor.g4 by ANTLR 4.0

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
public class CodeSensorParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__59=1, T__58=2, T__57=3, T__56=4, T__55=5, T__54=6, T__53=7, T__52=8, 
		T__51=9, T__50=10, T__49=11, T__48=12, T__47=13, T__46=14, T__45=15, T__44=16, 
		T__43=17, T__42=18, T__41=19, T__40=20, T__39=21, T__38=22, T__37=23, 
		T__36=24, T__35=25, T__34=26, T__33=27, T__32=28, T__31=29, T__30=30, 
		T__29=31, T__28=32, T__27=33, T__26=34, T__25=35, T__24=36, T__23=37, 
		T__22=38, T__21=39, T__20=40, T__19=41, T__18=42, T__17=43, T__16=44, 
		T__15=45, T__14=46, T__13=47, T__12=48, T__11=49, T__10=50, T__9=51, T__8=52, 
		T__7=53, T__6=54, T__5=55, T__4=56, T__3=57, T__2=58, T__1=59, T__0=60, 
		IF=61, ELSE=62, FOR=63, WHILE=64, BREAK=65, CASE=66, CONTINUE=67, SWITCH=68, 
		GOTO=69, RETURN=70, TYPEDEF=71, VOID=72, UNSIGNED=73, SIGNED=74, LONG=75, 
		CV_QUALIFIER=76, VIRTUAL=77, TRY=78, CATCH=79, THROW=80, USING=81, NAMESPACE=82, 
		AUTO=83, REGISTER=84, OPERATOR=85, TEMPLATE=86, ALPHA_NUMERIC=87, OPENING_CURLY=88, 
		CLOSING_CURLY=89, PRE_IF=90, PRE_ELSE=91, PRE_ENDIF=92, HEX_LITERAL=93, 
		DECIMAL_LITERAL=94, OCTAL_LITERAL=95, FLOATING_POINT_LITERAL=96, CHAR=97, 
		STRING=98, COMMENT=99, WHITESPACE=100, CPPCOMMENT=101, OTHER=102;
	public static final String[] tokenNames = {
		"<INVALID>", "'&'", "'['", "'*'", "'<'", "'--'", "'!='", "'<='", "'<<'", 
		"'do'", "'%'", "'->'", "'*='", "'union'", "')'", "'inline'", "'explicit'", 
		"'::'", "'='", "'|='", "'new'", "'class'", "'|'", "'!'", "'enum'", "'<<='", 
		"']'", "'-='", "'->*'", "'public'", "','", "'-'", "'('", "':'", "'&='", 
		"'private'", "'?'", "'>>='", "'...'", "'+='", "'^='", "'friend'", "'static'", 
		"'struct'", "'++'", "'>>'", "'^'", "'delete'", "'.'", "'+'", "'protected'", 
		"';'", "'&&'", "'||'", "'>'", "'%='", "'/='", "'=='", "'/'", "'~'", "'>='", 
		"'if'", "'else'", "'for'", "'while'", "'break'", "'case'", "'continue'", 
		"'switch'", "'goto'", "'return'", "'typedef'", "'void'", "'unsigned'", 
		"'signed'", "'long'", "CV_QUALIFIER", "'virtual'", "'try'", "'catch'", 
		"'throw'", "'using'", "'namespace'", "'auto'", "'register'", "'operator'", 
		"'template'", "ALPHA_NUMERIC", "'{'", "'}'", "PRE_IF", "PRE_ELSE", "PRE_ENDIF", 
		"HEX_LITERAL", "DECIMAL_LITERAL", "OCTAL_LITERAL", "FLOATING_POINT_LITERAL", 
		"CHAR", "STRING", "COMMENT", "WHITESPACE", "CPPCOMMENT", "OTHER"
	};
	public static final int
		RULE_code = 0, RULE_part = 1, RULE_declaration = 2, RULE_using_directive = 3, 
		RULE_unary_operator = 4, RULE_relational_operator = 5, RULE_constant = 6, 
		RULE_function_decl_specifiers = 7, RULE_class_key = 8, RULE_ptr_operator = 9, 
		RULE_access_specifier = 10, RULE_operator_function_id = 11, RULE_operator = 12, 
		RULE_assignment_operator = 13, RULE_equality_operator = 14, RULE_template_decl_start = 15, 
		RULE_template_param_list = 16, RULE_no_brackets = 17, RULE_no_brackets_curlies_or_squares = 18, 
		RULE_no_brackets_or_semicolon = 19, RULE_no_angle_brackets_or_brackets = 20, 
		RULE_no_curlies = 21, RULE_no_squares = 22, RULE_no_squares_or_semicolon = 23, 
		RULE_no_comma_or_semicolon = 24, RULE_assign_water = 25, RULE_assign_water_l2 = 26, 
		RULE_water = 27, RULE_statements = 28, RULE_statement = 29, RULE_pre_opener = 30, 
		RULE_pre_else = 31, RULE_pre_closer = 32, RULE_opening_curly = 33, RULE_closing_curly = 34, 
		RULE_non_expr_statement = 35, RULE_block_starter = 36, RULE_non_block_starter = 37, 
		RULE_selection_statement = 38, RULE_if_statement = 39, RULE_else_statement = 40, 
		RULE_switch_statement = 41, RULE_iteration_statement = 42, RULE_for_statement = 43, 
		RULE_while_statement = 44, RULE_do_statement = 45, RULE_do_statement1 = 46, 
		RULE_for_init_statement = 47, RULE_jump_statement = 48, RULE_break_or_continue = 49, 
		RULE_return_statement = 50, RULE_goto_statement = 51, RULE_try_block = 52, 
		RULE_catch_block = 53, RULE_param_type2 = 54, RULE_param_decl_specifiers2 = 55, 
		RULE_type_name2 = 56, RULE_label = 57, RULE_expr_statement = 58, RULE_statement_water = 59, 
		RULE_condition = 60, RULE_expr = 61, RULE_assign_expr = 62, RULE_conditional_expression = 63, 
		RULE_or_expression = 64, RULE_and_expression = 65, RULE_inclusive_or_expression = 66, 
		RULE_exclusive_or_expression = 67, RULE_bit_and_expression = 68, RULE_equality_expression = 69, 
		RULE_relational_expression = 70, RULE_shift_expression = 71, RULE_additive_expression = 72, 
		RULE_multiplicative_expression = 73, RULE_cast_expression = 74, RULE_unary_expression = 75, 
		RULE_postfix_expression = 76, RULE_field = 77, RULE_function_call_tail = 78, 
		RULE_call_template_list = 79, RULE_function_argument_list = 80, RULE_function_argument = 81, 
		RULE_postfix = 82, RULE_primary_expression = 83, RULE_symbols = 84, RULE_symbol = 85, 
		RULE_symbol_water = 86, RULE_function_def = 87, RULE_return_type = 88, 
		RULE_function_param_list = 89, RULE_parameter_decl_clause = 90, RULE_parameter_decl = 91, 
		RULE_parameter_id = 92, RULE_compound_statement = 93, RULE_ctor_list = 94, 
		RULE_ctor_initializer = 95, RULE_initializer_id = 96, RULE_ctor_expr = 97, 
		RULE_function_name = 98, RULE_exception_specification = 99, RULE_type_id_list = 100, 
		RULE_simple_decl = 101, RULE_var_decl = 102, RULE_init_declarator_list = 103, 
		RULE_init_declarator = 104, RULE_assign_expr_w_ = 105, RULE_assign_expr_w__l2 = 106, 
		RULE_class_def = 107, RULE_class_name = 108, RULE_base_classes = 109, 
		RULE_base_class = 110, RULE_type_name = 111, RULE_type_suffix = 112, RULE_base_type = 113, 
		RULE_constant_expr_w_ = 114, RULE_param_decl_specifiers = 115, RULE_parameter_name = 116, 
		RULE_param_type_list = 117, RULE_param_type = 118, RULE_param_type_id = 119, 
		RULE_identifier = 120, RULE_number = 121, RULE_ptrs = 122;
	public static final String[] ruleNames = {
		"code", "part", "declaration", "using_directive", "unary_operator", "relational_operator", 
		"constant", "function_decl_specifiers", "class_key", "ptr_operator", "access_specifier", 
		"operator_function_id", "operator", "assignment_operator", "equality_operator", 
		"template_decl_start", "template_param_list", "no_brackets", "no_brackets_curlies_or_squares", 
		"no_brackets_or_semicolon", "no_angle_brackets_or_brackets", "no_curlies", 
		"no_squares", "no_squares_or_semicolon", "no_comma_or_semicolon", "assign_water", 
		"assign_water_l2", "water", "statements", "statement", "pre_opener", "pre_else", 
		"pre_closer", "opening_curly", "closing_curly", "non_expr_statement", 
		"block_starter", "non_block_starter", "selection_statement", "if_statement", 
		"else_statement", "switch_statement", "iteration_statement", "for_statement", 
		"while_statement", "do_statement", "do_statement1", "for_init_statement", 
		"jump_statement", "break_or_continue", "return_statement", "goto_statement", 
		"try_block", "catch_block", "param_type2", "param_decl_specifiers2", "type_name2", 
		"label", "expr_statement", "statement_water", "condition", "expr", "assign_expr", 
		"conditional_expression", "or_expression", "and_expression", "inclusive_or_expression", 
		"exclusive_or_expression", "bit_and_expression", "equality_expression", 
		"relational_expression", "shift_expression", "additive_expression", "multiplicative_expression", 
		"cast_expression", "unary_expression", "postfix_expression", "field", 
		"function_call_tail", "call_template_list", "function_argument_list", 
		"function_argument", "postfix", "primary_expression", "symbols", "symbol", 
		"symbol_water", "function_def", "return_type", "function_param_list", 
		"parameter_decl_clause", "parameter_decl", "parameter_id", "compound_statement", 
		"ctor_list", "ctor_initializer", "initializer_id", "ctor_expr", "function_name", 
		"exception_specification", "type_id_list", "simple_decl", "var_decl", 
		"init_declarator_list", "init_declarator", "assign_expr_w_", "assign_expr_w__l2", 
		"class_def", "class_name", "base_classes", "base_class", "type_name", 
		"type_suffix", "base_type", "constant_expr_w_", "param_decl_specifiers", 
		"parameter_name", "param_type_list", "param_type", "param_type_id", "identifier", 
		"number", "ptrs"
	};

	@Override
	public String getGrammarFileName() { return "CodeSensor.g4"; }

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


	public CodeSensorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CodeContext extends ParserRuleContext {
		public PartContext part(int i) {
			return getRuleContext(PartContext.class,i);
		}
		public List<PartContext> part() {
			return getRuleContexts(PartContext.class);
		}
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitCode(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_code);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << IF) | (1L << ELSE) | (1L << FOR))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (WHILE - 64)) | (1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (21 - 64)) | (1L << (24 - 64)) | (1L << (32 - 64)) | (1L << (41 - 64)) | (1L << (42 - 64)) | (1L << (43 - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (USING - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)))) != 0)) {
				{
				{
				setState(246); part();
				}
				}
				setState(251);
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

	public static class PartContext extends ParserRuleContext {
		public WaterContext water() {
			return getRuleContext(WaterContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public PartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_part; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitPart(this);
		}
	}

	public final PartContext part() throws RecognitionException {
		PartContext _localctx = new PartContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_part);
		try {
			setState(254);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(252); declaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(253); water();
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

	public static class DeclarationContext extends ParserRuleContext {
		public Function_defContext function_def() {
			return getRuleContext(Function_defContext.class,0);
		}
		public Using_directiveContext using_directive() {
			return getRuleContext(Using_directiveContext.class,0);
		}
		public Simple_declContext simple_decl() {
			return getRuleContext(Simple_declContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			setState(259);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(256); function_def();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(257); simple_decl();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(258); using_directive();
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

	public static class Using_directiveContext extends ParserRuleContext {
		public TerminalNode USING() { return getToken(CodeSensorParser.USING, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode NAMESPACE() { return getToken(CodeSensorParser.NAMESPACE, 0); }
		public Using_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_using_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterUsing_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitUsing_directive(this);
		}
	}

	public final Using_directiveContext using_directive() throws RecognitionException {
		Using_directiveContext _localctx = new Using_directiveContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_using_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261); match(USING);
			setState(262); match(NAMESPACE);
			setState(263); identifier();
			setState(264); match(51);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitUnary_operator(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 23) | (1L << 31) | (1L << 49) | (1L << 59))) != 0)) ) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterRelational_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitRelational_operator(this);
		}
	}

	public final Relational_operatorContext relational_operator() throws RecognitionException {
		Relational_operatorContext _localctx = new Relational_operatorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_relational_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 54) | (1L << 60))) != 0)) ) {
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
		public TerminalNode CHAR() { return getToken(CodeSensorParser.CHAR, 0); }
		public TerminalNode OCTAL_LITERAL() { return getToken(CodeSensorParser.OCTAL_LITERAL, 0); }
		public TerminalNode HEX_LITERAL() { return getToken(CodeSensorParser.HEX_LITERAL, 0); }
		public TerminalNode FLOATING_POINT_LITERAL() { return getToken(CodeSensorParser.FLOATING_POINT_LITERAL, 0); }
		public TerminalNode DECIMAL_LITERAL() { return getToken(CodeSensorParser.DECIMAL_LITERAL, 0); }
		public TerminalNode STRING() { return getToken(CodeSensorParser.STRING, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			_la = _input.LA(1);
			if ( !(((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (HEX_LITERAL - 93)) | (1L << (DECIMAL_LITERAL - 93)) | (1L << (OCTAL_LITERAL - 93)) | (1L << (FLOATING_POINT_LITERAL - 93)) | (1L << (CHAR - 93)) | (1L << (STRING - 93)))) != 0)) ) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFunction_decl_specifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFunction_decl_specifiers(this);
		}
	}

	public final Function_decl_specifiersContext function_decl_specifiers() throws RecognitionException {
		Function_decl_specifiersContext _localctx = new Function_decl_specifiersContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_function_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			_la = _input.LA(1);
			if ( !(((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (15 - 15)) | (1L << (16 - 15)) | (1L << (41 - 15)) | (1L << (42 - 15)) | (1L << (VIRTUAL - 15)))) != 0)) ) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterClass_key(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitClass_key(this);
		}
	}

	public final Class_keyContext class_key() throws RecognitionException {
		Class_keyContext _localctx = new Class_keyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_class_key);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 21) | (1L << 24) | (1L << 43))) != 0)) ) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterPtr_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitPtr_operator(this);
		}
	}

	public final Ptr_operatorContext ptr_operator() throws RecognitionException {
		Ptr_operatorContext _localctx = new Ptr_operatorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ptr_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterAccess_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitAccess_specifier(this);
		}
	}

	public final Access_specifierContext access_specifier() throws RecognitionException {
		Access_specifierContext _localctx = new Access_specifierContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_access_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 29) | (1L << 35) | (1L << 50))) != 0)) ) {
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
		public TerminalNode OPERATOR() { return getToken(CodeSensorParser.OPERATOR, 0); }
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public Operator_function_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_function_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterOperator_function_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitOperator_function_id(this);
		}
	}

	public final Operator_function_idContext operator_function_id() throws RecognitionException {
		Operator_function_idContext _localctx = new Operator_function_idContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_operator_function_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280); match(OPERATOR);
			setState(281); operator();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitOperator(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_operator);
		int _la;
		try {
			setState(328);
			switch (_input.LA(1)) {
			case 20:
			case 47:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(283);
				_la = _input.LA(1);
				if ( !(_la==20 || _la==47) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(286);
				_la = _input.LA(1);
				if (_la==2) {
					{
					setState(284); match(2);
					setState(285); match(26);
					}
				}

				}
				}
				break;
			case 49:
				enterOuterAlt(_localctx, 2);
				{
				setState(288); match(49);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 3);
				{
				setState(289); match(31);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 4);
				{
				setState(290); match(3);
				}
				break;
			case 58:
				enterOuterAlt(_localctx, 5);
				{
				setState(291); match(58);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 6);
				{
				setState(292); match(10);
				}
				break;
			case 46:
				enterOuterAlt(_localctx, 7);
				{
				setState(293); match(46);
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 8);
				{
				setState(294); match(1);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 9);
				{
				setState(295); match(22);
				}
				break;
			case 59:
				enterOuterAlt(_localctx, 10);
				{
				setState(296); match(59);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 11);
				{
				setState(297); match(23);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 12);
				{
				setState(298); match(18);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 13);
				{
				setState(299); match(4);
				}
				break;
			case 54:
				enterOuterAlt(_localctx, 14);
				{
				setState(300); match(54);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 15);
				{
				setState(301); match(39);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 16);
				{
				setState(302); match(27);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 17);
				{
				setState(303); match(12);
				}
				break;
			case 56:
				enterOuterAlt(_localctx, 18);
				{
				setState(304); match(56);
				}
				break;
			case 55:
				enterOuterAlt(_localctx, 19);
				{
				setState(305); match(55);
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 20);
				{
				setState(306); match(40);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 21);
				{
				setState(307); match(34);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 22);
				{
				setState(308); match(19);
				}
				break;
			case 45:
				enterOuterAlt(_localctx, 23);
				{
				setState(309); match(45);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 24);
				{
				setState(310); match(8);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 25);
				{
				setState(311); match(37);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 26);
				{
				setState(312); match(25);
				}
				break;
			case 57:
				enterOuterAlt(_localctx, 27);
				{
				setState(313); match(57);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 28);
				{
				setState(314); match(6);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 29);
				{
				setState(315); match(7);
				}
				break;
			case 60:
				enterOuterAlt(_localctx, 30);
				{
				setState(316); match(60);
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 31);
				{
				setState(317); match(52);
				}
				break;
			case 53:
				enterOuterAlt(_localctx, 32);
				{
				setState(318); match(53);
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 33);
				{
				setState(319); match(44);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 34);
				{
				setState(320); match(5);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 35);
				{
				setState(321); match(30);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 36);
				{
				setState(322); match(28);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 37);
				{
				setState(323); match(11);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 38);
				{
				setState(324); match(32);
				setState(325); match(14);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 39);
				{
				setState(326); match(2);
				setState(327); match(26);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterAssignment_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitAssignment_operator(this);
		}
	}

	public final Assignment_operatorContext assignment_operator() throws RecognitionException {
		Assignment_operatorContext _localctx = new Assignment_operatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_assignment_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 18) | (1L << 19) | (1L << 25) | (1L << 27) | (1L << 34) | (1L << 37) | (1L << 39) | (1L << 40) | (1L << 55) | (1L << 56))) != 0)) ) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterEquality_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitEquality_operator(this);
		}
	}

	public final Equality_operatorContext equality_operator() throws RecognitionException {
		Equality_operatorContext _localctx = new Equality_operatorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_equality_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
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
		public TerminalNode TEMPLATE() { return getToken(CodeSensorParser.TEMPLATE, 0); }
		public Template_decl_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_decl_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterTemplate_decl_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitTemplate_decl_start(this);
		}
	}

	public final Template_decl_startContext template_decl_start() throws RecognitionException {
		Template_decl_startContext _localctx = new Template_decl_startContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_template_decl_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334); match(TEMPLATE);
			setState(335); match(4);
			setState(336); template_param_list();
			setState(337); match(54);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterTemplate_param_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitTemplate_param_list(this);
		}
	}

	public final Template_param_listContext template_param_list() throws RecognitionException {
		Template_param_listContext _localctx = new Template_param_listContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_template_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << IF) | (1L << ELSE) | (1L << FOR))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (WHILE - 64)) | (1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				setState(348);
				switch (_input.LA(1)) {
				case 4:
					{
					{
					setState(339); match(4);
					setState(340); template_param_list();
					setState(341); match(54);
					}
					}
					break;
				case 32:
					{
					{
					setState(343); match(32);
					setState(344); template_param_list();
					setState(345); match(14);
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
				case 53:
				case 55:
				case 56:
				case 57:
				case 58:
				case 59:
				case 60:
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
					setState(347); no_angle_brackets_or_brackets();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(352);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterNo_brackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitNo_brackets(this);
		}
	}

	public final No_bracketsContext no_brackets() throws RecognitionException {
		No_bracketsContext _localctx = new No_bracketsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_no_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterNo_brackets_curlies_or_squares(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitNo_brackets_curlies_or_squares(this);
		}
	}

	public final No_brackets_curlies_or_squaresContext no_brackets_curlies_or_squares() throws RecognitionException {
		No_brackets_curlies_or_squaresContext _localctx = new No_brackets_curlies_or_squaresContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_no_brackets_curlies_or_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 14) | (1L << 26) | (1L << 32))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterNo_brackets_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitNo_brackets_or_semicolon(this);
		}
	}

	public final No_brackets_or_semicolonContext no_brackets_or_semicolon() throws RecognitionException {
		No_brackets_or_semicolonContext _localctx = new No_brackets_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_no_brackets_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 14) | (1L << 32) | (1L << 51))) != 0)) ) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterNo_angle_brackets_or_brackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitNo_angle_brackets_or_brackets(this);
		}
	}

	public final No_angle_brackets_or_bracketsContext no_angle_brackets_or_brackets() throws RecognitionException {
		No_angle_brackets_or_bracketsContext _localctx = new No_angle_brackets_or_bracketsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_no_angle_brackets_or_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 14) | (1L << 32) | (1L << 54))) != 0)) ) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterNo_curlies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitNo_curlies(this);
		}
	}

	public final No_curliesContext no_curlies() throws RecognitionException {
		No_curliesContext _localctx = new No_curliesContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_no_curlies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterNo_squares(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitNo_squares(this);
		}
	}

	public final No_squaresContext no_squares() throws RecognitionException {
		No_squaresContext _localctx = new No_squaresContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_no_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==2 || _la==26) ) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterNo_squares_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitNo_squares_or_semicolon(this);
		}
	}

	public final No_squares_or_semicolonContext no_squares_or_semicolon() throws RecognitionException {
		No_squares_or_semicolonContext _localctx = new No_squares_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_no_squares_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 26) | (1L << 51))) != 0)) ) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterNo_comma_or_semicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitNo_comma_or_semicolon(this);
		}
	}

	public final No_comma_or_semicolonContext no_comma_or_semicolon() throws RecognitionException {
		No_comma_or_semicolonContext _localctx = new No_comma_or_semicolonContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_no_comma_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==30 || _la==51) ) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterAssign_water(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitAssign_water(this);
		}
	}

	public final Assign_waterContext assign_water() throws RecognitionException {
		Assign_waterContext _localctx = new Assign_waterContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_assign_water);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 14) | (1L << 26) | (1L << 30) | (1L << 32) | (1L << 51))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterAssign_water_l2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitAssign_water_l2(this);
		}
	}

	public final Assign_water_l2Context assign_water_l2() throws RecognitionException {
		Assign_water_l2Context _localctx = new Assign_water_l2Context(_ctx, getState());
		enterRule(_localctx, 52, RULE_assign_water_l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 14) | (1L << 26) | (1L << 32))) != 0) || _la==OPENING_CURLY || _la==CLOSING_CURLY) ) {
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
		public TerminalNode OTHER() { return getToken(CodeSensorParser.OTHER, 0); }
		public WaterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_water; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterWater(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitWater(this);
		}
	}

	public final WaterContext water() throws RecognitionException {
		WaterContext _localctx = new WaterContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_water);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << IF) | (1L << ELSE) | (1L << FOR))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (WHILE - 64)) | (1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)) | (1L << (5 - 64)) | (1L << (9 - 64)) | (1L << (13 - 64)) | (1L << (21 - 64)) | (1L << (23 - 64)) | (1L << (24 - 64)) | (1L << (29 - 64)) | (1L << (31 - 64)) | (1L << (32 - 64)) | (1L << (35 - 64)) | (1L << (43 - 64)) | (1L << (44 - 64)) | (1L << (49 - 64)) | (1L << (50 - 64)) | (1L << (59 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)))) != 0)) {
				{
				setState(381);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(375); pre_opener();
					}
					break;

				case 2:
					{
					setState(376); pre_closer();
					}
					break;

				case 3:
					{
					setState(377); pre_else();
					preProcSkipToEnd(); 
					}
					break;

				case 4:
					{
					setState(380); statement();
					}
					break;
				}
				}
				setState(385);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_statement);
		try {
			setState(391);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(386); opening_curly();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(387); closing_curly();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(388); non_expr_statement();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(389); expr_statement();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(390); statement_water();
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
		public TerminalNode PRE_IF() { return getToken(CodeSensorParser.PRE_IF, 0); }
		public Pre_openerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pre_opener; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterPre_opener(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitPre_opener(this);
		}
	}

	public final Pre_openerContext pre_opener() throws RecognitionException {
		Pre_openerContext _localctx = new Pre_openerContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_pre_opener);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393); match(PRE_IF);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode PRE_ELSE() { return getToken(CodeSensorParser.PRE_ELSE, 0); }
		public Pre_elseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pre_else; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterPre_else(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitPre_else(this);
		}
	}

	public final Pre_elseContext pre_else() throws RecognitionException {
		Pre_elseContext _localctx = new Pre_elseContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_pre_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395); match(PRE_ELSE);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode PRE_ENDIF() { return getToken(CodeSensorParser.PRE_ENDIF, 0); }
		public Pre_closerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pre_closer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterPre_closer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitPre_closer(this);
		}
	}

	public final Pre_closerContext pre_closer() throws RecognitionException {
		Pre_closerContext _localctx = new Pre_closerContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_pre_closer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397); match(PRE_ENDIF);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterOpening_curly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitOpening_curly(this);
		}
	}

	public final Opening_curlyContext opening_curly() throws RecognitionException {
		Opening_curlyContext _localctx = new Opening_curlyContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_opening_curly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399); match(OPENING_CURLY);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterClosing_curly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitClosing_curly(this);
		}
	}

	public final Closing_curlyContext closing_curly() throws RecognitionException {
		Closing_curlyContext _localctx = new Closing_curlyContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_closing_curly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401); match(CLOSING_CURLY);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterNon_expr_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitNon_expr_statement(this);
		}
	}

	public final Non_expr_statementContext non_expr_statement() throws RecognitionException {
		Non_expr_statementContext _localctx = new Non_expr_statementContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_non_expr_statement);
		try {
			setState(405);
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
				setState(403); block_starter();
				}
				break;
			case 13:
			case 21:
			case 24:
			case 29:
			case 35:
			case 43:
			case 50:
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
				setState(404); non_block_starter();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterBlock_starter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitBlock_starter(this);
		}
	}

	public final Block_starterContext block_starter() throws RecognitionException {
		Block_starterContext _localctx = new Block_starterContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_block_starter);
		try {
			setState(411);
			switch (_input.LA(1)) {
			case IF:
			case ELSE:
			case SWITCH:
				enterOuterAlt(_localctx, 1);
				{
				setState(407); selection_statement();
				}
				break;
			case 9:
			case FOR:
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(408); iteration_statement();
				}
				break;
			case TRY:
				enterOuterAlt(_localctx, 3);
				{
				setState(409); try_block();
				}
				break;
			case CATCH:
				enterOuterAlt(_localctx, 4);
				{
				setState(410); catch_block();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterNon_block_starter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitNon_block_starter(this);
		}
	}

	public final Non_block_starterContext non_block_starter() throws RecognitionException {
		Non_block_starterContext _localctx = new Non_block_starterContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_non_block_starter);
		try {
			setState(416);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(413); jump_statement();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(414); simple_decl();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(415); label();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterSelection_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitSelection_statement(this);
		}
	}

	public final Selection_statementContext selection_statement() throws RecognitionException {
		Selection_statementContext _localctx = new Selection_statementContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_selection_statement);
		try {
			setState(421);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(418); if_statement();
				}
				break;
			case ELSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(419); else_statement();
				}
				break;
			case SWITCH:
				enterOuterAlt(_localctx, 3);
				{
				setState(420); switch_statement();
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
		public TerminalNode IF() { return getToken(CodeSensorParser.IF, 0); }
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitIf_statement(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423); match(IF);
			setState(424); match(32);
			setState(425); condition();
			setState(426); match(14);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode ELSE() { return getToken(CodeSensorParser.ELSE, 0); }
		public Else_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterElse_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitElse_statement(this);
		}
	}

	public final Else_statementContext else_statement() throws RecognitionException {
		Else_statementContext _localctx = new Else_statementContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_else_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428); match(ELSE);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode SWITCH() { return getToken(CodeSensorParser.SWITCH, 0); }
		public Switch_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterSwitch_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitSwitch_statement(this);
		}
	}

	public final Switch_statementContext switch_statement() throws RecognitionException {
		Switch_statementContext _localctx = new Switch_statementContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_switch_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430); match(SWITCH);
			setState(431); match(32);
			setState(432); condition();
			setState(433); match(14);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterIteration_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitIteration_statement(this);
		}
	}

	public final Iteration_statementContext iteration_statement() throws RecognitionException {
		Iteration_statementContext _localctx = new Iteration_statementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_iteration_statement);
		try {
			setState(438);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(435); for_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 2);
				{
				setState(436); do_statement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(437); while_statement();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFor_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFor_statement(this);
		}
	}

	public final For_statementContext for_statement() throws RecognitionException {
		For_statementContext _localctx = new For_statementContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_for_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440); match(FOR);
			setState(441); match(32);
			setState(442); for_init_statement();
			setState(443); condition();
			setState(444); match(51);
			setState(446);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 23) | (1L << 31) | (1L << 32) | (1L << 44) | (1L << 49) | (1L << 59))) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (ALPHA_NUMERIC - 87)) | (1L << (HEX_LITERAL - 87)) | (1L << (DECIMAL_LITERAL - 87)) | (1L << (OCTAL_LITERAL - 87)) | (1L << (FLOATING_POINT_LITERAL - 87)) | (1L << (CHAR - 87)) | (1L << (STRING - 87)))) != 0)) {
				{
				setState(445); expr();
				}
			}

			setState(448); match(14);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterWhile_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitWhile_statement(this);
		}
	}

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_while_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450); match(WHILE);
			setState(451); match(32);
			setState(452); condition();
			setState(453); match(14);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterDo_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitDo_statement(this);
		}
	}

	public final Do_statementContext do_statement() throws RecognitionException {
		Do_statementContext _localctx = new Do_statementContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_do_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455); match(9);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterDo_statement1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitDo_statement1(this);
		}
	}

	public final Do_statement1Context do_statement1() throws RecognitionException {
		Do_statement1Context _localctx = new Do_statement1Context(_ctx, getState());
		enterRule(_localctx, 92, RULE_do_statement1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457); match(9);
			setState(458); statement();
			setState(459); match(WHILE);
			setState(460); match(32);
			setState(461); expr();
			setState(462); match(14);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFor_init_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFor_init_statement(this);
		}
	}

	public final For_init_statementContext for_init_statement() throws RecognitionException {
		For_init_statementContext _localctx = new For_init_statementContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_for_init_statement);
		int _la;
		try {
			setState(469);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(464); simple_decl();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(466);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 23) | (1L << 31) | (1L << 32) | (1L << 44) | (1L << 49) | (1L << 59))) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (ALPHA_NUMERIC - 87)) | (1L << (HEX_LITERAL - 87)) | (1L << (DECIMAL_LITERAL - 87)) | (1L << (OCTAL_LITERAL - 87)) | (1L << (FLOATING_POINT_LITERAL - 87)) | (1L << (CHAR - 87)) | (1L << (STRING - 87)))) != 0)) {
					{
					setState(465); expr();
					}
				}

				setState(468); match(51);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterJump_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitJump_statement(this);
		}
	}

	public final Jump_statementContext jump_statement() throws RecognitionException {
		Jump_statementContext _localctx = new Jump_statementContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_jump_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			switch (_input.LA(1)) {
			case BREAK:
			case CONTINUE:
				{
				setState(471); break_or_continue();
				}
				break;
			case RETURN:
				{
				setState(472); return_statement();
				}
				break;
			case GOTO:
				{
				setState(473); goto_statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(476); match(51);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterBreak_or_continue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitBreak_or_continue(this);
		}
	}

	public final Break_or_continueContext break_or_continue() throws RecognitionException {
		Break_or_continueContext _localctx = new Break_or_continueContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_break_or_continue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterReturn_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitReturn_statement(this);
		}
	}

	public final Return_statementContext return_statement() throws RecognitionException {
		Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_return_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480); match(RETURN);
			setState(482);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 23) | (1L << 31) | (1L << 32) | (1L << 44) | (1L << 49) | (1L << 59))) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (ALPHA_NUMERIC - 87)) | (1L << (HEX_LITERAL - 87)) | (1L << (DECIMAL_LITERAL - 87)) | (1L << (OCTAL_LITERAL - 87)) | (1L << (FLOATING_POINT_LITERAL - 87)) | (1L << (CHAR - 87)) | (1L << (STRING - 87)))) != 0)) {
				{
				setState(481); expr();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterGoto_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitGoto_statement(this);
		}
	}

	public final Goto_statementContext goto_statement() throws RecognitionException {
		Goto_statementContext _localctx = new Goto_statementContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_goto_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484); match(GOTO);
			setState(485); identifier();
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode TRY() { return getToken(CodeSensorParser.TRY, 0); }
		public Try_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_try_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterTry_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitTry_block(this);
		}
	}

	public final Try_blockContext try_block() throws RecognitionException {
		Try_blockContext _localctx = new Try_blockContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_try_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487); match(TRY);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode CATCH() { return getToken(CodeSensorParser.CATCH, 0); }
		public Catch_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catch_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterCatch_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitCatch_block(this);
		}
	}

	public final Catch_blockContext catch_block() throws RecognitionException {
		Catch_blockContext _localctx = new Catch_blockContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_catch_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(489); match(CATCH);
			setState(490); match(32);
			setState(491); param_type2();
			setState(492); match(14);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterParam_type2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitParam_type2(this);
		}
	}

	public final Param_type2Context param_type2() throws RecognitionException {
		Param_type2Context _localctx = new Param_type2Context(_ctx, getState());
		enterRule(_localctx, 108, RULE_param_type2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494); param_decl_specifiers2();
			setState(495); param_type_id();
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode REGISTER() { return getToken(CodeSensorParser.REGISTER, 0); }
		public Type_name2Context type_name2() {
			return getRuleContext(Type_name2Context.class,0);
		}
		public TerminalNode AUTO() { return getToken(CodeSensorParser.AUTO, 0); }
		public Param_decl_specifiers2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl_specifiers2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterParam_decl_specifiers2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitParam_decl_specifiers2(this);
		}
	}

	public final Param_decl_specifiers2Context param_decl_specifiers2() throws RecognitionException {
		Param_decl_specifiers2Context _localctx = new Param_decl_specifiers2Context(_ctx, getState());
		enterRule(_localctx, 110, RULE_param_decl_specifiers2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			_la = _input.LA(1);
			if (_la==AUTO || _la==REGISTER) {
				{
				setState(497);
				_la = _input.LA(1);
				if ( !(_la==AUTO || _la==REGISTER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(500); type_name2();
			}
		}
		catch (RecognitionException re) {
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
		public List<TerminalNode> CV_QUALIFIER() { return getTokens(CodeSensorParser.CV_QUALIFIER); }
		public Template_param_listContext template_param_list(int i) {
			return getRuleContext(Template_param_listContext.class,i);
		}
		public TerminalNode SIGNED() { return getToken(CodeSensorParser.SIGNED, 0); }
		public TerminalNode UNSIGNED() { return getToken(CodeSensorParser.UNSIGNED, 0); }
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
			return getToken(CodeSensorParser.CV_QUALIFIER, i);
		}
		public Type_name2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterType_name2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitType_name2(this);
		}
	}

	public final Type_name2Context type_name2() throws RecognitionException {
		Type_name2Context _localctx = new Type_name2Context(_ctx, getState());
		enterRule(_localctx, 112, RULE_type_name2);
		int _la;
		try {
			setState(534);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(505);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CV_QUALIFIER) {
					{
					{
					setState(502); match(CV_QUALIFIER);
					}
					}
					setState(507);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(511);
				switch (_input.LA(1)) {
				case 13:
				case 21:
				case 24:
				case 43:
					{
					setState(508); class_key();
					}
					break;
				case UNSIGNED:
					{
					setState(509); match(UNSIGNED);
					}
					break;
				case SIGNED:
					{
					setState(510); match(SIGNED);
					}
					break;
				case VOID:
				case LONG:
				case ALPHA_NUMERIC:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(513); base_type();
				setState(518);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(514); match(4);
					setState(515); template_param_list();
					setState(516); match(54);
					}
				}

				setState(530);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==17) {
					{
					{
					setState(520); match(17);
					setState(521); base_type();
					setState(526);
					_la = _input.LA(1);
					if (_la==4) {
						{
						setState(522); match(4);
						setState(523); template_param_list();
						setState(524); match(54);
						}
					}

					}
					}
					setState(532);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(533);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitLabel(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(544);
			switch (_input.LA(1)) {
			case CASE:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
				{
				{
				setState(537);
				_la = _input.LA(1);
				if (_la==CASE) {
					{
					setState(536); match(CASE);
					}
				}

				setState(541);
				switch (_input.LA(1)) {
				case ALPHA_NUMERIC:
					{
					setState(539); identifier();
					}
					break;
				case HEX_LITERAL:
				case DECIMAL_LITERAL:
				case OCTAL_LITERAL:
					{
					setState(540); number();
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
			case 50:
				{
				setState(543); access_specifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(546); match(33);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterExpr_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitExpr_statement(this);
		}
	}

	public final Expr_statementContext expr_statement() throws RecognitionException {
		Expr_statementContext _localctx = new Expr_statementContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_expr_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548); expr();
			setState(549); match(51);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterStatement_water(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitStatement_water(this);
		}
	}

	public final Statement_waterContext statement_water() throws RecognitionException {
		Statement_waterContext _localctx = new Statement_waterContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_statement_water);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553); expr();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(555); assign_expr();
			setState(558);
			_la = _input.LA(1);
			if (_la==30) {
				{
				setState(556); match(30);
				setState(557); assign_expr();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterAssign_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitAssign_expr(this);
		}
	}

	public final Assign_exprContext assign_expr() throws RecognitionException {
		Assign_exprContext _localctx = new Assign_exprContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_assign_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560); conditional_expression();
			setState(564);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 18) | (1L << 19) | (1L << 25) | (1L << 27) | (1L << 34) | (1L << 37) | (1L << 39) | (1L << 40) | (1L << 55) | (1L << 56))) != 0)) {
				{
				setState(561); assignment_operator();
				setState(562); assign_expr();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterConditional_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitConditional_expression(this);
		}
	}

	public final Conditional_expressionContext conditional_expression() throws RecognitionException {
		Conditional_expressionContext _localctx = new Conditional_expressionContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_conditional_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566); or_expression();
			setState(572);
			_la = _input.LA(1);
			if (_la==36) {
				{
				setState(567); match(36);
				setState(568); expr();
				setState(569); match(33);
				setState(570); conditional_expression();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterOr_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitOr_expression(this);
		}
	}

	public final Or_expressionContext or_expression() throws RecognitionException {
		Or_expressionContext _localctx = new Or_expressionContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(574); and_expression();
			setState(577);
			_la = _input.LA(1);
			if (_la==53) {
				{
				setState(575); match(53);
				setState(576); or_expression();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterAnd_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitAnd_expression(this);
		}
	}

	public final And_expressionContext and_expression() throws RecognitionException {
		And_expressionContext _localctx = new And_expressionContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579); inclusive_or_expression();
			setState(582);
			_la = _input.LA(1);
			if (_la==52) {
				{
				setState(580); match(52);
				setState(581); and_expression();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterInclusive_or_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitInclusive_or_expression(this);
		}
	}

	public final Inclusive_or_expressionContext inclusive_or_expression() throws RecognitionException {
		Inclusive_or_expressionContext _localctx = new Inclusive_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_inclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(584); exclusive_or_expression();
			setState(587);
			_la = _input.LA(1);
			if (_la==22) {
				{
				setState(585); match(22);
				setState(586); inclusive_or_expression();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterExclusive_or_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitExclusive_or_expression(this);
		}
	}

	public final Exclusive_or_expressionContext exclusive_or_expression() throws RecognitionException {
		Exclusive_or_expressionContext _localctx = new Exclusive_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_exclusive_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589); bit_and_expression();
			setState(592);
			_la = _input.LA(1);
			if (_la==46) {
				{
				setState(590); match(46);
				setState(591); exclusive_or_expression();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterBit_and_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitBit_and_expression(this);
		}
	}

	public final Bit_and_expressionContext bit_and_expression() throws RecognitionException {
		Bit_and_expressionContext _localctx = new Bit_and_expressionContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_bit_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(594); equality_expression();
			setState(597);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(595); match(1);
				setState(596); bit_and_expression();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterEquality_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitEquality_expression(this);
		}
	}

	public final Equality_expressionContext equality_expression() throws RecognitionException {
		Equality_expressionContext _localctx = new Equality_expressionContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_equality_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599); relational_expression();
			setState(603);
			_la = _input.LA(1);
			if (_la==6 || _la==57) {
				{
				setState(600); equality_operator();
				setState(601); equality_expression();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterRelational_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitRelational_expression(this);
		}
	}

	public final Relational_expressionContext relational_expression() throws RecognitionException {
		Relational_expressionContext _localctx = new Relational_expressionContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_relational_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(605); shift_expression();
			setState(609);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 7) | (1L << 54) | (1L << 60))) != 0)) {
				{
				setState(606); relational_operator();
				setState(607); relational_expression();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterShift_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitShift_expression(this);
		}
	}

	public final Shift_expressionContext shift_expression() throws RecognitionException {
		Shift_expressionContext _localctx = new Shift_expressionContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_shift_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(611); additive_expression();
			setState(614);
			_la = _input.LA(1);
			if (_la==8 || _la==45) {
				{
				setState(612);
				_la = _input.LA(1);
				if ( !(_la==8 || _la==45) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(613); shift_expression();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterAdditive_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitAdditive_expression(this);
		}
	}

	public final Additive_expressionContext additive_expression() throws RecognitionException {
		Additive_expressionContext _localctx = new Additive_expressionContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_additive_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(616); multiplicative_expression();
			setState(619);
			_la = _input.LA(1);
			if (_la==31 || _la==49) {
				{
				setState(617);
				_la = _input.LA(1);
				if ( !(_la==31 || _la==49) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(618); additive_expression();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterMultiplicative_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitMultiplicative_expression(this);
		}
	}

	public final Multiplicative_expressionContext multiplicative_expression() throws RecognitionException {
		Multiplicative_expressionContext _localctx = new Multiplicative_expressionContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_multiplicative_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(621); cast_expression();
			setState(624);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 10) | (1L << 58))) != 0)) {
				{
				setState(622);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 10) | (1L << 58))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(623); cast_expression();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterCast_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitCast_expression(this);
		}
	}

	public final Cast_expressionContext cast_expression() throws RecognitionException {
		Cast_expressionContext _localctx = new Cast_expressionContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_cast_expression);
		int _la;
		try {
			setState(638);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(626); match(32);
				setState(627); type_name();
				setState(631);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1 || _la==3) {
					{
					{
					setState(628); ptr_operator();
					}
					}
					setState(633);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(634); match(14);
				setState(635); cast_expression();
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(637); unary_expression();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterUnary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitUnary_expression(this);
		}
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_unary_expression);
		int _la;
		try {
			setState(652);
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
				setState(640); postfix_expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 2);
				{
				setState(641); match(5);
				setState(642); unary_expression();
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 3);
				{
				setState(643); match(44);
				setState(644); unary_expression();
				}
				break;
			case 1:
			case 3:
			case 23:
			case 31:
			case 49:
			case 59:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(646); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(645); unary_operator();
					}
					}
					setState(648); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 23) | (1L << 31) | (1L << 49) | (1L << 59))) != 0) );
				setState(650); postfix_expression();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFieldOnly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFieldOnly(this);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFuncCall(this);
		}
	}

	public final Postfix_expressionContext postfix_expression() throws RecognitionException {
		Postfix_expressionContext _localctx = new Postfix_expressionContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_postfix_expression);
		try {
			setState(658);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				_localctx = new FieldOnlyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(654); field();
				}
				break;

			case 2:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(655); field();
				setState(656); function_call_tail();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(660); primary_expression();
			setState(664);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 5) | (1L << 11) | (1L << 44) | (1L << 48))) != 0)) {
				{
				{
				setState(661); postfix();
				}
				}
				setState(666);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFunction_call_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFunction_call_tail(this);
		}
	}

	public final Function_call_tailContext function_call_tail() throws RecognitionException {
		Function_call_tailContext _localctx = new Function_call_tailContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_function_call_tail);
		try {
			setState(671);
			switch (_input.LA(1)) {
			case 4:
				enterOuterAlt(_localctx, 1);
				{
				setState(667); call_template_list();
				setState(668); function_argument_list();
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 2);
				{
				setState(670); function_argument_list();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterCall_template_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitCall_template_list(this);
		}
	}

	public final Call_template_listContext call_template_list() throws RecognitionException {
		Call_template_listContext _localctx = new Call_template_listContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_call_template_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(673); match(4);
			setState(674); template_param_list();
			setState(675); match(54);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFunction_argument_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFunction_argument_list(this);
		}
	}

	public final Function_argument_listContext function_argument_list() throws RecognitionException {
		Function_argument_listContext _localctx = new Function_argument_listContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_function_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(677); match(32);
			setState(686);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 23) | (1L << 31) | (1L << 32) | (1L << 44) | (1L << 49) | (1L << 59))) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (ALPHA_NUMERIC - 87)) | (1L << (HEX_LITERAL - 87)) | (1L << (DECIMAL_LITERAL - 87)) | (1L << (OCTAL_LITERAL - 87)) | (1L << (FLOATING_POINT_LITERAL - 87)) | (1L << (CHAR - 87)) | (1L << (STRING - 87)))) != 0)) {
				{
				setState(678); function_argument();
				setState(683);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==30) {
					{
					{
					setState(679); match(30);
					setState(680); function_argument();
					}
					}
					setState(685);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(688); match(14);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFunction_argument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFunction_argument(this);
		}
	}

	public final Function_argumentContext function_argument() throws RecognitionException {
		Function_argumentContext _localctx = new Function_argumentContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_function_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(690); assign_expr();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterPostfix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitPostfix(this);
		}
	}

	public final PostfixContext postfix() throws RecognitionException {
		PostfixContext _localctx = new PostfixContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_postfix);
		try {
			setState(704);
			switch (_input.LA(1)) {
			case 2:
			case 11:
			case 48:
				enterOuterAlt(_localctx, 1);
				{
				setState(700);
				switch (_input.LA(1)) {
				case 48:
					{
					setState(692); match(48);
					setState(693); identifier();
					}
					break;
				case 11:
					{
					setState(694); match(11);
					setState(695); identifier();
					}
					break;
				case 2:
					{
					setState(696); match(2);
					setState(697); expr();
					setState(698); match(26);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 2);
				{
				setState(702); match(44);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 3);
				{
				setState(703); match(5);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterPrimary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitPrimary_expression(this);
		}
	}

	public final Primary_expressionContext primary_expression() throws RecognitionException {
		Primary_expressionContext _localctx = new Primary_expressionContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_primary_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(712);
			switch (_input.LA(1)) {
			case 32:
				{
				setState(706); match(32);
				setState(707); expr();
				setState(708); match(14);
				}
				break;
			case ALPHA_NUMERIC:
				{
				setState(710); identifier();
				}
				break;
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case CHAR:
			case STRING:
				{
				setState(711); constant();
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

	public static class SymbolsContext extends ParserRuleContext {
		public List<SymbolContext> symbol() {
			return getRuleContexts(SymbolContext.class);
		}
		public SymbolContext symbol(int i) {
			return getRuleContext(SymbolContext.class,i);
		}
		public SymbolsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbols; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterSymbols(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitSymbols(this);
		}
	}

	public final SymbolsContext symbols() throws RecognitionException {
		SymbolsContext _localctx = new SymbolsContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_symbols);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(717);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 21) | (1L << 24) | (1L << 32) | (1L << 43))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (TYPEDEF - 71)) | (1L << (VOID - 71)) | (1L << (UNSIGNED - 71)) | (1L << (SIGNED - 71)) | (1L << (LONG - 71)) | (1L << (CV_QUALIFIER - 71)) | (1L << (TEMPLATE - 71)) | (1L << (ALPHA_NUMERIC - 71)) | (1L << (HEX_LITERAL - 71)) | (1L << (DECIMAL_LITERAL - 71)) | (1L << (OCTAL_LITERAL - 71)) | (1L << (FLOATING_POINT_LITERAL - 71)) | (1L << (CHAR - 71)) | (1L << (STRING - 71)))) != 0)) {
				{
				{
				setState(714); symbol();
				}
				}
				setState(719);
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

	public static class SymbolContext extends ParserRuleContext {
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public Simple_declContext simple_decl() {
			return getRuleContext(Simple_declContext.class,0);
		}
		public SymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitSymbol(this);
		}
	}

	public final SymbolContext symbol() throws RecognitionException {
		SymbolContext _localctx = new SymbolContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_symbol);
		try {
			setState(722);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(720); simple_decl();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(721); postfix_expression();
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

	public static class Symbol_waterContext extends ParserRuleContext {
		public Symbol_waterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbol_water; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterSymbol_water(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitSymbol_water(this);
		}
	}

	public final Symbol_waterContext symbol_water() throws RecognitionException {
		Symbol_waterContext _localctx = new Symbol_waterContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_symbol_water);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(724);
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

	public static class Function_defContext extends ParserRuleContext {
		public Function_param_listContext function_param_list() {
			return getRuleContext(Function_param_listContext.class,0);
		}
		public Template_decl_startContext template_decl_start() {
			return getRuleContext(Template_decl_startContext.class,0);
		}
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public Ctor_listContext ctor_list() {
			return getRuleContext(Ctor_listContext.class,0);
		}
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public Function_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFunction_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFunction_def(this);
		}
	}

	public final Function_defContext function_def() throws RecognitionException {
		Function_defContext _localctx = new Function_defContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_function_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(727);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(726); template_decl_start();
				}
			}

			setState(730);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(729); return_type();
				}
				break;
			}
			setState(732); function_name();
			setState(733); function_param_list();
			setState(735);
			_la = _input.LA(1);
			if (_la==33) {
				{
				setState(734); ctor_list();
				}
			}

			setState(737); compound_statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_typeContext extends ParserRuleContext {
		public List<Function_decl_specifiersContext> function_decl_specifiers() {
			return getRuleContexts(Function_decl_specifiersContext.class);
		}
		public Ptr_operatorContext ptr_operator(int i) {
			return getRuleContext(Ptr_operatorContext.class,i);
		}
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public Function_decl_specifiersContext function_decl_specifiers(int i) {
			return getRuleContext(Function_decl_specifiersContext.class,i);
		}
		public List<Ptr_operatorContext> ptr_operator() {
			return getRuleContexts(Ptr_operatorContext.class);
		}
		public Return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterReturn_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitReturn_type(this);
		}
	}

	public final Return_typeContext return_type() throws RecognitionException {
		Return_typeContext _localctx = new Return_typeContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_return_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(742);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (15 - 15)) | (1L << (16 - 15)) | (1L << (41 - 15)) | (1L << (42 - 15)) | (1L << (VIRTUAL - 15)))) != 0)) {
				{
				{
				setState(739); function_decl_specifiers();
				}
				}
				setState(744);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(745); type_name();
			}
			setState(750);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1 || _la==3) {
				{
				{
				setState(747); ptr_operator();
				}
				}
				setState(752);
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

	public static class Function_param_listContext extends ParserRuleContext {
		public List<TerminalNode> CV_QUALIFIER() { return getTokens(CodeSensorParser.CV_QUALIFIER); }
		public Exception_specificationContext exception_specification() {
			return getRuleContext(Exception_specificationContext.class,0);
		}
		public Parameter_decl_clauseContext parameter_decl_clause() {
			return getRuleContext(Parameter_decl_clauseContext.class,0);
		}
		public TerminalNode CV_QUALIFIER(int i) {
			return getToken(CodeSensorParser.CV_QUALIFIER, i);
		}
		public Function_param_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_param_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFunction_param_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFunction_param_list(this);
		}
	}

	public final Function_param_listContext function_param_list() throws RecognitionException {
		Function_param_listContext _localctx = new Function_param_listContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_function_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(753); match(32);
			setState(755);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 21) | (1L << 24) | (1L << 43))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (VOID - 72)) | (1L << (UNSIGNED - 72)) | (1L << (SIGNED - 72)) | (1L << (LONG - 72)) | (1L << (CV_QUALIFIER - 72)) | (1L << (AUTO - 72)) | (1L << (REGISTER - 72)) | (1L << (ALPHA_NUMERIC - 72)))) != 0)) {
				{
				setState(754); parameter_decl_clause();
				}
			}

			setState(757); match(14);
			setState(761);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CV_QUALIFIER) {
				{
				{
				setState(758); match(CV_QUALIFIER);
				}
				}
				setState(763);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(765);
			_la = _input.LA(1);
			if (_la==THROW) {
				{
				setState(764); exception_specification();
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

	public static class Parameter_decl_clauseContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(CodeSensorParser.VOID, 0); }
		public List<Parameter_declContext> parameter_decl() {
			return getRuleContexts(Parameter_declContext.class);
		}
		public Parameter_declContext parameter_decl(int i) {
			return getRuleContext(Parameter_declContext.class,i);
		}
		public Parameter_decl_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_decl_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterParameter_decl_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitParameter_decl_clause(this);
		}
	}

	public final Parameter_decl_clauseContext parameter_decl_clause() throws RecognitionException {
		Parameter_decl_clauseContext _localctx = new Parameter_decl_clauseContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_parameter_decl_clause);
		int _la;
		try {
			int _alt;
			setState(780);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(767); parameter_decl();
				setState(772);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(768); match(30);
						setState(769); parameter_decl();
						}
						} 
					}
					setState(774);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
				}
				}
				setState(777);
				_la = _input.LA(1);
				if (_la==30) {
					{
					setState(775); match(30);
					setState(776); match(38);
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(779); match(VOID);
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

	public static class Parameter_declContext extends ParserRuleContext {
		public Param_decl_specifiersContext param_decl_specifiers() {
			return getRuleContext(Param_decl_specifiersContext.class,0);
		}
		public Parameter_idContext parameter_id() {
			return getRuleContext(Parameter_idContext.class,0);
		}
		public Parameter_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterParameter_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitParameter_decl(this);
		}
	}

	public final Parameter_declContext parameter_decl() throws RecognitionException {
		Parameter_declContext _localctx = new Parameter_declContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_parameter_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(782); param_decl_specifiers();
			setState(783); parameter_id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parameter_idContext extends ParserRuleContext {
		public Type_suffixContext type_suffix() {
			return getRuleContext(Type_suffixContext.class,0);
		}
		public Parameter_idContext parameter_id() {
			return getRuleContext(Parameter_idContext.class,0);
		}
		public Parameter_nameContext parameter_name() {
			return getRuleContext(Parameter_nameContext.class,0);
		}
		public PtrsContext ptrs() {
			return getRuleContext(PtrsContext.class,0);
		}
		public Parameter_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterParameter_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitParameter_id(this);
		}
	}

	public final Parameter_idContext parameter_id() throws RecognitionException {
		Parameter_idContext _localctx = new Parameter_idContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_parameter_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(786);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(785); ptrs();
				}
			}

			setState(793);
			switch (_input.LA(1)) {
			case 32:
				{
				setState(788); match(32);
				setState(789); parameter_id();
				setState(790); match(14);
				}
				break;
			case 29:
			case 35:
			case 50:
			case ALPHA_NUMERIC:
				{
				setState(792); parameter_name();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(796);
			_la = _input.LA(1);
			if (_la==2 || _la==32) {
				{
				setState(795); type_suffix();
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

	public static class Compound_statementContext extends ParserRuleContext {
		public TerminalNode OPENING_CURLY() { return getToken(CodeSensorParser.OPENING_CURLY, 0); }
		public Compound_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterCompound_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitCompound_statement(this);
		}
	}

	public final Compound_statementContext compound_statement() throws RecognitionException {
		Compound_statementContext _localctx = new Compound_statementContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_compound_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(798); match(OPENING_CURLY);
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

	public static class Ctor_listContext extends ParserRuleContext {
		public Ctor_initializerContext ctor_initializer(int i) {
			return getRuleContext(Ctor_initializerContext.class,i);
		}
		public List<Ctor_initializerContext> ctor_initializer() {
			return getRuleContexts(Ctor_initializerContext.class);
		}
		public Ctor_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctor_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterCtor_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitCtor_list(this);
		}
	}

	public final Ctor_listContext ctor_list() throws RecognitionException {
		Ctor_listContext _localctx = new Ctor_listContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_ctor_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(801); match(33);
			setState(802); ctor_initializer();
			setState(807);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==30) {
				{
				{
				setState(803); match(30);
				setState(804); ctor_initializer();
				}
				}
				setState(809);
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

	public static class Ctor_initializerContext extends ParserRuleContext {
		public Initializer_idContext initializer_id() {
			return getRuleContext(Initializer_idContext.class,0);
		}
		public Ctor_exprContext ctor_expr() {
			return getRuleContext(Ctor_exprContext.class,0);
		}
		public Ctor_initializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctor_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterCtor_initializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitCtor_initializer(this);
		}
	}

	public final Ctor_initializerContext ctor_initializer() throws RecognitionException {
		Ctor_initializerContext _localctx = new Ctor_initializerContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_ctor_initializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(810); initializer_id();
			setState(811); ctor_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Initializer_idContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Initializer_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterInitializer_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitInitializer_id(this);
		}
	}

	public final Initializer_idContext initializer_id() throws RecognitionException {
		Initializer_idContext _localctx = new Initializer_idContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_initializer_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(814);
			_la = _input.LA(1);
			if (_la==17) {
				{
				setState(813); match(17);
				}
			}

			setState(816); identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ctor_exprContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Ctor_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctor_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterCtor_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitCtor_expr(this);
		}
	}

	public final Ctor_exprContext ctor_expr() throws RecognitionException {
		Ctor_exprContext _localctx = new Ctor_exprContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_ctor_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(818); match(32);
			setState(820);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 23) | (1L << 31) | (1L << 32) | (1L << 44) | (1L << 49) | (1L << 59))) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (ALPHA_NUMERIC - 87)) | (1L << (HEX_LITERAL - 87)) | (1L << (DECIMAL_LITERAL - 87)) | (1L << (OCTAL_LITERAL - 87)) | (1L << (FLOATING_POINT_LITERAL - 87)) | (1L << (CHAR - 87)) | (1L << (STRING - 87)))) != 0)) {
				{
				setState(819); expr();
				}
			}

			setState(822); match(14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_nameContext extends ParserRuleContext {
		public Operator_function_idContext operator_function_id() {
			return getRuleContext(Operator_function_idContext.class,0);
		}
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterFunction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitFunction_name(this);
		}
	}

	public final Function_nameContext function_name() throws RecognitionException {
		Function_nameContext _localctx = new Function_nameContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_function_name);
		try {
			setState(830);
			switch (_input.LA(1)) {
			case 32:
				enterOuterAlt(_localctx, 1);
				{
				setState(824); match(32);
				setState(825); function_name();
				setState(826); match(14);
				}
				break;
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(828); identifier();
				}
				break;
			case OPERATOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(829); operator_function_id();
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

	public static class Exception_specificationContext extends ParserRuleContext {
		public Type_id_listContext type_id_list() {
			return getRuleContext(Type_id_listContext.class,0);
		}
		public TerminalNode THROW() { return getToken(CodeSensorParser.THROW, 0); }
		public Exception_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exception_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterException_specification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitException_specification(this);
		}
	}

	public final Exception_specificationContext exception_specification() throws RecognitionException {
		Exception_specificationContext _localctx = new Exception_specificationContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_exception_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(832); match(THROW);
			setState(833); match(32);
			setState(834); type_id_list();
			setState(835); match(14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_id_listContext extends ParserRuleContext {
		public List<Type_id_listContext> type_id_list() {
			return getRuleContexts(Type_id_listContext.class);
		}
		public Type_id_listContext type_id_list(int i) {
			return getRuleContext(Type_id_listContext.class,i);
		}
		public No_bracketsContext no_brackets(int i) {
			return getRuleContext(No_bracketsContext.class,i);
		}
		public List<No_bracketsContext> no_brackets() {
			return getRuleContexts(No_bracketsContext.class);
		}
		public Type_id_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_id_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterType_id_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitType_id_list(this);
		}
	}

	public final Type_id_listContext type_id_list() throws RecognitionException {
		Type_id_listContext _localctx = new Type_id_listContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_type_id_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(840);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << IF) | (1L << ELSE) | (1L << FOR))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (WHILE - 64)) | (1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(837); no_brackets();
				}
				}
				setState(842);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(854);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==32) {
				{
				{
				setState(843); match(32);
				setState(844); type_id_list();
				setState(845); match(14);
				setState(849);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << IF) | (1L << ELSE) | (1L << FOR))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (WHILE - 64)) | (1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(846); no_brackets();
					}
					}
					setState(851);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(856);
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

	public static class Simple_declContext extends ParserRuleContext {
		public Template_decl_startContext template_decl_start() {
			return getRuleContext(Template_decl_startContext.class,0);
		}
		public TerminalNode TYPEDEF() { return getToken(CodeSensorParser.TYPEDEF, 0); }
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Simple_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterSimple_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitSimple_decl(this);
		}
	}

	public final Simple_declContext simple_decl() throws RecognitionException {
		Simple_declContext _localctx = new Simple_declContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_simple_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(858);
			_la = _input.LA(1);
			if (_la==TYPEDEF) {
				{
				setState(857); match(TYPEDEF);
				}
			}

			setState(861);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(860); template_decl_start();
				}
			}

			setState(863); var_decl();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterDeclByClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitDeclByClass(this);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterDeclByType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitDeclByType(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_var_decl);
		try {
			setState(872);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				_localctx = new DeclByTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(865); type_name();
				setState(866); init_declarator_list();
				}
				break;

			case 2:
				_localctx = new DeclByClassContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(868); class_def();
				setState(870);
				switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
				case 1:
					{
					setState(869); init_declarator_list();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterInit_declarator_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitInit_declarator_list(this);
		}
	}

	public final Init_declarator_listContext init_declarator_list() throws RecognitionException {
		Init_declarator_listContext _localctx = new Init_declarator_listContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(874); init_declarator();
			setState(879);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==30) {
				{
				{
				setState(875); match(30);
				setState(876); init_declarator();
				}
				}
				setState(881);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(882); match(51);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterInit_declarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitInit_declarator(this);
		}
	}

	public final Init_declaratorContext init_declarator() throws RecognitionException {
		Init_declaratorContext _localctx = new Init_declaratorContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_init_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(885);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(884); ptrs();
				}
			}

			setState(887); identifier();
			setState(889);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				{
				setState(888); type_suffix();
				}
				break;
			}
			}
			setState(898);
			switch (_input.LA(1)) {
			case 32:
				{
				{
				setState(891); match(32);
				setState(893);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 5) | (1L << 23) | (1L << 31) | (1L << 32) | (1L << 44) | (1L << 49) | (1L << 59))) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (ALPHA_NUMERIC - 87)) | (1L << (HEX_LITERAL - 87)) | (1L << (DECIMAL_LITERAL - 87)) | (1L << (OCTAL_LITERAL - 87)) | (1L << (FLOATING_POINT_LITERAL - 87)) | (1L << (CHAR - 87)) | (1L << (STRING - 87)))) != 0)) {
					{
					setState(892); expr();
					}
				}

				setState(895); match(14);
				}
				}
				break;
			case 18:
				{
				{
				setState(896); match(18);
				setState(897); assign_expr_w_();
				}
				}
				break;
			case 30:
			case 51:
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterAssign_expr_w_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitAssign_expr_w_(this);
		}
	}

	public final Assign_expr_w_Context assign_expr_w_() throws RecognitionException {
		Assign_expr_w_Context _localctx = new Assign_expr_w_Context(_ctx, getState());
		enterRule(_localctx, 210, RULE_assign_expr_w_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(903);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 31) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << IF) | (1L << ELSE) | (1L << FOR))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (WHILE - 64)) | (1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(900); assign_water();
				}
				}
				setState(905);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(928);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2 || _la==32 || _la==OPENING_CURLY) {
				{
				{
				setState(918);
				switch (_input.LA(1)) {
				case OPENING_CURLY:
					{
					setState(906); match(OPENING_CURLY);
					setState(907); assign_expr_w__l2();
					setState(908); match(CLOSING_CURLY);
					}
					break;
				case 32:
					{
					setState(910); match(32);
					setState(911); assign_expr_w__l2();
					setState(912); match(14);
					}
					break;
				case 2:
					{
					setState(914); match(2);
					setState(915); assign_expr_w__l2();
					setState(916); match(26);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(923);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 31) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << IF) | (1L << ELSE) | (1L << FOR))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (WHILE - 64)) | (1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(920); assign_water();
					}
					}
					setState(925);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(930);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterAssign_expr_w__l2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitAssign_expr_w__l2(this);
		}
	}

	public final Assign_expr_w__l2Context assign_expr_w__l2() throws RecognitionException {
		Assign_expr_w__l2Context _localctx = new Assign_expr_w__l2Context(_ctx, getState());
		enterRule(_localctx, 212, RULE_assign_expr_w__l2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(934);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << IF) | (1L << ELSE) | (1L << FOR))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (WHILE - 64)) | (1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(931); assign_water_l2();
				}
				}
				setState(936);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(959);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2 || _la==32 || _la==OPENING_CURLY) {
				{
				{
				setState(949);
				switch (_input.LA(1)) {
				case OPENING_CURLY:
					{
					setState(937); match(OPENING_CURLY);
					setState(938); assign_expr_w__l2();
					setState(939); match(CLOSING_CURLY);
					}
					break;
				case 32:
					{
					setState(941); match(32);
					setState(942); assign_expr_w__l2();
					setState(943); match(14);
					}
					break;
				case 2:
					{
					setState(945); match(2);
					setState(946); assign_expr_w__l2();
					setState(947); match(26);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(954);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << IF) | (1L << ELSE) | (1L << FOR))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (WHILE - 64)) | (1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(951); assign_water_l2();
					}
					}
					setState(956);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(961);
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
		public TerminalNode OPENING_CURLY() { return getToken(CodeSensorParser.OPENING_CURLY, 0); }
		public Class_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterClass_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitClass_def(this);
		}
	}

	public final Class_defContext class_def() throws RecognitionException {
		Class_defContext _localctx = new Class_defContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(962); class_key();
			setState(964);
			_la = _input.LA(1);
			if (_la==ALPHA_NUMERIC) {
				{
				setState(963); class_name();
				}
			}

			setState(967);
			_la = _input.LA(1);
			if (_la==33) {
				{
				setState(966); base_classes();
				}
			}

			setState(969); match(OPENING_CURLY);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterClass_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitClass_name(this);
		}
	}

	public final Class_nameContext class_name() throws RecognitionException {
		Class_nameContext _localctx = new Class_nameContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_class_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(972); identifier();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterBase_classes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitBase_classes(this);
		}
	}

	public final Base_classesContext base_classes() throws RecognitionException {
		Base_classesContext _localctx = new Base_classesContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_base_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(974); match(33);
			setState(975); base_class();
			setState(980);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==30) {
				{
				{
				setState(976); match(30);
				setState(977); base_class();
				}
				}
				setState(982);
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
		public TerminalNode VIRTUAL() { return getToken(CodeSensorParser.VIRTUAL, 0); }
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterBase_class(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitBase_class(this);
		}
	}

	public final Base_classContext base_class() throws RecognitionException {
		Base_classContext _localctx = new Base_classContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_base_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(984);
			_la = _input.LA(1);
			if (_la==VIRTUAL) {
				{
				setState(983); match(VIRTUAL);
				}
			}

			setState(987);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 29) | (1L << 35) | (1L << 50))) != 0)) {
				{
				setState(986); access_specifier();
				}
			}

			setState(989); identifier();
			}
		}
		catch (RecognitionException re) {
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
		public List<TerminalNode> CV_QUALIFIER() { return getTokens(CodeSensorParser.CV_QUALIFIER); }
		public Template_param_listContext template_param_list(int i) {
			return getRuleContext(Template_param_listContext.class,i);
		}
		public TerminalNode SIGNED() { return getToken(CodeSensorParser.SIGNED, 0); }
		public TerminalNode UNSIGNED() { return getToken(CodeSensorParser.UNSIGNED, 0); }
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
			return getToken(CodeSensorParser.CV_QUALIFIER, i);
		}
		public Type_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterType_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitType_name(this);
		}
	}

	public final Type_nameContext type_name() throws RecognitionException {
		Type_nameContext _localctx = new Type_nameContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_type_name);
		int _la;
		try {
			setState(1023);
			switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(994);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CV_QUALIFIER) {
					{
					{
					setState(991); match(CV_QUALIFIER);
					}
					}
					setState(996);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1000);
				switch (_input.LA(1)) {
				case 13:
				case 21:
				case 24:
				case 43:
					{
					setState(997); class_key();
					}
					break;
				case UNSIGNED:
					{
					setState(998); match(UNSIGNED);
					}
					break;
				case SIGNED:
					{
					setState(999); match(SIGNED);
					}
					break;
				case VOID:
				case LONG:
				case ALPHA_NUMERIC:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1002); base_type();
				setState(1007);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(1003); match(4);
					setState(1004); template_param_list();
					setState(1005); match(54);
					}
				}

				setState(1019);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==17) {
					{
					{
					setState(1009); match(17);
					setState(1010); base_type();
					setState(1015);
					_la = _input.LA(1);
					if (_la==4) {
						{
						setState(1011); match(4);
						setState(1012); template_param_list();
						setState(1013); match(54);
						}
					}

					}
					}
					setState(1021);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1022);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterType_suffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitType_suffix(this);
		}
	}

	public final Type_suffixContext type_suffix() throws RecognitionException {
		Type_suffixContext _localctx = new Type_suffixContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_type_suffix);
		try {
			setState(1030);
			switch (_input.LA(1)) {
			case 2:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1025); match(2);
				setState(1026); constant_expr_w_();
				setState(1027); match(26);
				}
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 2);
				{
				setState(1029); param_type_list();
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
		public TerminalNode VOID() { return getToken(CodeSensorParser.VOID, 0); }
		public TerminalNode ALPHA_NUMERIC() { return getToken(CodeSensorParser.ALPHA_NUMERIC, 0); }
		public TerminalNode LONG(int i) {
			return getToken(CodeSensorParser.LONG, i);
		}
		public List<TerminalNode> LONG() { return getTokens(CodeSensorParser.LONG); }
		public Base_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterBase_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitBase_type(this);
		}
	}

	public final Base_typeContext base_type() throws RecognitionException {
		Base_typeContext _localctx = new Base_typeContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_base_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1037);
			switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
			case 1:
				{
				setState(1032); match(ALPHA_NUMERIC);
				}
				break;

			case 2:
				{
				setState(1033); match(VOID);
				}
				break;

			case 3:
				{
				setState(1034); match(LONG);
				}
				break;

			case 4:
				{
				setState(1035); match(LONG);
				setState(1036); match(LONG);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterConstant_expr_w_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitConstant_expr_w_(this);
		}
	}

	public final Constant_expr_w_Context constant_expr_w_() throws RecognitionException {
		Constant_expr_w_Context _localctx = new Constant_expr_w_Context(_ctx, getState());
		enterRule(_localctx, 228, RULE_constant_expr_w_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1042);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << IF) | (1L << ELSE) | (1L << FOR))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (WHILE - 64)) | (1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(1039); no_squares();
				}
				}
				setState(1044);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1056);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2) {
				{
				{
				setState(1045); match(2);
				setState(1046); constant_expr_w_();
				setState(1047); match(26);
				setState(1051);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << IF) | (1L << ELSE) | (1L << FOR))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (WHILE - 64)) | (1L << (BREAK - 64)) | (1L << (CASE - 64)) | (1L << (CONTINUE - 64)) | (1L << (SWITCH - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (TYPEDEF - 64)) | (1L << (VOID - 64)) | (1L << (UNSIGNED - 64)) | (1L << (SIGNED - 64)) | (1L << (LONG - 64)) | (1L << (CV_QUALIFIER - 64)) | (1L << (VIRTUAL - 64)) | (1L << (TRY - 64)) | (1L << (CATCH - 64)) | (1L << (THROW - 64)) | (1L << (USING - 64)) | (1L << (NAMESPACE - 64)) | (1L << (AUTO - 64)) | (1L << (REGISTER - 64)) | (1L << (OPERATOR - 64)) | (1L << (TEMPLATE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (OPENING_CURLY - 64)) | (1L << (CLOSING_CURLY - 64)) | (1L << (PRE_IF - 64)) | (1L << (PRE_ELSE - 64)) | (1L << (PRE_ENDIF - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (CHAR - 64)) | (1L << (STRING - 64)) | (1L << (COMMENT - 64)) | (1L << (WHITESPACE - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(1048); no_squares();
					}
					}
					setState(1053);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(1058);
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
		public TerminalNode REGISTER() { return getToken(CodeSensorParser.REGISTER, 0); }
		public TerminalNode AUTO() { return getToken(CodeSensorParser.AUTO, 0); }
		public Param_decl_specifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl_specifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterParam_decl_specifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitParam_decl_specifiers(this);
		}
	}

	public final Param_decl_specifiersContext param_decl_specifiers() throws RecognitionException {
		Param_decl_specifiersContext _localctx = new Param_decl_specifiersContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_param_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1060);
			_la = _input.LA(1);
			if (_la==AUTO || _la==REGISTER) {
				{
				setState(1059);
				_la = _input.LA(1);
				if ( !(_la==AUTO || _la==REGISTER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(1062); type_name();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterParameter_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitParameter_name(this);
		}
	}

	public final Parameter_nameContext parameter_name() throws RecognitionException {
		Parameter_nameContext _localctx = new Parameter_nameContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_parameter_name);
		try {
			setState(1066);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(1064); identifier();
				}
				break;
			case 29:
			case 35:
			case 50:
				enterOuterAlt(_localctx, 2);
				{
				setState(1065); access_specifier();
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
		public TerminalNode VOID() { return getToken(CodeSensorParser.VOID, 0); }
		public Param_type_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_type_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterParam_type_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitParam_type_list(this);
		}
	}

	public final Param_type_listContext param_type_list() throws RecognitionException {
		Param_type_listContext _localctx = new Param_type_listContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_param_type_list);
		int _la;
		try {
			setState(1083);
			switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1068); match(32);
				setState(1069); match(VOID);
				setState(1070); match(14);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1071); match(32);
				setState(1080);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 21) | (1L << 24) | (1L << 43))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (VOID - 72)) | (1L << (UNSIGNED - 72)) | (1L << (SIGNED - 72)) | (1L << (LONG - 72)) | (1L << (CV_QUALIFIER - 72)) | (1L << (AUTO - 72)) | (1L << (REGISTER - 72)) | (1L << (ALPHA_NUMERIC - 72)))) != 0)) {
					{
					setState(1072); param_type();
					setState(1077);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==30) {
						{
						{
						setState(1073); match(30);
						setState(1074); param_type();
						}
						}
						setState(1079);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1082); match(14);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterParam_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitParam_type(this);
		}
	}

	public final Param_typeContext param_type() throws RecognitionException {
		Param_typeContext _localctx = new Param_typeContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_param_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1085); param_decl_specifiers();
			setState(1086); param_type_id();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterParam_type_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitParam_type_id(this);
		}
	}

	public final Param_type_idContext param_type_id() throws RecognitionException {
		Param_type_idContext _localctx = new Param_type_idContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_param_type_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1089);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(1088); ptrs();
				}
			}

			setState(1098);
			switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
			case 1:
				{
				setState(1091); match(32);
				setState(1092); param_type_id();
				setState(1093); match(14);
				}
				break;

			case 2:
				{
				setState(1096);
				_la = _input.LA(1);
				if (((((_la - 29)) & ~0x3f) == 0 && ((1L << (_la - 29)) & ((1L << (29 - 29)) | (1L << (35 - 29)) | (1L << (50 - 29)) | (1L << (ALPHA_NUMERIC - 29)))) != 0)) {
					{
					setState(1095); parameter_name();
					}
				}

				}
				break;
			}
			setState(1101);
			_la = _input.LA(1);
			if (_la==2 || _la==32) {
				{
				setState(1100); type_suffix();
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
			return getToken(CodeSensorParser.ALPHA_NUMERIC, i);
		}
		public List<TerminalNode> ALPHA_NUMERIC() { return getTokens(CodeSensorParser.ALPHA_NUMERIC); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1103); match(ALPHA_NUMERIC);
			setState(1108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==17) {
				{
				{
				setState(1104); match(17);
				setState(1105); match(ALPHA_NUMERIC);
				}
				}
				setState(1110);
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
		public TerminalNode OCTAL_LITERAL() { return getToken(CodeSensorParser.OCTAL_LITERAL, 0); }
		public TerminalNode HEX_LITERAL() { return getToken(CodeSensorParser.HEX_LITERAL, 0); }
		public TerminalNode DECIMAL_LITERAL() { return getToken(CodeSensorParser.DECIMAL_LITERAL, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1111);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterPtrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitPtrs(this);
		}
	}

	public final PtrsContext ptrs() throws RecognitionException {
		PtrsContext _localctx = new PtrsContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_ptrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1114); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1113); ptr_operator();
				}
				}
				setState(1116); 
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
		"\2\3h\u0461\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
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
		"\4i\ti\4j\tj\4k\tk\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t"+
		"\tt\4u\tu\4v\tv\4w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\3\2\7\2\u00fa\n\2"+
		"\f\2\16\2\u00fd\13\2\3\3\3\3\5\3\u0101\n\3\3\4\3\4\3\4\5\4\u0106\n\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\5\16\u0121\n\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u014b\n\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\7\22\u015f\n\22\f\22\16\22\u0162\13\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u0180\n\36\f\36\16"+
		"\36\u0183\13\36\3\37\3\37\3\37\3\37\3\37\5\37\u018a\n\37\3 \3 \3!\3!\3"+
		"\"\3\"\3#\3#\3$\3$\3%\3%\5%\u0198\n%\3&\3&\3&\3&\5&\u019e\n&\3\'\3\'\3"+
		"\'\5\'\u01a3\n\'\3(\3(\3(\5(\u01a8\n(\3)\3)\3)\3)\3)\3*\3*\3+\3+\3+\3"+
		"+\3+\3,\3,\3,\5,\u01b9\n,\3-\3-\3-\3-\3-\3-\5-\u01c1\n-\3-\3-\3.\3.\3"+
		".\3.\3.\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\5\61\u01d5"+
		"\n\61\3\61\5\61\u01d8\n\61\3\62\3\62\3\62\5\62\u01dd\n\62\3\62\3\62\3"+
		"\63\3\63\3\64\3\64\5\64\u01e5\n\64\3\65\3\65\3\65\3\66\3\66\3\67\3\67"+
		"\3\67\3\67\3\67\38\38\38\39\59\u01f5\n9\39\39\3:\7:\u01fa\n:\f:\16:\u01fd"+
		"\13:\3:\3:\3:\5:\u0202\n:\3:\3:\3:\3:\3:\5:\u0209\n:\3:\3:\3:\3:\3:\3"+
		":\5:\u0211\n:\7:\u0213\n:\f:\16:\u0216\13:\3:\5:\u0219\n:\3;\5;\u021c"+
		"\n;\3;\3;\5;\u0220\n;\3;\5;\u0223\n;\3;\3;\3<\3<\3<\3=\3=\3>\3>\3?\3?"+
		"\3?\5?\u0231\n?\3@\3@\3@\3@\5@\u0237\n@\3A\3A\3A\3A\3A\3A\5A\u023f\nA"+
		"\3B\3B\3B\5B\u0244\nB\3C\3C\3C\5C\u0249\nC\3D\3D\3D\5D\u024e\nD\3E\3E"+
		"\3E\5E\u0253\nE\3F\3F\3F\5F\u0258\nF\3G\3G\3G\3G\5G\u025e\nG\3H\3H\3H"+
		"\3H\5H\u0264\nH\3I\3I\3I\5I\u0269\nI\3J\3J\3J\5J\u026e\nJ\3K\3K\3K\5K"+
		"\u0273\nK\3L\3L\3L\7L\u0278\nL\fL\16L\u027b\13L\3L\3L\3L\3L\5L\u0281\n"+
		"L\3M\3M\3M\3M\3M\3M\6M\u0289\nM\rM\16M\u028a\3M\3M\5M\u028f\nM\3N\3N\3"+
		"N\3N\5N\u0295\nN\3O\3O\7O\u0299\nO\fO\16O\u029c\13O\3P\3P\3P\3P\5P\u02a2"+
		"\nP\3Q\3Q\3Q\3Q\3R\3R\3R\3R\7R\u02ac\nR\fR\16R\u02af\13R\5R\u02b1\nR\3"+
		"R\3R\3S\3S\3T\3T\3T\3T\3T\3T\3T\3T\5T\u02bf\nT\3T\3T\5T\u02c3\nT\3U\3"+
		"U\3U\3U\3U\3U\5U\u02cb\nU\3V\7V\u02ce\nV\fV\16V\u02d1\13V\3W\3W\5W\u02d5"+
		"\nW\3X\3X\3Y\5Y\u02da\nY\3Y\5Y\u02dd\nY\3Y\3Y\3Y\5Y\u02e2\nY\3Y\3Y\3Z"+
		"\7Z\u02e7\nZ\fZ\16Z\u02ea\13Z\3Z\3Z\3Z\7Z\u02ef\nZ\fZ\16Z\u02f2\13Z\3"+
		"[\3[\5[\u02f6\n[\3[\3[\7[\u02fa\n[\f[\16[\u02fd\13[\3[\5[\u0300\n[\3\\"+
		"\3\\\3\\\7\\\u0305\n\\\f\\\16\\\u0308\13\\\3\\\3\\\5\\\u030c\n\\\3\\\5"+
		"\\\u030f\n\\\3]\3]\3]\3^\5^\u0315\n^\3^\3^\3^\3^\3^\5^\u031c\n^\3^\5^"+
		"\u031f\n^\3_\3_\3_\3`\3`\3`\3`\7`\u0328\n`\f`\16`\u032b\13`\3a\3a\3a\3"+
		"b\5b\u0331\nb\3b\3b\3c\3c\5c\u0337\nc\3c\3c\3d\3d\3d\3d\3d\3d\5d\u0341"+
		"\nd\3e\3e\3e\3e\3e\3f\7f\u0349\nf\ff\16f\u034c\13f\3f\3f\3f\3f\7f\u0352"+
		"\nf\ff\16f\u0355\13f\7f\u0357\nf\ff\16f\u035a\13f\3g\5g\u035d\ng\3g\5"+
		"g\u0360\ng\3g\3g\3h\3h\3h\3h\3h\5h\u0369\nh\5h\u036b\nh\3i\3i\3i\7i\u0370"+
		"\ni\fi\16i\u0373\13i\3i\3i\3j\5j\u0378\nj\3j\3j\5j\u037c\nj\3j\3j\5j\u0380"+
		"\nj\3j\3j\3j\5j\u0385\nj\3k\7k\u0388\nk\fk\16k\u038b\13k\3k\3k\3k\3k\3"+
		"k\3k\3k\3k\3k\3k\3k\3k\5k\u0399\nk\3k\7k\u039c\nk\fk\16k\u039f\13k\7k"+
		"\u03a1\nk\fk\16k\u03a4\13k\3l\7l\u03a7\nl\fl\16l\u03aa\13l\3l\3l\3l\3"+
		"l\3l\3l\3l\3l\3l\3l\3l\3l\5l\u03b8\nl\3l\7l\u03bb\nl\fl\16l\u03be\13l"+
		"\7l\u03c0\nl\fl\16l\u03c3\13l\3m\3m\5m\u03c7\nm\3m\5m\u03ca\nm\3m\3m\3"+
		"m\3n\3n\3o\3o\3o\3o\7o\u03d5\no\fo\16o\u03d8\13o\3p\5p\u03db\np\3p\5p"+
		"\u03de\np\3p\3p\3q\7q\u03e3\nq\fq\16q\u03e6\13q\3q\3q\3q\5q\u03eb\nq\3"+
		"q\3q\3q\3q\3q\5q\u03f2\nq\3q\3q\3q\3q\3q\3q\5q\u03fa\nq\7q\u03fc\nq\f"+
		"q\16q\u03ff\13q\3q\5q\u0402\nq\3r\3r\3r\3r\3r\5r\u0409\nr\3s\3s\3s\3s"+
		"\3s\5s\u0410\ns\3t\7t\u0413\nt\ft\16t\u0416\13t\3t\3t\3t\3t\7t\u041c\n"+
		"t\ft\16t\u041f\13t\7t\u0421\nt\ft\16t\u0424\13t\3u\5u\u0427\nu\3u\3u\3"+
		"v\3v\5v\u042d\nv\3w\3w\3w\3w\3w\3w\3w\7w\u0436\nw\fw\16w\u0439\13w\5w"+
		"\u043b\nw\3w\5w\u043e\nw\3x\3x\3x\3y\5y\u0444\ny\3y\3y\3y\3y\3y\5y\u044b"+
		"\ny\5y\u044d\ny\3y\5y\u0450\ny\3z\3z\3z\7z\u0455\nz\fz\16z\u0458\13z\3"+
		"{\3{\3|\6|\u045d\n|\r|\16|\u045e\3|\2}\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080"+
		"\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098"+
		"\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0"+
		"\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8"+
		"\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0"+
		"\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\2 "+
		"\b\3\3\5\5\31\31!!\63\63==\6\6\6\t\t88>>\3_d\5\21\22+,OO\6\17\17\27\27"+
		"\32\32--\4\3\3\5\5\5\37\37%%\64\64\4\26\26\61\61\n\16\16\24\25\33\33\35"+
		"\35$$\'\')*9:\4\b\b;;\4\20\20\"\"\7\4\4\20\20\34\34\"\"Z[\5\20\20\"\""+
		"\65\65\6\6\6\20\20\"\"88\3Z[\4\4\4\34\34\5\4\4\34\34\65\65\4  \65\65\t"+
		"\4\4\20\20\34\34  \"\"\65\65Z[\7\4\4\20\20\34\34\"\"Z[\3hh\4CCEE\3UV\3"+
		"KL\4\n\n//\4!!\63\63\5\5\5\f\f<<\3KL\3UV\3_a\u04a0\2\u00fb\3\2\2\2\4\u0100"+
		"\3\2\2\2\6\u0105\3\2\2\2\b\u0107\3\2\2\2\n\u010c\3\2\2\2\f\u010e\3\2\2"+
		"\2\16\u0110\3\2\2\2\20\u0112\3\2\2\2\22\u0114\3\2\2\2\24\u0116\3\2\2\2"+
		"\26\u0118\3\2\2\2\30\u011a\3\2\2\2\32\u014a\3\2\2\2\34\u014c\3\2\2\2\36"+
		"\u014e\3\2\2\2 \u0150\3\2\2\2\"\u0160\3\2\2\2$\u0163\3\2\2\2&\u0165\3"+
		"\2\2\2(\u0167\3\2\2\2*\u0169\3\2\2\2,\u016b\3\2\2\2.\u016d\3\2\2\2\60"+
		"\u016f\3\2\2\2\62\u0171\3\2\2\2\64\u0173\3\2\2\2\66\u0175\3\2\2\28\u0177"+
		"\3\2\2\2:\u0181\3\2\2\2<\u0189\3\2\2\2>\u018b\3\2\2\2@\u018d\3\2\2\2B"+
		"\u018f\3\2\2\2D\u0191\3\2\2\2F\u0193\3\2\2\2H\u0197\3\2\2\2J\u019d\3\2"+
		"\2\2L\u01a2\3\2\2\2N\u01a7\3\2\2\2P\u01a9\3\2\2\2R\u01ae\3\2\2\2T\u01b0"+
		"\3\2\2\2V\u01b8\3\2\2\2X\u01ba\3\2\2\2Z\u01c4\3\2\2\2\\\u01c9\3\2\2\2"+
		"^\u01cb\3\2\2\2`\u01d7\3\2\2\2b\u01dc\3\2\2\2d\u01e0\3\2\2\2f\u01e2\3"+
		"\2\2\2h\u01e6\3\2\2\2j\u01e9\3\2\2\2l\u01eb\3\2\2\2n\u01f0\3\2\2\2p\u01f4"+
		"\3\2\2\2r\u0218\3\2\2\2t\u0222\3\2\2\2v\u0226\3\2\2\2x\u0229\3\2\2\2z"+
		"\u022b\3\2\2\2|\u022d\3\2\2\2~\u0232\3\2\2\2\u0080\u0238\3\2\2\2\u0082"+
		"\u0240\3\2\2\2\u0084\u0245\3\2\2\2\u0086\u024a\3\2\2\2\u0088\u024f\3\2"+
		"\2\2\u008a\u0254\3\2\2\2\u008c\u0259\3\2\2\2\u008e\u025f\3\2\2\2\u0090"+
		"\u0265\3\2\2\2\u0092\u026a\3\2\2\2\u0094\u026f\3\2\2\2\u0096\u0280\3\2"+
		"\2\2\u0098\u028e\3\2\2\2\u009a\u0294\3\2\2\2\u009c\u0296\3\2\2\2\u009e"+
		"\u02a1\3\2\2\2\u00a0\u02a3\3\2\2\2\u00a2\u02a7\3\2\2\2\u00a4\u02b4\3\2"+
		"\2\2\u00a6\u02c2\3\2\2\2\u00a8\u02ca\3\2\2\2\u00aa\u02cf\3\2\2\2\u00ac"+
		"\u02d4\3\2\2\2\u00ae\u02d6\3\2\2\2\u00b0\u02d9\3\2\2\2\u00b2\u02e8\3\2"+
		"\2\2\u00b4\u02f3\3\2\2\2\u00b6\u030e\3\2\2\2\u00b8\u0310\3\2\2\2\u00ba"+
		"\u0314\3\2\2\2\u00bc\u0320\3\2\2\2\u00be\u0323\3\2\2\2\u00c0\u032c\3\2"+
		"\2\2\u00c2\u0330\3\2\2\2\u00c4\u0334\3\2\2\2\u00c6\u0340\3\2\2\2\u00c8"+
		"\u0342\3\2\2\2\u00ca\u034a\3\2\2\2\u00cc\u035c\3\2\2\2\u00ce\u036a\3\2"+
		"\2\2\u00d0\u036c\3\2\2\2\u00d2\u0377\3\2\2\2\u00d4\u0389\3\2\2\2\u00d6"+
		"\u03a8\3\2\2\2\u00d8\u03c4\3\2\2\2\u00da\u03ce\3\2\2\2\u00dc\u03d0\3\2"+
		"\2\2\u00de\u03da\3\2\2\2\u00e0\u0401\3\2\2\2\u00e2\u0408\3\2\2\2\u00e4"+
		"\u040f\3\2\2\2\u00e6\u0414\3\2\2\2\u00e8\u0426\3\2\2\2\u00ea\u042c\3\2"+
		"\2\2\u00ec\u043d\3\2\2\2\u00ee\u043f\3\2\2\2\u00f0\u0443\3\2\2\2\u00f2"+
		"\u0451\3\2\2\2\u00f4\u0459\3\2\2\2\u00f6\u045c\3\2\2\2\u00f8\u00fa\5\4"+
		"\3\2\u00f9\u00f8\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb"+
		"\u00fc\3\2\2\2\u00fc\3\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u0101\5\6\4\2"+
		"\u00ff\u0101\58\35\2\u0100\u00fe\3\2\2\2\u0100\u00ff\3\2\2\2\u0101\5\3"+
		"\2\2\2\u0102\u0106\5\u00b0Y\2\u0103\u0106\5\u00ccg\2\u0104\u0106\5\b\5"+
		"\2\u0105\u0102\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0104\3\2\2\2\u0106\7"+
		"\3\2\2\2\u0107\u0108\7S\2\2\u0108\u0109\7T\2\2\u0109\u010a\5\u00f2z\2"+
		"\u010a\u010b\7\65\2\2\u010b\t\3\2\2\2\u010c\u010d\t\2\2\2\u010d\13\3\2"+
		"\2\2\u010e\u010f\t\3\2\2\u010f\r\3\2\2\2\u0110\u0111\t\4\2\2\u0111\17"+
		"\3\2\2\2\u0112\u0113\t\5\2\2\u0113\21\3\2\2\2\u0114\u0115\t\6\2\2\u0115"+
		"\23\3\2\2\2\u0116\u0117\t\7\2\2\u0117\25\3\2\2\2\u0118\u0119\t\b\2\2\u0119"+
		"\27\3\2\2\2\u011a\u011b\7W\2\2\u011b\u011c\5\32\16\2\u011c\31\3\2\2\2"+
		"\u011d\u0120\t\t\2\2\u011e\u011f\7\4\2\2\u011f\u0121\7\34\2\2\u0120\u011e"+
		"\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u014b\3\2\2\2\u0122\u014b\7\63\2\2"+
		"\u0123\u014b\7!\2\2\u0124\u014b\7\5\2\2\u0125\u014b\7<\2\2\u0126\u014b"+
		"\7\f\2\2\u0127\u014b\7\60\2\2\u0128\u014b\7\3\2\2\u0129\u014b\7\30\2\2"+
		"\u012a\u014b\7=\2\2\u012b\u014b\7\31\2\2\u012c\u014b\7\24\2\2\u012d\u014b"+
		"\7\6\2\2\u012e\u014b\78\2\2\u012f\u014b\7)\2\2\u0130\u014b\7\35\2\2\u0131"+
		"\u014b\7\16\2\2\u0132\u014b\7:\2\2\u0133\u014b\79\2\2\u0134\u014b\7*\2"+
		"\2\u0135\u014b\7$\2\2\u0136\u014b\7\25\2\2\u0137\u014b\7/\2\2\u0138\u014b"+
		"\7\n\2\2\u0139\u014b\7\'\2\2\u013a\u014b\7\33\2\2\u013b\u014b\7;\2\2\u013c"+
		"\u014b\7\b\2\2\u013d\u014b\7\t\2\2\u013e\u014b\7>\2\2\u013f\u014b\7\66"+
		"\2\2\u0140\u014b\7\67\2\2\u0141\u014b\7.\2\2\u0142\u014b\7\7\2\2\u0143"+
		"\u014b\7 \2\2\u0144\u014b\7\36\2\2\u0145\u014b\7\r\2\2\u0146\u0147\7\""+
		"\2\2\u0147\u014b\7\20\2\2\u0148\u0149\7\4\2\2\u0149\u014b\7\34\2\2\u014a"+
		"\u011d\3\2\2\2\u014a\u0122\3\2\2\2\u014a\u0123\3\2\2\2\u014a\u0124\3\2"+
		"\2\2\u014a\u0125\3\2\2\2\u014a\u0126\3\2\2\2\u014a\u0127\3\2\2\2\u014a"+
		"\u0128\3\2\2\2\u014a\u0129\3\2\2\2\u014a\u012a\3\2\2\2\u014a\u012b\3\2"+
		"\2\2\u014a\u012c\3\2\2\2\u014a\u012d\3\2\2\2\u014a\u012e\3\2\2\2\u014a"+
		"\u012f\3\2\2\2\u014a\u0130\3\2\2\2\u014a\u0131\3\2\2\2\u014a\u0132\3\2"+
		"\2\2\u014a\u0133\3\2\2\2\u014a\u0134\3\2\2\2\u014a\u0135\3\2\2\2\u014a"+
		"\u0136\3\2\2\2\u014a\u0137\3\2\2\2\u014a\u0138\3\2\2\2\u014a\u0139\3\2"+
		"\2\2\u014a\u013a\3\2\2\2\u014a\u013b\3\2\2\2\u014a\u013c\3\2\2\2\u014a"+
		"\u013d\3\2\2\2\u014a\u013e\3\2\2\2\u014a\u013f\3\2\2\2\u014a\u0140\3\2"+
		"\2\2\u014a\u0141\3\2\2\2\u014a\u0142\3\2\2\2\u014a\u0143\3\2\2\2\u014a"+
		"\u0144\3\2\2\2\u014a\u0145\3\2\2\2\u014a\u0146\3\2\2\2\u014a\u0148\3\2"+
		"\2\2\u014b\33\3\2\2\2\u014c\u014d\t\n\2\2\u014d\35\3\2\2\2\u014e\u014f"+
		"\t\13\2\2\u014f\37\3\2\2\2\u0150\u0151\7X\2\2\u0151\u0152\7\6\2\2\u0152"+
		"\u0153\5\"\22\2\u0153\u0154\78\2\2\u0154!\3\2\2\2\u0155\u0156\7\6\2\2"+
		"\u0156\u0157\5\"\22\2\u0157\u0158\78\2\2\u0158\u015f\3\2\2\2\u0159\u015a"+
		"\7\"\2\2\u015a\u015b\5\"\22\2\u015b\u015c\7\20\2\2\u015c\u015f\3\2\2\2"+
		"\u015d\u015f\5*\26\2\u015e\u0155\3\2\2\2\u015e\u0159\3\2\2\2\u015e\u015d"+
		"\3\2\2\2\u015f\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161"+
		"#\3\2\2\2\u0162\u0160\3\2\2\2\u0163\u0164\n\f\2\2\u0164%\3\2\2\2\u0165"+
		"\u0166\n\r\2\2\u0166\'\3\2\2\2\u0167\u0168\n\16\2\2\u0168)\3\2\2\2\u0169"+
		"\u016a\n\17\2\2\u016a+\3\2\2\2\u016b\u016c\n\20\2\2\u016c-\3\2\2\2\u016d"+
		"\u016e\n\21\2\2\u016e/\3\2\2\2\u016f\u0170\n\22\2\2\u0170\61\3\2\2\2\u0171"+
		"\u0172\n\23\2\2\u0172\63\3\2\2\2\u0173\u0174\n\24\2\2\u0174\65\3\2\2\2"+
		"\u0175\u0176\n\25\2\2\u0176\67\3\2\2\2\u0177\u0178\n\26\2\2\u01789\3\2"+
		"\2\2\u0179\u0180\5> \2\u017a\u0180\5B\"\2\u017b\u017c\5@!\2\u017c\u017d"+
		"\b\36\1\2\u017d\u0180\3\2\2\2\u017e\u0180\5<\37\2\u017f\u0179\3\2\2\2"+
		"\u017f\u017a\3\2\2\2\u017f\u017b\3\2\2\2\u017f\u017e\3\2\2\2\u0180\u0183"+
		"\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182;\3\2\2\2\u0183"+
		"\u0181\3\2\2\2\u0184\u018a\5D#\2\u0185\u018a\5F$\2\u0186\u018a\5H%\2\u0187"+
		"\u018a\5v<\2\u0188\u018a\5x=\2\u0189\u0184\3\2\2\2\u0189\u0185\3\2\2\2"+
		"\u0189\u0186\3\2\2\2\u0189\u0187\3\2\2\2\u0189\u0188\3\2\2\2\u018a=\3"+
		"\2\2\2\u018b\u018c\7\\\2\2\u018c?\3\2\2\2\u018d\u018e\7]\2\2\u018eA\3"+
		"\2\2\2\u018f\u0190\7^\2\2\u0190C\3\2\2\2\u0191\u0192\7Z\2\2\u0192E\3\2"+
		"\2\2\u0193\u0194\7[\2\2\u0194G\3\2\2\2\u0195\u0198\5J&\2\u0196\u0198\5"+
		"L\'\2\u0197\u0195\3\2\2\2\u0197\u0196\3\2\2\2\u0198I\3\2\2\2\u0199\u019e"+
		"\5N(\2\u019a\u019e\5V,\2\u019b\u019e\5j\66\2\u019c\u019e\5l\67\2\u019d"+
		"\u0199\3\2\2\2\u019d\u019a\3\2\2\2\u019d\u019b\3\2\2\2\u019d\u019c\3\2"+
		"\2\2\u019eK\3\2\2\2\u019f\u01a3\5b\62\2\u01a0\u01a3\5\u00ccg\2\u01a1\u01a3"+
		"\5t;\2\u01a2\u019f\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2\u01a1\3\2\2\2\u01a3"+
		"M\3\2\2\2\u01a4\u01a8\5P)\2\u01a5\u01a8\5R*\2\u01a6\u01a8\5T+\2\u01a7"+
		"\u01a4\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a7\u01a6\3\2\2\2\u01a8O\3\2\2\2"+
		"\u01a9\u01aa\7?\2\2\u01aa\u01ab\7\"\2\2\u01ab\u01ac\5z>\2\u01ac\u01ad"+
		"\7\20\2\2\u01adQ\3\2\2\2\u01ae\u01af\7@\2\2\u01afS\3\2\2\2\u01b0\u01b1"+
		"\7F\2\2\u01b1\u01b2\7\"\2\2\u01b2\u01b3\5z>\2\u01b3\u01b4\7\20\2\2\u01b4"+
		"U\3\2\2\2\u01b5\u01b9\5X-\2\u01b6\u01b9\5\\/\2\u01b7\u01b9\5Z.\2\u01b8"+
		"\u01b5\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b8\u01b7\3\2\2\2\u01b9W\3\2\2\2"+
		"\u01ba\u01bb\7A\2\2\u01bb\u01bc\7\"\2\2\u01bc\u01bd\5`\61\2\u01bd\u01be"+
		"\5z>\2\u01be\u01c0\7\65\2\2\u01bf\u01c1\5|?\2\u01c0\u01bf\3\2\2\2\u01c0"+
		"\u01c1\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c3\7\20\2\2\u01c3Y\3\2\2\2"+
		"\u01c4\u01c5\7B\2\2\u01c5\u01c6\7\"\2\2\u01c6\u01c7\5z>\2\u01c7\u01c8"+
		"\7\20\2\2\u01c8[\3\2\2\2\u01c9\u01ca\7\13\2\2\u01ca]\3\2\2\2\u01cb\u01cc"+
		"\7\13\2\2\u01cc\u01cd\5<\37\2\u01cd\u01ce\7B\2\2\u01ce\u01cf\7\"\2\2\u01cf"+
		"\u01d0\5|?\2\u01d0\u01d1\7\20\2\2\u01d1_\3\2\2\2\u01d2\u01d8\5\u00ccg"+
		"\2\u01d3\u01d5\5|?\2\u01d4\u01d3\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d6"+
		"\3\2\2\2\u01d6\u01d8\7\65\2\2\u01d7\u01d2\3\2\2\2\u01d7\u01d4\3\2\2\2"+
		"\u01d8a\3\2\2\2\u01d9\u01dd\5d\63\2\u01da\u01dd\5f\64\2\u01db\u01dd\5"+
		"h\65\2\u01dc\u01d9\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc\u01db\3\2\2\2\u01dd"+
		"\u01de\3\2\2\2\u01de\u01df\7\65\2\2\u01dfc\3\2\2\2\u01e0\u01e1\t\27\2"+
		"\2\u01e1e\3\2\2\2\u01e2\u01e4\7H\2\2\u01e3\u01e5\5|?\2\u01e4\u01e3\3\2"+
		"\2\2\u01e4\u01e5\3\2\2\2\u01e5g\3\2\2\2\u01e6\u01e7\7G\2\2\u01e7\u01e8"+
		"\5\u00f2z\2\u01e8i\3\2\2\2\u01e9\u01ea\7P\2\2\u01eak\3\2\2\2\u01eb\u01ec"+
		"\7Q\2\2\u01ec\u01ed\7\"\2\2\u01ed\u01ee\5n8\2\u01ee\u01ef\7\20\2\2\u01ef"+
		"m\3\2\2\2\u01f0\u01f1\5p9\2\u01f1\u01f2\5\u00f0y\2\u01f2o\3\2\2\2\u01f3"+
		"\u01f5\t\30\2\2\u01f4\u01f3\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f6\3"+
		"\2\2\2\u01f6\u01f7\5r:\2\u01f7q\3\2\2\2\u01f8\u01fa\7N\2\2\u01f9\u01f8"+
		"\3\2\2\2\u01fa\u01fd\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc"+
		"\u0201\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fe\u0202\5\22\n\2\u01ff\u0202\7"+
		"K\2\2\u0200\u0202\7L\2\2\u0201\u01fe\3\2\2\2\u0201\u01ff\3\2\2\2\u0201"+
		"\u0200\3\2\2\2\u0201\u0202\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0208\5\u00e4"+
		"s\2\u0204\u0205\7\6\2\2\u0205\u0206\5\"\22\2\u0206\u0207\78\2\2\u0207"+
		"\u0209\3\2\2\2\u0208\u0204\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u0214\3\2"+
		"\2\2\u020a\u020b\7\23\2\2\u020b\u0210\5\u00e4s\2\u020c\u020d\7\6\2\2\u020d"+
		"\u020e\5\"\22\2\u020e\u020f\78\2\2\u020f\u0211\3\2\2\2\u0210\u020c\3\2"+
		"\2\2\u0210\u0211\3\2\2\2\u0211\u0213\3\2\2\2\u0212\u020a\3\2\2\2\u0213"+
		"\u0216\3\2\2\2\u0214\u0212\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0219\3\2"+
		"\2\2\u0216\u0214\3\2\2\2\u0217\u0219\t\31\2\2\u0218\u01fb\3\2\2\2\u0218"+
		"\u0217\3\2\2\2\u0219s\3\2\2\2\u021a\u021c\7D\2\2\u021b\u021a\3\2\2\2\u021b"+
		"\u021c\3\2\2\2\u021c\u021f\3\2\2\2\u021d\u0220\5\u00f2z\2\u021e\u0220"+
		"\5\u00f4{\2\u021f\u021d\3\2\2\2\u021f\u021e\3\2\2\2\u0220\u0223\3\2\2"+
		"\2\u0221\u0223\5\26\f\2\u0222\u021b\3\2\2\2\u0222\u0221\3\2\2\2\u0223"+
		"\u0224\3\2\2\2\u0224\u0225\7#\2\2\u0225u\3\2\2\2\u0226\u0227\5|?\2\u0227"+
		"\u0228\7\65\2\2\u0228w\3\2\2\2\u0229\u022a\13\2\2\2\u022ay\3\2\2\2\u022b"+
		"\u022c\5|?\2\u022c{\3\2\2\2\u022d\u0230\5~@\2\u022e\u022f\7 \2\2\u022f"+
		"\u0231\5~@\2\u0230\u022e\3\2\2\2\u0230\u0231\3\2\2\2\u0231}\3\2\2\2\u0232"+
		"\u0236\5\u0080A\2\u0233\u0234\5\34\17\2\u0234\u0235\5~@\2\u0235\u0237"+
		"\3\2\2\2\u0236\u0233\3\2\2\2\u0236\u0237\3\2\2\2\u0237\177\3\2\2\2\u0238"+
		"\u023e\5\u0082B\2\u0239\u023a\7&\2\2\u023a\u023b\5|?\2\u023b\u023c\7#"+
		"\2\2\u023c\u023d\5\u0080A\2\u023d\u023f\3\2\2\2\u023e\u0239\3\2\2\2\u023e"+
		"\u023f\3\2\2\2\u023f\u0081\3\2\2\2\u0240\u0243\5\u0084C\2\u0241\u0242"+
		"\7\67\2\2\u0242\u0244\5\u0082B\2\u0243\u0241\3\2\2\2\u0243\u0244\3\2\2"+
		"\2\u0244\u0083\3\2\2\2\u0245\u0248\5\u0086D\2\u0246\u0247\7\66\2\2\u0247"+
		"\u0249\5\u0084C\2\u0248\u0246\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u0085"+
		"\3\2\2\2\u024a\u024d\5\u0088E\2\u024b\u024c\7\30\2\2\u024c\u024e\5\u0086"+
		"D\2\u024d\u024b\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u0087\3\2\2\2\u024f"+
		"\u0252\5\u008aF\2\u0250\u0251\7\60\2\2\u0251\u0253\5\u0088E\2\u0252\u0250"+
		"\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0089\3\2\2\2\u0254\u0257\5\u008cG"+
		"\2\u0255\u0256\7\3\2\2\u0256\u0258\5\u008aF\2\u0257\u0255\3\2\2\2\u0257"+
		"\u0258\3\2\2\2\u0258\u008b\3\2\2\2\u0259\u025d\5\u008eH\2\u025a\u025b"+
		"\5\36\20\2\u025b\u025c\5\u008cG\2\u025c\u025e\3\2\2\2\u025d\u025a\3\2"+
		"\2\2\u025d\u025e\3\2\2\2\u025e\u008d\3\2\2\2\u025f\u0263\5\u0090I\2\u0260"+
		"\u0261\5\f\7\2\u0261\u0262\5\u008eH\2\u0262\u0264\3\2\2\2\u0263\u0260"+
		"\3\2\2\2\u0263\u0264\3\2\2\2\u0264\u008f\3\2\2\2\u0265\u0268\5\u0092J"+
		"\2\u0266\u0267\t\32\2\2\u0267\u0269\5\u0090I\2\u0268\u0266\3\2\2\2\u0268"+
		"\u0269\3\2\2\2\u0269\u0091\3\2\2\2\u026a\u026d\5\u0094K\2\u026b\u026c"+
		"\t\33\2\2\u026c\u026e\5\u0092J\2\u026d\u026b\3\2\2\2\u026d\u026e\3\2\2"+
		"\2\u026e\u0093\3\2\2\2\u026f\u0272\5\u0096L\2\u0270\u0271\t\34\2\2\u0271"+
		"\u0273\5\u0096L\2\u0272\u0270\3\2\2\2\u0272\u0273\3\2\2\2\u0273\u0095"+
		"\3\2\2\2\u0274\u0275\7\"\2\2\u0275\u0279\5\u00e0q\2\u0276\u0278\5\24\13"+
		"\2\u0277\u0276\3\2\2\2\u0278\u027b\3\2\2\2\u0279\u0277\3\2\2\2\u0279\u027a"+
		"\3\2\2\2\u027a\u027c\3\2\2\2\u027b\u0279\3\2\2\2\u027c\u027d\7\20\2\2"+
		"\u027d\u027e\5\u0096L\2\u027e\u0281\3\2\2\2\u027f\u0281\5\u0098M\2\u0280"+
		"\u0274\3\2\2\2\u0280\u027f\3\2\2\2\u0281\u0097\3\2\2\2\u0282\u028f\5\u009a"+
		"N\2\u0283\u0284\7\7\2\2\u0284\u028f\5\u0098M\2\u0285\u0286\7.\2\2\u0286"+
		"\u028f\5\u0098M\2\u0287\u0289\5\n\6\2\u0288\u0287\3\2\2\2\u0289\u028a"+
		"\3\2\2\2\u028a\u0288\3\2\2\2\u028a\u028b\3\2\2\2\u028b\u028c\3\2\2\2\u028c"+
		"\u028d\5\u009aN\2\u028d\u028f\3\2\2\2\u028e\u0282\3\2\2\2\u028e\u0283"+
		"\3\2\2\2\u028e\u0285\3\2\2\2\u028e\u0288\3\2\2\2\u028f\u0099\3\2\2\2\u0290"+
		"\u0295\5\u009cO\2\u0291\u0292\5\u009cO\2\u0292\u0293\5\u009eP\2\u0293"+
		"\u0295\3\2\2\2\u0294\u0290\3\2\2\2\u0294\u0291\3\2\2\2\u0295\u009b\3\2"+
		"\2\2\u0296\u029a\5\u00a8U\2\u0297\u0299\5\u00a6T\2\u0298\u0297\3\2\2\2"+
		"\u0299\u029c\3\2\2\2\u029a\u0298\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u009d"+
		"\3\2\2\2\u029c\u029a\3\2\2\2\u029d\u029e\5\u00a0Q\2\u029e\u029f\5\u00a2"+
		"R\2\u029f\u02a2\3\2\2\2\u02a0\u02a2\5\u00a2R\2\u02a1\u029d\3\2\2\2\u02a1"+
		"\u02a0\3\2\2\2\u02a2\u009f\3\2\2\2\u02a3\u02a4\7\6\2\2\u02a4\u02a5\5\""+
		"\22\2\u02a5\u02a6\78\2\2\u02a6\u00a1\3\2\2\2\u02a7\u02b0\7\"\2\2\u02a8"+
		"\u02ad\5\u00a4S\2\u02a9\u02aa\7 \2\2\u02aa\u02ac\5\u00a4S\2\u02ab\u02a9"+
		"\3\2\2\2\u02ac\u02af\3\2\2\2\u02ad\u02ab\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae"+
		"\u02b1\3\2\2\2\u02af\u02ad\3\2\2\2\u02b0\u02a8\3\2\2\2\u02b0\u02b1\3\2"+
		"\2\2\u02b1\u02b2\3\2\2\2\u02b2\u02b3\7\20\2\2\u02b3\u00a3\3\2\2\2\u02b4"+
		"\u02b5\5~@\2\u02b5\u00a5\3\2\2\2\u02b6\u02b7\7\62\2\2\u02b7\u02bf\5\u00f2"+
		"z\2\u02b8\u02b9\7\r\2\2\u02b9\u02bf\5\u00f2z\2\u02ba\u02bb\7\4\2\2\u02bb"+
		"\u02bc\5|?\2\u02bc\u02bd\7\34\2\2\u02bd\u02bf\3\2\2\2\u02be\u02b6\3\2"+
		"\2\2\u02be\u02b8\3\2\2\2\u02be\u02ba\3\2\2\2\u02bf\u02c3\3\2\2\2\u02c0"+
		"\u02c3\7.\2\2\u02c1\u02c3\7\7\2\2\u02c2\u02be\3\2\2\2\u02c2\u02c0\3\2"+
		"\2\2\u02c2\u02c1\3\2\2\2\u02c3\u00a7\3\2\2\2\u02c4\u02c5\7\"\2\2\u02c5"+
		"\u02c6\5|?\2\u02c6\u02c7\7\20\2\2\u02c7\u02cb\3\2\2\2\u02c8\u02cb\5\u00f2"+
		"z\2\u02c9\u02cb\5\16\b\2\u02ca\u02c4\3\2\2\2\u02ca\u02c8\3\2\2\2\u02ca"+
		"\u02c9\3\2\2\2\u02cb\u00a9\3\2\2\2\u02cc\u02ce\5\u00acW\2\u02cd\u02cc"+
		"\3\2\2\2\u02ce\u02d1\3\2\2\2\u02cf\u02cd\3\2\2\2\u02cf\u02d0\3\2\2\2\u02d0"+
		"\u00ab\3\2\2\2\u02d1\u02cf\3\2\2\2\u02d2\u02d5\5\u00ccg\2\u02d3\u02d5"+
		"\5\u009aN\2\u02d4\u02d2\3\2\2\2\u02d4\u02d3\3\2\2\2\u02d5\u00ad\3\2\2"+
		"\2\u02d6\u02d7\13\2\2\2\u02d7\u00af\3\2\2\2\u02d8\u02da\5 \21\2\u02d9"+
		"\u02d8\3\2\2\2\u02d9\u02da\3\2\2\2\u02da\u02dc\3\2\2\2\u02db\u02dd\5\u00b2"+
		"Z\2\u02dc\u02db\3\2\2\2\u02dc\u02dd\3\2\2\2\u02dd\u02de\3\2\2\2\u02de"+
		"\u02df\5\u00c6d\2\u02df\u02e1\5\u00b4[\2\u02e0\u02e2\5\u00be`\2\u02e1"+
		"\u02e0\3\2\2\2\u02e1\u02e2\3\2\2\2\u02e2\u02e3\3\2\2\2\u02e3\u02e4\5\u00bc"+
		"_\2\u02e4\u00b1\3\2\2\2\u02e5\u02e7\5\20\t\2\u02e6\u02e5\3\2\2\2\u02e7"+
		"\u02ea\3\2\2\2\u02e8\u02e6\3\2\2\2\u02e8\u02e9\3\2\2\2\u02e9\u02eb\3\2"+
		"\2\2\u02ea\u02e8\3\2\2\2\u02eb\u02ec\5\u00e0q\2\u02ec\u02f0\3\2\2\2\u02ed"+
		"\u02ef\5\24\13\2\u02ee\u02ed\3\2\2\2\u02ef\u02f2\3\2\2\2\u02f0\u02ee\3"+
		"\2\2\2\u02f0\u02f1\3\2\2\2\u02f1\u00b3\3\2\2\2\u02f2\u02f0\3\2\2\2\u02f3"+
		"\u02f5\7\"\2\2\u02f4\u02f6\5\u00b6\\\2\u02f5\u02f4\3\2\2\2\u02f5\u02f6"+
		"\3\2\2\2\u02f6\u02f7\3\2\2\2\u02f7\u02fb\7\20\2\2\u02f8\u02fa\7N\2\2\u02f9"+
		"\u02f8\3\2\2\2\u02fa\u02fd\3\2\2\2\u02fb\u02f9\3\2\2\2\u02fb\u02fc\3\2"+
		"\2\2\u02fc\u02ff\3\2\2\2\u02fd\u02fb\3\2\2\2\u02fe\u0300\5\u00c8e\2\u02ff"+
		"\u02fe\3\2\2\2\u02ff\u0300\3\2\2\2\u0300\u00b5\3\2\2\2\u0301\u0306\5\u00b8"+
		"]\2\u0302\u0303\7 \2\2\u0303\u0305\5\u00b8]\2\u0304\u0302\3\2\2\2\u0305"+
		"\u0308\3\2\2\2\u0306\u0304\3\2\2\2\u0306\u0307\3\2\2\2\u0307\u030b\3\2"+
		"\2\2\u0308\u0306\3\2\2\2\u0309\u030a\7 \2\2\u030a\u030c\7(\2\2\u030b\u0309"+
		"\3\2\2\2\u030b\u030c\3\2\2\2\u030c\u030f\3\2\2\2\u030d\u030f\7J\2\2\u030e"+
		"\u0301\3\2\2\2\u030e\u030d\3\2\2\2\u030f\u00b7\3\2\2\2\u0310\u0311\5\u00e8"+
		"u\2\u0311\u0312\5\u00ba^\2\u0312\u00b9\3\2\2\2\u0313\u0315\5\u00f6|\2"+
		"\u0314\u0313\3\2\2\2\u0314\u0315\3\2\2\2\u0315\u031b\3\2\2\2\u0316\u0317"+
		"\7\"\2\2\u0317\u0318\5\u00ba^\2\u0318\u0319\7\20\2\2\u0319\u031c\3\2\2"+
		"\2\u031a\u031c\5\u00eav\2\u031b\u0316\3\2\2\2\u031b\u031a\3\2\2\2\u031c"+
		"\u031e\3\2\2\2\u031d\u031f\5\u00e2r\2\u031e\u031d\3\2\2\2\u031e\u031f"+
		"\3\2\2\2\u031f\u00bb\3\2\2\2\u0320\u0321\7Z\2\2\u0321\u0322\b_\1\2\u0322"+
		"\u00bd\3\2\2\2\u0323\u0324\7#\2\2\u0324\u0329\5\u00c0a\2\u0325\u0326\7"+
		" \2\2\u0326\u0328\5\u00c0a\2\u0327\u0325\3\2\2\2\u0328\u032b\3\2\2\2\u0329"+
		"\u0327\3\2\2\2\u0329\u032a\3\2\2\2\u032a\u00bf\3\2\2\2\u032b\u0329\3\2"+
		"\2\2\u032c\u032d\5\u00c2b\2\u032d\u032e\5\u00c4c\2\u032e\u00c1\3\2\2\2"+
		"\u032f\u0331\7\23\2\2\u0330\u032f\3\2\2\2\u0330\u0331\3\2\2\2\u0331\u0332"+
		"\3\2\2\2\u0332\u0333\5\u00f2z\2\u0333\u00c3\3\2\2\2\u0334\u0336\7\"\2"+
		"\2\u0335\u0337\5|?\2\u0336\u0335\3\2\2\2\u0336\u0337\3\2\2\2\u0337\u0338"+
		"\3\2\2\2\u0338\u0339\7\20\2\2\u0339\u00c5\3\2\2\2\u033a\u033b\7\"\2\2"+
		"\u033b\u033c\5\u00c6d\2\u033c\u033d\7\20\2\2\u033d\u0341\3\2\2\2\u033e"+
		"\u0341\5\u00f2z\2\u033f\u0341\5\30\r\2\u0340\u033a\3\2\2\2\u0340\u033e"+
		"\3\2\2\2\u0340\u033f\3\2\2\2\u0341\u00c7\3\2\2\2\u0342\u0343\7R\2\2\u0343"+
		"\u0344\7\"\2\2\u0344\u0345\5\u00caf\2\u0345\u0346\7\20\2\2\u0346\u00c9"+
		"\3\2\2\2\u0347\u0349\5$\23\2\u0348\u0347\3\2\2\2\u0349\u034c\3\2\2\2\u034a"+
		"\u0348\3\2\2\2\u034a\u034b\3\2\2\2\u034b\u0358\3\2\2\2\u034c\u034a\3\2"+
		"\2\2\u034d\u034e\7\"\2\2\u034e\u034f\5\u00caf\2\u034f\u0353\7\20\2\2\u0350"+
		"\u0352\5$\23\2\u0351\u0350\3\2\2\2\u0352\u0355\3\2\2\2\u0353\u0351\3\2"+
		"\2\2\u0353\u0354\3\2\2\2\u0354\u0357\3\2\2\2\u0355\u0353\3\2\2\2\u0356"+
		"\u034d\3\2\2\2\u0357\u035a\3\2\2\2\u0358\u0356\3\2\2\2\u0358\u0359\3\2"+
		"\2\2\u0359\u00cb\3\2\2\2\u035a\u0358\3\2\2\2\u035b\u035d\7I\2\2\u035c"+
		"\u035b\3\2\2\2\u035c\u035d\3\2\2\2\u035d\u035f\3\2\2\2\u035e\u0360\5 "+
		"\21\2\u035f\u035e\3\2\2\2\u035f\u0360\3\2\2\2\u0360\u0361\3\2\2\2\u0361"+
		"\u0362\5\u00ceh\2\u0362\u00cd\3\2\2\2\u0363\u0364\5\u00e0q\2\u0364\u0365"+
		"\5\u00d0i\2\u0365\u036b\3\2\2\2\u0366\u0368\5\u00d8m\2\u0367\u0369\5\u00d0"+
		"i\2\u0368\u0367\3\2\2\2\u0368\u0369\3\2\2\2\u0369\u036b\3\2\2\2\u036a"+
		"\u0363\3\2\2\2\u036a\u0366\3\2\2\2\u036b\u00cf\3\2\2\2\u036c\u0371\5\u00d2"+
		"j\2\u036d\u036e\7 \2\2\u036e\u0370\5\u00d2j\2\u036f\u036d\3\2\2\2\u0370"+
		"\u0373\3\2\2\2\u0371\u036f\3\2\2\2\u0371\u0372\3\2\2\2\u0372\u0374\3\2"+
		"\2\2\u0373\u0371\3\2\2\2\u0374\u0375\7\65\2\2\u0375\u00d1\3\2\2\2\u0376"+
		"\u0378\5\u00f6|\2\u0377\u0376\3\2\2\2\u0377\u0378\3\2\2\2\u0378\u0379"+
		"\3\2\2\2\u0379\u037b\5\u00f2z\2\u037a\u037c\5\u00e2r\2\u037b\u037a\3\2"+
		"\2\2\u037b\u037c\3\2\2\2\u037c\u0384\3\2\2\2\u037d\u037f\7\"\2\2\u037e"+
		"\u0380\5|?\2\u037f\u037e\3\2\2\2\u037f\u0380\3\2\2\2\u0380\u0381\3\2\2"+
		"\2\u0381\u0385\7\20\2\2\u0382\u0383\7\24\2\2\u0383\u0385\5\u00d4k\2\u0384"+
		"\u037d\3\2\2\2\u0384\u0382\3\2\2\2\u0384\u0385\3\2\2\2\u0385\u00d3\3\2"+
		"\2\2\u0386\u0388\5\64\33\2\u0387\u0386\3\2\2\2\u0388\u038b\3\2\2\2\u0389"+
		"\u0387\3\2\2\2\u0389\u038a\3\2\2\2\u038a\u03a2\3\2\2\2\u038b\u0389\3\2"+
		"\2\2\u038c\u038d\7Z\2\2\u038d\u038e\5\u00d6l\2\u038e\u038f\7[\2\2\u038f"+
		"\u0399\3\2\2\2\u0390\u0391\7\"\2\2\u0391\u0392\5\u00d6l\2\u0392\u0393"+
		"\7\20\2\2\u0393\u0399\3\2\2\2\u0394\u0395\7\4\2\2\u0395\u0396\5\u00d6"+
		"l\2\u0396\u0397\7\34\2\2\u0397\u0399\3\2\2\2\u0398\u038c\3\2\2\2\u0398"+
		"\u0390\3\2\2\2\u0398\u0394\3\2\2\2\u0399\u039d\3\2\2\2\u039a\u039c\5\64"+
		"\33\2\u039b\u039a\3\2\2\2\u039c\u039f\3\2\2\2\u039d\u039b\3\2\2\2\u039d"+
		"\u039e\3\2\2\2\u039e\u03a1\3\2\2\2\u039f\u039d\3\2\2\2\u03a0\u0398\3\2"+
		"\2\2\u03a1\u03a4\3\2\2\2\u03a2\u03a0\3\2\2\2\u03a2\u03a3\3\2\2\2\u03a3"+
		"\u00d5\3\2\2\2\u03a4\u03a2\3\2\2\2\u03a5\u03a7\5\66\34\2\u03a6\u03a5\3"+
		"\2\2\2\u03a7\u03aa\3\2\2\2\u03a8\u03a6\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9"+
		"\u03c1\3\2\2\2\u03aa\u03a8\3\2\2\2\u03ab\u03ac\7Z\2\2\u03ac\u03ad\5\u00d6"+
		"l\2\u03ad\u03ae\7[\2\2\u03ae\u03b8\3\2\2\2\u03af\u03b0\7\"\2\2\u03b0\u03b1"+
		"\5\u00d6l\2\u03b1\u03b2\7\20\2\2\u03b2\u03b8\3\2\2\2\u03b3\u03b4\7\4\2"+
		"\2\u03b4\u03b5\5\u00d6l\2\u03b5\u03b6\7\34\2\2\u03b6\u03b8\3\2\2\2\u03b7"+
		"\u03ab\3\2\2\2\u03b7\u03af\3\2\2\2\u03b7\u03b3\3\2\2\2\u03b8\u03bc\3\2"+
		"\2\2\u03b9\u03bb\5\66\34\2\u03ba\u03b9\3\2\2\2\u03bb\u03be\3\2\2\2\u03bc"+
		"\u03ba\3\2\2\2\u03bc\u03bd\3\2\2\2\u03bd\u03c0\3\2\2\2\u03be\u03bc\3\2"+
		"\2\2\u03bf\u03b7\3\2\2\2\u03c0\u03c3\3\2\2\2\u03c1\u03bf\3\2\2\2\u03c1"+
		"\u03c2\3\2\2\2\u03c2\u00d7\3\2\2\2\u03c3\u03c1\3\2\2\2\u03c4\u03c6\5\22"+
		"\n\2\u03c5\u03c7\5\u00dan\2\u03c6\u03c5\3\2\2\2\u03c6\u03c7\3\2\2\2\u03c7"+
		"\u03c9\3\2\2\2\u03c8\u03ca\5\u00dco\2\u03c9\u03c8\3\2\2\2\u03c9\u03ca"+
		"\3\2\2\2\u03ca\u03cb\3\2\2\2\u03cb\u03cc\7Z\2\2\u03cc\u03cd\bm\1\2\u03cd"+
		"\u00d9\3\2\2\2\u03ce\u03cf\5\u00f2z\2\u03cf\u00db\3\2\2\2\u03d0\u03d1"+
		"\7#\2\2\u03d1\u03d6\5\u00dep\2\u03d2\u03d3\7 \2\2\u03d3\u03d5\5\u00de"+
		"p\2\u03d4\u03d2\3\2\2\2\u03d5\u03d8\3\2\2\2\u03d6\u03d4\3\2\2\2\u03d6"+
		"\u03d7\3\2\2\2\u03d7\u00dd\3\2\2\2\u03d8\u03d6\3\2\2\2\u03d9\u03db\7O"+
		"\2\2\u03da\u03d9\3\2\2\2\u03da\u03db\3\2\2\2\u03db\u03dd\3\2\2\2\u03dc"+
		"\u03de\5\26\f\2\u03dd\u03dc\3\2\2\2\u03dd\u03de\3\2\2\2\u03de\u03df\3"+
		"\2\2\2\u03df\u03e0\5\u00f2z\2\u03e0\u00df\3\2\2\2\u03e1\u03e3\7N\2\2\u03e2"+
		"\u03e1\3\2\2\2\u03e3\u03e6\3\2\2\2\u03e4\u03e2\3\2\2\2\u03e4\u03e5\3\2"+
		"\2\2\u03e5\u03ea\3\2\2\2\u03e6\u03e4\3\2\2\2\u03e7\u03eb\5\22\n\2\u03e8"+
		"\u03eb\7K\2\2\u03e9\u03eb\7L\2\2\u03ea\u03e7\3\2\2\2\u03ea\u03e8\3\2\2"+
		"\2\u03ea\u03e9\3\2\2\2\u03ea\u03eb\3\2\2\2\u03eb\u03ec\3\2\2\2\u03ec\u03f1"+
		"\5\u00e4s\2\u03ed\u03ee\7\6\2\2\u03ee\u03ef\5\"\22\2\u03ef\u03f0\78\2"+
		"\2\u03f0\u03f2\3\2\2\2\u03f1\u03ed\3\2\2\2\u03f1\u03f2\3\2\2\2\u03f2\u03fd"+
		"\3\2\2\2\u03f3\u03f4\7\23\2\2\u03f4\u03f9\5\u00e4s\2\u03f5\u03f6\7\6\2"+
		"\2\u03f6\u03f7\5\"\22\2\u03f7\u03f8\78\2\2\u03f8\u03fa\3\2\2\2\u03f9\u03f5"+
		"\3\2\2\2\u03f9\u03fa\3\2\2\2\u03fa\u03fc\3\2\2\2\u03fb\u03f3\3\2\2\2\u03fc"+
		"\u03ff\3\2\2\2\u03fd\u03fb\3\2\2\2\u03fd\u03fe\3\2\2\2\u03fe\u0402\3\2"+
		"\2\2\u03ff\u03fd\3\2\2\2\u0400\u0402\t\35\2\2\u0401\u03e4\3\2\2\2\u0401"+
		"\u0400\3\2\2\2\u0402\u00e1\3\2\2\2\u0403\u0404\7\4\2\2\u0404\u0405\5\u00e6"+
		"t\2\u0405\u0406\7\34\2\2\u0406\u0409\3\2\2\2\u0407\u0409\5\u00ecw\2\u0408"+
		"\u0403\3\2\2\2\u0408\u0407\3\2\2\2\u0409\u00e3\3\2\2\2\u040a\u0410\7Y"+
		"\2\2\u040b\u0410\7J\2\2\u040c\u0410\7M\2\2\u040d\u040e\7M\2\2\u040e\u0410"+
		"\7M\2\2\u040f\u040a\3\2\2\2\u040f\u040b\3\2\2\2\u040f\u040c\3\2\2\2\u040f"+
		"\u040d\3\2\2\2\u0410\u00e5\3\2\2\2\u0411\u0413\5.\30\2\u0412\u0411\3\2"+
		"\2\2\u0413\u0416\3\2\2\2\u0414\u0412\3\2\2\2\u0414\u0415\3\2\2\2\u0415"+
		"\u0422\3\2\2\2\u0416\u0414\3\2\2\2\u0417\u0418\7\4\2\2\u0418\u0419\5\u00e6"+
		"t\2\u0419\u041d\7\34\2\2\u041a\u041c\5.\30\2\u041b\u041a\3\2\2\2\u041c"+
		"\u041f\3\2\2\2\u041d\u041b\3\2\2\2\u041d\u041e\3\2\2\2\u041e\u0421\3\2"+
		"\2\2\u041f\u041d\3\2\2\2\u0420\u0417\3\2\2\2\u0421\u0424\3\2\2\2\u0422"+
		"\u0420\3\2\2\2\u0422\u0423\3\2\2\2\u0423\u00e7\3\2\2\2\u0424\u0422\3\2"+
		"\2\2\u0425\u0427\t\36\2\2\u0426\u0425\3\2\2\2\u0426\u0427\3\2\2\2\u0427"+
		"\u0428\3\2\2\2\u0428\u0429\5\u00e0q\2\u0429\u00e9\3\2\2\2\u042a\u042d"+
		"\5\u00f2z\2\u042b\u042d\5\26\f\2\u042c\u042a\3\2\2\2\u042c\u042b\3\2\2"+
		"\2\u042d\u00eb\3\2\2\2\u042e\u042f\7\"\2\2\u042f\u0430\7J\2\2\u0430\u043e"+
		"\7\20\2\2\u0431\u043a\7\"\2\2\u0432\u0437\5\u00eex\2\u0433\u0434\7 \2"+
		"\2\u0434\u0436\5\u00eex\2\u0435\u0433\3\2\2\2\u0436\u0439\3\2\2\2\u0437"+
		"\u0435\3\2\2\2\u0437\u0438\3\2\2\2\u0438\u043b\3\2\2\2\u0439\u0437\3\2"+
		"\2\2\u043a\u0432\3\2\2\2\u043a\u043b\3\2\2\2\u043b\u043c\3\2\2\2\u043c"+
		"\u043e\7\20\2\2\u043d\u042e\3\2\2\2\u043d\u0431\3\2\2\2\u043e\u00ed\3"+
		"\2\2\2\u043f\u0440\5\u00e8u\2\u0440\u0441\5\u00f0y\2\u0441\u00ef\3\2\2"+
		"\2\u0442\u0444\5\u00f6|\2\u0443\u0442\3\2\2\2\u0443\u0444\3\2\2\2\u0444"+
		"\u044c\3\2\2\2\u0445\u0446\7\"\2\2\u0446\u0447\5\u00f0y\2\u0447\u0448"+
		"\7\20\2\2\u0448\u044d\3\2\2\2\u0449\u044b\5\u00eav\2\u044a\u0449\3\2\2"+
		"\2\u044a\u044b\3\2\2\2\u044b\u044d\3\2\2\2\u044c\u0445\3\2\2\2\u044c\u044a"+
		"\3\2\2\2\u044d\u044f\3\2\2\2\u044e\u0450\5\u00e2r\2\u044f\u044e\3\2\2"+
		"\2\u044f\u0450\3\2\2\2\u0450\u00f1\3\2\2\2\u0451\u0456\7Y\2\2\u0452\u0453"+
		"\7\23\2\2\u0453\u0455\7Y\2\2\u0454\u0452\3\2\2\2\u0455\u0458\3\2\2\2\u0456"+
		"\u0454\3\2\2\2\u0456\u0457\3\2\2\2\u0457\u00f3\3\2\2\2\u0458\u0456\3\2"+
		"\2\2\u0459\u045a\t\37\2\2\u045a\u00f5\3\2\2\2\u045b\u045d\5\24\13\2\u045c"+
		"\u045b\3\2\2\2\u045d\u045e\3\2\2\2\u045e\u045c\3\2\2\2\u045e\u045f\3\2"+
		"\2\2\u045f\u00f7\3\2\2\2|\u00fb\u0100\u0105\u0120\u014a\u015e\u0160\u017f"+
		"\u0181\u0189\u0197\u019d\u01a2\u01a7\u01b8\u01c0\u01d4\u01d7\u01dc\u01e4"+
		"\u01f4\u01fb\u0201\u0208\u0210\u0214\u0218\u021b\u021f\u0222\u0230\u0236"+
		"\u023e\u0243\u0248\u024d\u0252\u0257\u025d\u0263\u0268\u026d\u0272\u0279"+
		"\u0280\u028a\u028e\u0294\u029a\u02a1\u02ad\u02b0\u02be\u02c2\u02ca\u02cf"+
		"\u02d4\u02d9\u02dc\u02e1\u02e8\u02f0\u02f5\u02fb\u02ff\u0306\u030b\u030e"+
		"\u0314\u031b\u031e\u0329\u0330\u0336\u0340\u034a\u0353\u0358\u035c\u035f"+
		"\u0368\u036a\u0371\u0377\u037b\u037f\u0384\u0389\u0398\u039d\u03a2\u03a8"+
		"\u03b7\u03bc\u03c1\u03c6\u03c9\u03d6\u03da\u03dd\u03e4\u03ea\u03f1\u03f9"+
		"\u03fd\u0401\u0408\u040f\u0414\u041d\u0422\u0426\u042c\u0437\u043a\u043d"+
		"\u0443\u044a\u044c\u044f\u0456\u045e";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}
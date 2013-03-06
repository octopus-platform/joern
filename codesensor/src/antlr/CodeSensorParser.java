// Generated from ./CodeSensor.g4 by ANTLR 4.0

	package antlr;

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
		T__73=1, T__72=2, T__71=3, T__70=4, T__69=5, T__68=6, T__67=7, T__66=8, 
		T__65=9, T__64=10, T__63=11, T__62=12, T__61=13, T__60=14, T__59=15, T__58=16, 
		T__57=17, T__56=18, T__55=19, T__54=20, T__53=21, T__52=22, T__51=23, 
		T__50=24, T__49=25, T__48=26, T__47=27, T__46=28, T__45=29, T__44=30, 
		T__43=31, T__42=32, T__41=33, T__40=34, T__39=35, T__38=36, T__37=37, 
		T__36=38, T__35=39, T__34=40, T__33=41, T__32=42, T__31=43, T__30=44, 
		T__29=45, T__28=46, T__27=47, T__26=48, T__25=49, T__24=50, T__23=51, 
		T__22=52, T__21=53, T__20=54, T__19=55, T__18=56, T__17=57, T__16=58, 
		T__15=59, T__14=60, T__13=61, T__12=62, T__11=63, T__10=64, T__9=65, T__8=66, 
		T__7=67, T__6=68, T__5=69, T__4=70, T__3=71, T__2=72, T__1=73, T__0=74, 
		IF=75, ELSE=76, FOR=77, WHILE=78, SWITCH=79, CONTINUE=80, BREAK=81, GOTO=82, 
		RETURN=83, CASE=84, ALPHA_NUMERIC=85, CPPCOMMENT=86, COMMENT=87, STRING=88, 
		PREPROC=89, HEX_LITERAL=90, DECIMAL_LITERAL=91, OCTAL_LITERAL=92, FLOATING_POINT_LITERAL=93, 
		WHITESPACE=94, OTHER=95;
	public static final String[] tokenNames = {
		"<INVALID>", "'&'", "'register'", "'*'", "'['", "'<'", "'--'", "'!='", 
		"'<='", "'<<'", "'namespace'", "'}'", "'%'", "'->'", "'auto'", "'union'", 
		"'*='", "')'", "'virtual'", "'signed'", "'explicit'", "'inline'", "'throw'", 
		"'unsigned'", "'::'", "'template'", "'='", "'const'", "'|='", "'new'", 
		"'class'", "'|'", "'!'", "'enum'", "'long'", "'using'", "']'", "'<<='", 
		"'-='", "'->*'", "'public'", "','", "'-'", "':'", "'('", "'&='", "'private'", 
		"'void'", "'>>='", "'{'", "'...'", "'+='", "'^='", "'friend'", "'struct'", 
		"'static'", "'++'", "'>>'", "'delete'", "'^'", "'+'", "'protected'", "'operator'", 
		"'typedef'", "'volatile'", "';'", "'&&'", "'||'", "'>'", "'%='", "'/='", 
		"'/'", "'=='", "'~'", "'>='", "'if'", "'ELSE'", "'for'", "'while'", "'switch'", 
		"'continue'", "'break'", "'goto'", "'return'", "'case'", "ALPHA_NUMERIC", 
		"CPPCOMMENT", "COMMENT", "STRING", "PREPROC", "HEX_LITERAL", "DECIMAL_LITERAL", 
		"OCTAL_LITERAL", "FLOATING_POINT_LITERAL", "WHITESPACE", "OTHER"
	};
	public static final int
		RULE_code = 0, RULE_part = 1, RULE_declaration = 2, RULE_simple_decl = 3, 
		RULE_template_decl_start = 4, RULE_template_param_list = 5, RULE_var_decl = 6, 
		RULE_init_declarator_list = 7, RULE_init_declarator = 8, RULE_class_def = 9, 
		RULE_class_name = 10, RULE_base_classes = 11, RULE_base_class = 12, RULE_class_content = 13, 
		RULE_label = 14, RULE_function_def = 15, RULE_return_type = 16, RULE_type_name = 17, 
		RULE_base_type = 18, RULE_assign_expr = 19, RULE_function_param_list = 20, 
		RULE_parameter_decl_clause = 21, RULE_parameter_decl = 22, RULE_parameter_id = 23, 
		RULE_ptrs = 24, RULE_param_decl_specifiers = 25, RULE_type_suffix = 26, 
		RULE_param_type_list = 27, RULE_param_type = 28, RULE_param_type_id = 29, 
		RULE_constant_expr = 30, RULE_expr = 31, RULE_compound_statement = 32, 
		RULE_parameter_name = 33, RULE_ctor_list = 34, RULE_ctor_initializer = 35, 
		RULE_initializer_id = 36, RULE_ctor_expr = 37, RULE_function_name = 38, 
		RULE_exception_specification = 39, RULE_type_id_list = 40, RULE_using_directive = 41, 
		RULE_unary_operator = 42, RULE_constant = 43, RULE_no_brackets = 44, RULE_no_brackets_curlies_or_squares = 45, 
		RULE_no_brackets_or_semicolon = 46, RULE_no_angle_brackets_or_brackets = 47, 
		RULE_no_curlies = 48, RULE_no_squares = 49, RULE_no_squares_or_semicolon = 50, 
		RULE_no_comma_or_semicolon = 51, RULE_cv_qualifier = 52, RULE_function_decl_specifiers = 53, 
		RULE_class_key = 54, RULE_ptr_operator = 55, RULE_access_specifier = 56, 
		RULE_operator_function_id = 57, RULE_operator = 58, RULE_assignment_operator = 59, 
		RULE_identifier = 60, RULE_number = 61, RULE_water = 62;
	public static final String[] ruleNames = {
		"code", "part", "declaration", "simple_decl", "template_decl_start", "template_param_list", 
		"var_decl", "init_declarator_list", "init_declarator", "class_def", "class_name", 
		"base_classes", "base_class", "class_content", "label", "function_def", 
		"return_type", "type_name", "base_type", "assign_expr", "function_param_list", 
		"parameter_decl_clause", "parameter_decl", "parameter_id", "ptrs", "param_decl_specifiers", 
		"type_suffix", "param_type_list", "param_type", "param_type_id", "constant_expr", 
		"expr", "compound_statement", "parameter_name", "ctor_list", "ctor_initializer", 
		"initializer_id", "ctor_expr", "function_name", "exception_specification", 
		"type_id_list", "using_directive", "unary_operator", "constant", "no_brackets", 
		"no_brackets_curlies_or_squares", "no_brackets_or_semicolon", "no_angle_brackets_or_brackets", 
		"no_curlies", "no_squares", "no_squares_or_semicolon", "no_comma_or_semicolon", 
		"cv_qualifier", "function_decl_specifiers", "class_key", "ptr_operator", 
		"access_specifier", "operator_function_id", "operator", "assignment_operator", 
		"identifier", "number", "water"
	};

	@Override
	public String getGrammarFileName() { return "CodeSensor.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

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
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (73 - 64)) | (1L << (74 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (23 - 64)) | (1L << (25 - 64)) | (1L << (27 - 64)) | (1L << (30 - 64)) | (1L << (33 - 64)) | (1L << (34 - 64)) | (1L << (35 - 64)) | (1L << (44 - 64)) | (1L << (47 - 64)) | (1L << (53 - 64)) | (1L << (54 - 64)) | (1L << (55 - 64)) | (1L << (62 - 64)) | (1L << (63 - 64)) | (1L << (64 - 64)) | (1L << (ALPHA_NUMERIC - 64)))) != 0)) {
				{
				{
				setState(126); part();
				}
				}
				setState(131);
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
			setState(134);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132); declaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(133); water();
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
			setState(139);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(136); simple_decl();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(137); function_def();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(138); using_directive();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterSimple_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitSimple_decl(this);
		}
	}

	public final Simple_declContext simple_decl() throws RecognitionException {
		Simple_declContext _localctx = new Simple_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_simple_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_la = _input.LA(1);
			if (_la==63) {
				{
				setState(141); match(63);
				}
			}

			setState(145);
			_la = _input.LA(1);
			if (_la==25) {
				{
				setState(144); template_decl_start();
				}
			}

			setState(147); var_decl();
			setState(148); match(65);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterTemplate_decl_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitTemplate_decl_start(this);
		}
	}

	public final Template_decl_startContext template_decl_start() throws RecognitionException {
		Template_decl_startContext _localctx = new Template_decl_startContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_template_decl_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150); match(25);
			setState(151); match(5);
			setState(152); template_param_list();
			setState(153); match(68);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 10, RULE_template_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (73 - 64)) | (1L << (74 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				setState(164);
				switch (_input.LA(1)) {
				case 5:
					{
					{
					setState(155); match(5);
					setState(156); template_param_list();
					setState(157); match(68);
					}
					}
					break;
				case 44:
					{
					{
					setState(159); match(44);
					setState(160); template_param_list();
					setState(161); match(17);
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
				case 16:
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
				case 40:
				case 41:
				case 42:
				case 43:
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
				case 65:
				case 66:
				case 67:
				case 69:
				case 70:
				case 71:
				case 72:
				case 73:
				case 74:
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
				case ALPHA_NUMERIC:
				case CPPCOMMENT:
				case COMMENT:
				case STRING:
				case PREPROC:
				case HEX_LITERAL:
				case DECIMAL_LITERAL:
				case OCTAL_LITERAL:
				case FLOATING_POINT_LITERAL:
				case WHITESPACE:
				case OTHER:
					{
					setState(163); no_angle_brackets_or_brackets();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(168);
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
		enterRule(_localctx, 12, RULE_var_decl);
		int _la;
		try {
			setState(176);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new DeclByTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(169); type_name();
				setState(170); init_declarator_list();
				}
				break;

			case 2:
				_localctx = new DeclByClassContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(172); class_def();
				setState(174);
				_la = _input.LA(1);
				if (_la==1 || _la==3 || _la==ALPHA_NUMERIC) {
					{
					setState(173); init_declarator_list();
					}
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
		enterRule(_localctx, 14, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178); init_declarator();
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==41) {
				{
				{
				setState(179); match(41);
				setState(180); init_declarator();
				}
				}
				setState(185);
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
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
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
		enterRule(_localctx, 16, RULE_init_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(187);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(186); ptrs();
				}
			}

			setState(189); identifier();
			setState(191);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(190); type_suffix();
				}
				break;
			}
			}
			setState(200);
			switch (_input.LA(1)) {
			case 44:
				{
				{
				setState(193); match(44);
				setState(195);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(194); expr();
					}
					break;
				}
				setState(197); match(17);
				}
				}
				break;
			case 26:
				{
				{
				setState(198); match(26);
				setState(199); assign_expr();
				}
				}
				break;
			case 41:
			case 65:
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

	public static class Class_defContext extends ParserRuleContext {
		public Class_contentContext class_content() {
			return getRuleContext(Class_contentContext.class,0);
		}
		public Base_classesContext base_classes() {
			return getRuleContext(Base_classesContext.class,0);
		}
		public Class_keyContext class_key() {
			return getRuleContext(Class_keyContext.class,0);
		}
		public Class_nameContext class_name() {
			return getRuleContext(Class_nameContext.class,0);
		}
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
		enterRule(_localctx, 18, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202); class_key();
			setState(204);
			_la = _input.LA(1);
			if (_la==ALPHA_NUMERIC) {
				{
				setState(203); class_name();
				}
			}

			setState(207);
			_la = _input.LA(1);
			if (_la==43) {
				{
				setState(206); base_classes();
				}
			}

			setState(209); match(49);
			setState(210); class_content();
			setState(211); match(11);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 20, RULE_class_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 22, RULE_base_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215); match(43);
			setState(216); base_class();
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==41) {
				{
				{
				setState(217); match(41);
				setState(218); base_class();
				}
				}
				setState(223);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterBase_class(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitBase_class(this);
		}
	}

	public final Base_classContext base_class() throws RecognitionException {
		Base_classContext _localctx = new Base_classContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_base_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			_la = _input.LA(1);
			if (_la==18) {
				{
				setState(224); match(18);
				}
			}

			setState(228);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 40) | (1L << 46) | (1L << 61))) != 0)) {
				{
				setState(227); access_specifier();
				}
			}

			setState(230); identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_contentContext extends ParserRuleContext {
		public List<Class_contentContext> class_content() {
			return getRuleContexts(Class_contentContext.class);
		}
		public LabelContext label(int i) {
			return getRuleContext(LabelContext.class,i);
		}
		public List<Function_defContext> function_def() {
			return getRuleContexts(Function_defContext.class);
		}
		public Class_contentContext class_content(int i) {
			return getRuleContext(Class_contentContext.class,i);
		}
		public Simple_declContext simple_decl(int i) {
			return getRuleContext(Simple_declContext.class,i);
		}
		public List<No_curliesContext> no_curlies() {
			return getRuleContexts(No_curliesContext.class);
		}
		public No_curliesContext no_curlies(int i) {
			return getRuleContext(No_curliesContext.class,i);
		}
		public List<LabelContext> label() {
			return getRuleContexts(LabelContext.class);
		}
		public Function_defContext function_def(int i) {
			return getRuleContext(Function_defContext.class,i);
		}
		public List<Simple_declContext> simple_decl() {
			return getRuleContexts(Simple_declContext.class);
		}
		public Class_contentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterClass_content(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitClass_content(this);
		}
	}

	public final Class_contentContext class_content() throws RecognitionException {
		Class_contentContext _localctx = new Class_contentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_class_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 23) | (1L << 25) | (1L << 27) | (1L << 30) | (1L << 33) | (1L << 34) | (1L << 40) | (1L << 44) | (1L << 46) | (1L << 47) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (73 - 64)) | (1L << (74 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)) | (1L << (61 - 64)) | (1L << (62 - 64)) | (1L << (63 - 64)) | (1L << (64 - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)))) != 0)) {
				{
				setState(240);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(232); simple_decl();
					}
					break;

				case 2:
					{
					setState(233); function_def();
					}
					break;

				case 3:
					{
					setState(234); label();
					}
					break;

				case 4:
					{
					setState(235); match(49);
					setState(236); class_content();
					setState(237); match(11);
					}
					break;

				case 5:
					{
					setState(239); no_curlies();
					}
					break;
				}
				}
				setState(244);
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
		enterRule(_localctx, 28, RULE_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			switch (_input.LA(1)) {
			case CASE:
			case ALPHA_NUMERIC:
			case HEX_LITERAL:
			case DECIMAL_LITERAL:
			case OCTAL_LITERAL:
				{
				{
				setState(246);
				_la = _input.LA(1);
				if (_la==CASE) {
					{
					setState(245); match(CASE);
					}
				}

				setState(250);
				switch (_input.LA(1)) {
				case ALPHA_NUMERIC:
					{
					setState(248); identifier();
					}
					break;
				case HEX_LITERAL:
				case DECIMAL_LITERAL:
				case OCTAL_LITERAL:
					{
					setState(249); number();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				break;
			case 40:
			case 46:
			case 61:
				{
				setState(252); access_specifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(255); match(43);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 30, RULE_function_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			_la = _input.LA(1);
			if (_la==25) {
				{
				setState(257); template_decl_start();
				}
			}

			setState(261);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(260); return_type();
				}
				break;
			}
			setState(263); function_name();
			setState(264); function_param_list();
			setState(266);
			_la = _input.LA(1);
			if (_la==43) {
				{
				setState(265); ctor_list();
				}
			}

			setState(268); compound_statement();
			}
		}
		catch (RecognitionException re) {
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
		public List<Ptr_operatorContext> ptr_operator() {
			return getRuleContexts(Ptr_operatorContext.class);
		}
		public Function_decl_specifiersContext function_decl_specifiers(int i) {
			return getRuleContext(Function_decl_specifiersContext.class,i);
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
		enterRule(_localctx, 32, RULE_return_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 18) | (1L << 20) | (1L << 21) | (1L << 53) | (1L << 55))) != 0)) {
				{
				{
				setState(270); function_decl_specifiers();
				}
				}
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(276); type_name();
			}
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 18) | (1L << 20) | (1L << 21) | (1L << 53) | (1L << 55))) != 0)) {
				{
				{
				setState(278); function_decl_specifiers();
				}
				}
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1 || _la==3) {
				{
				{
				setState(284); ptr_operator();
				}
				}
				setState(289);
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterType_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitType_name(this);
		}
	}

	public final Type_nameContext type_name() throws RecognitionException {
		Type_nameContext _localctx = new Type_nameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_type_name);
		int _la;
		try {
			setState(322);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==27 || _la==64) {
					{
					{
					setState(290); cv_qualifier();
					}
					}
					setState(295);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(299);
				switch (_input.LA(1)) {
				case 15:
				case 30:
				case 33:
				case 54:
					{
					setState(296); class_key();
					}
					break;
				case 23:
					{
					setState(297); match(23);
					}
					break;
				case 19:
					{
					setState(298); match(19);
					}
					break;
				case 34:
				case 47:
				case ALPHA_NUMERIC:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(301); base_type();
				setState(306);
				_la = _input.LA(1);
				if (_la==5) {
					{
					setState(302); match(5);
					setState(303); template_param_list();
					setState(304); match(68);
					}
				}

				setState(318);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==24) {
					{
					{
					setState(308); match(24);
					setState(309); base_type();
					setState(314);
					_la = _input.LA(1);
					if (_la==5) {
						{
						setState(310); match(5);
						setState(311); template_param_list();
						setState(312); match(68);
						}
					}

					}
					}
					setState(320);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(321);
				_la = _input.LA(1);
				if ( !(_la==19 || _la==23) ) {
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
		public TerminalNode ALPHA_NUMERIC() { return getToken(CodeSensorParser.ALPHA_NUMERIC, 0); }
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
		enterRule(_localctx, 36, RULE_base_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(324); match(ALPHA_NUMERIC);
				}
				break;

			case 2:
				{
				setState(325); match(47);
				}
				break;

			case 3:
				{
				setState(326); match(34);
				}
				break;

			case 4:
				{
				setState(327); match(34);
				setState(328); match(34);
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

	public static class Assign_exprContext extends ParserRuleContext {
		public List<No_comma_or_semicolonContext> no_comma_or_semicolon() {
			return getRuleContexts(No_comma_or_semicolonContext.class);
		}
		public No_comma_or_semicolonContext no_comma_or_semicolon(int i) {
			return getRuleContext(No_comma_or_semicolonContext.class,i);
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
		enterRule(_localctx, 38, RULE_assign_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(331); no_comma_or_semicolon();
				}
				}
				setState(334); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (73 - 64)) | (1L << (74 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0) );
			}
		}
		catch (RecognitionException re) {
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
		public List<Cv_qualifierContext> cv_qualifier() {
			return getRuleContexts(Cv_qualifierContext.class);
		}
		public Exception_specificationContext exception_specification() {
			return getRuleContext(Exception_specificationContext.class,0);
		}
		public Parameter_decl_clauseContext parameter_decl_clause() {
			return getRuleContext(Parameter_decl_clauseContext.class,0);
		}
		public Cv_qualifierContext cv_qualifier(int i) {
			return getRuleContext(Cv_qualifierContext.class,i);
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
		enterRule(_localctx, 40, RULE_function_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336); match(44);
			setState(338);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 14) | (1L << 15) | (1L << 19) | (1L << 23) | (1L << 27) | (1L << 30) | (1L << 33) | (1L << 34) | (1L << 47) | (1L << 54))) != 0) || _la==64 || _la==ALPHA_NUMERIC) {
				{
				setState(337); parameter_decl_clause();
				}
			}

			setState(340); match(17);
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==27 || _la==64) {
				{
				{
				setState(341); cv_qualifier();
				}
				}
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(348);
			_la = _input.LA(1);
			if (_la==22) {
				{
				setState(347); exception_specification();
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
		enterRule(_localctx, 42, RULE_parameter_decl_clause);
		int _la;
		try {
			int _alt;
			setState(363);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(350); parameter_decl();
				setState(355);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(351); match(41);
						setState(352); parameter_decl();
						}
						} 
					}
					setState(357);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				}
				}
				setState(360);
				_la = _input.LA(1);
				if (_la==41) {
					{
					setState(358); match(41);
					setState(359); match(50);
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(362); match(47);
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
		enterRule(_localctx, 44, RULE_parameter_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365); param_decl_specifiers();
			setState(366); parameter_id();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 46, RULE_parameter_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(368); ptrs();
				}
			}

			setState(376);
			switch (_input.LA(1)) {
			case 44:
				{
				setState(371); match(44);
				setState(372); parameter_id();
				setState(373); match(17);
				}
				break;
			case 40:
			case 46:
			case 61:
			case ALPHA_NUMERIC:
				{
				setState(375); parameter_name();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(379);
			_la = _input.LA(1);
			if (_la==4 || _la==44) {
				{
				setState(378); type_suffix();
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
		enterRule(_localctx, 48, RULE_ptrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(381); ptr_operator();
				}
				}
				setState(384); 
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterParam_decl_specifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitParam_decl_specifiers(this);
		}
	}

	public final Param_decl_specifiersContext param_decl_specifiers() throws RecognitionException {
		Param_decl_specifiersContext _localctx = new Param_decl_specifiersContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_param_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			_la = _input.LA(1);
			if (_la==2 || _la==14) {
				{
				setState(386);
				_la = _input.LA(1);
				if ( !(_la==2 || _la==14) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(389); type_name();
			}
		}
		catch (RecognitionException re) {
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
		public Constant_exprContext constant_expr() {
			return getRuleContext(Constant_exprContext.class,0);
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
		enterRule(_localctx, 52, RULE_type_suffix);
		try {
			setState(396);
			switch (_input.LA(1)) {
			case 4:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(391); match(4);
				setState(392); constant_expr();
				setState(393); match(36);
				}
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 2);
				{
				setState(395); param_type_list();
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterParam_type_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitParam_type_list(this);
		}
	}

	public final Param_type_listContext param_type_list() throws RecognitionException {
		Param_type_listContext _localctx = new Param_type_listContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_param_type_list);
		int _la;
		try {
			setState(413);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(398); match(44);
				setState(399); match(47);
				setState(400); match(17);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(401); match(44);
				setState(410);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 14) | (1L << 15) | (1L << 19) | (1L << 23) | (1L << 27) | (1L << 30) | (1L << 33) | (1L << 34) | (1L << 47) | (1L << 54))) != 0) || _la==64 || _la==ALPHA_NUMERIC) {
					{
					setState(402); param_type();
					setState(407);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==41) {
						{
						{
						setState(403); match(41);
						setState(404); param_type();
						}
						}
						setState(409);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(412); match(17);
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
		enterRule(_localctx, 56, RULE_param_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415); param_decl_specifiers();
			setState(417);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(416); param_type_id();
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
		enterRule(_localctx, 58, RULE_param_type_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			_la = _input.LA(1);
			if (_la==1 || _la==3) {
				{
				setState(419); ptrs();
				}
			}

			setState(429);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(422); match(44);
				setState(423); param_type_id();
				setState(424); match(17);
				}
				break;

			case 2:
				{
				setState(427);
				_la = _input.LA(1);
				if (((((_la - 40)) & ~0x3f) == 0 && ((1L << (_la - 40)) & ((1L << (40 - 40)) | (1L << (46 - 40)) | (1L << (61 - 40)) | (1L << (ALPHA_NUMERIC - 40)))) != 0)) {
					{
					setState(426); parameter_name();
					}
				}

				}
				break;
			}
			setState(432);
			_la = _input.LA(1);
			if (_la==4 || _la==44) {
				{
				setState(431); type_suffix();
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

	public static class Constant_exprContext extends ParserRuleContext {
		public List<No_squaresContext> no_squares() {
			return getRuleContexts(No_squaresContext.class);
		}
		public No_squaresContext no_squares(int i) {
			return getRuleContext(No_squaresContext.class,i);
		}
		public List<Constant_exprContext> constant_expr() {
			return getRuleContexts(Constant_exprContext.class);
		}
		public Constant_exprContext constant_expr(int i) {
			return getRuleContext(Constant_exprContext.class,i);
		}
		public Constant_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterConstant_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitConstant_expr(this);
		}
	}

	public final Constant_exprContext constant_expr() throws RecognitionException {
		Constant_exprContext _localctx = new Constant_exprContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_constant_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (73 - 64)) | (1L << (74 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(434); no_squares();
				}
				}
				setState(439);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(451);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(440); match(4);
				setState(441); constant_expr();
				setState(442); match(36);
				setState(446);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (73 - 64)) | (1L << (74 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(443); no_squares();
					}
					}
					setState(448);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(453);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public No_bracketsContext no_brackets(int i) {
			return getRuleContext(No_bracketsContext.class,i);
		}
		public List<No_bracketsContext> no_brackets() {
			return getRuleContexts(No_bracketsContext.class);
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
		enterRule(_localctx, 62, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (73 - 64)) | (1L << (74 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(454); no_brackets();
				}
				}
				setState(459);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(471);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==44) {
				{
				{
				setState(460); match(44);
				setState(461); expr();
				setState(462); match(17);
				setState(466);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (73 - 64)) | (1L << (74 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(463); no_brackets();
					}
					}
					setState(468);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(473);
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

	public static class Compound_statementContext extends ParserRuleContext {
		public Compound_statementContext compound_statement(int i) {
			return getRuleContext(Compound_statementContext.class,i);
		}
		public List<No_curliesContext> no_curlies() {
			return getRuleContexts(No_curliesContext.class);
		}
		public No_curliesContext no_curlies(int i) {
			return getRuleContext(No_curliesContext.class,i);
		}
		public List<Compound_statementContext> compound_statement() {
			return getRuleContexts(Compound_statementContext.class);
		}
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
		enterRule(_localctx, 64, RULE_compound_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474); match(49);
			setState(478);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (73 - 64)) | (1L << (74 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(475); no_curlies();
				}
				}
				setState(480);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(490);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==49) {
				{
				{
				setState(481); compound_statement();
				setState(485);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (73 - 64)) | (1L << (74 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(482); no_curlies();
					}
					}
					setState(487);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(492);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(493); match(11);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 66, RULE_parameter_name);
		try {
			setState(497);
			switch (_input.LA(1)) {
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(495); identifier();
				}
				break;
			case 40:
			case 46:
			case 61:
				enterOuterAlt(_localctx, 2);
				{
				setState(496); access_specifier();
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
		enterRule(_localctx, 68, RULE_ctor_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499); match(43);
			setState(500); ctor_initializer();
			setState(505);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==41) {
				{
				{
				setState(501); match(41);
				setState(502); ctor_initializer();
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
		enterRule(_localctx, 70, RULE_ctor_initializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508); initializer_id();
			setState(509); ctor_expr();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 72, RULE_initializer_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(512);
			_la = _input.LA(1);
			if (_la==24) {
				{
				setState(511); match(24);
				}
			}

			setState(514); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 74, RULE_ctor_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516); match(44);
			setState(518);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(517); expr();
				}
				break;
			}
			setState(520); match(17);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 76, RULE_function_name);
		try {
			setState(528);
			switch (_input.LA(1)) {
			case 44:
				enterOuterAlt(_localctx, 1);
				{
				setState(522); match(44);
				setState(523); function_name();
				setState(524); match(17);
				}
				break;
			case ALPHA_NUMERIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(526); identifier();
				}
				break;
			case 62:
				enterOuterAlt(_localctx, 3);
				{
				setState(527); operator_function_id();
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
		enterRule(_localctx, 78, RULE_exception_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(530); match(22);
			setState(531); match(44);
			setState(532); type_id_list();
			setState(533); match(17);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 80, RULE_type_id_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (73 - 64)) | (1L << (74 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
				{
				{
				setState(535); no_brackets();
				}
				}
				setState(540);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(552);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==44) {
				{
				{
				setState(541); match(44);
				setState(542); type_id_list();
				setState(543); match(17);
				setState(547);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 18) | (1L << 19) | (1L << 20) | (1L << 21) | (1L << 22) | (1L << 23) | (1L << 24) | (1L << 25) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 33) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 37) | (1L << 38) | (1L << 39) | (1L << 40) | (1L << 41) | (1L << 42) | (1L << 43) | (1L << 45) | (1L << 46) | (1L << 47) | (1L << 48) | (1L << 49) | (1L << 50) | (1L << 51) | (1L << 52) | (1L << 53) | (1L << 54) | (1L << 55) | (1L << 56) | (1L << 57) | (1L << 58) | (1L << 59) | (1L << 60) | (1L << 61) | (1L << 62) | (1L << 63))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (65 - 64)) | (1L << (66 - 64)) | (1L << (67 - 64)) | (1L << (68 - 64)) | (1L << (69 - 64)) | (1L << (70 - 64)) | (1L << (71 - 64)) | (1L << (72 - 64)) | (1L << (73 - 64)) | (1L << (74 - 64)) | (1L << (IF - 64)) | (1L << (ELSE - 64)) | (1L << (FOR - 64)) | (1L << (WHILE - 64)) | (1L << (SWITCH - 64)) | (1L << (CONTINUE - 64)) | (1L << (BREAK - 64)) | (1L << (GOTO - 64)) | (1L << (RETURN - 64)) | (1L << (CASE - 64)) | (1L << (ALPHA_NUMERIC - 64)) | (1L << (CPPCOMMENT - 64)) | (1L << (COMMENT - 64)) | (1L << (STRING - 64)) | (1L << (PREPROC - 64)) | (1L << (HEX_LITERAL - 64)) | (1L << (DECIMAL_LITERAL - 64)) | (1L << (OCTAL_LITERAL - 64)) | (1L << (FLOATING_POINT_LITERAL - 64)) | (1L << (WHITESPACE - 64)) | (1L << (OTHER - 64)))) != 0)) {
					{
					{
					setState(544); no_brackets();
					}
					}
					setState(549);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(554);
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

	public static class Using_directiveContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
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
		enterRule(_localctx, 82, RULE_using_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(555); match(35);
			setState(556); match(10);
			setState(557); identifier();
			setState(558); match(65);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 84, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 32) | (1L << 42) | (1L << 60))) != 0) || _la==73) ) {
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
		enterRule(_localctx, 86, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			_la = _input.LA(1);
			if ( !(((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (STRING - 88)) | (1L << (HEX_LITERAL - 88)) | (1L << (DECIMAL_LITERAL - 88)) | (1L << (OCTAL_LITERAL - 88)) | (1L << (FLOATING_POINT_LITERAL - 88)))) != 0)) ) {
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
		enterRule(_localctx, 88, RULE_no_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==17 || _la==44) ) {
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
		enterRule(_localctx, 90, RULE_no_brackets_curlies_or_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 11) | (1L << 17) | (1L << 36) | (1L << 44) | (1L << 49))) != 0)) ) {
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
		enterRule(_localctx, 92, RULE_no_brackets_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			_la = _input.LA(1);
			if ( _la <= 0 || (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (17 - 17)) | (1L << (44 - 17)) | (1L << (65 - 17)))) != 0)) ) {
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
		enterRule(_localctx, 94, RULE_no_angle_brackets_or_brackets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
			_la = _input.LA(1);
			if ( _la <= 0 || (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & ((1L << (5 - 5)) | (1L << (17 - 5)) | (1L << (44 - 5)) | (1L << (68 - 5)))) != 0)) ) {
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
		enterRule(_localctx, 96, RULE_no_curlies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==11 || _la==49) ) {
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
		enterRule(_localctx, 98, RULE_no_squares);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(574);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==4 || _la==36) ) {
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
		enterRule(_localctx, 100, RULE_no_squares_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(576);
			_la = _input.LA(1);
			if ( _la <= 0 || (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & ((1L << (4 - 4)) | (1L << (36 - 4)) | (1L << (65 - 4)))) != 0)) ) {
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
		enterRule(_localctx, 102, RULE_no_comma_or_semicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(578);
			_la = _input.LA(1);
			if ( _la <= 0 || (_la==41 || _la==65) ) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterCv_qualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitCv_qualifier(this);
		}
	}

	public final Cv_qualifierContext cv_qualifier() throws RecognitionException {
		Cv_qualifierContext _localctx = new Cv_qualifierContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_cv_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(580);
			_la = _input.LA(1);
			if ( !(_la==27 || _la==64) ) {
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
		enterRule(_localctx, 106, RULE_function_decl_specifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 18) | (1L << 20) | (1L << 21) | (1L << 53) | (1L << 55))) != 0)) ) {
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
		enterRule(_localctx, 108, RULE_class_key);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(584);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 15) | (1L << 30) | (1L << 33) | (1L << 54))) != 0)) ) {
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
		enterRule(_localctx, 110, RULE_ptr_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(586);
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
		enterRule(_localctx, 112, RULE_access_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(588);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 40) | (1L << 46) | (1L << 61))) != 0)) ) {
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
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).enterOperator_function_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeSensorListener ) ((CodeSensorListener)listener).exitOperator_function_id(this);
		}
	}

	public final Operator_function_idContext operator_function_id() throws RecognitionException {
		Operator_function_idContext _localctx = new Operator_function_idContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_operator_function_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590); match(62);
			setState(591); operator();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 116, RULE_operator);
		int _la;
		try {
			setState(638);
			switch (_input.LA(1)) {
			case 29:
			case 58:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(593);
				_la = _input.LA(1);
				if ( !(_la==29 || _la==58) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(596);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(594); match(4);
					setState(595); match(36);
					}
				}

				}
				}
				break;
			case 60:
				enterOuterAlt(_localctx, 2);
				{
				setState(598); match(60);
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 3);
				{
				setState(599); match(42);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 4);
				{
				setState(600); match(3);
				}
				break;
			case 71:
				enterOuterAlt(_localctx, 5);
				{
				setState(601); match(71);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 6);
				{
				setState(602); match(12);
				}
				break;
			case 59:
				enterOuterAlt(_localctx, 7);
				{
				setState(603); match(59);
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 8);
				{
				setState(604); match(1);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 9);
				{
				setState(605); match(31);
				}
				break;
			case 73:
				enterOuterAlt(_localctx, 10);
				{
				setState(606); match(73);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 11);
				{
				setState(607); match(32);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 12);
				{
				setState(608); match(26);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 13);
				{
				setState(609); match(5);
				}
				break;
			case 68:
				enterOuterAlt(_localctx, 14);
				{
				setState(610); match(68);
				}
				break;
			case 51:
				enterOuterAlt(_localctx, 15);
				{
				setState(611); match(51);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 16);
				{
				setState(612); match(38);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 17);
				{
				setState(613); match(16);
				}
				break;
			case 70:
				enterOuterAlt(_localctx, 18);
				{
				setState(614); match(70);
				}
				break;
			case 69:
				enterOuterAlt(_localctx, 19);
				{
				setState(615); match(69);
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 20);
				{
				setState(616); match(52);
				}
				break;
			case 45:
				enterOuterAlt(_localctx, 21);
				{
				setState(617); match(45);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 22);
				{
				setState(618); match(28);
				}
				break;
			case 57:
				enterOuterAlt(_localctx, 23);
				{
				setState(619); match(57);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 24);
				{
				setState(620); match(9);
				}
				break;
			case 48:
				enterOuterAlt(_localctx, 25);
				{
				setState(621); match(48);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 26);
				{
				setState(622); match(37);
				}
				break;
			case 72:
				enterOuterAlt(_localctx, 27);
				{
				setState(623); match(72);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 28);
				{
				setState(624); match(7);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 29);
				{
				setState(625); match(8);
				}
				break;
			case 74:
				enterOuterAlt(_localctx, 30);
				{
				setState(626); match(74);
				}
				break;
			case 66:
				enterOuterAlt(_localctx, 31);
				{
				setState(627); match(66);
				}
				break;
			case 67:
				enterOuterAlt(_localctx, 32);
				{
				setState(628); match(67);
				}
				break;
			case 56:
				enterOuterAlt(_localctx, 33);
				{
				setState(629); match(56);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 34);
				{
				setState(630); match(6);
				}
				break;
			case 41:
				enterOuterAlt(_localctx, 35);
				{
				setState(631); match(41);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 36);
				{
				setState(632); match(39);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 37);
				{
				setState(633); match(13);
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 38);
				{
				setState(634); match(44);
				setState(635); match(17);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 39);
				{
				setState(636); match(4);
				setState(637); match(36);
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
		enterRule(_localctx, 118, RULE_assignment_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(640);
			_la = _input.LA(1);
			if ( !(((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & ((1L << (16 - 16)) | (1L << (26 - 16)) | (1L << (28 - 16)) | (1L << (37 - 16)) | (1L << (38 - 16)) | (1L << (45 - 16)) | (1L << (48 - 16)) | (1L << (51 - 16)) | (1L << (52 - 16)) | (1L << (69 - 16)) | (1L << (70 - 16)))) != 0)) ) {
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
		enterRule(_localctx, 120, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(642); match(ALPHA_NUMERIC);
			setState(647);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==24) {
				{
				{
				setState(643); match(24);
				setState(644); match(ALPHA_NUMERIC);
				}
				}
				setState(649);
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
		enterRule(_localctx, 122, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(650);
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
		enterRule(_localctx, 124, RULE_water);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(652);
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

	public static final String _serializedATN =
		"\2\3a\u0291\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\3\2\7\2\u0082\n\2\f\2\16\2\u0085\13"+
		"\2\3\3\3\3\5\3\u0089\n\3\3\4\3\4\3\4\5\4\u008e\n\4\3\5\5\5\u0091\n\5\3"+
		"\5\5\5\u0094\n\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\7\7\u00a7\n\7\f\7\16\7\u00aa\13\7\3\b\3\b\3\b\3\b\3\b\5"+
		"\b\u00b1\n\b\5\b\u00b3\n\b\3\t\3\t\3\t\7\t\u00b8\n\t\f\t\16\t\u00bb\13"+
		"\t\3\n\5\n\u00be\n\n\3\n\3\n\5\n\u00c2\n\n\3\n\3\n\5\n\u00c6\n\n\3\n\3"+
		"\n\3\n\5\n\u00cb\n\n\3\13\3\13\5\13\u00cf\n\13\3\13\5\13\u00d2\n\13\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u00de\n\r\f\r\16\r\u00e1"+
		"\13\r\3\16\5\16\u00e4\n\16\3\16\5\16\u00e7\n\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\7\17\u00f3\n\17\f\17\16\17\u00f6\13\17\3"+
		"\20\5\20\u00f9\n\20\3\20\3\20\5\20\u00fd\n\20\3\20\5\20\u0100\n\20\3\20"+
		"\3\20\3\21\5\21\u0105\n\21\3\21\5\21\u0108\n\21\3\21\3\21\3\21\5\21\u010d"+
		"\n\21\3\21\3\21\3\22\7\22\u0112\n\22\f\22\16\22\u0115\13\22\3\22\3\22"+
		"\3\22\7\22\u011a\n\22\f\22\16\22\u011d\13\22\3\22\7\22\u0120\n\22\f\22"+
		"\16\22\u0123\13\22\3\23\7\23\u0126\n\23\f\23\16\23\u0129\13\23\3\23\3"+
		"\23\3\23\5\23\u012e\n\23\3\23\3\23\3\23\3\23\3\23\5\23\u0135\n\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u013d\n\23\7\23\u013f\n\23\f\23\16\23\u0142"+
		"\13\23\3\23\5\23\u0145\n\23\3\24\3\24\3\24\3\24\3\24\5\24\u014c\n\24\3"+
		"\25\6\25\u014f\n\25\r\25\16\25\u0150\3\26\3\26\5\26\u0155\n\26\3\26\3"+
		"\26\7\26\u0159\n\26\f\26\16\26\u015c\13\26\3\26\5\26\u015f\n\26\3\27\3"+
		"\27\3\27\7\27\u0164\n\27\f\27\16\27\u0167\13\27\3\27\3\27\5\27\u016b\n"+
		"\27\3\27\5\27\u016e\n\27\3\30\3\30\3\30\3\31\5\31\u0174\n\31\3\31\3\31"+
		"\3\31\3\31\3\31\5\31\u017b\n\31\3\31\5\31\u017e\n\31\3\32\6\32\u0181\n"+
		"\32\r\32\16\32\u0182\3\33\5\33\u0186\n\33\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\34\5\34\u018f\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u0198\n"+
		"\35\f\35\16\35\u019b\13\35\5\35\u019d\n\35\3\35\5\35\u01a0\n\35\3\36\3"+
		"\36\5\36\u01a4\n\36\3\37\5\37\u01a7\n\37\3\37\3\37\3\37\3\37\3\37\5\37"+
		"\u01ae\n\37\5\37\u01b0\n\37\3\37\5\37\u01b3\n\37\3 \7 \u01b6\n \f \16"+
		" \u01b9\13 \3 \3 \3 \3 \7 \u01bf\n \f \16 \u01c2\13 \7 \u01c4\n \f \16"+
		" \u01c7\13 \3!\7!\u01ca\n!\f!\16!\u01cd\13!\3!\3!\3!\3!\7!\u01d3\n!\f"+
		"!\16!\u01d6\13!\7!\u01d8\n!\f!\16!\u01db\13!\3\"\3\"\7\"\u01df\n\"\f\""+
		"\16\"\u01e2\13\"\3\"\3\"\7\"\u01e6\n\"\f\"\16\"\u01e9\13\"\7\"\u01eb\n"+
		"\"\f\"\16\"\u01ee\13\"\3\"\3\"\3#\3#\5#\u01f4\n#\3$\3$\3$\3$\7$\u01fa"+
		"\n$\f$\16$\u01fd\13$\3%\3%\3%\3&\5&\u0203\n&\3&\3&\3\'\3\'\5\'\u0209\n"+
		"\'\3\'\3\'\3(\3(\3(\3(\3(\3(\5(\u0213\n(\3)\3)\3)\3)\3)\3*\7*\u021b\n"+
		"*\f*\16*\u021e\13*\3*\3*\3*\3*\7*\u0224\n*\f*\16*\u0227\13*\7*\u0229\n"+
		"*\f*\16*\u022c\13*\3+\3+\3+\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3"+
		"\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\3"+
		"8\38\39\39\3:\3:\3;\3;\3;\3<\3<\3<\5<\u0257\n<\3<\3<\3<\3<\3<\3<\3<\3"+
		"<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3"+
		"<\3<\3<\3<\3<\3<\3<\3<\3<\3<\5<\u0281\n<\3=\3=\3>\3>\3>\7>\u0288\n>\f"+
		">\16>\u028b\13>\3?\3?\3@\3@\3@\2A\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\2\27\4\25"+
		"\25\31\31\4\4\4\20\20\b\3\3\5\5\"\",,>>KK\4ZZ\\_\4\23\23..\b\6\6\r\r\23"+
		"\23&&..\63\63\5\23\23..CC\6\7\7\23\23..FF\4\r\r\63\63\4\6\6&&\5\6\6&&"+
		"CC\4++CC\4\35\35BB\6\24\24\26\27\67\6799\6\21\21  ##88\4\3\3\5\5\5**\60"+
		"\60??\4\37\37<<\n\22\22\34\34\36\36\'(//\62\62\65\66GH\3\\^\3aa\u02cf"+
		"\2\u0083\3\2\2\2\4\u0088\3\2\2\2\6\u008d\3\2\2\2\b\u0090\3\2\2\2\n\u0098"+
		"\3\2\2\2\f\u00a8\3\2\2\2\16\u00b2\3\2\2\2\20\u00b4\3\2\2\2\22\u00bd\3"+
		"\2\2\2\24\u00cc\3\2\2\2\26\u00d7\3\2\2\2\30\u00d9\3\2\2\2\32\u00e3\3\2"+
		"\2\2\34\u00f4\3\2\2\2\36\u00ff\3\2\2\2 \u0104\3\2\2\2\"\u0113\3\2\2\2"+
		"$\u0144\3\2\2\2&\u014b\3\2\2\2(\u014e\3\2\2\2*\u0152\3\2\2\2,\u016d\3"+
		"\2\2\2.\u016f\3\2\2\2\60\u0173\3\2\2\2\62\u0180\3\2\2\2\64\u0185\3\2\2"+
		"\2\66\u018e\3\2\2\28\u019f\3\2\2\2:\u01a1\3\2\2\2<\u01a6\3\2\2\2>\u01b7"+
		"\3\2\2\2@\u01cb\3\2\2\2B\u01dc\3\2\2\2D\u01f3\3\2\2\2F\u01f5\3\2\2\2H"+
		"\u01fe\3\2\2\2J\u0202\3\2\2\2L\u0206\3\2\2\2N\u0212\3\2\2\2P\u0214\3\2"+
		"\2\2R\u021c\3\2\2\2T\u022d\3\2\2\2V\u0232\3\2\2\2X\u0234\3\2\2\2Z\u0236"+
		"\3\2\2\2\\\u0238\3\2\2\2^\u023a\3\2\2\2`\u023c\3\2\2\2b\u023e\3\2\2\2"+
		"d\u0240\3\2\2\2f\u0242\3\2\2\2h\u0244\3\2\2\2j\u0246\3\2\2\2l\u0248\3"+
		"\2\2\2n\u024a\3\2\2\2p\u024c\3\2\2\2r\u024e\3\2\2\2t\u0250\3\2\2\2v\u0280"+
		"\3\2\2\2x\u0282\3\2\2\2z\u0284\3\2\2\2|\u028c\3\2\2\2~\u028e\3\2\2\2\u0080"+
		"\u0082\5\4\3\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2"+
		"\2\2\u0083\u0084\3\2\2\2\u0084\3\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0089"+
		"\5\6\4\2\u0087\u0089\5~@\2\u0088\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089"+
		"\5\3\2\2\2\u008a\u008e\5\b\5\2\u008b\u008e\5 \21\2\u008c\u008e\5T+\2\u008d"+
		"\u008a\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e\7\3\2\2\2"+
		"\u008f\u0091\7A\2\2\u0090\u008f\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093"+
		"\3\2\2\2\u0092\u0094\5\n\6\2\u0093\u0092\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\u0095\3\2\2\2\u0095\u0096\5\16\b\2\u0096\u0097\7C\2\2\u0097\t\3\2\2\2"+
		"\u0098\u0099\7\33\2\2\u0099\u009a\7\7\2\2\u009a\u009b\5\f\7\2\u009b\u009c"+
		"\7F\2\2\u009c\13\3\2\2\2\u009d\u009e\7\7\2\2\u009e\u009f\5\f\7\2\u009f"+
		"\u00a0\7F\2\2\u00a0\u00a7\3\2\2\2\u00a1\u00a2\7.\2\2\u00a2\u00a3\5\f\7"+
		"\2\u00a3\u00a4\7\23\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a7\5`\61\2\u00a6"+
		"\u009d\3\2\2\2\u00a6\u00a1\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa\3\2"+
		"\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\r\3\2\2\2\u00aa\u00a8"+
		"\3\2\2\2\u00ab\u00ac\5$\23\2\u00ac\u00ad\5\20\t\2\u00ad\u00b3\3\2\2\2"+
		"\u00ae\u00b0\5\24\13\2\u00af\u00b1\5\20\t\2\u00b0\u00af\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00ab\3\2\2\2\u00b2\u00ae\3\2"+
		"\2\2\u00b3\17\3\2\2\2\u00b4\u00b9\5\22\n\2\u00b5\u00b6\7+\2\2\u00b6\u00b8"+
		"\5\22\n\2\u00b7\u00b5\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2"+
		"\u00b9\u00ba\3\2\2\2\u00ba\21\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00be"+
		"\5\62\32\2\u00bd\u00bc\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\3\2\2\2"+
		"\u00bf\u00c1\5z>\2\u00c0\u00c2\5\66\34\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2"+
		"\3\2\2\2\u00c2\u00ca\3\2\2\2\u00c3\u00c5\7.\2\2\u00c4\u00c6\5@!\2\u00c5"+
		"\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00cb\7\23"+
		"\2\2\u00c8\u00c9\7\34\2\2\u00c9\u00cb\5(\25\2\u00ca\u00c3\3\2\2\2\u00ca"+
		"\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\23\3\2\2\2\u00cc\u00ce\5n8\2"+
		"\u00cd\u00cf\5\26\f\2\u00ce\u00cd\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1"+
		"\3\2\2\2\u00d0\u00d2\5\30\r\2\u00d1\u00d0\3\2\2\2\u00d1\u00d2\3\2\2\2"+
		"\u00d2\u00d3\3\2\2\2\u00d3\u00d4\7\63\2\2\u00d4\u00d5\5\34\17\2\u00d5"+
		"\u00d6\7\r\2\2\u00d6\25\3\2\2\2\u00d7\u00d8\5z>\2\u00d8\27\3\2\2\2\u00d9"+
		"\u00da\7-\2\2\u00da\u00df\5\32\16\2\u00db\u00dc\7+\2\2\u00dc\u00de\5\32"+
		"\16\2\u00dd\u00db\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\31\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e4\7\24\2"+
		"\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00e7"+
		"\5r:\2\u00e6\u00e5\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8"+
		"\u00e9\5z>\2\u00e9\33\3\2\2\2\u00ea\u00f3\5\b\5\2\u00eb\u00f3\5 \21\2"+
		"\u00ec\u00f3\5\36\20\2\u00ed\u00ee\7\63\2\2\u00ee\u00ef\5\34\17\2\u00ef"+
		"\u00f0\7\r\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00f3\5b\62\2\u00f2\u00ea\3\2"+
		"\2\2\u00f2\u00eb\3\2\2\2\u00f2\u00ec\3\2\2\2\u00f2\u00ed\3\2\2\2\u00f2"+
		"\u00f1\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2"+
		"\2\2\u00f5\35\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f9\7V\2\2\u00f8\u00f7"+
		"\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00fd\5z>\2\u00fb"+
		"\u00fd\5|?\2\u00fc\u00fa\3\2\2\2\u00fc\u00fb\3\2\2\2\u00fd\u0100\3\2\2"+
		"\2\u00fe\u0100\5r:\2\u00ff\u00f8\3\2\2\2\u00ff\u00fe\3\2\2\2\u0100\u0101"+
		"\3\2\2\2\u0101\u0102\7-\2\2\u0102\37\3\2\2\2\u0103\u0105\5\n\6\2\u0104"+
		"\u0103\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u0108\5\""+
		"\22\2\u0107\u0106\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u010a\5N(\2\u010a\u010c\5*\26\2\u010b\u010d\5F$\2\u010c\u010b\3\2\2\2"+
		"\u010c\u010d\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\5B\"\2\u010f!\3\2"+
		"\2\2\u0110\u0112\5l\67\2\u0111\u0110\3\2\2\2\u0112\u0115\3\2\2\2\u0113"+
		"\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0116\3\2\2\2\u0115\u0113\3\2"+
		"\2\2\u0116\u0117\5$\23\2\u0117\u011b\3\2\2\2\u0118\u011a\5l\67\2\u0119"+
		"\u0118\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2"+
		"\2\2\u011c\u0121\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u0120\5p9\2\u011f\u011e"+
		"\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"#\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0126\5j\66\2\u0125\u0124\3\2\2\2"+
		"\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012d"+
		"\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012e\5n8\2\u012b\u012e\7\31\2\2\u012c"+
		"\u012e\7\25\2\2\u012d\u012a\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012c\3"+
		"\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0134\5&\24\2\u0130"+
		"\u0131\7\7\2\2\u0131\u0132\5\f\7\2\u0132\u0133\7F\2\2\u0133\u0135\3\2"+
		"\2\2\u0134\u0130\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0140\3\2\2\2\u0136"+
		"\u0137\7\32\2\2\u0137\u013c\5&\24\2\u0138\u0139\7\7\2\2\u0139\u013a\5"+
		"\f\7\2\u013a\u013b\7F\2\2\u013b\u013d\3\2\2\2\u013c\u0138\3\2\2\2\u013c"+
		"\u013d\3\2\2\2\u013d\u013f\3\2\2\2\u013e\u0136\3\2\2\2\u013f\u0142\3\2"+
		"\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0145\3\2\2\2\u0142"+
		"\u0140\3\2\2\2\u0143\u0145\t\2\2\2\u0144\u0127\3\2\2\2\u0144\u0143\3\2"+
		"\2\2\u0145%\3\2\2\2\u0146\u014c\7W\2\2\u0147\u014c\7\61\2\2\u0148\u014c"+
		"\7$\2\2\u0149\u014a\7$\2\2\u014a\u014c\7$\2\2\u014b\u0146\3\2\2\2\u014b"+
		"\u0147\3\2\2\2\u014b\u0148\3\2\2\2\u014b\u0149\3\2\2\2\u014c\'\3\2\2\2"+
		"\u014d\u014f\5h\65\2\u014e\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u014e"+
		"\3\2\2\2\u0150\u0151\3\2\2\2\u0151)\3\2\2\2\u0152\u0154\7.\2\2\u0153\u0155"+
		"\5,\27\2\u0154\u0153\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0156\3\2\2\2\u0156"+
		"\u015a\7\23\2\2\u0157\u0159\5j\66\2\u0158\u0157\3\2\2\2\u0159\u015c\3"+
		"\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015e\3\2\2\2\u015c"+
		"\u015a\3\2\2\2\u015d\u015f\5P)\2\u015e\u015d\3\2\2\2\u015e\u015f\3\2\2"+
		"\2\u015f+\3\2\2\2\u0160\u0165\5.\30\2\u0161\u0162\7+\2\2\u0162\u0164\5"+
		".\30\2\u0163\u0161\3\2\2\2\u0164\u0167\3\2\2\2\u0165\u0163\3\2\2\2\u0165"+
		"\u0166\3\2\2\2\u0166\u016a\3\2\2\2\u0167\u0165\3\2\2\2\u0168\u0169\7+"+
		"\2\2\u0169\u016b\7\64\2\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b"+
		"\u016e\3\2\2\2\u016c\u016e\7\61\2\2\u016d\u0160\3\2\2\2\u016d\u016c\3"+
		"\2\2\2\u016e-\3\2\2\2\u016f\u0170\5\64\33\2\u0170\u0171\5\60\31\2\u0171"+
		"/\3\2\2\2\u0172\u0174\5\62\32\2\u0173\u0172\3\2\2\2\u0173\u0174\3\2\2"+
		"\2\u0174\u017a\3\2\2\2\u0175\u0176\7.\2\2\u0176\u0177\5\60\31\2\u0177"+
		"\u0178\7\23\2\2\u0178\u017b\3\2\2\2\u0179\u017b\5D#\2\u017a\u0175\3\2"+
		"\2\2\u017a\u0179\3\2\2\2\u017b\u017d\3\2\2\2\u017c\u017e\5\66\34\2\u017d"+
		"\u017c\3\2\2\2\u017d\u017e\3\2\2\2\u017e\61\3\2\2\2\u017f\u0181\5p9\2"+
		"\u0180\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183"+
		"\3\2\2\2\u0183\63\3\2\2\2\u0184\u0186\t\3\2\2\u0185\u0184\3\2\2\2\u0185"+
		"\u0186\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0188\5$\23\2\u0188\65\3\2\2"+
		"\2\u0189\u018a\7\6\2\2\u018a\u018b\5> \2\u018b\u018c\7&\2\2\u018c\u018f"+
		"\3\2\2\2\u018d\u018f\58\35\2\u018e\u0189\3\2\2\2\u018e\u018d\3\2\2\2\u018f"+
		"\67\3\2\2\2\u0190\u0191\7.\2\2\u0191\u0192\7\61\2\2\u0192\u01a0\7\23\2"+
		"\2\u0193\u019c\7.\2\2\u0194\u0199\5:\36\2\u0195\u0196\7+\2\2\u0196\u0198"+
		"\5:\36\2\u0197\u0195\3\2\2\2\u0198\u019b\3\2\2\2\u0199\u0197\3\2\2\2\u0199"+
		"\u019a\3\2\2\2\u019a\u019d\3\2\2\2\u019b\u0199\3\2\2\2\u019c\u0194\3\2"+
		"\2\2\u019c\u019d\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u01a0\7\23\2\2\u019f"+
		"\u0190\3\2\2\2\u019f\u0193\3\2\2\2\u01a09\3\2\2\2\u01a1\u01a3\5\64\33"+
		"\2\u01a2\u01a4\5<\37\2\u01a3\u01a2\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4;"+
		"\3\2\2\2\u01a5\u01a7\5\62\32\2\u01a6\u01a5\3\2\2\2\u01a6\u01a7\3\2\2\2"+
		"\u01a7\u01af\3\2\2\2\u01a8\u01a9\7.\2\2\u01a9\u01aa\5<\37\2\u01aa\u01ab"+
		"\7\23\2\2\u01ab\u01b0\3\2\2\2\u01ac\u01ae\5D#\2\u01ad\u01ac\3\2\2\2\u01ad"+
		"\u01ae\3\2\2\2\u01ae\u01b0\3\2\2\2\u01af\u01a8\3\2\2\2\u01af\u01ad\3\2"+
		"\2\2\u01b0\u01b2\3\2\2\2\u01b1\u01b3\5\66\34\2\u01b2\u01b1\3\2\2\2\u01b2"+
		"\u01b3\3\2\2\2\u01b3=\3\2\2\2\u01b4\u01b6\5d\63\2\u01b5\u01b4\3\2\2\2"+
		"\u01b6\u01b9\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01c5"+
		"\3\2\2\2\u01b9\u01b7\3\2\2\2\u01ba\u01bb\7\6\2\2\u01bb\u01bc\5> \2\u01bc"+
		"\u01c0\7&\2\2\u01bd\u01bf\5d\63\2\u01be\u01bd\3\2\2\2\u01bf\u01c2\3\2"+
		"\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c4\3\2\2\2\u01c2"+
		"\u01c0\3\2\2\2\u01c3\u01ba\3\2\2\2\u01c4\u01c7\3\2\2\2\u01c5\u01c3\3\2"+
		"\2\2\u01c5\u01c6\3\2\2\2\u01c6?\3\2\2\2\u01c7\u01c5\3\2\2\2\u01c8\u01ca"+
		"\5Z.\2\u01c9\u01c8\3\2\2\2\u01ca\u01cd\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cb"+
		"\u01cc\3\2\2\2\u01cc\u01d9\3\2\2\2\u01cd\u01cb\3\2\2\2\u01ce\u01cf\7."+
		"\2\2\u01cf\u01d0\5@!\2\u01d0\u01d4\7\23\2\2\u01d1\u01d3\5Z.\2\u01d2\u01d1"+
		"\3\2\2\2\u01d3\u01d6\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5"+
		"\u01d8\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d7\u01ce\3\2\2\2\u01d8\u01db\3\2"+
		"\2\2\u01d9\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01daA\3\2\2\2\u01db\u01d9"+
		"\3\2\2\2\u01dc\u01e0\7\63\2\2\u01dd\u01df\5b\62\2\u01de\u01dd\3\2\2\2"+
		"\u01df\u01e2\3\2\2\2\u01e0\u01de\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01ec"+
		"\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e3\u01e7\5B\"\2\u01e4\u01e6\5b\62\2\u01e5"+
		"\u01e4\3\2\2\2\u01e6\u01e9\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e7\u01e8\3\2"+
		"\2\2\u01e8\u01eb\3\2\2\2\u01e9\u01e7\3\2\2\2\u01ea\u01e3\3\2\2\2\u01eb"+
		"\u01ee\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01ef\3\2"+
		"\2\2\u01ee\u01ec\3\2\2\2\u01ef\u01f0\7\r\2\2\u01f0C\3\2\2\2\u01f1\u01f4"+
		"\5z>\2\u01f2\u01f4\5r:\2\u01f3\u01f1\3\2\2\2\u01f3\u01f2\3\2\2\2\u01f4"+
		"E\3\2\2\2\u01f5\u01f6\7-\2\2\u01f6\u01fb\5H%\2\u01f7\u01f8\7+\2\2\u01f8"+
		"\u01fa\5H%\2\u01f9\u01f7\3\2\2\2\u01fa\u01fd\3\2\2\2\u01fb\u01f9\3\2\2"+
		"\2\u01fb\u01fc\3\2\2\2\u01fcG\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fe\u01ff"+
		"\5J&\2\u01ff\u0200\5L\'\2\u0200I\3\2\2\2\u0201\u0203\7\32\2\2\u0202\u0201"+
		"\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0205\5z>\2\u0205"+
		"K\3\2\2\2\u0206\u0208\7.\2\2\u0207\u0209\5@!\2\u0208\u0207\3\2\2\2\u0208"+
		"\u0209\3\2\2\2\u0209\u020a\3\2\2\2\u020a\u020b\7\23\2\2\u020bM\3\2\2\2"+
		"\u020c\u020d\7.\2\2\u020d\u020e\5N(\2\u020e\u020f\7\23\2\2\u020f\u0213"+
		"\3\2\2\2\u0210\u0213\5z>\2\u0211\u0213\5t;\2\u0212\u020c\3\2\2\2\u0212"+
		"\u0210\3\2\2\2\u0212\u0211\3\2\2\2\u0213O\3\2\2\2\u0214\u0215\7\30\2\2"+
		"\u0215\u0216\7.\2\2\u0216\u0217\5R*\2\u0217\u0218\7\23\2\2\u0218Q\3\2"+
		"\2\2\u0219\u021b\5Z.\2\u021a\u0219\3\2\2\2\u021b\u021e\3\2\2\2\u021c\u021a"+
		"\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u022a\3\2\2\2\u021e\u021c\3\2\2\2\u021f"+
		"\u0220\7.\2\2\u0220\u0221\5R*\2\u0221\u0225\7\23\2\2\u0222\u0224\5Z.\2"+
		"\u0223\u0222\3\2\2\2\u0224\u0227\3\2\2\2\u0225\u0223\3\2\2\2\u0225\u0226"+
		"\3\2\2\2\u0226\u0229\3\2\2\2\u0227\u0225\3\2\2\2\u0228\u021f\3\2\2\2\u0229"+
		"\u022c\3\2\2\2\u022a\u0228\3\2\2\2\u022a\u022b\3\2\2\2\u022bS\3\2\2\2"+
		"\u022c\u022a\3\2\2\2\u022d\u022e\7%\2\2\u022e\u022f\7\f\2\2\u022f\u0230"+
		"\5z>\2\u0230\u0231\7C\2\2\u0231U\3\2\2\2\u0232\u0233\t\4\2\2\u0233W\3"+
		"\2\2\2\u0234\u0235\t\5\2\2\u0235Y\3\2\2\2\u0236\u0237\n\6\2\2\u0237[\3"+
		"\2\2\2\u0238\u0239\n\7\2\2\u0239]\3\2\2\2\u023a\u023b\n\b\2\2\u023b_\3"+
		"\2\2\2\u023c\u023d\n\t\2\2\u023da\3\2\2\2\u023e\u023f\n\n\2\2\u023fc\3"+
		"\2\2\2\u0240\u0241\n\13\2\2\u0241e\3\2\2\2\u0242\u0243\n\f\2\2\u0243g"+
		"\3\2\2\2\u0244\u0245\n\r\2\2\u0245i\3\2\2\2\u0246\u0247\t\16\2\2\u0247"+
		"k\3\2\2\2\u0248\u0249\t\17\2\2\u0249m\3\2\2\2\u024a\u024b\t\20\2\2\u024b"+
		"o\3\2\2\2\u024c\u024d\t\21\2\2\u024dq\3\2\2\2\u024e\u024f\t\22\2\2\u024f"+
		"s\3\2\2\2\u0250\u0251\7@\2\2\u0251\u0252\5v<\2\u0252u\3\2\2\2\u0253\u0256"+
		"\t\23\2\2\u0254\u0255\7\6\2\2\u0255\u0257\7&\2\2\u0256\u0254\3\2\2\2\u0256"+
		"\u0257\3\2\2\2\u0257\u0281\3\2\2\2\u0258\u0281\7>\2\2\u0259\u0281\7,\2"+
		"\2\u025a\u0281\7\5\2\2\u025b\u0281\7I\2\2\u025c\u0281\7\16\2\2\u025d\u0281"+
		"\7=\2\2\u025e\u0281\7\3\2\2\u025f\u0281\7!\2\2\u0260\u0281\7K\2\2\u0261"+
		"\u0281\7\"\2\2\u0262\u0281\7\34\2\2\u0263\u0281\7\7\2\2\u0264\u0281\7"+
		"F\2\2\u0265\u0281\7\65\2\2\u0266\u0281\7(\2\2\u0267\u0281\7\22\2\2\u0268"+
		"\u0281\7H\2\2\u0269\u0281\7G\2\2\u026a\u0281\7\66\2\2\u026b\u0281\7/\2"+
		"\2\u026c\u0281\7\36\2\2\u026d\u0281\7;\2\2\u026e\u0281\7\13\2\2\u026f"+
		"\u0281\7\62\2\2\u0270\u0281\7\'\2\2\u0271\u0281\7J\2\2\u0272\u0281\7\t"+
		"\2\2\u0273\u0281\7\n\2\2\u0274\u0281\7L\2\2\u0275\u0281\7D\2\2\u0276\u0281"+
		"\7E\2\2\u0277\u0281\7:\2\2\u0278\u0281\7\b\2\2\u0279\u0281\7+\2\2\u027a"+
		"\u0281\7)\2\2\u027b\u0281\7\17\2\2\u027c\u027d\7.\2\2\u027d\u0281\7\23"+
		"\2\2\u027e\u027f\7\6\2\2\u027f\u0281\7&\2\2\u0280\u0253\3\2\2\2\u0280"+
		"\u0258\3\2\2\2\u0280\u0259\3\2\2\2\u0280\u025a\3\2\2\2\u0280\u025b\3\2"+
		"\2\2\u0280\u025c\3\2\2\2\u0280\u025d\3\2\2\2\u0280\u025e\3\2\2\2\u0280"+
		"\u025f\3\2\2\2\u0280\u0260\3\2\2\2\u0280\u0261\3\2\2\2\u0280\u0262\3\2"+
		"\2\2\u0280\u0263\3\2\2\2\u0280\u0264\3\2\2\2\u0280\u0265\3\2\2\2\u0280"+
		"\u0266\3\2\2\2\u0280\u0267\3\2\2\2\u0280\u0268\3\2\2\2\u0280\u0269\3\2"+
		"\2\2\u0280\u026a\3\2\2\2\u0280\u026b\3\2\2\2\u0280\u026c\3\2\2\2\u0280"+
		"\u026d\3\2\2\2\u0280\u026e\3\2\2\2\u0280\u026f\3\2\2\2\u0280\u0270\3\2"+
		"\2\2\u0280\u0271\3\2\2\2\u0280\u0272\3\2\2\2\u0280\u0273\3\2\2\2\u0280"+
		"\u0274\3\2\2\2\u0280\u0275\3\2\2\2\u0280\u0276\3\2\2\2\u0280\u0277\3\2"+
		"\2\2\u0280\u0278\3\2\2\2\u0280\u0279\3\2\2\2\u0280\u027a\3\2\2\2\u0280"+
		"\u027b\3\2\2\2\u0280\u027c\3\2\2\2\u0280\u027e\3\2\2\2\u0281w\3\2\2\2"+
		"\u0282\u0283\t\24\2\2\u0283y\3\2\2\2\u0284\u0289\7W\2\2\u0285\u0286\7"+
		"\32\2\2\u0286\u0288\7W\2\2\u0287\u0285\3\2\2\2\u0288\u028b\3\2\2\2\u0289"+
		"\u0287\3\2\2\2\u0289\u028a\3\2\2\2\u028a{\3\2\2\2\u028b\u0289\3\2\2\2"+
		"\u028c\u028d\t\25\2\2\u028d}\3\2\2\2\u028e\u028f\n\26\2\2\u028f\177\3"+
		"\2\2\2P\u0083\u0088\u008d\u0090\u0093\u00a6\u00a8\u00b0\u00b2\u00b9\u00bd"+
		"\u00c1\u00c5\u00ca\u00ce\u00d1\u00df\u00e3\u00e6\u00f2\u00f4\u00f8\u00fc"+
		"\u00ff\u0104\u0107\u010c\u0113\u011b\u0121\u0127\u012d\u0134\u013c\u0140"+
		"\u0144\u014b\u0150\u0154\u015a\u015e\u0165\u016a\u016d\u0173\u017a\u017d"+
		"\u0182\u0185\u018e\u0199\u019c\u019f\u01a3\u01a6\u01ad\u01af\u01b2\u01b7"+
		"\u01c0\u01c5\u01cb\u01d4\u01d9\u01e0\u01e7\u01ec\u01f3\u01fb\u0202\u0208"+
		"\u0212\u021c\u0225\u022a\u0256\u0280\u0289";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}
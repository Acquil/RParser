package com.mycompany.rparser;

// Generated from RemoveWhiteSpace.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RemoveWhiteSpace}.
 */
public interface RemoveWhiteSpaceListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RemoveWhiteSpace#stream}.
	 * @param ctx the parse tree
	 */
	void enterStream(RemoveWhiteSpace.StreamContext ctx);
	/**
	 * Exit a parse tree produced by {@link RemoveWhiteSpace#stream}.
	 * @param ctx the parse tree
	 */
	void exitStream(RemoveWhiteSpace.StreamContext ctx);
	/**
	 * Enter a parse tree produced by {@link RemoveWhiteSpace#eat}.
	 * @param ctx the parse tree
	 */
	void enterEat(RemoveWhiteSpace.EatContext ctx);
	/**
	 * Exit a parse tree produced by {@link RemoveWhiteSpace#eat}.
	 * @param ctx the parse tree
	 */
	void exitEat(RemoveWhiteSpace.EatContext ctx);
	/**
	 * Enter a parse tree produced by {@link RemoveWhiteSpace#elem}.
	 * @param ctx the parse tree
	 */
	void enterElem(RemoveWhiteSpace.ElemContext ctx);
	/**
	 * Exit a parse tree produced by {@link RemoveWhiteSpace#elem}.
	 * @param ctx the parse tree
	 */
	void exitElem(RemoveWhiteSpace.ElemContext ctx);
	/**
	 * Enter a parse tree produced by {@link RemoveWhiteSpace#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(RemoveWhiteSpace.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link RemoveWhiteSpace#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(RemoveWhiteSpace.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link RemoveWhiteSpace#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(RemoveWhiteSpace.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link RemoveWhiteSpace#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(RemoveWhiteSpace.OpContext ctx);
}
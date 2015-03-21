package hudson.plugins.ast.specific;

import java.util.List;

import com.puppycrawl.tools.checkstyle.api.DetailAST;

import hudson.plugins.ast.factory.Ast;

/**
 * Creates the abstract syntax tree for the whole file.
 *
 * @author Christian Möstl
 */
public class FileAst extends Ast {
    /**
     * Creates a new instance of {@link FileAst}.
     *
     * @param fileName   the name of the Java file
     * @param lineNumber the line number that contains the warning
     */
    public FileAst(final String fileName, final int lineNumber) {
        super(fileName, lineNumber);
    }

    @Override
    public List<DetailAST> chooseArea() {
        runThroughAST(getAbstractSyntaxTree());

        return getAllElements();
    }
}
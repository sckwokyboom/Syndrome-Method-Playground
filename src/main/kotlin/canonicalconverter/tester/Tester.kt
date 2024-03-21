package canonicalconverter.tester

import Matrix

interface MatrixTester {
    fun test(vararg matrices: Matrix): Boolean
}
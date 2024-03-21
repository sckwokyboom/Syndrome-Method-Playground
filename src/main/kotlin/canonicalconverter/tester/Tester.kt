package canonicalconverter.tester

import canonicalconverter.Matrix

interface MatrixTester {
    fun test(vararg matrices: Matrix): Boolean
}
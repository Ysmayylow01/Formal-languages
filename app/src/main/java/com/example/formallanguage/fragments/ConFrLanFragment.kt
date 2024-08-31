package com.example.formallanguage.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.formallanguage.R
import com.example.formallanguage.adapter.PAdapter
import com.example.formallanguage.model.PModel
import java.util.*
import kotlin.collections.ArrayList

class ConFrLanFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView : androidx.appcompat.widget.SearchView
    private var itemList = ArrayList<PModel>()
    private lateinit var PAdapter : PAdapter
    private lateinit var adapter: PAdapter



    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_con_fr_lan, container, false)



        recyclerView = view.findViewById(R.id.recyclerView)
        searchView = view.findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        addDataToList()




        searchView.setOnQueryTextListener(object: androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
        return view
    }
    private fun filterList(query: String?) {
        if (query != null) {
            val filteredList = ArrayList<PModel>()
            for (i in itemList) {
                if (i.name.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
                else  {

                }
            }

            if (filteredList.isEmpty()) {
                adapter.setFilteredList(filteredList)


            }
            else {
                adapter.setFilteredList(filteredList)
            }

        }}
    private fun addDataToList() {
        itemList = ArrayList()
        itemList.add(
            PModel("Deterministic Finite Automata (DFA)","Deterministic Finite Automata (DFA) are a type of finite automaton used to recognize and accept or reject strings belonging to a regular language. DFAs are deterministic in the sense that for every input symbol, there is a unique transition to the next state.\n" +
                    "\n" +
                    "A DFA consists of the following components:\n" +
                    "\n" +
                    "Set of States (Q):\n" +
                    "A finite set of states represents the possible configurations the automaton can be in. Each state is uniquely identified and has a specific meaning or role in the automaton.\n" +
                    "\n" +
                    "Alphabet (Σ):\n" +
                    "An alphabet is a finite set of symbols or input characters that the DFA reads from the input string. These symbols are the valid inputs that the DFA can process.\n" +
                    "\n" +
                    "Transition Function (δ):\n" +
                    "The transition function defines the behavior of the DFA. It specifies the next state based on the current state and the input symbol. For a DFA, the transition function is deterministic, meaning that for each state and input symbol, there is only one possible next state.\n" +
                    "\n" +
                    "The transition function is defined as follows:\n" +
                    "δ: Q × Σ → Q\n" +
                    "\n" +
                    "Start State (q0):\n" +
                    "The start state is the initial state of the DFA. It represents the configuration of the automaton before processing any input symbols. Once the DFA starts, it reads the input string from left to right.\n" +
                    "\n" +
                    "Set of Accept States (F):\n" +
                    "The set of accept states comprises the final or accepting states of the DFA. When the DFA reaches an accept state after processing the entire input string, it signifies that the string belongs to the language recognized by the DFA.\n" +
                    "\n" +
                    "The formal definition of a DFA is a 5-tuple (Q, Σ, δ, q0, F), where:\n" +
                    "\n" +
                    "Q is the set of states,\n" +
                    "Σ is the input alphabet,\n" +
                    "δ is the transition function,\n" +
                    "q0 is the start state, and\n" +
                    "F is the set of accept states.\n" +
                    "To recognize a string using a DFA, you start from the start state and process each input symbol according to the transition function. Once the entire string is processed, if the DFA is in an accept state, the string is accepted; otherwise, it is rejected.\n" +
                    "\n" +
                    "DFAs are particularly useful for pattern matching, lexical analysis, and simple language recognition tasks. They are easy to implement and have efficient time complexity, making them suitable for many practical applications.")
        )
        itemList.add(
            PModel("Context-free grammars","Context-free grammars (CFGs) are a formal notation used to describe context-free languages. They consist of a set of production rules that specify how to rewrite non-terminal symbols into strings of terminal and/or non-terminal symbols. CFGs are widely used in computer science and linguistics to define the syntax of programming languages, formal languages, and natural languages.\n" +
                    "\n" +
                    "A context-free grammar consists of four components:\n" +
                    "\n" +
                    "Terminals: These are the basic symbols or tokens that appear in the language. They are the smallest units of the language and cannot be further divided. Examples of terminals in a programming language might include keywords, operators, punctuation marks, and literals.\n" +
                    "\n" +
                    "Non-terminals: These are symbols that represent a group of related strings in the language. Non-terminals are placeholders that can be replaced by a sequence of terminals and/or other non-terminals using production rules. Non-terminals help define the structure and composition of the language.\n" +
                    "\n" +
                    "Production Rules: Production rules describe the possible replacements or rewrites that can be applied to non-terminal symbols. Each production rule consists of a non-terminal symbol on the left-hand side, an arrow symbol (->), and a sequence of terminals and/or non-terminals on the right-hand side. Production rules define how non-terminals can be expanded or rewritten into other symbols.\n" +
                    "\n" +
                    "Start Symbol: The start symbol is a special non-terminal that represents the initial symbol from which the derivation of strings in the language begins. It is usually denoted by S.\n" +
                    "\n" +
                    "Here's an example of a context-free grammar for a simple arithmetic expression language:\n" +
                    "\n" +
                    "Terminals: {+, -, *, /, (, ), digits}\n" +
                    "Non-terminals: {E, T, F}\n" +
                    "Production Rules:\n" +
                    "E -> E + T\n" +
                    "E -> E - T\n" +
                    "E -> T\n" +
                    "T -> T * F\n" +
                    "T -> T / F\n" +
                    "T -> F\n" +
                    "F -> (E)\n" +
                    "F -> digits\n" +
                    "In this grammar, E represents an arithmetic expression, T represents a term, and F represents a factor. The production rules define how expressions, terms, and factors can be constructed. For example, the rule E -> E + T states that an expression can be expanded by adding a term to it.\n" +
                    "\n" +
                    "Using this grammar, we can derive valid arithmetic expressions. Starting with the start symbol E, we can apply the production rules to generate expressions. For instance:\n" +
                    "\n" +
                    "E -> E + T -> E + T * F -> T + T * F -> F + T * F -> (E) + T * F -> (E) + F * F -> (digits) + F * F -> (digits) + digits * F -> (digits) + digits * digits\n" +
                    "\n" +
                    "The resulting string \"(digits) + digits * digits\" is a valid arithmetic expression in the language described by the context-free grammar.\n" +
                    "\n" +
                    "Context-free grammars provide a formal and systematic way to define the syntax of languages, making them essential in parsing, compiler design, natural language processing, and other areas of computer science.")
        )
        itemList.add(
            PModel("Derivation trees","Derivation trees, also known as parse trees or syntax trees, are graphical representations of the derivation process in a context-free grammar. They provide a visual depiction of how a string in a language can be derived by applying production rules from the grammar.\n" +
                    "\n" +
                    "A derivation tree is a rooted tree where each node represents a symbol (either a terminal or non-terminal) in the grammar. The root of the tree corresponds to the start symbol, and the leaves correspond to the terminals in the derived string. Non-terminals are represented by interior nodes, and the edges of the tree represent the application of production rules.\n" +
                    "\n" +
                    "To construct a derivation tree for a given string, you start with the start symbol at the root. Then, for each step in the derivation process, you expand a non-terminal symbol using a production rule. This expansion is represented by creating child nodes for the non-terminal and connecting them to the parent node. This process continues until all non-terminals are replaced by terminals, resulting in the derived string.\n" +
                    "\n" +
                    "Here's an example to illustrate the concept. Consider the following context-free grammar:\n" +
                    "\n" +
                    "Terminals: {a, b}\n" +
                    "Non-terminals: {S}\n" +
                    "Production Rules:\n" +
                    "S -> aSb\n" +
                    "S -> ε\n" +
                    "Let's derive the string \"aabbb\" using this grammar and construct a derivation tree:\n" +
                    "\n" +
                    "Start with the start symbol S as the root of the tree.\n" +
                    "Apply the production rule S -> aSb, expanding the non-terminal S.\n" +
                    "Create child nodes for the symbols \"a\" and \"S\", connecting them to the root node.\n" +
                    "Apply the production rule S -> aSb again, expanding the non-terminal S in the second child node.\n" +
                    "Create child nodes for the symbols \"a\" and \"S\", connecting them to the second child node.\n" +
                    "Apply the production rule S -> ε, expanding the non-terminal S in the second child node.\n" +
                    "Create a child node for the symbol \"ε\", connecting it to the second child node.\n" +
                    "The derivation is complete, and we have derived the string \"aabbb\".Derivation trees are useful for understanding the structure " +
                    "of derived strings, analyzing syntax, and building parsers for context-free grammars. They provide a visual representation that aids in the interpretation and manipulation of language constructs.")
        )
        itemList.add(
            PModel("Simplifying context-free grammars","Simplifying context-free grammars is a common task in formal language theory and compiler design. By simplifying a context-free grammar, we aim to reduce its size or complexity while preserving the language it generates. This can make the grammar easier to understand, analyze, and use in various applications. Here are some techniques for simplifying context-free grammars:\n" +
                    "\n" +
                    "Eliminating Useless Symbols:\n" +
                    "\n" +
                    "Remove unreachable symbols: Identify non-terminals and terminals that cannot be reached from the start symbol. Remove those symbols and any associated productions.\n" +
                    "Remove non-generating symbols: Identify non-terminals that cannot derive any terminal string. Remove those non-terminals and any productions involving them.\n" +
                    "Remove non-reachable symbols: Identify non-terminals and terminals that cannot derive or be reached from the start symbol in any derivation. Remove those symbols and any associated productions.\n" +
                    "Removing ε-Productions:\n" +
                    "\n" +
                    "Identify ε-productions: An ε-production is a production where the right-hand side is empty (ε). Identify such productions in the grammar.\n" +
                    "Eliminate ε-productions: For each ε-production A -> ε, remove it from the grammar. Then, for each production containing A on the right-hand side, create new productions where A is removed, and all combinations of the remaining symbols are generated. Repeat this process until no more ε-productions remain.\n" +
                    "Removing Unit Productions:\n" +
                    "\n" +
                    "Identify unit productions: A unit production is a production where the right-hand side consists of a single non-terminal symbol. Identify all unit productions in the grammar.\n" +
                    "Eliminate unit productions: For each unit production A -> B, where A and B are non-terminals, replace all occurrences of A with B in the grammar, including in the right-hand side of other productions. Repeat this process until no more unit productions remain.\n" +
                    "Left-Factoring Productions:\n" +
                    "\n" +
                    "Identify common prefixes: Look for common prefixes in the right-hand sides of productions for the same non-terminal. For example, if you have A -> αβ and A -> αγ, where α is a common prefix, you can left-factor the productions.\n" +
                    "Left-factor the productions: Create a new non-terminal symbol for the common prefix and introduce new productions. For example, replace the original productions with A -> αA' and A' -> β | γ.\n" +
                    "Merging Equivalent Productions:\n" +
                    "\n" +
                    "Identify equivalent productions: Productions that have the same non-terminal on the left-hand side and produce the same strings can be merged.\n" +
                    "Merge equivalent productions: Combine the equivalent productions into a single production, using the '|' symbol to represent multiple alternatives.\n" +
                    "These techniques help simplify context-free grammars by reducing redundancy, eliminating unreachable or useless symbols, and removing ε-productions and unit productions. It is important to note that while these simplification techniques make the grammar more concise and manageable, they should be applied carefully to ensure that the resulting simplified grammar still generates the desired language.")
        )
        itemList.add(
            PModel("Pushdown automata","A pushdown automaton (PDA) is a type of abstract machine used to recognize context-free languages. It is an extension of a finite automaton with an added stack, which provides additional memory and computational capabilities.\n" +
                    "\n" +
                    "A pushdown automaton consists of five components:\n" +
                    "\n" +
                    "Input Alphabet: The set of symbols that form the input to the PDA. These symbols are read one at a time during the computation.\n" +
                    "\n" +
                    "Stack Alphabet: The set of symbols that can be stored in the stack. The stack is a last-in, first-out (LIFO) data structure and can store an unbounded number of symbols.\n" +
                    "\n" +
                    "Transition Function: This function determines the PDA's behavior during computation. It takes into account the current state, the input symbol being read, and the symbol at the top of the stack, and specifies the next state, the symbol(s) to be pushed onto the stack, and whether to pop a symbol from the stack.\n" +
                    "\n" +
                    "Initial State: The PDA starts in a designated initial state.\n" +
                    "\n" +
                    "Accepting States: The set of states in which the PDA can halt and accept the input.\n" +
                    "\n" +
                    "During the computation, the PDA reads the input symbols from left to right, simultaneously accessing and manipulating the stack. The PDA's behavior is governed by the transition function, which determines the state transitions and stack operations based on the current input symbol and the top symbol of the stack.\n" +
                    "\n" +
                    "A PDA accepts an input string if, after reading the entire string, it enters an accepting state. The PDA may also reject the input string if it reaches a non-accepting state or if it tries to perform an invalid stack operation (e.g., popping from an empty stack).\n" +
                    "\n" +
                    "Pushdown automata are particularly suited for recognizing context-free languages, which cannot be recognized by regular finite automata. The stack enables the PDA to keep track of non-terminal symbols and perform stack operations corresponding to the rules of a context-free grammar. PDAs are closely related to context-free grammars and can be used to simulate their parsing process.\n" +
                    "\n" +
                    "Pushdown automata have applications in various areas, including compiler design, natural language processing, and parsing. They provide a powerful computational model for analyzing and recognizing languages with context-free structures.")
        )
        itemList.add(
            PModel("Pumping lemma for CFL","\n" +
                    "The pumping lemma for context-free languages (CFL) is a fundamental result in formal language theory that provides a property that context-free languages must satisfy. It helps in proving that certain languages are not context-free by showing that they do not satisfy the conditions of the pumping lemma. Here's the statement of the pumping lemma for CFL:\n" +
                    "\n" +
                    "Let L be a context-free language. Then, there exists a pumping length p, such that for any string w ∈ L with |w| ≥ p, we can write w as uvxyz, satisfying the following conditions:\n" +
                    "\n" +
                    "|vxy| ≤ p: The length of the substring vxy is less than or equal to the pumping length p.\n" +
                    "|vy| ≥ 1: The substring vy has at least one symbol.\n" +
                    "For all integers i ≥ 0, the string u(v^i)x(y^i)z is also in L. This means that by repeating v and y (zero or more times), the resulting strings are still in the language L.\n" +
                    "In simpler terms, the pumping lemma states that for any sufficiently long string in a context-free language, you can divide it into five parts: u, v, x, y, and z. The middle part, v and y combined, can be repeated or removed any number of times without affecting the fact that the resulting strings are still in the language L.\n" +
                    "\n" +
                    "If a language L does not satisfy the conditions of the pumping lemma, it implies that L is not a context-free language. However, it's important to note that satisfying the pumping lemma doesn't guarantee that a language is context-free; it only provides a necessary condition.\n" +
                    "\n" +
                    "The pumping lemma for CFL is a powerful tool for proving that certain languages are not context-free. By assuming that a language is context-free and showing that it fails the conditions of the pumping lemma, we can conclude that the language is not context-free.")
        )
        itemList.add(
            PModel(" Closure properties of CFL","Context-free languages (CFLs) have several closure properties, which means that applying certain operations on CFLs results in another CFL. These closure properties are important in formal language theory and compiler design. Here are some of the main closure properties of CFLs:\n" +
                    "\n" +
                    "Union: The union of two CFLs is also a CFL. If L1 and L2 are context-free languages, then their union L1 ∪ L2 is also a context-free language.\n" +
                    "\n" +
                    "Concatenation: The concatenation of two CFLs is also a CFL. If L1 and L2 are context-free languages, then their concatenation L1L2 is also a context-free language.\n" +
                    "\n" +
                    "Kleene Star: The Kleene star (closure under iteration) of a CFL is also a CFL. If L is a context-free language, then L* (the set of all possible concatenations of zero or more strings from L) is also a context-free language.\n" +
                    "\n" +
                    "Intersection with Regular Languages: The intersection of a CFL with a regular language is a CFL. If L is a context-free language and R is a regular language, then L ∩ R is also a context-free language.\n" +
                    "\n" +
                    "Homomorphism: If L is a context-free language and h is a homomorphism, then h(L) (the image of L under h) is also a context-free language. A homomorphism is a function that maps each symbol in the language to a string of symbols.\n" +
                    "\n" +
                    "Reversal: The reversal of a CFL is also a CFL. If L is a context-free language, then L^R (the set of all reversals of strings in L) is also a context-free language.\n" +
                    "\n" +
                    "Intersection with Regular Sets: The intersection of a CFL with a regular set (a language accepted by a finite automaton) is a CFL. If L is a context-free language and S is a regular set, then L ∩ S is also a context-free language.\n" +
                    "\n" +
                    "These closure properties demonstrate that context-free languages are closed under various operations, allowing us to manipulate and combine CFLs while preserving their context-free nature. These properties are useful in language theory, parsing algorithms, and the design and analysis of programming languages.")
        )
        itemList.add(
            PModel("Decision algorithms","Decision algorithms are algorithms that determine the answer to a specific decision problem. A decision problem is a computational problem that requires a yes/no answer. Decision algorithms are designed to solve such problems by systematically examining the input and producing the correct answer.\n" +
                    "\n" +
                    "Here are some common decision algorithms and their associated problem domains:\n" +
                    "\n" +
                    "Decision Tree Algorithm: This algorithm constructs a binary tree-like structure, called a decision tree, to make decisions based on input features. It is often used in machine learning and data mining for classification tasks.\n" +
                    "\n" +
                    "Dijkstra's Algorithm: This algorithm solves the single-source shortest path problem in a graph with non-negative edge weights. It determines the shortest path from a given source node to all other nodes in the graph. It has applications in network routing, transportation planning, and optimization problems.\n" +
                    "\n" +
                    "Prim's Algorithm: This algorithm finds a minimum spanning tree in a weighted undirected graph. It starts with an arbitrary vertex and greedily adds edges to form a tree with the minimum total weight. It is commonly used in network design and clustering applications.\n" +
                    "\n" +
                    "Kruskal's Algorithm: This algorithm also finds a minimum spanning tree in a weighted undirected graph. It sorts the edges by weight and adds them to the spanning tree in increasing order, avoiding cycles. It has similar applications as Prim's algorithm.\n" +
                    "\n" +
                    "Bellman-Ford Algorithm: This algorithm solves the single-source shortest path problem in a graph with both positive and negative edge weights. It can handle graphs with negative cycles and is used in network routing protocols and time-dependent routing.\n" +
                    "\n" +
                    "Floyd-Warshall Algorithm: This algorithm finds the shortest paths between all pairs of vertices in a weighted directed graph. It is an efficient way to compute all-pairs shortest paths and is used in graph analysis, network optimization, and traffic routing.\n" +
                    "\n" +
                    "Binary Search: This algorithm efficiently searches for a specific element in a sorted list or array by repeatedly dividing the search space in half. It has applications in searching and retrieval tasks and is a fundamental algorithm in computer science.\n" +
                    "\n" +
                    "These are just a few examples of decision algorithms used in various problem domains. Decision algorithms are essential tools in solving computational problems and providing efficient and accurate answers to decision problems. They form the basis for many algorithms and techniques in computer science, optimization, artificial intelligence, and other fields.")
        )

        itemList.add(
            PModel("Non-Terminals and Terminals","In the context of formal languages and grammars, non-terminals and terminals are symbols used to define the structure and rules of a language. They play a crucial role in context-free grammars (CFGs) and the derivation of strings in a language.\n" +
                    "\n" +
                    "Terminals: Terminals, also known as terminal symbols or terminal characters, are the basic building blocks or atomic elements of a language. They represent the actual input symbols or tokens that belong to the language being described. Terminals are the symbols that appear in the final strings of the language.\n" +
                    "For example, in a programming language, terminals could represent keywords, operators, punctuation marks, identifiers, literals (e.g., numbers, strings), etc. In a mathematical expression language, terminals could represent numbers, variables, operators, and parentheses.\n" +
                    "\n" +
                    "In formal grammar notation, terminals are often represented using lowercase letters or special symbols. For instance, 'a', 'b', 'c' could be terminals representing specific characters or tokens in a language.\n" +
                    "\n" +
                    "Non-Terminals: Non-terminals, also known as non-terminal symbols or variables, are symbols that represent syntactic categories or placeholders in a language. They do not directly represent specific input symbols but serve as placeholders for groups of symbols or substructures within the language.\n" +
                    "Non-terminals are used in context-free grammars to define production rules that specify how symbols can be rewritten or replaced. They provide a way to generate and organize the structure of the language.\n" +
                    "\n" +
                    "Non-terminals are often represented using uppercase letters or symbols. For example, 'A', 'B', 'C' could be non-terminals representing various syntactic categories such as expressions, statements, or blocks.\n" +
                    "\n" +
                    "In the derivation process of a context-free grammar, non-terminals are replaced by other symbols (terminals or non-terminals) according to the production rules until a string of terminals is obtained.\n" +
                    "\n" +
                    "In summary, terminals represent the actual symbols or tokens of a language, while non-terminals represent syntactic categories or placeholders that define the structure and rules of the language. Together, they form the basis of context-free grammars and allow for the description and generation of strings in a language.")
        )

        itemList.add(
            PModel("Ambiguity","Ambiguity, in the context of formal languages and grammars, refers to a situation where a particular string in a language can be derived by more than one valid parse tree or interpretation. It occurs when a context-free grammar allows for multiple possible ways of deriving the same string, leading to different interpretations or meanings.\n" +
                    "\n" +
                    "Ambiguity can arise in both the syntax and semantics of a language. Here are two common types of ambiguity:\n" +
                    "\n" +
                    "Syntactic Ambiguity: Syntactic ambiguity occurs when a string can be parsed or derived in multiple ways, resulting in different parse trees. This typically arises due to ambiguous production rules in a context-free grammar.\n" +
                    "For example, consider a simple grammar for arithmetic expressions:\n" +
                    "E -> E + E  |  E * E  |  (E)  |  id\n" +
                    "This grammar allows for multiple possible interpretations of an expression like \"2 + 3 * 4\". It can be parsed as either (2 + 3) * 4 or 2 + (3 * 4), resulting in different meanings.\n" +
                    "\n" +
                    "Semantic Ambiguity: Semantic ambiguity occurs when a string has multiple possible interpretations or meanings based on the context or semantics of the language. It is not directly related to the grammar but arises from the ambiguity in the language itself.\n" +
                    "For example, consider the sentence \"Flying planes can be dangerous.\" Here, the phrase \"Flying planes\" can be interpreted in two different ways: \"Planes that are flying can be dangerous\" or \"The act of flying planes can be dangerous.\"\n" +
                    "\n" +
                    "Ambiguity can cause issues in language processing and understanding. It can lead to different interpretations, confusion, or errors in parsing, translation, and semantic analysis. Therefore, in many applications, it is desirable to have unambiguous grammars and languages to ensure clear and unique interpretations of the input.\n" +
                    "\n" +
                    "In grammar design and language analysis, efforts are made to eliminate or minimize ambiguity by carefully constructing unambiguous grammars or by disambiguating ambiguous constructs through additional rules or context.")
        )
        itemList.add(
            PModel("Language Hierarchy","The language hierarchy, also known as the Chomsky hierarchy, is a classification system that categorizes formal languages into different levels based on their generative power and the types of grammars that can generate them. The hierarchy was proposed by linguist Noam Chomsky in the 1950s and has become a fundamental concept in formal language theory. The Chomsky hierarchy consists of the following four levels:\n" +
                    "\n" +
                    "Regular Languages: Regular languages are the simplest type of formal languages. They can be described by regular expressions, finite automata (including deterministic and non-deterministic finite automata), and regular grammars. Regular languages are characterized by their linear structure and can be recognized by finite-state machines. Examples of regular languages include the language of all valid email addresses and the language of all binary strings with an equal number of 0s and 1s.\n" +
                    "\n" +
                    "Context-Free Languages: Context-free languages (CFLs) are more expressive than regular languages. They can be described by context-free grammars and recognized by pushdown automata. Context-free languages are characterized by their nested or hierarchical structure, where non-terminals are replaced by a sequence of symbols according to production rules. Examples of context-free languages include programming languages, mathematical expressions, and nested parentheses.\n" +
                    "\n" +
                    "Context-Sensitive Languages: Context-sensitive languages are more powerful than context-free languages. They can be described by context-sensitive grammars, which allow the left-hand side of production rules to have variable-length strings. Context-sensitive languages are recognized by linear-bounded automata, where the automaton's tape length can grow linearly with the input size. Examples of context-sensitive languages include natural languages and some advanced programming language features.\n" +
                    "\n" +
                    "Recursively Enumerable Languages: Recursively enumerable languages, also known as recursively enumerable sets or Type-0 languages, are the most general and powerful class of languages in the hierarchy. They can be described by Turing machines, which have unlimited computational power. Recursively enumerable languages include all computable languages, which are languages for which a Turing machine halts and accepts every valid string in the language. Examples of recursively enumerable languages include all recursively enumerable sets of integers and the language of all possible programs in a given programming language.\n" +
                    "\n" +
                    "The Chomsky hierarchy demonstrates a gradual increase in generative power as we move up the levels. Each level encompasses the languages of the levels below it, and some languages are exclusive to specific levels. The hierarchy helps in understanding the complexity and expressive capabilities of different types of formal languages and the corresponding grammar formalisms and computational models used to describe and recognize them.")
        )





        adapter = PAdapter(itemList)
        recyclerView.adapter = adapter



    }












}
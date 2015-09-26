# AMOR #

The [AMOR project](http://www.modelversioning.org) (Adaptable Model Versioning) is a cooperative research project funded by the Austrian Federal Ministry of Transport, Innovation and Technology (BMVIT) and Austrian Research Promotion Agency (FFG) under grant FIT-IT-819584. With AMOR, we propose novel methods and techniques to leverage version control in the area of MDE. For more information, we kindly refer to the [project web site](http://www.modelversioning.org). AMOR is realized by the [Business Informatics Group](http://www.big.tuwien.ac.at) (Vienna University of Technology), the [Department of Information Systems](http://www.ce.jku.at/en), the [Departement of Telekooperation](http://www.tk.uni-linz.ac.at/) (Johannes Kepler University Linz) and [SparxSystems Central Europe](http://www.sparxsystems.at/).

# AMOR Conflict Detection #

The sources hosted in this Eclipse Labs project contain the **conflict detection functionality of AMOR** for _atomic operation conflicts_ and _composite operation conflicts_. Please note that the sources in this project rely on the components of [EMF Modeling Operations (EMO)](http://www.modelversioning.org/emf-modeling-operations). Thus, to check out and compile the sources of the conflict detection component, you first have to checkout and compile [the sources of EMO](https://sourceforge.net/projects/emfmo/). Please note that AMOR's conflict detection components as well as EMO is currently only available for _Eclipse Helios (3.6)_. We are currently working to migrate the implementation to Eclipse Indigo (3.7).
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.modelversioning.conflictreport.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.modelversioning.conflictreport.ConflictDependency;
import org.modelversioning.conflictreport.ConflictReport;
import org.modelversioning.conflictreport.ConflictReportPackage;

import org.modelversioning.conflictreport.DependentDiagramChange;
import org.modelversioning.conflictreport.EquivalentChange;
import org.modelversioning.conflictreport.conflict.Conflict;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conflict Report</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.impl.ConflictReportImpl#getConflicts <em>Conflicts</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.impl.ConflictReportImpl#getEquivalentChanges <em>Equivalent Changes</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.impl.ConflictReportImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.impl.ConflictReportImpl#getLeftVersion <em>Left Version</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.impl.ConflictReportImpl#getRightVersion <em>Right Version</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.impl.ConflictReportImpl#getLeftDiagrams <em>Left Diagrams</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.impl.ConflictReportImpl#getRightDiagrams <em>Right Diagrams</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.impl.ConflictReportImpl#getLeftUser <em>Left User</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.impl.ConflictReportImpl#getRightUser <em>Right User</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.impl.ConflictReportImpl#getDiagramDependencies <em>Diagram Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConflictReportImpl extends EObjectImpl implements ConflictReport {
	/**
	 * The cached value of the '{@link #getConflicts() <em>Conflicts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConflicts()
	 * @generated
	 * @ordered
	 */
	protected EList<Conflict> conflicts;

	/**
	 * The cached value of the '{@link #getEquivalentChanges() <em>Equivalent Changes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquivalentChanges()
	 * @generated
	 * @ordered
	 */
	protected EList<EquivalentChange> equivalentChanges;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<ConflictDependency> dependencies;

	/**
	 * The cached value of the '{@link #getLeftVersion() <em>Left Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftVersion()
	 * @generated
	 * @ordered
	 */
	protected ComparisonResourceSnapshot leftVersion;

	/**
	 * The cached value of the '{@link #getRightVersion() <em>Right Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightVersion()
	 * @generated
	 * @ordered
	 */
	protected ComparisonResourceSnapshot rightVersion;

	/**
	 * The cached value of the '{@link #getLeftDiagrams() <em>Left Diagrams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<ComparisonResourceSnapshot> leftDiagrams;

	/**
	 * The cached value of the '{@link #getRightDiagrams() <em>Right Diagrams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<ComparisonResourceSnapshot> rightDiagrams;

	/**
	 * The default value of the '{@link #getLeftUser() <em>Left User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftUser()
	 * @generated
	 * @ordered
	 */
	protected static final String LEFT_USER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLeftUser() <em>Left User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftUser()
	 * @generated
	 * @ordered
	 */
	protected String leftUser = LEFT_USER_EDEFAULT;

	/**
	 * The default value of the '{@link #getRightUser() <em>Right User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightUser()
	 * @generated
	 * @ordered
	 */
	protected static final String RIGHT_USER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRightUser() <em>Right User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightUser()
	 * @generated
	 * @ordered
	 */
	protected String rightUser = RIGHT_USER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDiagramDependencies() <em>Diagram Dependencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<DependentDiagramChange> diagramDependencies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConflictReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConflictReportPackage.Literals.CONFLICT_REPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Conflict> getConflicts() {
		if (conflicts == null) {
			conflicts = new EObjectContainmentEList<Conflict>(Conflict.class, this, ConflictReportPackage.CONFLICT_REPORT__CONFLICTS);
		}
		return conflicts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EquivalentChange> getEquivalentChanges() {
		if (equivalentChanges == null) {
			equivalentChanges = new EObjectContainmentEList<EquivalentChange>(EquivalentChange.class, this, ConflictReportPackage.CONFLICT_REPORT__EQUIVALENT_CHANGES);
		}
		return equivalentChanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConflictDependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectResolvingEList<ConflictDependency>(ConflictDependency.class, this, ConflictReportPackage.CONFLICT_REPORT__DEPENDENCIES);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComparisonResourceSnapshot getLeftVersion() {
		return leftVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftVersion(ComparisonResourceSnapshot newLeftVersion, NotificationChain msgs) {
		ComparisonResourceSnapshot oldLeftVersion = leftVersion;
		leftVersion = newLeftVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConflictReportPackage.CONFLICT_REPORT__LEFT_VERSION, oldLeftVersion, newLeftVersion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftVersion(ComparisonResourceSnapshot newLeftVersion) {
		if (newLeftVersion != leftVersion) {
			NotificationChain msgs = null;
			if (leftVersion != null)
				msgs = ((InternalEObject)leftVersion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConflictReportPackage.CONFLICT_REPORT__LEFT_VERSION, null, msgs);
			if (newLeftVersion != null)
				msgs = ((InternalEObject)newLeftVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConflictReportPackage.CONFLICT_REPORT__LEFT_VERSION, null, msgs);
			msgs = basicSetLeftVersion(newLeftVersion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConflictReportPackage.CONFLICT_REPORT__LEFT_VERSION, newLeftVersion, newLeftVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComparisonResourceSnapshot getRightVersion() {
		return rightVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRightVersion(ComparisonResourceSnapshot newRightVersion, NotificationChain msgs) {
		ComparisonResourceSnapshot oldRightVersion = rightVersion;
		rightVersion = newRightVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConflictReportPackage.CONFLICT_REPORT__RIGHT_VERSION, oldRightVersion, newRightVersion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightVersion(ComparisonResourceSnapshot newRightVersion) {
		if (newRightVersion != rightVersion) {
			NotificationChain msgs = null;
			if (rightVersion != null)
				msgs = ((InternalEObject)rightVersion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConflictReportPackage.CONFLICT_REPORT__RIGHT_VERSION, null, msgs);
			if (newRightVersion != null)
				msgs = ((InternalEObject)newRightVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConflictReportPackage.CONFLICT_REPORT__RIGHT_VERSION, null, msgs);
			msgs = basicSetRightVersion(newRightVersion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConflictReportPackage.CONFLICT_REPORT__RIGHT_VERSION, newRightVersion, newRightVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComparisonResourceSnapshot> getLeftDiagrams() {
		if (leftDiagrams == null) {
			leftDiagrams = new EObjectContainmentEList<ComparisonResourceSnapshot>(ComparisonResourceSnapshot.class, this, ConflictReportPackage.CONFLICT_REPORT__LEFT_DIAGRAMS);
		}
		return leftDiagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComparisonResourceSnapshot> getRightDiagrams() {
		if (rightDiagrams == null) {
			rightDiagrams = new EObjectContainmentEList<ComparisonResourceSnapshot>(ComparisonResourceSnapshot.class, this, ConflictReportPackage.CONFLICT_REPORT__RIGHT_DIAGRAMS);
		}
		return rightDiagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLeftUser() {
		return leftUser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftUser(String newLeftUser) {
		String oldLeftUser = leftUser;
		leftUser = newLeftUser;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConflictReportPackage.CONFLICT_REPORT__LEFT_USER, oldLeftUser, leftUser));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRightUser() {
		return rightUser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightUser(String newRightUser) {
		String oldRightUser = rightUser;
		rightUser = newRightUser;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConflictReportPackage.CONFLICT_REPORT__RIGHT_USER, oldRightUser, rightUser));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DependentDiagramChange> getDiagramDependencies() {
		if (diagramDependencies == null) {
			diagramDependencies = new EObjectResolvingEList<DependentDiagramChange>(DependentDiagramChange.class, this, ConflictReportPackage.CONFLICT_REPORT__DIAGRAM_DEPENDENCIES);
		}
		return diagramDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasConflictingChange(DiffElement diffElement) {
		for (Conflict conflict : getConflicts()) {
			if (conflict.getLeftChange().equals(diffElement)
					|| conflict.getRightChange().equals(diffElement)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<DiffElement> getConflictingChanges(DiffElement diffElement) {
		EList<DiffElement> conflictingChanges = new BasicEList<DiffElement>();
		for (Conflict conflict : getConflicts()) {
			if (conflict.getLeftChange().equals(diffElement)) {
				conflictingChanges.add(conflict.getRightChange());
			} else if (conflict.getRightChange().equals(diffElement)) {
				conflictingChanges.add(conflict.getLeftChange());
			}
		}
		return conflictingChanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Conflict> getConflicts(DiffElement diffElement) {
		EList<Conflict> foundConflicts = new BasicEList<Conflict>();
		for (Conflict conflict : getConflicts()) {
			if (conflict.getLeftChange().equals(diffElement)
					|| conflict.getRightChange().equals(diffElement)) {
				foundConflicts.add(conflict);
			}
		}
		return foundConflicts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasEquivalentChange(DiffElement diffElement) {
		for (EquivalentChange change : getEquivalentChanges()) {
			if (change.getLeftChange().equals(diffElement)
					|| change.getRightChange().equals(diffElement)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<DiffElement> getEquivalentChanges(DiffElement diffElement) {
		EList<DiffElement> equivalentChanges = new BasicEList<DiffElement>();
		for (EquivalentChange change : getEquivalentChanges()) {
			if (change.getLeftChange().equals(diffElement)) {
				equivalentChanges.add(change.getRightChange());
			} else if (change.getRightChange().equals(diffElement)) {
				equivalentChanges.add(change.getLeftChange());
			}
		}
		return equivalentChanges;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<DiffElement> getEquivalentSubChanges() {
		EList<DiffElement> equivalentSubChanges = new BasicEList<DiffElement>();
		for (EquivalentChange change : getEquivalentChanges()) {
			equivalentSubChanges.add(change.getSubChange());
		}
		return equivalentSubChanges;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<DiffElement> getEquivalentPreferredChanges() {
		EList<DiffElement> equivalentPreferredChanges = new BasicEList<DiffElement>();
		for (EquivalentChange change : getEquivalentChanges()) {
			equivalentPreferredChanges.add(change.getPreferredChange());
		}
		return equivalentPreferredChanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isDependentDiagramChange(DiffElement diagramChange) {
		for (DependentDiagramChange change : getDiagramDependencies()) {
			if (change.getDiagramChanges().contains(diagramChange)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiffElement> getDependentDiagramChanges(DiffElement modelChange) {
		EList<DiffElement> dependentDiagramChanges = new BasicEList<DiffElement>();
		for (DependentDiagramChange change : getDiagramDependencies()) {
			if (change.getModelChange().equals(modelChange)) {
				dependentDiagramChanges.addAll(change.getDiagramChanges());
			}
		}
		return dependentDiagramChanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiffElement getDependentModelChange(DiffElement diagramChange) {
		for (DependentDiagramChange dependentDiagramChange : getDiagramDependencies()) {
			for (DiffElement change : dependentDiagramChange.getDiagramChanges()) {
				if (change.equals(diagramChange)) {
					return dependentDiagramChange.getModelChange();
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean hasDependentDiagramChange(DiffElement modelChange) {
		for (DependentDiagramChange change : getDiagramDependencies()) {
			if (change.getModelChange().equals(modelChange)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConflictReportPackage.CONFLICT_REPORT__CONFLICTS:
				return ((InternalEList<?>)getConflicts()).basicRemove(otherEnd, msgs);
			case ConflictReportPackage.CONFLICT_REPORT__EQUIVALENT_CHANGES:
				return ((InternalEList<?>)getEquivalentChanges()).basicRemove(otherEnd, msgs);
			case ConflictReportPackage.CONFLICT_REPORT__LEFT_VERSION:
				return basicSetLeftVersion(null, msgs);
			case ConflictReportPackage.CONFLICT_REPORT__RIGHT_VERSION:
				return basicSetRightVersion(null, msgs);
			case ConflictReportPackage.CONFLICT_REPORT__LEFT_DIAGRAMS:
				return ((InternalEList<?>)getLeftDiagrams()).basicRemove(otherEnd, msgs);
			case ConflictReportPackage.CONFLICT_REPORT__RIGHT_DIAGRAMS:
				return ((InternalEList<?>)getRightDiagrams()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConflictReportPackage.CONFLICT_REPORT__CONFLICTS:
				return getConflicts();
			case ConflictReportPackage.CONFLICT_REPORT__EQUIVALENT_CHANGES:
				return getEquivalentChanges();
			case ConflictReportPackage.CONFLICT_REPORT__DEPENDENCIES:
				return getDependencies();
			case ConflictReportPackage.CONFLICT_REPORT__LEFT_VERSION:
				return getLeftVersion();
			case ConflictReportPackage.CONFLICT_REPORT__RIGHT_VERSION:
				return getRightVersion();
			case ConflictReportPackage.CONFLICT_REPORT__LEFT_DIAGRAMS:
				return getLeftDiagrams();
			case ConflictReportPackage.CONFLICT_REPORT__RIGHT_DIAGRAMS:
				return getRightDiagrams();
			case ConflictReportPackage.CONFLICT_REPORT__LEFT_USER:
				return getLeftUser();
			case ConflictReportPackage.CONFLICT_REPORT__RIGHT_USER:
				return getRightUser();
			case ConflictReportPackage.CONFLICT_REPORT__DIAGRAM_DEPENDENCIES:
				return getDiagramDependencies();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConflictReportPackage.CONFLICT_REPORT__CONFLICTS:
				getConflicts().clear();
				getConflicts().addAll((Collection<? extends Conflict>)newValue);
				return;
			case ConflictReportPackage.CONFLICT_REPORT__EQUIVALENT_CHANGES:
				getEquivalentChanges().clear();
				getEquivalentChanges().addAll((Collection<? extends EquivalentChange>)newValue);
				return;
			case ConflictReportPackage.CONFLICT_REPORT__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends ConflictDependency>)newValue);
				return;
			case ConflictReportPackage.CONFLICT_REPORT__LEFT_VERSION:
				setLeftVersion((ComparisonResourceSnapshot)newValue);
				return;
			case ConflictReportPackage.CONFLICT_REPORT__RIGHT_VERSION:
				setRightVersion((ComparisonResourceSnapshot)newValue);
				return;
			case ConflictReportPackage.CONFLICT_REPORT__LEFT_DIAGRAMS:
				getLeftDiagrams().clear();
				getLeftDiagrams().addAll((Collection<? extends ComparisonResourceSnapshot>)newValue);
				return;
			case ConflictReportPackage.CONFLICT_REPORT__RIGHT_DIAGRAMS:
				getRightDiagrams().clear();
				getRightDiagrams().addAll((Collection<? extends ComparisonResourceSnapshot>)newValue);
				return;
			case ConflictReportPackage.CONFLICT_REPORT__LEFT_USER:
				setLeftUser((String)newValue);
				return;
			case ConflictReportPackage.CONFLICT_REPORT__RIGHT_USER:
				setRightUser((String)newValue);
				return;
			case ConflictReportPackage.CONFLICT_REPORT__DIAGRAM_DEPENDENCIES:
				getDiagramDependencies().clear();
				getDiagramDependencies().addAll((Collection<? extends DependentDiagramChange>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConflictReportPackage.CONFLICT_REPORT__CONFLICTS:
				getConflicts().clear();
				return;
			case ConflictReportPackage.CONFLICT_REPORT__EQUIVALENT_CHANGES:
				getEquivalentChanges().clear();
				return;
			case ConflictReportPackage.CONFLICT_REPORT__DEPENDENCIES:
				getDependencies().clear();
				return;
			case ConflictReportPackage.CONFLICT_REPORT__LEFT_VERSION:
				setLeftVersion((ComparisonResourceSnapshot)null);
				return;
			case ConflictReportPackage.CONFLICT_REPORT__RIGHT_VERSION:
				setRightVersion((ComparisonResourceSnapshot)null);
				return;
			case ConflictReportPackage.CONFLICT_REPORT__LEFT_DIAGRAMS:
				getLeftDiagrams().clear();
				return;
			case ConflictReportPackage.CONFLICT_REPORT__RIGHT_DIAGRAMS:
				getRightDiagrams().clear();
				return;
			case ConflictReportPackage.CONFLICT_REPORT__LEFT_USER:
				setLeftUser(LEFT_USER_EDEFAULT);
				return;
			case ConflictReportPackage.CONFLICT_REPORT__RIGHT_USER:
				setRightUser(RIGHT_USER_EDEFAULT);
				return;
			case ConflictReportPackage.CONFLICT_REPORT__DIAGRAM_DEPENDENCIES:
				getDiagramDependencies().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConflictReportPackage.CONFLICT_REPORT__CONFLICTS:
				return conflicts != null && !conflicts.isEmpty();
			case ConflictReportPackage.CONFLICT_REPORT__EQUIVALENT_CHANGES:
				return equivalentChanges != null && !equivalentChanges.isEmpty();
			case ConflictReportPackage.CONFLICT_REPORT__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case ConflictReportPackage.CONFLICT_REPORT__LEFT_VERSION:
				return leftVersion != null;
			case ConflictReportPackage.CONFLICT_REPORT__RIGHT_VERSION:
				return rightVersion != null;
			case ConflictReportPackage.CONFLICT_REPORT__LEFT_DIAGRAMS:
				return leftDiagrams != null && !leftDiagrams.isEmpty();
			case ConflictReportPackage.CONFLICT_REPORT__RIGHT_DIAGRAMS:
				return rightDiagrams != null && !rightDiagrams.isEmpty();
			case ConflictReportPackage.CONFLICT_REPORT__LEFT_USER:
				return LEFT_USER_EDEFAULT == null ? leftUser != null : !LEFT_USER_EDEFAULT.equals(leftUser);
			case ConflictReportPackage.CONFLICT_REPORT__RIGHT_USER:
				return RIGHT_USER_EDEFAULT == null ? rightUser != null : !RIGHT_USER_EDEFAULT.equals(rightUser);
			case ConflictReportPackage.CONFLICT_REPORT__DIAGRAM_DEPENDENCIES:
				return diagramDependencies != null && !diagramDependencies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (leftUser: ");
		result.append(leftUser);
		result.append(", rightUser: ");
		result.append(rightUser);
		result.append(')');
		return result.toString();
	}

} //ConflictReportImpl

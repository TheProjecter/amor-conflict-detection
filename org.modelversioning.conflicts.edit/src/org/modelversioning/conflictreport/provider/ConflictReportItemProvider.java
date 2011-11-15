/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.modelversioning.conflictreport.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.compare.diff.metamodel.DiffFactory;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.modelversioning.conflictreport.ConflictReport;
import org.modelversioning.conflictreport.ConflictReportFactory;
import org.modelversioning.conflictreport.ConflictReportPackage;

import org.modelversioning.conflictreport.conflict.ConflictFactory;

/**
 * This is the item provider adapter for a {@link org.modelversioning.conflictreport.ConflictReport} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ConflictReportItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConflictReportItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addDependenciesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Dependencies feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDependenciesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConflictReport_dependencies_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConflictReport_dependencies_feature", "_UI_ConflictReport_type"),
				 ConflictReportPackage.Literals.CONFLICT_REPORT__DEPENDENCIES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ConflictReportPackage.Literals.CONFLICT_REPORT__CONFLICTS);
			childrenFeatures.add(ConflictReportPackage.Literals.CONFLICT_REPORT__EQUIVALENT_CHANGES);
			childrenFeatures.add(ConflictReportPackage.Literals.CONFLICT_REPORT__LEFT_VERSION);
			childrenFeatures.add(ConflictReportPackage.Literals.CONFLICT_REPORT__RIGHT_VERSION);
			childrenFeatures.add(ConflictReportPackage.Literals.CONFLICT_REPORT__LEFT_DIAGRAMS);
			childrenFeatures.add(ConflictReportPackage.Literals.CONFLICT_REPORT__RIGHT_DIAGRAMS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ConflictReport.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ConflictReport"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_ConflictReport_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ConflictReport.class)) {
			case ConflictReportPackage.CONFLICT_REPORT__CONFLICTS:
			case ConflictReportPackage.CONFLICT_REPORT__EQUIVALENT_CHANGES:
			case ConflictReportPackage.CONFLICT_REPORT__LEFT_VERSION:
			case ConflictReportPackage.CONFLICT_REPORT__RIGHT_VERSION:
			case ConflictReportPackage.CONFLICT_REPORT__LEFT_DIAGRAMS:
			case ConflictReportPackage.CONFLICT_REPORT__RIGHT_DIAGRAMS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ConflictReportPackage.Literals.CONFLICT_REPORT__CONFLICTS,
				 ConflictFactory.eINSTANCE.createMetamodelViolation()));

		newChildDescriptors.add
			(createChildParameter
				(ConflictReportPackage.Literals.CONFLICT_REPORT__CONFLICTS,
				 ConflictFactory.eINSTANCE.createOperationContractViolation()));

		newChildDescriptors.add
			(createChildParameter
				(ConflictReportPackage.Literals.CONFLICT_REPORT__CONFLICTS,
				 ConflictFactory.eINSTANCE.createUpdateUpdate()));

		newChildDescriptors.add
			(createChildParameter
				(ConflictReportPackage.Literals.CONFLICT_REPORT__CONFLICTS,
				 ConflictFactory.eINSTANCE.createDeleteUpdate()));

		newChildDescriptors.add
			(createChildParameter
				(ConflictReportPackage.Literals.CONFLICT_REPORT__CONFLICTS,
				 ConflictFactory.eINSTANCE.createAddAdd()));

		newChildDescriptors.add
			(createChildParameter
				(ConflictReportPackage.Literals.CONFLICT_REPORT__EQUIVALENT_CHANGES,
				 ConflictReportFactory.eINSTANCE.createEquivalentChange()));

		newChildDescriptors.add
			(createChildParameter
				(ConflictReportPackage.Literals.CONFLICT_REPORT__LEFT_VERSION,
				 DiffFactory.eINSTANCE.createComparisonResourceSnapshot()));

		newChildDescriptors.add
			(createChildParameter
				(ConflictReportPackage.Literals.CONFLICT_REPORT__RIGHT_VERSION,
				 DiffFactory.eINSTANCE.createComparisonResourceSnapshot()));

		newChildDescriptors.add
			(createChildParameter
				(ConflictReportPackage.Literals.CONFLICT_REPORT__LEFT_DIAGRAMS,
				 DiffFactory.eINSTANCE.createComparisonResourceSnapshot()));

		newChildDescriptors.add
			(createChildParameter
				(ConflictReportPackage.Literals.CONFLICT_REPORT__RIGHT_DIAGRAMS,
				 DiffFactory.eINSTANCE.createComparisonResourceSnapshot()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == ConflictReportPackage.Literals.CONFLICT_REPORT__LEFT_VERSION ||
			childFeature == ConflictReportPackage.Literals.CONFLICT_REPORT__RIGHT_VERSION ||
			childFeature == ConflictReportPackage.Literals.CONFLICT_REPORT__LEFT_DIAGRAMS ||
			childFeature == ConflictReportPackage.Literals.CONFLICT_REPORT__RIGHT_DIAGRAMS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ConflictReportEditPlugin.INSTANCE;
	}

}

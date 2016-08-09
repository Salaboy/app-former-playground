package demo.client.local;

import org.livespark.formmodeler.rendering.client.view.FormView;
import demo.client.shared.AddressFormModel;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import javax.inject.Named;
import java.util.List;
import java.util.ArrayList;
import demo.client.shared.Address;
import org.gwtbootstrap3.client.ui.TextBox;
import javax.inject.Inject;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;

@Templated
@Named("AddressFormView")
public class AddressFormView extends FormView<AddressFormModel>
{

   @Inject
   @Bound(property = "address.id")
   @DataField
   private TextBox address_id;
   @Inject
   @Bound(property = "address.street")
   @DataField
   private TextBox address_street;
   @Inject
   @Bound(property = "address.num")
   @DataField
   private TextBox address_num;
   @Inject
   @Bound(property = "address.cp")
   @DataField
   private TextBox address_cp;
   @Inject
   @Bound(property = "address.city")
   @DataField
   private TextBox address_city;
   @Inject
   @Bound(property = "address.country")
   @DataField
   private TextBox address_country;

   @Override
   protected int getEntitiesCount()
   {
      return 1;
   }

   @Override
   protected List getEntities()
   {
      List entities = new ArrayList();
      Object address = getModel().getAddress();
      if (address != null)
         entities.add(address);
      return entities;
   }

   @Override
   protected void initEntities()
   {
      if (getModel().getAddress() == null)
         getModel().setAddress(new Address());
   }

   @Override
   protected void initForm()
   {
      validator.registerInput("address_id", address_id);
      validator.registerInput("address_street", address_street);
      validator.registerInput("address_num", address_num);
      validator.registerInput("address_cp", address_cp);
      validator.registerInput("address_city", address_city);
      validator.registerInput("address_country", address_country);
   }

   @Override
   public void beforeDisplay()
   {
   }

   @Override
   public boolean doExtraValidations()
   {
      boolean valid = true;
      return valid;
   }

   @Override
   public void setReadOnly(boolean readOnly)
   {
      address_street.setReadOnly(readOnly);
      address_num.setReadOnly(readOnly);
      address_cp.setReadOnly(readOnly);
      address_city.setReadOnly(readOnly);
      address_country.setReadOnly(readOnly);
   }
}
package me.yanaga.querydsl.args.jsf;

import com.google.common.base.Strings;
import me.yanaga.querydsl.args.core.single.IntegerArgument;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = IntegerArgument.class)
public class IntegerArgumentConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (!Strings.isNullOrEmpty(value)) {
			return IntegerArgument.of(value);
		}
		return IntegerArgument.of();
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return value.toString();
		}
		return null;
	}

}

package ru.malik.myApp3.client.view.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.sencha.gxt.cell.core.client.form.FieldCell;
import com.sencha.gxt.core.client.dom.XElement;
import com.sencha.gxt.theme.base.client.field.TwinTriggerFieldDefaultAppearance;

/**
 * Created by Зуфар on 19.12.2014.
 */
public class LookupAppear extends TwinTriggerFieldDefaultAppearance {
    public interface SupplierTwinTriggerFieldResources extends  TwinTriggerFieldResources{
        @Override
        @Source("com/sencha/gxt/theme/base/client/field/clearTrigger.gif")
        public ImageResource triggerArrow();

        @Override
        @Source("com/sencha/gxt/theme/base/client/field/clearTriggerClick.gif")
        public ImageResource triggerArrowClick();

        @Override
        @Source("com/sencha/gxt/theme/base/client/field/clearTriggerOver.gif")
        public ImageResource triggerArrowOver();

        @Override
        @Source("com/sencha/gxt/theme/base/client/field/clearTriggerFocus.gif")
        public ImageResource triggerArrowFocus();


        @Source("images/icons/searchTrigger.gif")
        public ImageResource twinTriggerArrow();

        @Source("images/icons/searchTriggerClick.gif")
        public ImageResource twinTriggerArrowClick();

        @Source("images/icons/searchTriggerOver.gif")
        public ImageResource twinTriggerArrowOver();

        @Source("images/icons/searchTriggerFocus.gif")
        public ImageResource twinTriggerArrowFocus();

        @Source("images/icons/searchTriggerFocusClick.gif")
        public ImageResource twinTriggerArrowFocusClick();

        @Source("images/icons/searchTriggerFocusOver.gif")
        public ImageResource twinTriggerArrowFocusOver();

        @Override
        @Source({"com/sencha/gxt/theme/base/client/field/ValueBaseField.css",
                "com/sencha/gxt/theme/base/client/field/TextField.css",
                "com/sencha/gxt/theme/base/client/field/TriggerField.css",
                "com/sencha/gxt/theme/base/client/field/TwinTriggerField.css",
                "css/SupplierTwinTriggerField.css"})
        SupplierTwinTriggerFieldStyle css();
    }

    public interface SupplierTwinTriggerFieldStyle extends TwinTriggerFieldStyle {

    }

    SupplierTwinTriggerFieldResources resources;
    SupplierTwinTriggerFieldStyle style;

    public LookupAppear(SupplierTwinTriggerFieldResources res) {
        super(res);
        this.resources = res;
        this.style = res.css();
    }

    public LookupAppear() {
        this(GWT.<SupplierTwinTriggerFieldResources>create(SupplierTwinTriggerFieldResources.class));
    }

    @Override
    public void render(SafeHtmlBuilder sb, String value,
                       FieldCell.FieldAppearanceOptions options) {
        int width = options.getWidth();
        boolean hideTrigger = options.isHideTrigger();
        String name = options.getName() != null ? " name='" + options.getName() + "' " : "";
        String disabled = options.isDisabled() ? "disabled=true" : "";

        if (width == -1) {
            width = 150;
        }

        String inputStyles = "";
        String wrapStyles = "";

        if (width != -1) {
            wrapStyles += "width:" + width + "px;";
            // 6px margin, 2px border
            width -= 8;

            if (!hideTrigger) {
                width -= resources.triggerArrow().getWidth();
                width -= resources.twinTriggerArrow().getWidth();//***added for two icons, side by side***
            }
            inputStyles += "width:" + width + "px;";
        }

        String cls = style.field() + " " + style.text();

        if (value.equals("") && options.getEmptyText() != null) {
            cls += " " + style.empty();
            value = options.getEmptyText();
        }

        String ro = options.isReadonly() ? " readonly " : " ";

        String input = "<input " + name + disabled + ro + " style='" + inputStyles + "' type='text' value='" + value
                + "' class='" + cls + "'/>";

        sb.appendHtmlConstant("<div style='" + wrapStyles + "' class='" + style.wrap() + "'>");

        if (!options.isHideTrigger()) {

            sb.appendHtmlConstant("<table width=100% cellpadding=0 cellspacing=0><tr><td>");
            sb.appendHtmlConstant(input);
            sb.appendHtmlConstant("</td>");
            sb.appendHtmlConstant("<td>");
            sb.appendHtmlConstant("<div class='" + style.trigger() + "'></div>");
            sb.appendHtmlConstant("<div class='" + style.twinTrigger() + "'></div>");
            sb.appendHtmlConstant("</td></table>");
        } else {
            sb.appendHtmlConstant(input);
        }

        sb.appendHtmlConstant("</div>");
    }

    /*added missing method*/
    @Override
    public void onResize(XElement parent, int width, int height,
                         boolean hideTrigger) {
        if (width != -1) {
            Element div = parent.getFirstChildElement();
            div.getStyle().setPropertyPx("width", width);

            // 6px margin, 2px border
            width -= 8;

            if (!hideTrigger) {
                width -= resources.triggerArrow().getWidth();
                width -= resources.twinTriggerArrow().getWidth();//***added for two icons, side by side***
            }
            parent.selectNode("input").getStyle().setPropertyPx("width", width);
        }
    }

}
